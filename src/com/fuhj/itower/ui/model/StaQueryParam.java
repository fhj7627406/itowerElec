/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-20
 */
@Data @AllArgsConstructor @NoArgsConstructor public class StaQueryParam {
	private String itProvinceId;
	private String itCityId;
	private String itDistrictId;
	private String stName;
	private String stCode;

	/**
	 * @param stName
	 * @param stCode
	 */
	public StaQueryParam(String stName, String stCode) {
		super();
		this.stName = stName;
		this.stCode = stCode;
	}

}
