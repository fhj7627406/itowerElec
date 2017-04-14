/**
 * 
 */
package com.fuhj.weixin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.net.ssl.SSLContext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fuhj.log.AppLogger;
import com.fuhj.util.JsonUtil;
import com.fuhj.weixin.json.BatchContactBean;
import com.fuhj.weixin.json.BatchContactJson;
import com.fuhj.weixin.json.BatchRequestKey;
import com.fuhj.weixin.json.ContactItem;
import com.fuhj.weixin.json.FullContactListBean;
import com.fuhj.weixin.json.HeartBeatBean;
import com.fuhj.weixin.json.KeyVal;
import com.fuhj.weixin.json.MessageJson;
import com.fuhj.weixin.json.SyncKey;
import com.fuhj.weixin.json.WebWxInitBean;
import com.fuhj.weixin.json.WebWxInitJson;
import com.fuhj.weixin.json.WebWxStatusNotifyBean;
import com.fuhj.weixin.json.WebWxStatusNotifyJson;
import com.fuhj.weixin.json.WebWxSyncPostBean;
import com.fuhj.weixin.json.WebWxSyncPostJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-21
 */
public class WebWX {
	private static final String DEFAULT_CHARSET = "UTF-8";
	@Getter @Setter private boolean isInitCompleted = false;
	@Getter @Setter private String domain_main = "wx.qq.com";
	@Getter @Setter private String domain_webpush = "webpush.weixin.qq.com";
	@Getter @Setter private String redirect_uri;
	@Getter @Setter private WXLoginBean wxlgBean = null;
	@Getter @Setter private String uuid;
	@Getter @Setter private Map<String, ContactItem> initContactMap;
	// 微信好友列表
	@Setter private Map<String, ContactItem> fullContactMap;
	@Setter private Map<String, ContactItem> fullContactNickNameMap;
	private final Gson gson = new Gson();
	/** 连接超时 */
	private static final int TIMEOUT_CONNECTION = 60000;
	/** 读取超时 */
	private static final int TIMEOUT_SOCKET = 60000;
	/** 重试3次 */
	private static final int RETRY_TIME = 3;
	private static final String HTTPS = "https://";
	private static final String WEB_PATH = "/cgi-bin/mmwebwx-bin/";

	private static HttpClientBuilder builder;

	static {
		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(
					null, new TrustStrategy() {
						public boolean isTrusted(X509Certificate[] chain,
								String authType) throws CertificateException {
							return true;
						}
					}).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		// SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).setSoTimeout(TIMEOUT_SOCKET).build();
		ConnectionConfig connectionConfig = ConnectionConfig.custom().setBufferSize(4096).build();
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(TIMEOUT_CONNECTION)
					.setConnectTimeout(TIMEOUT_CONNECTION).setSocketTimeout(TIMEOUT_SOCKET).build();
		builder = HttpClientBuilder.create();
		builder.disableContentCompression();
		builder.setSSLSocketFactory(sslsf);
		// builder.setDefaultSocketConfig(socketConfig);
		builder.setDefaultConnectionConfig(connectionConfig);
		builder.setDefaultRequestConfig(requestConfig);

		// HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
		// @Override public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
		// if (executionCount >= 5) {// 如果已经重试了5次，就放弃
		// return false;
		// }
		// if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
		// return true;
		// }
		// if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
		// return true;
		// }
		// if (exception instanceof InterruptedIOException) {// 超时
		// return true;
		// }
		// if (exception instanceof UnknownHostException) {// 目标服务器不可达
		// return true;
		// }
		// if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
		// return true;
		// }
		// if (exception instanceof SSLException) {// ssl握手异常
		// return true;
		// }
		// HttpClientContext clientContext = HttpClientContext.adapt(context);
		// HttpRequest request = clientContext.getRequest();
		// // 如果请求是幂等的，就再次尝试
		// if (!(request instanceof HttpEntityEnclosingRequest)) {
		// return true;
		// }
		// return false;
		// }
		// };
		// builder.setRetryHandler(retryHandler);
	}

