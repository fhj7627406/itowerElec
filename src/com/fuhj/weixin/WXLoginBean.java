/**
 * 
 */
package com.fuhj.weixin;

import com.fuhj.weixin.json.BaseRequest;
import com.fuhj.weixin.json.WebWxInitBean;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-17
 */
public class WXLoginBean {
	private String skey;
	private String wxsid;
	private String wxuin;
	private String pass_ticket;
	private String deviceid;
	private long _count;
	private WebWxInitBean webWxInitBean;
	private String cookie;

	public WXLoginBean(String skey, String wxsid, String wxuin, String pass_ticket, String cookie) {
		super();
		this.skey = skey;
		this.wxsid = wxsid;
		this.wxuin = wxuin;
		this.pass_ticket = pass_ticket;
		this.cookie = cookie;
		this._count = System.currentTimeMillis();
	}

	public BaseRequest bulidBaseRequest() {
		return new BaseRequest(getWxuin(), getWxsid(), getSkey(), getDeviceid());
	}

	/**
	 * @return the skey
	 */
	public String getSkey() {
		return skey;
	}

	/**
	 * @param skey the skey to set
	 */
	public void setSkey(String skey) {
		this.skey = skey;
	}

	/**
	 * @return the wxsid
	 */
	public String getWxsid() {
		return wxsid;
	}

	/**
	 * @param wxsid the wxsid to set
	 */
	public void setWxsid(String wxsid) {
		this.wxsid = wxsid;
	}

	/**
	 * @return the wxuin
	 */
	public String getWxuin() {
		return wxuin;
	}

	/**
	 * @param wxuin the wxuin to set
	 */
	public void setWxuin(String wxuin) {
		this.wxuin = wxuin;
	}

	/**
	 * @return the pass_ticket
	 */
	public String getPass_ticket() {
		return pass_ticket;
	}

	/**
	 * @param pass_ticket the pass_ticket to set
	 */
	public void setPass_ticket(String pass_ticket) {
		this.pass_ticket = pass_ticket;
	}

	/**
	 * @return the deviceid
	 */
	public String getDeviceid() {
		this.deviceid = "e" + WebWXUtil.generDeviceIdStr();
		return this.deviceid;
	}

	/**
	 * @param deviceid the deviceid to set
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	/**
	 * @return the _count
	 */
	public long get_count() {
		return _count;
	}

	/**
	 * @param _count the _count to set
	 */
	public void set_count(long _count) {
		this._count = _count;
	}

	/**
	 * @return the webWxInitBean
	 */
	public WebWxInitBean getWebWxInitBean() {
		return webWxInitBean;
	}

	/**
	 * @param webWxInitBean the webWxInitBean to set
	 */
	public void setWebWxInitBean(WebWxInitBean webWxInitBean) {
		this.webWxInitBean = webWxInitBean;
	}

	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

}