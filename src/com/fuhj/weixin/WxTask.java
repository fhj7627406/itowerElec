/**
 * 
 */
package com.fuhj.weixin;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.fit.cssbox.demo.ImageRenderer;

import com.fuhj.itower.model.BotChatLog;
import com.fuhj.itower.service.MainService;
import com.fuhj.itower.tasks.KeepItowerLogin;
import com.fuhj.itower.tasks.QueryItowerDZ;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ImageUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.json.BatchContactBean;
import com.fuhj.weixin.json.ContactItem;
import com.fuhj.weixin.json.HeartBeatBean;
import com.fuhj.weixin.json.Member;
import com.fuhj.weixin.json.MessageJson;
import com.fuhj.weixin.json.WebWxInitBean;
import com.fuhj.weixin.json.WebWxSyncPostBean;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-25
 */
public class WxTask implements Runnable {
	boolean tag = false;
	private WebWX webwx;
	@Getter
	@Setter
	private IUICallBack uiCallBack;
	private IReplyService replyService;
	private WebWxInitBean wxInit;
	private MainService mainService;

	/**
	 * @param webwx
	 * @param uiCallBack
	 */
	public WxTask(WebWX webwx, IReplyService replyService, IUICallBack uiCallBack) {
		super();
		this.webwx = webwx;
		this.replyService = replyService;
		this.uiCallBack = uiCallBack;
		mainService = SpringUtil.getBean(MainService.class);
	}

