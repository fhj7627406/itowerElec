/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-22
 */
public class AlarmComparator implements Comparator<Object> {

	private boolean asc = true;
	@Getter @Setter private int type = 0;

	public AlarmComparator(boolean asc, int type) {
		this.asc = asc;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override public int compare(Object arg0, Object arg1) {
		AlarmModel a0 = (AlarmModel) arg0;
		AlarmModel a1 = (AlarmModel) arg1;

		switch (type) {
		case 1:
			return a0.getAlarmtime().compareTo(a1.getAlarmtime()) * (asc ? 1 : -1);
		case 2:
			return (a0.getAlarmduration() - a1.getAlarmduration()) * (asc ? 1 : -1);
		case 3:
			return (a0.getEleccountdown() - a1.getEleccountdown()) * (asc ? 1 : -1);
		case 4:
			return (a0.getElecWarninglevel() - a1.getElecWarninglevel()) * (asc ? 1 : -1);
		case 5:
			float wl0 = 0;
			float wl1 = 0;
			try {
				wl0 = Float.parseFloat(a0.getVoltage());
			} catch (NumberFormatException e) {
				wl0 = asc ? (float) Short.MAX_VALUE : (float) Short.MIN_VALUE;
			}
			try {
				wl1 = Float.parseFloat(a1.getVoltage());
			} catch (NumberFormatException e) {
				wl1 = asc ? (float) Short.MAX_VALUE : (float) Short.MIN_VALUE;
			}
			return Float.compare(wl0, wl1) * (asc ? 1 : -1);
		default:
			return 0;
		}
	}
}
