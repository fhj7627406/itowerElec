package com.fuhj.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.HTMLWriter;
import org.dom4j.io.OutputFormat;

import com.fuhj.log.AppLogger;

public class RequestHelper {
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	/** 连接超时 */
	private static final int TIMEOUT_CONNECTION = 10000;
	/** 读取超时 */
	private static final int TIMEOUT_SOCKET = 30000;
	/** 重试3次 */
	private static final int RETRY_TIME = 3;

	public static String request(String url, String method, Map<String, String> headerMap, Map<String, String> formMap, String reqCharset,
			String resCharset) throws Exception {
		StringBuffer params = new StringBuffer();
		StringBuffer result = new StringBuffer();
		int time = 0;
		do {
			HttpURLConnection conSend = null;
			BufferedReader reader = null;
			try {
				URL urlSend = new URL(url);
				conSend = (HttpURLConnection) urlSend.openConnection();
				conSend.setDoInput(true);
				conSend.setConnectTimeout(TIMEOUT_CONNECTION);
				conSend.setReadTimeout(TIMEOUT_SOCKET);
				conSend.setUseCaches(false);

				if (method.equals(METHOD_POST)) {
					conSend.setRequestMethod(METHOD_POST);
				}

				if (headerMap != null && headerMap.size() > 0) {
					for (Entry<String, String> e : headerMap.entrySet()) {
						conSend.setRequestProperty(e.getKey(), e.getValue());
					}
				}
				if (formMap != null && formMap.size() > 0) {
					conSend.setDoOutput(true);
					for (Entry<String, String> e : formMap.entrySet()) {
						params.append(e.getKey());
						params.append("=");
						params.append(e.getValue());
						params.append("&");
					}
					params.deleteCharAt(params.length() - 1);
					OutputStreamWriter out = StringUtils.isEmpty(reqCharset) ? new OutputStreamWriter(conSend.getOutputStream())
							: new OutputStreamWriter(
									conSend.getOutputStream(), reqCharset);
					out.write(params.toString());
					out.close();
				}
				reader = StringUtils.isEmpty(resCharset) ? new BufferedReader(new InputStreamReader(conSend.getInputStream()))
						: new BufferedReader(new InputStreamReader(
								conSend.getInputStream(), resCharset));
				String rs = "";
				while ((rs = reader.readLine()) != null) {
					result.append(rs);
				}
				break;
			} catch (Exception e) {
				AppLogger.sysDebug("发生错误，重试请求");
				// AppLogger.sysDebug(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					e.printStackTrace();
					throw e;
				}
			} finally {
				try {
					if (reader != null)
						reader.close();
				} catch (IOException e) {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		return StringEscapeUtils.unescapeHtml(result.toString());
	}

	public static String request(String url, String method, Map<String, String> headerMap, Map<String, String> formMap) throws Exception {
		return request(url, method, headerMap, formMap, "", "");
	}

	public static String request(String url, String method, Map<String, String> headerMap, String formString, String reqCharset, String resCharset)
			throws Exception {
		StringBuffer result = new StringBuffer();
		int time = 0;
		do {
			HttpURLConnection conSend = null;
			InputStream is = null;
			BufferedReader reader = null;
			try {
				URL urlSend = new URL(url);
				conSend = (HttpURLConnection) urlSend.openConnection();
				conSend.setDoInput(true);
				conSend.setDoOutput(true);
				conSend.setUseCaches(false);
				if (method.equals(METHOD_POST)) {
					conSend.setRequestMethod(METHOD_POST);
				}

				if (headerMap != null && headerMap.size() > 0) {
					for (Entry<String, String> e : headerMap.entrySet()) {
						conSend.setRequestProperty(e.getKey(), e.getValue());
					}
				}
				if (StringUtils.isNotEmpty(formString)) {
					// java.net.ConnectException: Connection timed out: connect
					OutputStream os = conSend.getOutputStream();
					OutputStreamWriter out = new OutputStreamWriter(os, reqCharset);
					out.write(formString);
					out.close();
					os.close();
				}
				is = conSend.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, resCharset));
				String rs = "";
				while ((rs = reader.readLine()) != null) {
					result.append(rs);
				}
				break;
			} catch (Exception e) {
				AppLogger.sysDebug("发生错误，重试请求");
				// AppLogger.sysDebug(e);
				time++;
				if (time < RETRY_TIME) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					}
					continue;
				} else {
					e.printStackTrace();
					throw e;
				}
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (is != null) {
						is.close();
					}
				} catch (IOException e) {
					throw e;
				}
			}
		} while (time < RETRY_TIME);
		return StringEscapeUtils.unescapeHtml(result.toString());
	}

	public static BufferedImage getImg(String url, Map<String, String> headerMap) throws Exception {
		BufferedImage img = null;
		URL urlSend = new URL(url);
		HttpURLConnection conSend = (HttpURLConnection) urlSend.openConnection();
		conSend.setDoInput(true);
		conSend.setUseCaches(false);
		if (headerMap != null && headerMap.size() > 0) {
			for (Entry<String, String> e : headerMap.entrySet()) {
				conSend.setRequestProperty(e.getKey(), e.getValue());
			}
		}
		img = ImageIO.read(conSend.getInputStream());
		return img;
	}

	public static String formatHtml(String str) throws Exception {
		Document document = null;
		document = DocumentHelper.parseText(str);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		StringWriter writer = new StringWriter();
		HTMLWriter htmlWriter = new HTMLWriter(writer, format);
		htmlWriter.write(document);
		htmlWriter.close();
		return writer.toString();
	}
}
