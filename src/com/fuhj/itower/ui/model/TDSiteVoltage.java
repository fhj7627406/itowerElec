/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fuhj.itower.model.BaseModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-8
 */
@Data @AllArgsConstructor @NoArgsConstructor public class TDSiteVoltage extends BaseModel {
	private int index;
	private String siteName;
	private String siteSYSCode;
	private String siteCode;
	private String troubleNO;
	private String voltage;
	private Date updateTime;
}
