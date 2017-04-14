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

/**
 * 
 * @author Administrator
 */
@Data @AllArgsConstructor @NoArgsConstructor public class BaseRequest {
	private String Uin = "";
	private String Sid = "";
	private String Skey = "";
	private String DeviceID = "";

	@Override public String toString() {
		return "BaseRequest{" + "Uin=" + Uin + ", Sid=" + Sid + ", Skey=" + Skey + ", DeviceID=" + DeviceID + '}';
	}

	@Override public int hashCode() {
		int hash = 3;
		hash = 59 * hash + Objects.hashCode(this.Uin);
		hash = 59 * hash + Objects.hashCode(this.Sid);
		hash = 59 * hash + Objects.hashCode(this.Skey);
		hash = 59 * hash + Objects.hashCode(this.DeviceID);
		return hash;
	}

	@Override public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BaseRequest other = (BaseRequest) obj;
		if (!Objects.equals(this.Uin, other.Uin)) {
			return false;
		}
		if (!Objects.equals(this.Sid, other.Sid)) {
			return false;
		}
		if (!Objects.equals(this.Skey, other.Skey)) {
			return false;
		}
		if (!Objects.equals(this.DeviceID, other.DeviceID)) {
			return false;
		}
		return true;
	}
}
