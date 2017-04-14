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
@Data public class ProfileJson {
	private int BitFlag;

	@SerializedName("UserName") private UserName userName;

	@SerializedName("NickName") private NickName nickName;

	private long BindUin;

	@SerializedName("BindEmail") private BindEmail be;

	@SerializedName("BindMobile") private BindMobile bm;

	private long Status;

	private int Sex;

	private int PersonalCard;

	private String Alias = "";

	private String HeadImgUpdateFlag = "";

	private String HeadImgUrl = "";

	private String Signature = "";

	public ProfileJson() {
		userName = new UserName();
		nickName = new NickName();
		be = new BindEmail();
		bm = new BindMobile();
	}

	@Override public String toString() {
		return "ProfileJson{" + "BitFlag=" + BitFlag + ", userName=" + userName + ", nickName=" + nickName + ", BindUin=" + BindUin + ", be=" + be
				+ ", bm=" + bm + ", Status=" + Status + ", Sex=" + Sex + ", PersonalCard=" + PersonalCard + ", Alias=" + Alias
				+ ", HeadImgUpdateFlag=" + HeadImgUpdateFlag + ", HeadImgUrl=" + HeadImgUrl + ", Signature=" + Signature + '}';
	}

	class UserName {
		private String Buff = "";

		public String getBuff() {
			return Buff;
		}

		public void setBuff(String Buff) {
			this.Buff = Buff;
		}
	}

	class NickName {
		private String Buff = "";

		public String getBuff() {
			return Buff;
		}

		public void setBuff(String Buff) {
			this.Buff = Buff;
		}
	}

	class BindEmail {
		private String Buff = "";

		public String getBuff() {
			return Buff;
		}

		public void setBuff(String Buff) {
			this.Buff = Buff;
		}
	}

	class BindMobile {
		private String Buff = "";

		public String getBuff() {
			return Buff;
		}

		public void setBuff(String Buff) {
			this.Buff = Buff;
		}
	}
}
