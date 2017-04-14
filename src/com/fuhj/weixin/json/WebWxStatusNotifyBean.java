/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fuhj.weixin.json;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Administrator
 */
@Data public class WebWxStatusNotifyBean {
	@SerializedName("BaseResponse") private BaseResponse br;
	private String MsgID;

	public WebWxStatusNotifyBean() {
		br = new BaseResponse();
	}

	@Override public String toString() {
		return "WebWxStatusNotifyBean{" + "br=" + br + ", MsgID=" + MsgID + '}';
	}

}
