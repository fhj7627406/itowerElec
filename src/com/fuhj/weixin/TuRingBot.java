/**
 * 
 */
package com.fuhj.weixin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.fuhj.log.AppLogger;

import net.sf.json.JSONObject;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-17
 */
public class TuRingBot {
	public static final String TURING_API = "http://www.tuling123.com/openapi/api";
	public static final String TURING_API_KEY = "8f9c7bb044c5f32b5c0b0d703ee1be51";
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final Map<String, String> REPLACE_KEYWORD = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6766846479575296886L;

		{
			put("图灵机器人", "小黄T-800");
			put("Turingrobot", "fuhj_robot");
			put("<br>", "\n");
		}
	};

	public String talk(String msg) throws IOException {
		return talk(msg, null);
	}

	// Code 说明
	// 100000 文本类
	// 200000 链接类
	// 302000 新闻类
	// 308000 菜谱类
	// 313000（儿童版） 儿歌类
	// 314000（儿童版） 诗词类
	public String talk(String msg, String userid) {
		Form form = Form.form();
		form.add("key", TURING_API_KEY);
		form.add("info", msg);
		if (StringUtils.isNotEmpty(userid)) {
			form.add("userid", userid);
		}
		List<NameValuePair> bodyForm = form.build();
		String rs = "";
		try {
			rs = Request.Post(TURING_API).version(HttpVersion.HTTP_1_1).bodyForm(bodyForm, Consts.UTF_8).execute().returnContent().asString(Consts.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AppLogger.sysDebug("TuRingBot says:" + rs);
		JSONObject json = JSONObject.fromObject(rs);
		String code = json.getString("code");
		String reply = json.getString("text");
		if (code.equals("100000")) {

		} else if (code.equals("200000")) {

		} else if (code.equals("302000")) {

		} else if (code.equals("308000")) {

		}

		if (StringUtils.isNotEmpty(reply)) {
			for (Entry<String, String> e : REPLACE_KEYWORD.entrySet()) {
				reply = reply.replace(e.getKey(), e.getValue());
			}
		}
		return reply;
	}

	public static void main(String[] args) throws Exception {
		TuRingBot bot = new TuRingBot();
		AppLogger.sysDebug(bot.talk("美女图片"));
	}
}
