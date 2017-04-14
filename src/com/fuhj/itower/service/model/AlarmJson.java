/**
 * 
 */
package com.fuhj.itower.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-18
 */
@Data @NoArgsConstructor public class AlarmJson {
	public int code;
	public String text;
	public int count;
	public JSONArray list;

	/**
	 * @param code
	 * @param text
	 */
	public AlarmJson(int code, String text) {
		super();
		this.code = code;
		this.text = text;
	}
}
