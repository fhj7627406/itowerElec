/**
 * 
 */
package com.fuhj.weixin;

import java.text.NumberFormat;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-17
 */
public class WebWXUtil {

	public static String generDeviceIdStr() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		double d = Math.random() * (999999999999999L - 100000000000000L) + 100000000000000L;
		String str = nf.format(d);
		return str.substring(0, 15);
	}

}
