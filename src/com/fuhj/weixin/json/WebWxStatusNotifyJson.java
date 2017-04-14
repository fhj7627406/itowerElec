package com.fuhj.weixin.json;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Administrator
 */
@Data public class WebWxStatusNotifyJson {

	@SerializedName("BaseRequest") private BaseRequest br;

	private long ClientMsgId;
	private int Code;
	private String FromUserName;
	private String ToUserName;

}
