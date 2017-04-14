/**
 * 
 */
package com.fuhj.weixin.json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-7-5
 */
@Data public class BatchContactBean {
	@SerializedName("BaseResponse") private BaseResponse baseResponse = new BaseResponse();;

	@SerializedName("Count") private int count;

	@SerializedName("ContactList") private List<ContactItem> contactList = new ArrayList<ContactItem>();
}
