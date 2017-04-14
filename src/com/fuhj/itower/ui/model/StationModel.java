/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fuhj.itower.model.ItStation;

@Data
@EqualsAndHashCode(callSuper = false)
public class StationModel extends ItStation {
	private String province;
	private String city;
	private String district;
	private String agstaffname;
	private String agstafftel;
	private String batteryId;
	private String originName;
	private String typeName;
	private String sceneName;
}
