/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fuhj.itower.model.BaseModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2017-1-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GenElecReportItem extends BaseModel {
	private String itProvinceId;
	private String itCityId;
	private String itDistrictId;
	private String showName;
	private int sum;
	private int done;
	private int ing;
}
