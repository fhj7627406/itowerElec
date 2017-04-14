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
@Data public class WebWxSyncPostJson {
	@SerializedName("BaseRequest") private BaseRequest br;

	@SerializedName("SyncKey") private SyncKey syncKey;

	@SerializedName("rr") private long rr;

	public WebWxSyncPostJson(BaseRequest br, SyncKey syncKey) {
		this.br = br;
		this.syncKey = syncKey;
		rr = ~System.currentTimeMillis();
	}
}