	/**
	 * 访问微信服务器获取会话ID
	 * 
	 * @return
	 * @throws Exception
	 */
	public void getLoginUUID() throws Exception {
		String uid = "";
		String url = "https://login.weixin.qq.com/jslogin?appid=wx782c26e4c19acffb&redirect_uri=https%3A%2F%2Fwx.qq.com%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage&fun=new&lang=zh_CN&_="
				+ System.currentTimeMillis();
		String str = null;

		try {
			Executor executor = Executor.newInstance(builder.build());
			str = executor.execute(Request.Get(url)).returnContent().asString();
			Pattern p = Pattern.compile("window.QRLogin.code = (.*?); window.QRLogin.uuid = \"(.*?)\";");
			Matcher matcher = p.matcher(str);
			if (matcher.find()) {
				if (matcher.group(1).equals("200")) {
					uid = matcher.group(2);
				}
			}
			setUuid(uid);
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
		AppLogger.sysDebug("STEP 1: UUID=" + uid);
	}

	/**
	 * 通过会话ID获得二维码图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public BufferedImage getQRCode() throws Exception {
		BufferedImage img = null;
		try {
			Executor executor = Executor.newInstance(builder.build());
			img = ImageIO.read(executor.execute(Request.Get("https://login.weixin.qq.com/qrcode/" + getUuid()))
						.returnContent()
						.asStream());
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
		AppLogger.sysDebug("STEP 2: getQRCode");
		return img;
	}

	/**
	 * 用作轮询手机端是否已经扫描二维码并确认在Web端登录
	 * 
	 * @return code: 408 登陆超时 201 扫描成功 200 确认登录
	 * @throws Exception
	 */
	public int scanImgCheck() throws Exception {
		StringBuffer loginUrl = new StringBuffer("https://login.weixin.qq.com").append(WEB_PATH)
				.append("login?uuid=").append(getUuid())
				.append("&tip=1&_=").append(System.currentTimeMillis());
		String codeStr = "";
		int code = -1;

		try {
			Executor executor = Executor.newInstance(builder.build());
			codeStr = executor.execute(Request.Get(loginUrl.toString())).returnContent().asString();
			if (codeStr.contains("window.code")) {
				String windowcode = codeStr.substring("window.code=".length(),
							"window.code=".length() + 3);
				code = Integer.parseInt(windowcode);
				if (code == 200) {
					String url = codeStr.substring(
								"window.code=200;window.redirect_uri=".length() + 2,
								codeStr.length() - 2);
					setRedirect_uri(url);
				}
			}
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
		AppLogger.sysDebug("STEP 3: code=" + code);
		return code;
	}

	/**
	 * 访问登录地址，获得uin和sid
	 * 
	 * @throws Exception
	 */
	public void wxLogin() throws Exception {
		// https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxnewloginpage?ticket=AUPzufD0Nbk0YcxYgZ_K2qGY@qrticket_0&uuid=gfdQ5qV6mg==&lang=zh_CN&scan=1461246920
		String redirect_uri_host = new URL(redirect_uri).getHost();
		// // 此处可能域名返回wx.qq.com|wx2.qq.com
		if ("wx2.qq.com".equals(redirect_uri_host)) {
			setDomain_main("wx2.qq.com");
			setDomain_webpush("webpush2.weixin.qq.com");
		}
		BasicCookieStore cookieStore = new BasicCookieStore();
		int time = 0;
		do {
			// 这里如果不禁用重定向，response.getEntity().getContent()将会获得重定向后的网页内容
			CloseableHttpClient client = HttpClients
					.custom()
					.disableRedirectHandling()
					.setDefaultCookieStore(cookieStore)
					.build();
			HttpGet httpGet = new HttpGet(redirect_uri);
			StringBuffer cookie_sb = new StringBuffer();
			String skey = "", wxsid = "", wxuin = "", pass_ticket = "";
			try {
				HttpResponse response = client.execute(httpGet);
				for (Cookie c : cookieStore.getCookies()) {
					cookie_sb.append(c.getName()).append("=").append(c.getValue()).append("; ");
				}
				HttpEntity entity = response.getEntity();
				if (entity == null) {
					throw new ClientProtocolException("Response contains no content");
				}
				Document doc = DocumentHelper.parseText(IOUtils.toString(entity.getContent()));
				Element rootElt = doc.getRootElement();
				skey = rootElt.elementTextTrim("skey");
				wxsid = rootElt.elementTextTrim("wxsid");
				wxuin = rootElt.elementTextTrim("wxuin");
				pass_ticket = rootElt.elementTextTrim("pass_ticket");
				AppLogger.sysDebug("STEP 4: XML:" + doc.asXML());
				AppLogger.sysDebug("STEP 4: cookie:" + cookie_sb);
				setWxlgBean(new WXLoginBean(skey, wxsid, wxuin, pass_ticket, cookie_sb.toString()));
				break;
			} catch (Exception e) {
				AppLogger.sysError(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					throw e;
				}
			} finally {
				try {
					client.close();
				} catch (IOException e) {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
	}

	/**
	 * 初始化微信信息
	 * 
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public void wxInit() throws Exception {
		StringBuffer initUrl = new StringBuffer(getWXURI())
				.append("webwxinit?r=").append(System.currentTimeMillis())
				.append("&pass_ticket=").append(wxlgBean.getPass_ticket());

		WebWxInitJson json = new WebWxInitJson(wxlgBean.bulidBaseRequest());
		String body = gson.toJson(json);
		AppLogger.sysDebug("STEP 5 body:" + body);

		try {
			Executor executor = Executor.newInstance(builder.build());
			WebWxInitBean bean = executor.execute(
						Request.Post(initUrl.toString())
								.version(HttpVersion.HTTP_1_1)
								.bodyString(body.toString(), ContentType.APPLICATION_JSON))
						.handleResponse(new MyHandler<WebWxInitBean>(WebWxInitBean.class));
			wxlgBean.setWebWxInitBean(bean);
			initContactMap = new HashMap<String, ContactItem>();
			for (ContactItem item : bean.getContactList()) {
				initContactMap.put(item.getUserName(), item);
			}
			AppLogger.sysDebug("***************loginUserName: " + wxlgBean.getWebWxInitBean().getUser().getUserName() + "***************");
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
	}

	/**
	 * 设备通知
	 * 
	 * @param code 3初始化心跳同步 1收消息后同步
	 * @throws Exception
	 * @throws IOException
	 */
	public void statusNotify(int code, String from, String to) throws Exception {
		WebWxStatusNotifyJson json = new WebWxStatusNotifyJson();
		json.setBr(wxlgBean.bulidBaseRequest());
		json.setCode(code);
		json.setFromUserName(from);
		json.setToUserName(to);
		json.setClientMsgId(System.currentTimeMillis());

		String body = gson.toJson(json);
		AppLogger.sysDebug("wwsnotify:" + body);
		StringBuffer notifyUrl = new StringBuffer(getWXURI())
				.append("webwxstatusnotify?lang=zh_CN&pass_ticket=")
				.append(wxlgBean.getPass_ticket());
		try {
			Executor executor = Executor.newInstance(builder.build());
			WebWxStatusNotifyBean bean = executor.execute(
					Request.Post(notifyUrl.toString())
							.version(HttpVersion.HTTP_1_1)
							.addHeader("Cookie", wxlgBean.getCookie())
							.bodyString(body, ContentType.APPLICATION_JSON))
					.handleResponse(new MyHandler<WebWxStatusNotifyBean>(WebWxStatusNotifyBean.class));
			AppLogger.sysDebug("statusNotify:" + bean);
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
	}

	public void statusNotify() throws Exception {
		AppLogger.sysDebug("首次statusNotify");
		String userName = wxlgBean.getWebWxInitBean().getUser().getUserName();
		statusNotify(3, userName, userName);
	}

	public void statusNotify(WXLoginBean loginBean, String from, String to) throws Exception {
		AppLogger.sysDebug("普通statusNotify");
		statusNotify(1, from, to);
	}

	/**
	 * 保持与服务器的信息同步，心跳包获取 retcode: 0 正常 1100 失败/登出微信 selector: 0 正常 2 新的消息 7 进入/离开聊天界面
	 * 
	 * @return
	 * @throws IOException
	 */
	public HeartBeatBean wxsyncCheck() throws Exception {
		String skey_ = encode(wxlgBean.getSkey());
		String sid_ = encode(wxlgBean.getWxsid());
		String synckey_ = encode(parseSynckey(wxlgBean.getWebWxInitBean().getSyncKey()));

		// AppLogger.sysDebug("synckey parsed:" + synckey_);
		StringBuffer syncCheckUrl = new StringBuffer(getWXPushURI())
				.append("synccheck?r=").append(System.currentTimeMillis())
				.append("&skey=").append(skey_)
				.append("&sid=").append(sid_)
				.append("&uin=").append(wxlgBean.getWxuin())
				.append("&deviceid=").append(wxlgBean.getDeviceid())
				.append("&synckey=").append(synckey_)
				.append("&_=").append(wxlgBean.get_count());

		// AppLogger.sysDebug("syncCheckUrl:" + syncCheckUrl);
		HeartBeatBean hbb = null;
		int time = 0;
		do {
			try {
				Executor executor = Executor.newInstance(builder.build());
				String rs = executor.execute(Request.Get(syncCheckUrl.toString())
						.version(HttpVersion.HTTP_1_1)
						.addHeader("Cookie", wxlgBean.getCookie())
						.addHeader(HTTP.TARGET_HOST, getDomain_webpush())
						.addHeader("Referer", new StringBuffer("https://").append(getDomain_main()).append("/?&lang=zh_CN").toString())
						.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE))
						.returnContent().asString();
				hbb = HeartBeatBean.parseString(rs);
				wxlgBean.set_count(wxlgBean.get_count() + 1);
				break;
			} catch (Exception e) {
				AppLogger.sysError(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		AppLogger.sysDebug(new StringBuilder("<<<<<<<<<<<<<<<<<<<<<").append(hbb).append(">>>>>>>>>>>>>>>>>>>>>"));
		return hbb;
	}

	/**
	 * 获得别人发来的消息 MsgType 1文字 3图片 34语音 42名片 49文件 10000系统消息
	 * 
	 * @return WebWxSyncPostBean 消息JSON对象
	 * @throws IOException
	 */
	public WebWxSyncPostBean getMsg() throws Exception {
		WebWxSyncPostJson json = new WebWxSyncPostJson(wxlgBean.bulidBaseRequest(), wxlgBean.getWebWxInitBean().getSyncKey());
		String body = gson.toJson(json);
		// AppLogger.sysDebug("getMsg body: " + body);

		StringBuffer msgUrl = new StringBuffer(getWXURI())
				.append("webwxsync?sid=").append(wxlgBean.getWxsid())
				.append("&skey=").append(wxlgBean.getSkey())
				.append("&lang=zh_CN&pass_ticket=").append(wxlgBean.getPass_ticket());

		WebWxSyncPostBean bean = null;
		int time = 0;
		do {
			try {
				Executor executor = Executor.newInstance(builder.build());
				bean = executor.execute(Request.Post(msgUrl.toString())
						.version(HttpVersion.HTTP_1_1)
						.addHeader("Cookie", wxlgBean.getCookie())
						.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE)
						.addHeader(HTTP.TARGET_HOST, getDomain_main())
						.addHeader("Referer", new StringBuffer("https://").append(getDomain_main()).toString())
						.addHeader("Cache-Control", "max-age=0")
						.addHeader("Content-Type", "application/json;charset=utf-8")
						.bodyString(body, ContentType.APPLICATION_JSON))
						.handleResponse(new MyHandler<WebWxSyncPostBean>(WebWxSyncPostBean.class));

				// 更新SyncKey
				if (bean != null) {
					wxlgBean.getWebWxInitBean().setSyncKey(bean.getSyncKey());
				}
				break;
			} catch (Exception e) {
				AppLogger.sysError(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		if (bean != null) {
			for (MessageJson mj : bean.getAddMsgList()) {
				String contentUnescape = StringEscapeUtils.unescapeHtml(mj.getContent()).trim();
				mj.setContent(contentUnescape);
				AppLogger.sysDebug(new StringBuilder("msg content:").append(contentUnescape));
			}
		}
		return bean;
	}

	public BufferedImage getImgMsg(long msgId, boolean slave) throws Exception {
		StringBuffer msgUrl = new StringBuffer(getWXURI())
				.append("webwxgetmsgimg?MsgID=").append(msgId)
				.append("&skey=").append(wxlgBean.getSkey())
				.append(slave ? "&type=slave" : "");

		int time = 0;
		do {
			try {
				Executor executor = Executor.newInstance(builder.build());
				InputStream is = executor.execute(Request.Get(msgUrl.toString())
						.version(HttpVersion.HTTP_1_1)
						.addHeader("Cookie", wxlgBean.getCookie())
						.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE)
						.addHeader(HTTP.TARGET_HOST, getDomain_main())
						.addHeader("Referer", new StringBuffer("https://").append(getDomain_main()).toString())
						).returnContent().asStream();
				return ImageIO.read(is);
			} catch (Exception e) {
				AppLogger.sysError(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		return null;
	}

	/**
	 * 向用户发送文本消息
	 * 
	 * @param toUserName
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String sendTxtMsg(String toUserName, String content) throws Exception {
		// AppLogger.sysDebug("sendTxtMsg()");
		String sendMsgrs = "";

		StringBuffer sendMsgUrl = new StringBuffer(getWXURI())
				.append("webwxsendmsg?lang=zh_CN&pass_ticket=")
				.append(wxlgBean.getPass_ticket());

		JSONObject sendMsgJson = new JSONObject();
		JSONObject msgbr = new JSONObject();
		long now = System.currentTimeMillis();
		String localID = String.valueOf(Math.random());
		localID = now + localID.substring(localID.length() - 4, localID.length());
		msgbr.put("ClientMsgId", localID);
		msgbr.put("Content", content);
		msgbr.put("FromUserName", wxlgBean.getWebWxInitBean().getUser().getUserName());
		msgbr.put("LocalID", localID);
		msgbr.put("ToUserName", toUserName);
		msgbr.put("Type", 1);
		sendMsgJson.put("BaseRequest", gson.toJson(wxlgBean.bulidBaseRequest()));
		sendMsgJson.put("Msg", msgbr);

		AppLogger.sysDebug("sendMsgJson.toString():" + sendMsgJson.toString());
		int time = 0;
		do {
			try {
				Executor executor = Executor.newInstance(builder.build());
				sendMsgrs = executor.execute(Request.Post(sendMsgUrl.toString())
						.bodyString(sendMsgJson.toString(), ContentType.APPLICATION_JSON))
						.returnContent()
						.asString();
				break;
			} catch (Exception e) {
				AppLogger.sysError(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		// AppLogger.sysDebug("sendMsgrs:" + jsonFormatter(sendMsgrs));
		return sendMsgrs;
	}

	public String upload(WXLoginBean wxlb, File file, int mediaType, String toUserName) {

		String webwx_data_ticket = "";
		for (String s : wxlb.getCookie().split(";")) {
			s = s.trim();
			if (s.startsWith("webwx_data_ticket=")) {
				webwx_data_ticket = s.substring("webwx_data_ticket=".length());
			}
		}
		String mediaId = "";
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		HttpURLConnection conn = null;
		try {
			if (!file.exists() || !file.isFile()) {
				throw new IOException("文件不存在");
			}

			// 请求头参数
			String boundary = "---------------------------11549180028070"; // 区分每个参数之间
			String freFix = "--";
			String newLine = "\r\n";

			URL urlObj = new URL(new StringBuffer(getWXUploadURI()).append("webwxuploadmedia?f=json").toString());
			conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			conn.setRequestProperty("Host", new StringBuffer("file.").append(getDomain_main()).toString());
			String origin = new StringBuffer(HTTPS).append(getDomain_main()).toString();
			conn.setRequestProperty("Origin", origin);
			conn.setRequestProperty("Referer", new StringBuffer(origin).append("/?&lang=zh_CN").toString());
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0");

			// 请求主体
			StringBuffer sb = new StringBuffer();

			sb.append(freFix + boundary).append(newLine); // 这里注意多了个freFix，来区分去请求头中的参数
			sb.append("Content-Disposition: form-data; name=\"id\"");
			sb.append(newLine).append(newLine);
			sb.append("WU_FILE_0").append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"name\"");
			sb.append(newLine).append(newLine);
			sb.append(file.getName()).append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"type\"");
			sb.append(newLine).append(newLine);
			sb.append("image/png").append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"lastModifiedDate\"");
			sb.append(newLine).append(newLine);
			sb.append("Mon Apr 25 2016 15:24:21 GMT+0800").append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"size\"");
			sb.append(newLine).append(newLine);
			sb.append(file.length()).append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"mediatype\"");
			sb.append(newLine).append(newLine);
			sb.append("pic").append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"uploadmediarequest\"");
			sb.append(newLine).append(newLine);
			sb.append("{\"UploadType\":2,\"BaseRequest\":{\"Uin\":" + wxlgBean.getWxuin() + ",\"Sid\":\"" + wxlb.getWxsid() + "\",\"Skey\":\""
							+ wxlb.getSkey() + "\",\"DeviceID\":\"e742702725208037\"},\"ClientMediaId\":" + System.currentTimeMillis()
							+ ",\"TotalLen\":" + file.length() + ",\"StartPos\":0,\"DataLen\":" + file.length()
							+ ",\"MediaType\":" + mediaType + ",\"FromUserName\":\"" + wxlb.getWebWxInitBean().getUser().getUserName()
							+ "\",\"ToUserName\":\"" + toUserName + "\",\"FileMd5\":\"813a0ae79d69ffc2198d59918907a327\"}")
					.append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"webwx_data_ticket\"");
			sb.append(newLine).append(newLine);
			sb.append(webwx_data_ticket).append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"pass_ticket\"");
			sb.append(newLine).append(newLine);
			sb.append(wxlgBean.getPass_ticket()).append(newLine);

			sb.append(freFix + boundary).append(newLine);
			sb.append("Content-Disposition: form-data; name=\"filename\"; filename=\"" + file.getName() + "\"");
			sb.append(newLine);
			sb.append("Content-Type: image/png");
			sb.append(newLine).append(newLine);

			OutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			outputStream.write(sb.toString().getBytes("utf-8"));// 写入请求参数

			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[512];
			while ((bytes = dis.read(bufferOut)) != -1) {
				outputStream.write(bufferOut, 0, bytes);// 写入图片
			}
			outputStream.write(newLine.getBytes());
			outputStream.write((freFix + boundary + freFix + newLine).getBytes(DEFAULT_CHARSET));// 标识请求数据写入结束

			dis.close();
			outputStream.close();

			// 读取响应信息
			inputStream = conn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, DEFAULT_CHARSET);
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			@SuppressWarnings("rawtypes") Map map = JsonUtil.getMapFromJsonString(buffer.toString());
			mediaId = map.get("MediaId") != null ? map.get("MediaId").toString() : "";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			try {
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return mediaId;
	}

	public String sendImgMsg(String toUserName, BufferedImage bw, String format) throws Exception {
		File tempFile = File.createTempFile("ite_temp_" + System.currentTimeMillis(), ".tmp");
		int mediaType = 4;
		String sendImgMsgrs = "";
		boolean temp = ImageIO.write(bw, format, tempFile);
		String mediaId = temp ? upload(wxlgBean, tempFile, mediaType, toUserName) : ""; // 执行图片上传，返回流媒体id。PS：微信网页版中的发送文件/图片/等分为两步1.上传到服务器拿到返回的mediaId,2.发送通知消息

		if (StringUtils.isNotEmpty(mediaId)) {
			JSONObject sendMsgJson = new JSONObject();
			JSONObject msgbr = new JSONObject();
			long now = System.currentTimeMillis();
			String localID = String.valueOf(Math.random());
			localID = now + localID.substring(localID.length() - 4, localID.length());
			msgbr.put("Type", 3);
			msgbr.put("MediaId", mediaId);
			msgbr.put("FromUserName", wxlgBean.getWebWxInitBean().getUser().getUserName());
			msgbr.put("ToUserName", toUserName);
			msgbr.put("LocalID", localID);
			msgbr.put("ClientMsgId", localID);

			sendMsgJson.put("BaseRequest", gson.toJson(wxlgBean.bulidBaseRequest()));
			sendMsgJson.put("Msg", msgbr);
			sendMsgJson.put("Scene", 0);

			StringBuffer sendImgMsgUrl = new StringBuffer(getWXURI())
					.append("webwxsendmsgimg?fun=async&f=json&lang=zh_CN&pass_ticket=")
					.append(wxlgBean.getPass_ticket());

			Executor executor = Executor.newInstance(builder.build());
			sendImgMsgrs = executor.execute(Request.Post(sendImgMsgUrl.toString())
					.bodyString(sendMsgJson.toString(), ContentType.APPLICATION_JSON))
					.returnContent()
					.asString();
			tempFile.delete();
		}
		return sendImgMsgrs;
	}

	public FullContactListBean getFullContact() throws Exception {
		StringBuffer contactUrl = new StringBuffer(getWXURI())
				.append("webwxgetcontact?r=").append(System.currentTimeMillis())
				.append("&seq=0&skey=").append(wxlgBean.getSkey());
		FullContactListBean bean = null;
		try {
			Executor executor = Executor.newInstance(builder.build());
			bean = executor.execute(Request.Get(contactUrl.toString())
						.version(HttpVersion.HTTP_1_1)
						.addHeader("Cookie", wxlgBean.getCookie())
						.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE)
						.addHeader(HTTP.TARGET_HOST, getDomain_main())
						.addHeader("Referer", new StringBuffer("https://").append(getDomain_main()).toString()))
					.handleResponse(new MyHandler<FullContactListBean>(FullContactListBean.class));
			fullContactMap = new HashMap<String, ContactItem>();
			fullContactNickNameMap = new HashMap<String, ContactItem>();
			for (ContactItem item : bean.getMemberList()) {
				fullContactMap.put(item.getUserName(), item);
				fullContactNickNameMap.put(item.getNickName(), item);
			}
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
		// AppLogger.sysDebug("FullContactListBean:" + bean);
		return bean;
	}

	public BatchContactBean batchGetContact(final String userName, final String EncryChatRoomId) throws Exception {
		StringBuffer contactUrl = new StringBuffer(getWXURI())
				.append("webwxbatchgetcontact?TYPE=ex&r=").append(System.currentTimeMillis());
		BatchContactBean bean = null;
		BatchContactJson json = new BatchContactJson();
		json.setBr(wxlgBean.bulidBaseRequest());
		json.setCount(1);
		List<BatchRequestKey> rList = new ArrayList<BatchRequestKey>();
		rList.add(new BatchRequestKey(userName, EncryChatRoomId));
		json.setList(rList);
		String body = gson.toJson(json);
		try {
			Executor executor = Executor.newInstance(builder.build());
			bean = executor.execute(Request.Post(contactUrl.toString())
					.version(HttpVersion.HTTP_1_1)
					.addHeader("Cookie", wxlgBean.getCookie())
					.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE)
					.addHeader(HTTP.TARGET_HOST, getDomain_main())
					.addHeader("Referer", new StringBuffer("https://").append(getDomain_main()).toString())
					.addHeader("Content-Type", "application/json;charset=utf-8")
					.bodyString(body, ContentType.APPLICATION_JSON))
					.handleResponse(new MyHandler<BatchContactBean>(BatchContactBean.class));
		} catch (Exception e) {
			AppLogger.sysError(e);
			throw e;
		}
		return bean;
	}

	public BatchContactBean batchGetContact(final String userName) throws Exception {
		return batchGetContact(userName, "");
	}

	public BufferedImage getHeadImg(String headImgUrl) {
		try {
			Executor executor = Executor.newInstance(builder.build());
			InputStream is = executor.execute(Request.Get(new StringBuffer(HTTPS).append(getDomain_main()).append(headImgUrl).toString())
					.version(HttpVersion.HTTP_1_1)
					.addHeader("Cookie", wxlgBean.getCookie()))
					.returnContent()
					.asStream();
			return ImageIO.read(is);
		} catch (Exception e) {
			AppLogger.sysError(e);
		}
		return null;
	}

	public String jsonFormatter(String uglyJSONString) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

	public String getWXURI() {
		return new StringBuffer(HTTPS).append(getDomain_main()).append(WEB_PATH).toString();
	}

	public String getWXPushURI() {
		return new StringBuffer(HTTPS).append(getDomain_webpush()).append(WEB_PATH).toString();
	}

	public String getWXUploadURI() {
		return new StringBuffer(HTTPS).append("file.").append(getDomain_main()).append(WEB_PATH).toString();
	}

	/**
	 * syncKey转换，参照心跳包的请求格式
	 * 
	 * @param syncKey
	 * @return
	 */
	public String parseSynckey(SyncKey syncKey) {
		StringBuffer sb = new StringBuffer();
		for (KeyVal kv : syncKey.getKeyList()) {
			sb.append(kv.getKey());
			sb.append("_");
			sb.append(kv.getVal());
			sb.append("|");
		}
		return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
	}

	public String encode(String str) {
		return encode(str, DEFAULT_CHARSET);
	}

	public String encode(String str, String charset) {
		String s = "";
		try {
			s = URLEncoder.encode(str, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * @return the fullContactMap
	 */
	public Map<String, ContactItem> getFullContactMap() {
		if (fullContactMap == null || fullContactMap.isEmpty()) {
			try {
				getFullContact();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fullContactMap;
	}

	/**
	 * @return the fullContactNickNameMap
	 */
	public Map<String, ContactItem> getFullContactNickNameMap() {
		if (fullContactNickNameMap == null || fullContactNickNameMap.isEmpty()) {
			try {
				getFullContact();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fullContactNickNameMap;
	}

	/**
	 * 处理响应的JSON串转对象
	 * 
	 * @Description: TODO
	 * @author fu
	 * @date 2016-4-23
	 */
	@Data @AllArgsConstructor class MyHandler<T> implements ResponseHandler<T> {
		private Class<T> clazz;

		@Override public T handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			String rs = "";
			try {
				HttpEntity entity = response.getEntity();
				if (entity == null) {
					throw new ClientProtocolException("Response contains no content");
				}

				rs = IOUtils.toString(entity.getContent(), DEFAULT_CHARSET);
				// AppLogger.sysDebug("-------ResponseHandler--------");
				// AppLogger.sysDebug(clazz.getSimpleName());
				// AppLogger.sysDebug(rs);
				// AppLogger.sysDebug("-------ResponseHandler--------");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return gson.fromJson(rs.toString(), clazz);
		}
	}
}
