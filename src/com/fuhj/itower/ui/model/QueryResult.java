/**
 * 
 */
package com.fuhj.itower.ui.model;

import lombok.Getter;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-30
 */
public enum QueryResult {
	NODATA("无数据"), NOBATTERY("无开关电源数据"), FSUERROR("FSU故障/离线"), NOFSUREL("未关联FSU"), TIMEOUT("查询超时"), FAIL("查询失败"), INTERRUPT("查询被中断");
	@Getter private final String value;

	private QueryResult(String value) {
		this.value = value;
	}

	public static String getAllStrRegx() {
		StringBuffer tmp = new StringBuffer(NODATA.getValue()).append("|")
				.append(FSUERROR.getValue()).append("|")
				.append(NOBATTERY.getValue()).append("|")
				.append(NOFSUREL.getValue()).append("|")
				.append(TIMEOUT.getValue()).append("|")
				.append(FAIL.getValue()).append("|")
				.append(INTERRUPT.getValue());
		return tmp.toString();
	}
}
