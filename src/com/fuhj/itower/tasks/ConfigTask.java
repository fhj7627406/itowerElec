/**
 * 
 */
package com.fuhj.itower.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-16
 */
@Data @AllArgsConstructor @NoArgsConstructor public class ConfigTask {

	public static final String CHATROOMNAME = "chatRoomName";
	private String chatRoomName;
	public static final String RANGE = "range";
	private String range;

}
