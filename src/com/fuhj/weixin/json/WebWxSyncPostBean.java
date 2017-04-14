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
 */
@Data public class WebWxSyncPostBean {

	@SerializedName("BaseResponse") private BaseResponse br;

	private int AddMsgCount;

	private List<MessageJson> AddMsgList;

	private int ModContactCount;

	private List<ContactItem> ModContactList;

	private int DelContactCount;

	private List<ContactItem> DelContactList;

	private int ModChatRoomMemberCount;

	private List ModChatRoomMemberList;

	private ProfileJson Profile;

	private int ContinueFlag;

	@SerializedName("SyncKey") private SyncKey syncKey;

	private String SKey = "";

	public WebWxSyncPostBean() {
		br = new BaseResponse();
		AddMsgList = new ArrayList<MessageJson>();
		ModContactList = new ArrayList<ContactItem>();
		DelContactList = new ArrayList<ContactItem>();
		ModChatRoomMemberList = new ArrayList();
		Profile = new ProfileJson();
		syncKey = new SyncKey();
	}

	@Override public String toString() {
		return "WebWxSyncPostBean{" + "br=" + br + ", AddMsgCount=" + AddMsgCount + ", AddMsgList=" + AddMsgList + ", ModContactCount="
				+ ModContactCount + ", ModContactList=" + ModContactList + ", DelContactCount=" + DelContactCount + ", DelContactList="
				+ DelContactList + ", ModChatRoomMemberCount=" + ModChatRoomMemberCount + ", ModChatRoomMemberList=" + ModChatRoomMemberList
				+ ", Profile=" + Profile + ", ContinueFlag=" + ContinueFlag + ", syncKey=" + syncKey + ", SKey=" + SKey + '}';
	}
}
