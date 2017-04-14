/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fuhj.itower.model.BaseModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-7-8
 */
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = false) public class MonitorMapBean extends BaseModel {
	private int sumStation;
	private int deliveredStation;
	private int fsuOnline;
	private int activeAlarm;
	private int tdAlarm;
	private int wdAlarm;
	private int dzAlarm;
	private int fsuOffline;
	private int nrOrder;
}
