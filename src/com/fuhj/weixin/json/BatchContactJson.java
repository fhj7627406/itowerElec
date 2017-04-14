/**
 * 
 */
package com.fuhj.weixin.json;

import java.util.List;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-7-5
 */
@Data public class BatchContactJson {
	@SerializedName("BaseRequest") private BaseRequest br;
	@SerializedName("Count") private int count;
	@SerializedName("List") private List<BatchRequestKey> list;

}
