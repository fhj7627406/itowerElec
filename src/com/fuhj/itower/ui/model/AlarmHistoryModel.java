/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fuhj.itower.model.AlarmHistory;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-9
 */
@Data @EqualsAndHashCode(callSuper = false) public class AlarmHistoryModel extends AlarmHistory {
	private String city;
	private String district;
	private Date queryTime;
}