	@Override
	public void run() {
		do {
			int code = 0;
			try {
				code = webwx.scanImgCheck();
			} catch (Exception e) {
				AppLogger.sysError(e);
			}
			if (code == 200) {
				tag = true;
				try {
					webwx.wxLogin();
					uiCallBack.loginCompleted();
					webwx.wxInit();
					webwx.getFullContact();
					webwx.setInitCompleted(true);
					uiCallBack.initCompleted();
					webwx.statusNotify();
				} catch (Exception e) {
					AppLogger.sysError(e);
					return;
				}
				wxInit = webwx.getWxlgBean().getWebWxInitBean();
				while (true) {
					HeartBeatBean hbb = null;
					try {
						hbb = webwx.wxsyncCheck();
					} catch (Exception e) {
						AppLogger.sysError(e);
						continue;
					}
					if ("0".equals(hbb.getRetcode())) {
						if (!"0".equals(hbb.getSelector())) {
							WebWxSyncPostBean wwspb = null;
							try {
								wwspb = webwx.getMsg();
							} catch (Exception e) {
								AppLogger.sysError(e);
								continue;
							}

							ExecutorService exe = Executors.newFixedThreadPool(3);
							if (wwspb != null) {
								for (final MessageJson received : wwspb.getAddMsgList()) {
									exe.execute(new Runnable() {
										@Override
										public void run() {
											processMsg(received);
										}
									});
								}
							}
							exe.shutdown();
						}
					} else {
						AppLogger.sysError("心跳同步失败，监听停止");
						break;
					}
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!tag);
	}

	/**
	 * 加载单个联系人详情或者加载聊天室所有成员详细
	 * 
	 * @param webwx
	 * @param userName
	 * @return
	 */
	public ContactItem loadUserFromChatRoom(WebWX webwx, String userName) {
		ContactItem citem = webwx.getInitContactMap().get(userName);
		try {
			BatchContactBean cb = webwx.batchGetContact(userName);
			if (cb != null && cb.getContactList() != null && cb.getContactList().size() > 0) {
				citem = cb.getContactList().get(0);
				webwx.getInitContactMap().put(userName, citem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// AppLogger.sysDebug(ToStringBuilder.reflectionToString(citem,
		// ToStringStyle.SHORT_PREFIX_STYLE));
		return citem;
	}

	private String qunAtMe(String qunName, String fromUserName, String memberDisplayName, String content) {
		AppLogger.sysDebug("process qunAtMe:" + content);
		String reply = "";
		if (content.matches("\\s*")) {
			return reply;
		}
		Matcher atMatcher = Pattern.compile("(.*?)(正在处理|处理中|马上处理|已处理|正在发电|发电中|已发电|已督办|督办中|已通知|已通知处理|收到|\\[OK\\]).*?").matcher(content);
		StringBuffer atReply = new StringBuffer("@").append(memberDisplayName).append(" ");
		Matcher gElecMatcher = Pattern.compile("(.*?)(发电|我要发电|俺要发电|提交发电信息|我要提交发电信息)(.*?)").matcher(content);

		if (atMatcher.find()) {
			if (QueryItowerDZ.getCurrentDZMap().get(qunName) == null) {
				return reply;
			}
			String stationNameTemp = atMatcher.group(1).replaceAll("\\s", "");
			List<String> dzSearchrs = new ArrayList<String>();
			for (String s : QueryItowerDZ.getCurrentDZMap().get(qunName)) {
				if (s.equals(stationNameTemp) || s.contains(stationNameTemp)) {
					dzSearchrs.add(s);
				}
			}
			if (dzSearchrs.size() == 0) {
				reply = atReply.append("该站点未在当前一脱告警列表中").toString();
			} else if (dzSearchrs.size() == 1) {
				String site = dzSearchrs.get(0);
				List<String> inHandDZList = QueryItowerDZ.getInHandDZMap().get(qunName);
				List<String> sumInHandDZList = QueryItowerDZ.getSumInHandList();
				if (sumInHandDZList.contains(site)) {
					reply = atReply.append(site).append(" 一脱告警已督办").toString();
				} else {
					reply = atReply.append("好的，").append(site).append(" 一脱告警已督办").toString();
					inHandDZList.add(site);
				}
			} else {
				// 多个匹配
			}
		} else if (gElecMatcher.find()) {
			reply = atReply.append("\n好的，请打开以下网址提交发电信息：").append("http://t.cn/RfFTRY6\n使用帮助：https://shimo.im/doc/mlyVSq3FapQwLRYe").toString();
		} else {
			reply = atReply.append(replyService.aiService(content, fromUserName)).toString();
		}
		return reply;
	}

	public BufferedImage createBZImgToSend(String url) {
		ImageRenderer render = new ImageRenderer();
		try {
			File f = File.createTempFile("tempHtml", "svg");
			FileOutputStream out = new FileOutputStream(f);
			render.setWindowSize(new Dimension(451, 1), false);
			render.renderURL(url, out, ImageRenderer.Type.SVG);
			out.close();
			String tempPath = System.getProperty("java.io.tmpdir");
			if (!tempPath.substring(tempPath.length() - 1).equals(File.separator)) {
				tempPath += File.separator;
			}
			String pngPath = tempPath + "html.png";
			FileOutputStream fo = new FileOutputStream(new File(pngPath));
			ImageUtil.convertToPng(ImageUtil.svg2String(f), fo);
			fo.close();
			f.delete();
			File pngFile = new File(pngPath);
			if (pngFile.exists() && pngFile.getTotalSpace() > 0) {
				BufferedImage bw = ImageIO.read(pngFile);
				return bw;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void processMsg(final MessageJson received_msg) {
		// long msgId = received.getMsgId();
		int msgType = received_msg.getMsgType();
		String fromUserName = received_msg.getFromUserName();
		ContactItem citem_from = loadUserFromChatRoom(webwx, fromUserName);

		// 群中发言人对象
		Member tempM = null;
		String memberDisplayName = "";
		// 联系人未在最近联系人列表中则单独请求获取联系人信息

		// String toUserName = received.getToUserName();
		String content = received_msg.getContent();
		String userInQun = "";
		String atMyselfStr = new StringBuffer("@").append(wxInit.getUser().getNickName()).toString();
		boolean fromMyself = fromUserName.equals(wxInit.getUser().getUserName());
		boolean fromQun = false;
		boolean atme = false;

		// 群聊还是私聊
		Matcher matcher = Pattern.compile("@(.*):<br/>(.*)").matcher(content);
		if (matcher.find()) {
			fromQun = true;
			userInQun = new StringBuffer("@").append(matcher.group(1)).toString();
			content = matcher.group(2);
			if (content.contains(atMyselfStr)) {
				atme = true;
			}
			for (Member member : citem_from.getMemberList()) {
				if (member.getUserName().equals(userInQun)) {
					tempM = member;
					break;
				}
			}
			memberDisplayName = StringUtils.isNotEmpty(tempM.getDisplayName()) ? tempM.getDisplayName() : tempM.getNickName();
		} else {
			memberDisplayName = citem_from.getNickName();
		}
		memberDisplayName = memberDisplayName.replace("\\\"", "\"").replace("\\/", "/");
		if (atme) {
			content = content.replaceAll(new StringBuffer(atMyselfStr).append(".").toString(), "").trim();
			// AppLogger.sysDebug("content replace:" + content);
		}
		// MsgType 1文字 3图片 34语音 42名片 49文件 10000系统消息
		switch (msgType) {
		case 1:
			// Component c = conversationBox.getFellowIfAny("wxdialog");
			processTxtMsg(received_msg, citem_from, content, memberDisplayName, fromMyself, fromQun, atme);
			break;
		case 3:
			processImgMsg(received_msg, fromQun ? memberDisplayName : "");
			break;
		case 49:
			// https://file.wx2.qq.com/cgi-bin/mmwebwx-bin/webwxgetmedia?mediaid=@crypt_c26608c7_2b301104846b55f2439395d79e4e01a3670f7a7777ad919168d1cddb75bf8e316a38a9ea0e8568bb0417c26fc528a3b86070e148ddd3c586516ca670b87f77a40340f1b7921f2c70aea33d7790beddf5d9249da65f4942b09786b98145126981074e5d235e87d1c551fee84b6f5cb11775dad7e1c1c176a011b7e6f2902a7da9e77a9ef5211f69a665b172a081fc69facbc8af1aa274f6bcf61d62fcafed96b4656bb009088757d9a577b9ee6945031ae52573ca14adb43818a3b9d7e3e2b91173639d474219a3c54a83115f1c48c76b8336eca3b7cc3cb4b1761133bbb8587e&filename=aaa.txt&fromuser=16574375&webwx_data_ticket=gSf2SnNfL2ZhaZDtiYRIsqQY

			String webwx_data_ticket = "";
			for (String s : webwx.getWxlgBean().getCookie().split(";")) {
				s = s.trim();
				if (s.startsWith("webwx_data_ticket=")) {
					webwx_data_ticket = s.substring("webwx_data_ticket=".length());
				}
			}
			AppLogger.sysDebug("webwx_data_ticket:" + webwx_data_ticket);
			AppLogger.sysDebug("fileName:" + received_msg.getFileName());
			AppLogger.sysDebug("mediaId:" + received_msg.getMediaId());
			AppLogger.sysDebug("uin:" + webwx.getWxlgBean().getWxuin());
			break;
		default:
			break;
		}
	}

	public static final Pattern PATTERN_0 = Pattern.compile("^([aA])\\s*([指令]+$)");
	public static final Pattern PATTERN_1 = Pattern.compile("^([vV]|电压|告警电压)\\s*([\u4E00-\u9FFF\\s]+$)");
	public static final Pattern PATTERN_2 = Pattern.compile("^([bB][zZ]|保障)\\s*([\u4E00-\u9FFF\\s]+$)");
	public static final Pattern PATTERN_3 = Pattern.compile("^([lL][xX]|离线)\\s*([\u4E00-\u9FFF\\s]+$)");
	public static final Pattern PATTERN_4 = Pattern.compile("^([tT]|退服)\\s*([\u4E00-\u9FFF\\s]+$)");
	public static final Pattern PATTERN_5 = Pattern.compile("^([tT][dD]|停电统计)\\s*([\u4E00-\u9FFF\\s]+$)");
	public static final Pattern PATTERN_6 = Pattern.compile("^([zZ][bB]|重保)\\s*([\u4E00-\u9FFF\\s]+$)");

	private void processTxtMsg(final MessageJson received_msg, ContactItem citem_from, String content, String memberDisplayName, boolean fromMyself, boolean fromQun, boolean atme) {
		String fromUserName = received_msg.getFromUserName();
		// 读到的消息不是来自自己
		if (!fromMyself) {
			uiCallBack.received(received_msg, fromQun ? memberDisplayName : "", content, new Date());
			// boolean invalid_qun = citem_from != null &&
			// citem_from.getNickName().matches("(.*?)(张家界)(.*?)");
			// if (invalid_qun) {
			// return;
			// }

			// String allow_qun_regex = "";
			// if (SecurityUtil.IS_DEBUG) {
			// allow_qun_regex = "(.*?)(测试)(.*?)";
			// } else {
			// allow_qun_regex =
			// "(.*?)(益阳|安化|赫山|南县|桃江|沅江|资阳|值班机器人配置|监控机器人推广|衡阳|维护中心监控机房|娄底|常德|测试|广西|怀化|铁塔|发电)(.*?)";
			// }
			//
			// boolean allow_qun = citem_from != null &&
			// citem_from.getNickName().matches(allow_qun_regex);
			//
			// boolean allow_wxuser =
			// memberDisplayName.matches("(.*?)(fool喊姜|曹高|监控值班机器人|陈亮|晏雷)(.*?)");

			String reply = "";
			Matcher m0 = PATTERN_0.matcher(content);
			Matcher m1 = PATTERN_1.matcher(content);
			Matcher m2 = PATTERN_2.matcher(content);
			Matcher m3 = PATTERN_3.matcher(content);
			Matcher m4 = PATTERN_4.matcher(content);
			Matcher m5 = PATTERN_5.matcher(content);
			Matcher m6 = PATTERN_6.matcher(content);

			int serviceType = 1;
			if (m0.find()) {
				// reply = (allow_qun || allow_wxuser) ? replyService.help() :
				// replyService.invalidService();
				reply = replyService.help();
			} else if (m1.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m1.group(2), null, 1) :
				// replyService.invalidService();
				reply = replyService.localService(m1.group(2), null, 1);
			} else if (m2.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m2.group(2), null, 2) :
				// replyService.invalidService();
				reply = replyService.localService(m2.group(2), null, 2);
			} else if (m3.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m3.group(2), null, 3) :
				// replyService.invalidService();
				reply = replyService.localService(m3.group(2), null, 3);
			} else if (m4.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m4.group(2), null, 4) :
				// replyService.invalidService();
				reply = replyService.localService(m4.group(2), null, 4);
			} else if (m5.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m5.group(2), null, 5) :
				// replyService.invalidService();
				reply = replyService.localService(m5.group(2), null, 5);
			} else if (m6.find()) {
				// reply = (allow_qun || allow_wxuser) ?
				// replyService.localService(m6.group(2), null, 6) :
				// replyService.invalidService();
				reply = replyService.localService(m6.group(2), null, 6);
			} else {
				serviceType = 0;
				if (!fromQun) {
					if (content.matches("^\\d{4}$")) {
						if (!KeepItowerLogin.isLogin) {
							boolean reLoginRs = KeepItowerLogin.reLoginItower(content);
							reply = reLoginRs ? "登录成功！" : "登录失败,请重试！";
							serviceType = -1;
						} else {
							reply = "连接正常，无需登录！";
							serviceType = -1;
						}
					} else {
						reply = replyService.aiService(content, fromUserName);
						// reply = "";
						serviceType = 2;
					}
				} else {
					reply = "";
				}
			}

			// 群聊中@我
			if (fromQun && atme && serviceType == 0) {
				String qunName = citem_from.getNickName();
				reply = qunAtMe(qunName, fromUserName, memberDisplayName, content);
			}
			if (StringUtils.isNotEmpty(reply)) {
				// 调用服务返回链接
				if (reply.startsWith("http://localhost:9898/itowerElec/bz.jsp")) {
					BufferedImage bw = createBZImgToSend(reply);
					try {
						if (bw != null) {
							webwx.sendImgMsg(fromUserName, bw, "png");
							uiCallBack.sent(received_msg, bw, new Date());
						}
					} catch (Exception e) {
						AppLogger.sysError(e);
					}
				} else {
					try {
						webwx.sendTxtMsg(fromUserName, reply);
						// if (fromQun && atme) {
						// webwx.statusNotify(webwx.getWxlgBean(),
						// wxInit.getUser().getUserName(), userInQun);
						// }
						uiCallBack.sent(received_msg, reply, new Date());
						addBotChatLog_Send(fromQun, webwx, citem_from, reply, 1, serviceType);
					} catch (Exception e) {
						AppLogger.sysError(e);
					}
				}
				try {
					Thread.sleep(200);
					// 更新下syncKey
					webwx.getMsg();
				} catch (Exception e) {
					AppLogger.sysError(e);
				}
			}
		} else {
			uiCallBack.sent(received_msg, content, new Date());
		}
		addBotChatLog_Received(fromMyself, fromQun, webwx, citem_from, received_msg);
	}

	private void processImgMsg(final MessageJson received_msg, String memberDisplayName) {
		// uiCallBack.received(received_msg, memberDisplayName, "", new Date());
		// try {
		// BufferedImage bw = webwx.getImgMsg(received_msg.getMsgId(), true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public void addBotChatLog_Send(boolean fromQun, WebWX webwx, ContactItem cItem_to, String content, int msgType, int serviceType) {
		WebWxInitBean wib = webwx.getWxlgBean().getWebWxInitBean();
		BotChatLog log = new BotChatLog();
		log.setFrommyself(0);
		log.setReceiveorsend(1);// 0接收 1发送
		log.setFromgroup(fromQun ? 1 : 0);
		log.setFromuser(wib.getUser().getUserName());
		log.setFromusername(wib.getUser().getNickName());
		log.setTouser(cItem_to.getUserName());
		log.setTousername(cItem_to != null ? cItem_to.getNickName() : "");
		log.setContent(content);
		log.setMsgtype(msgType);
		log.setServicetype(serviceType);
		log.setLogtime(new Date());
		mainService.addBotChatLog(log);
	}

	public void addBotChatLog_Received(boolean fromMyself, boolean fromQun, WebWX webwx, ContactItem cItem_from, MessageJson msg) {
		WebWxInitBean wib = webwx.getWxlgBean().getWebWxInitBean();
		BotChatLog log = new BotChatLog();
		log.setFrommyself(fromMyself ? 1 : 0);
		log.setReceiveorsend(0);
		log.setFromgroup(fromQun ? 1 : 0);
		log.setFromuser(cItem_from.getUserName());
		log.setTouser(wib.getUser().getUserName());

		if (fromMyself) {
			ContactItem contactItem = webwx.getInitContactMap().get(msg.getToUserName());
			log.setFromusername(wib.getUser().getNickName());
			log.setTousername(contactItem != null ? contactItem.getNickName() : "");
		} else {
			ContactItem contactItem = webwx.getInitContactMap().get(msg.getFromUserName());
			log.setFromusername(contactItem != null ? contactItem.getNickName() : "");
			log.setTousername(wib.getUser().getNickName());
		}
		log.setMsgtype(msg.getMsgType());
		log.setServicetype(0);
		log.setContent(msg.getContent().trim());
		log.setLogtime(new Date());
		mainService.addBotChatLog(log);
	}
}