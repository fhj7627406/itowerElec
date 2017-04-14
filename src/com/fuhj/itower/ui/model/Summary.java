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
 * @date 2017-1-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Summary extends BaseModel {
	private String showText;
	private int sumDone;
	private int monthDone;
	private int todayDone;
	private int sumIng;
}
