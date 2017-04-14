/**
 * 
 */
package com.fuhj.weixin.json;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-7-13
 */
@Data @NoArgsConstructor public class Member {
	private String Uin;
	private String UserName = "";
	private String NickName = "";
	private String AttrStatus = "";
	private String PYInitial = "";
	private String PYQuanPin = "";
	private String RemarkPYInitial = "";
	private String RemarkPYQuanPin = "";
	private String MemberStatus = "";
	private String DisplayName = "";
	private String KeyWord = "";
}
