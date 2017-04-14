/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Vlayout;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.BotChatLog;
import com.fuhj.itower.service.MainService;
import com.fuhj.log.AppLogger;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.IUICallBack;
import com.fuhj.weixin.WebWXService;
import com.fuhj.weixin.json.ContactItem;
import com.fuhj.weixin.json.MessageJson;
import com.fuhj.weixin.json.UserInfo;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-18
 */
public class WeiXinBotVM implements IUICallBack {
	private Desktop desktop;
	private Component view;
	private Component loginBox;
	private Component conversationBox;
	private final WebWXService wwxService = WebWXService.getInstance();
	@Wire private Vlayout webwxContent;
	private MainService mainService;

	private static final DateFormat xdf = new SimpleDateFormat("HH:mm:ss");

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		mainService = SpringUtil.getBean(MainService.class);
		desktop = Executions.getCurrent().getDesktop();
		if (!desktop.isServerPushEnabled()) {
			desktop.enableServerPush(true);
		}
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		webwxInit();
	}

	public void webwxInit() {
		if (wwxService.isWebwxStart()) {
			wwxService.setUiCallback(this);
			chatBoxInit();
			chatBoxDataInit();
		} else {
			loginBox = Executions.createComponents("wxloginbox.zul", view, null);
			webwxContent.appendChild(loginBox);
			try {
				BufferedImage img = wwxService.getQRCode();
				if (img != null) {
					Component c = loginBox.getFellowIfAny("qrcodeimg");
					if (c != null) {
						Image qrcodeimg = (Image) c;
						qrcodeimg.setContent(img);
					}
					wwxService.setUiCallback(this);
					wwxService.startWebwx();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void chatBoxInit() {
		try {
			if (Events.inEventListener()) {
				if (loginBox != null) {
					view.removeChild(loginBox);
					loginBox.detach();
				}
				conversationBox = Executions.createComponents("wx_conversation.zul", view, null);
				webwxContent.appendChild(conversationBox);
			} else {
				Executions.activate(desktop);
				if (loginBox != null) {
					view.removeChild(loginBox);
					loginBox.detach();
				}
				conversationBox = Executions.createComponents("wx_conversation.zul", view, null);
				webwxContent.appendChild(conversationBox);
				Executions.deactivate(desktop);
			}
		} catch (DesktopUnavailableException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void chatBoxDataInit() {
		UserInfo user = wwxService.getWebwx().getWxlgBean().getWebWxInitBean().getUser();
		List<BotChatLog> list = mainService.getBotChatLog(user.getUserName(), new Date());
		for (BotChatLog log : list) {
			switch (log.getReceiveorsend()) {
			case 0:
				MessageJson msg1 = new MessageJson();
				msg1.setFromUserName(log.getFromusername());
				received(msg1, "", log.getContent(), log.getLogtime());
				break;
			case 1:
				MessageJson msg2 = new MessageJson();
				msg2.setToUserName(msg2.getToUserName());
				sent(msg2, log.getContent(), log.getLogtime());
				break;
			default:
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.weixin.IUICallBack#received()
	 */
	@Override public void received(final MessageJson received, final String displayName, final String content, final Date time)
			throws ServiceException {
		if (desktop == null || !desktop.isAlive() || !desktop.isServerPushEnabled()) {
			return;
		}
		ExecutorService exe = Executors.newSingleThreadExecutor();
		exe.submit(new Runnable() {
			@Override public void run() {

				Component c = conversationBox.getFellowIfAny("wxdialog");
				Grid grid = (Grid) c;
				ContactItem citem = wwxService.getWebwx().getInitContactMap().get(received.getFromUserName());

				try {
					Row row = new Row();
					row.setSpans("1,2");
					// row.setAction("");

					Div userdiv = new Div();
					userdiv.setSclass("user");
					Image userimg = new Image();
					if (citem != null) {
						BufferedImage bw = wwxService.getWebwx().getHeadImg(citem.getHeadImgUrl());
						if (bw != null) {
							userimg.setContent(bw);
						}
					}

					Div bodydiv = new Div();
					bodydiv.setSclass("body");

					A timea = new A();
					timea.setLabel(xdf.format(time));
					timea.setSclass("time blue");
					A usernamea = new A();

					String nickName = received.getFromUserName();

					if (citem != null) {
						nickName = citem.getNickName();
					}
					usernamea.setLabel(nickName);
					usernamea.setSclass("name");

					Div msgReceiveDiv = new Div();
					if (received.getMsgType() == 1) {
						msgReceiveDiv.setSclass("text");
						String[] array = content.split("\n|<br/>");

						for (String s : array) {
							Label lbl = new Label(s);
							lbl.setStyle("display: block");
							msgReceiveDiv.appendChild(lbl);
						}
						if (StringUtils.isNotEmpty(displayName)) {
							Label lbl = (Label) msgReceiveDiv.getFirstChild();
							lbl.setValue(displayName + ": " + lbl.getValue());
						}
					} else if (received.getMsgType() == 3) {
						Image img = new Image();
						BufferedImage bw = wwxService.getWebwx().getImgMsg(received.getMsgId(), true);
						img.setContent(bw);
						msgReceiveDiv.appendChild(img);
						img.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

							@Override public void onEvent(Event event) throws Exception {
								AppLogger.sysDebug("img onClick...");
							}
						});
					}
					userdiv.appendChild(userimg);
					bodydiv.appendChild(timea);
					bodydiv.appendChild(usernamea);
					bodydiv.appendChild(msgReceiveDiv);

					row.appendChild(userdiv);
					row.appendChild(bodydiv);

					Row spaceRow = new Row();
					spaceRow.setSpans("3");

					try {
						Executions.activate(desktop);
						// remove spaceRow
						// if (grid.getLastChild().getChildren().size() == 0) {
						// grid.removeChild(grid.getLastChild());
						// }
						grid.getRows().appendChild(row);
						grid.getRows().appendChild(spaceRow);
						Clients.scrollIntoView(spaceRow);
						Executions.deactivate(desktop);
					} catch (DesktopUnavailableException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		exe.shutdown();
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.weixin.IUICallBack#sent()
	 */
	@Override public void sent(final MessageJson msg, final String reply, final Date time) throws ServiceException {
		if (desktop == null || !desktop.isAlive() || !desktop.isServerPushEnabled()) {

			return;
		}
		ExecutorService exe = Executors.newSingleThreadExecutor();
		exe.submit(new Runnable() {

			@Override public void run() {
				Component c = conversationBox.getFellowIfAny("wxdialog");
				Grid grid = (Grid) c;
				UserInfo user = wwxService.getWebwx().getWxlgBean().getWebWxInitBean().getUser();
				try {
					String toUserName = msg.getToUserName();
					Row row = new Row();
					row.setSpans("2,1");
					Div userdiv = new Div();
					userdiv.setSclass("user2");
					Image userimg = new Image();
					// userimg.setTooltiptext("Jim's Avatar");
					BufferedImage bw = wwxService.getWebwx().getHeadImg(user.getHeadImgUrl());
					if (bw != null) {
						userimg.setContent(bw);
					}

					Div bodydiv = new Div();
					bodydiv.setSclass("body2 pull-right");
					A timea = new A();
					timea.setLabel(xdf.format(time));
					timea.setSclass("time2 blue");
					A usernamea = new A();

					usernamea.setLabel(user.getNickName());
					usernamea.setSclass("name");

					Div msgReceiveDiv = new Div();
					msgReceiveDiv.setSclass("text2");
					String[] array = reply.split("\n|<br/>");
					for (String s : array) {
						Label lbl = new Label(s);
						lbl.setStyle("display: block");
						msgReceiveDiv.appendChild(lbl);
					}
					userdiv.appendChild(userimg);
					bodydiv.appendChild(timea);
					bodydiv.appendChild(usernamea);
					bodydiv.appendChild(msgReceiveDiv);
					row.appendChild(bodydiv);
					row.appendChild(userdiv);

					Row spaceRow = new Row();
					spaceRow.setSpans("3");

					try {
						Executions.activate(desktop);
						// remove spaceRow
						// if (grid.getLastChild().getChildren().size() == 0) {
						// grid.removeChild(grid.getLastChild());
						// }
						grid.getRows().appendChild(row);
						grid.getRows().appendChild(spaceRow);
						Clients.scrollIntoView(spaceRow);
						Executions.deactivate(desktop);
					} catch (DesktopUnavailableException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		exe.shutdown();
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.weixin.IUICallBack#sent(com.fuhj.weixin.json.MessageJson, java.awt.image.BufferedImage, java.util.Date)
	 */
	@Override public void sent(MessageJson msg, BufferedImage reply, Date time) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.weixin.IUICallBack#loginCompleted()
	 */
	@Override public void loginCompleted() throws ServiceException {
		chatBoxInit();
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.weixin.IUICallBack#initCompleted()
	 */
	@Override public void initCompleted() throws ServiceException {
		// chatBoxDataInit();
	}

}
