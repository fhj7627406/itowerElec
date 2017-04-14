/**
 * 
 */
package com.fuhj.itower.service.model;

import java.util.Date;

import lombok.Data;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-18
 */
@Data public class AlarmModelJson {
	private int index;
	private String billId;
	private String stationid;
	private String stationcode;
	private String stationname;
	private Date alarmtime;
	private int alarmduration;
	private String troubleno;
	private String voltage;
}
