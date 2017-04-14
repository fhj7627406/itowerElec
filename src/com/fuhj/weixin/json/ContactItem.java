/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fuhj.weixin.json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 */
@Data @NoArgsConstructor public class ContactItem {
	private long Uin;
	private String UserName = "";
	private String NickName = "";
	private String HeadImgUrl = "";
	private int ContactFlag;
	private int MemberCount;
	private List<Member> MemberList = new ArrayList<Member>();
	private String RemarkName = "";
	private String HideInputBarFlag = "";
	private int Sex;
	private String Signature = "";
	private int VerifyFlag;
	private long OwnerUin;
	private String PYInitial = "";
	private String PYQuanPin = "";
	private String RemarkPYInitial = "";
	private String RemarkPYQuanPin = "";
	private int StarFriend;
	private int AppAccountFlag;
	private int Statues;
	private long AttrStatus;
	private String Province = "";
	private String City = "";
	private String Alias = "";
	private int SnsFlag;
	private int UniFriend;

	@Override public String toString() {
		return "ContactItem{" + "Uin=" + Uin + ", UserName=" + UserName + ", NickName=" + NickName + ", HeadImgUrl=" + HeadImgUrl + ", ContactFlag="
				+ ContactFlag + ", MemberCount=" + MemberCount
				+ ", MemberList=" + MemberList + ", RemarkName=" + RemarkName + ", HideInputBarFlag=" + HideInputBarFlag + ", Sex=" + Sex
				+ ", Signature=" + Signature + ", VerifyFlag=" + VerifyFlag
				+ ", OwnerUin=" + OwnerUin + ", PYInitial=" + PYInitial + ", PYQuanPin=" + PYQuanPin + ", RemarkPYInitial=" + RemarkPYInitial
				+ ", RemarkPYQuanPin=" + RemarkPYQuanPin
				+ ", StarFriend=" + StarFriend + ", AppAccountFlag=" + AppAccountFlag + ", Statues=" + Statues + ", AttrStatus=" + AttrStatus
				+ ", Province=" + Province + ", City=" + City
				+ ", Alias=" + Alias + ", SnsFlag=" + SnsFlag + ", UniFriend=" + UniFriend + '}';
	}

	@Override public int hashCode() {
		int hash = 7;
		hash = 73 * hash + (int) (this.Uin ^ (this.Uin >>> 32));
		return hash;
	}

	@Override public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ContactItem other = (ContactItem) obj;
		if (this.Uin != other.Uin) {
			return false;
		}
		return true;
	}
}
