/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fuhj.weixin.json;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Administrator
 * @desc 
 *       用于封装好请求用的json，发送给https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxinit?r={time
 *       }&skey=该地址
 */
@Data @AllArgsConstructor @NoArgsConstructor public class WebWxInitJson {
	@SerializedName("BaseRequest") private BaseRequest baseRequest;

	@Override public String toString() {
		return "WebWxInitJson{" + "baseRequest=" + baseRequest + '}';
	}

	@Override public int hashCode() {
		int hash = 3;
		hash = 67 * hash + Objects.hashCode(this.baseRequest);
		return hash;
	}

	@Override public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final WebWxInitJson other = (WebWxInitJson) obj;
		if (!Objects.equals(this.baseRequest, other.baseRequest)) {
			return false;
		}
		return true;
	}
}
