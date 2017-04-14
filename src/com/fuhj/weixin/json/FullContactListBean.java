/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fuhj.weixin.json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Administrator
 * @description 用于封装服务器返回的关于用户的所有的好友信息。
 */
@Data public class FullContactListBean {

	@SerializedName("BaseResponse") private BaseResponse br;

	@SerializedName("MemberCount") private int memberCount;

	@SerializedName("MemberList") private List<ContactItem> memberList;

	public FullContactListBean() {
		br = new BaseResponse();
		memberList = new ArrayList<ContactItem>();
	}

	@Override public String toString() {
		return "FullContactListJson{" + "br=" + br + ", memberCount=" + memberCount + ", memberList=" + memberList + '}';
	}
}
