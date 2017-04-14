/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fuhj.itower.model.GElecUser;

/**
 * @Description: TODO
 * @author fu
 * @date 2017-3-8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GelecUserModel extends GElecUser {
	private String province;
	private String city;
	private String district;
	private int done;
	private int ing;
	private int sum;
}
