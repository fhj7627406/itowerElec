/**
 * 
 */
package com.fuhj.weixin.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.google.gson.annotations.SerializedName;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-7-5
 */
@Data @AllArgsConstructor public class BatchRequestKey {
	@SerializedName("UserName") private String userName;
	@SerializedName("EncryChatRoomId") private String encryChatRoomId;
}