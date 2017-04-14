package com.fuhj.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FormatUtil {

	private static final DateFormat cdf = new SimpleDateFormat("yyyy年MM月dd日");
	private static final DateFormat chdf = new SimpleDateFormat("yyyy年MM月dd日HH时");
	private static final DateFormat edf = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat hdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static final DateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final DateFormat ufdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	private static final DateFormat ldf = new SimpleDateFormat("yyyyMMdd");
	private static final DateFormat adf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final DateFormat sdf = new SimpleDateFormat("yyMMdd");
	private static final DateFormat wdf = new SimpleDateFormat("EEE");
	private static final DateFormat mdf = new SimpleDateFormat("yyyyMM");

	public static final NumberFormat nf = new DecimalFormat();
	public static final NumberFormat nf1 = NumberFormat.getIntegerInstance();
	public static final NumberFormat nf2 = NumberFormat.getIntegerInstance();

	public static final String SELECT_INDEX = "selectIndex";
	public static final String ACTIVE_PAGE = "activePage";
	public static final String FORWARD_ADDRESS = "forwardAddress";

	public static final long spaceDate = getUnderLineTime("1970-01-01_00:00:00").getTime(); // 如果为1970-01-01
	// 00:00:00显示为空串""

	static {
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(8);
		nf.setMinimumIntegerDigits(1);
		nf.setMinimumFractionDigits(1);

		nf1.setGroupingUsed(false);
		nf1.setMaximumIntegerDigits(4);
		nf1.setMinimumIntegerDigits(4);
		nf1.setMaximumFractionDigits(0);

		nf2.setGroupingUsed(false);
		nf2.setMaximumFractionDigits(0);
	}

	/**
	 * 格式化成4位小数
	 * 
	 * @param num
	 * @return
	 */
	public synchronized static String formatNumber(double num) {
		return formatNumber(num, 4);
	}

	/**
	 * 格式化成指定小数位
	 * 
	 * @param num
	 * @param len
	 * @return
	 */
	public synchronized static String formatNumber(double num, int len) {
		nf.setMinimumFractionDigits(len);
		nf.setMaximumFractionDigits(len);
		return nf.format(num);
	}

	/**
	 * 格式化成5位整数格式
	 * 
	 * @param i
	 * @return
	 */
	public synchronized static String formatInteger(int i) {
		return nf1.format(i);
	}

	/**
	 * 格式化成指定长度整数格式
	 * 
	 * @param i
	 * @param len
	 * @return
	 */
	public synchronized static String formatInteger(int i, int len) {
		nf2.setMaximumIntegerDigits(len);
		nf2.setMinimumIntegerDigits(len);
		return nf2.format(i);
	}

	/**
	 * 返回固定长度的数字
	 * 
	 * @param value
	 * @param len 小数点后位数
	 * @return
	 */
	public final static double getFixedLenDouble(double value, int len) {
		long tmp = (long) (value * Math.pow(10, len + 1));
		tmp = tmp % Math.pow(10, len) >= 5 ? tmp + 5 : tmp;
		double val = (double) ((long) (tmp / 10)) / Math.pow(10, len);
		return val;
	}

	/**
	 * value二进制值的第index位是否为1
	 * 
	 * @param value 数值
	 * @param index 位数（从1开始）
	 * @return
	 */
	public static boolean isBinaryOne(long value, int index) {
		if (index < 1) {
			throw new IllegalArgumentException("index must > 0: " + index);
		}
		String bin = Long.toBinaryString(index);
		if (bin.length() < index) {
			return false;
		}
		return bin.charAt(index - 1) == '1';
	}

	/**
	 * 取十进制数对应的二进制数组
	 * 
	 * @param value
	 * @param len 返回数组的长度
	 * @return
	 */
	public static int[] getBinaryArray(long value, int len) {
		int[] binArray = new int[len];
		char[] bin = Long.toBinaryString(value).toCharArray();
		for (int i = bin.length - 1, j = binArray.length - 1; i >= 0 && j >= 0; i--, j--) {
			binArray[j] = (bin[i] == '1' ? 1 : 0);
		}
		return binArray;
	}

	/**
	 * 解析5位数字的字符串
	 * 
	 * @param s
	 * @return
	 */
	public synchronized static int parseInteger(String s) {
		if (s.length() != 4) {
			throw new IllegalArgumentException("s is too small or large: " + s);
		}

		try {
			return nf1.parse(s).intValue();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 在线时间数
	 * 
	 * @param millis
	 * @return
	 */
	public static String getOnlineTime(long millis) {
		if (millis < 0) {
			throw new IllegalArgumentException("millis < 0");
		}
		StringBuilder sb = new StringBuilder();
		long seconds = millis / 1000L;
		if (seconds > 3600L * 24) {
			sb.append(seconds / (3600L * 24)).append("天");
			seconds = seconds % (3600L * 24);
		}
		if (seconds > 3600L || sb.length() > 0) {
			sb.append(seconds / 3600L).append("小时");
			seconds = seconds % 3600L;
		}
		if (seconds > 60L || sb.length() > 0) {
			sb.append(seconds / 60L).append("分");
			seconds = seconds % 60L;
		}
		sb.append(seconds).append("秒");

		return sb.toString();
	}

	/**
	 * yyyy-MM-dd_HH:mm:ss
	 * 
	 * @param date
	 * @return yyyy-MM-dd_HH:mm:ss, null = "NULL"
	 */
	public synchronized static final String getUnderLineTime(Date date) {
		if (date == null) {
			return "";
		}
		return ufdf.format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm
	 */
	public synchronized static final String getDateMin(Date date) {
		if (date == null) {
			return "";
		}
		return hdf.format(date);
	}

	/**
	 * yyyy-MM-dd_HH:mm:ss
	 * 
	 * @param date yyyy-MM-dd_HH:mm:ss
	 * @return Date
	 */
	public synchronized static final Date getUnderLineTime(String date) {
		try {
			return ufdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * yyyyMMdd
	 * 
	 * @param date
	 * @return yyyyMMdd
	 */
	public synchronized static final String getLongDate(Date date) {
		if (date == null) {
			return "";
		}
		return ldf.format(date);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return yyyyMMddHHmmss
	 */
	public synchronized static final String getLongAllDate(Date date) {
		if (date == null) {
			return "";
		}
		return adf.format(date);
	}

	/**
	 * 解析日期
	 * 
	 * @param date yyyyMMdd
	 * @return Date
	 */
	public synchronized static final Date getLongDate(int date) {
		try {
			return ldf.parse(String.valueOf(date));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public synchronized static final String getEDate(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return edf.format(date);
	}

	/**
	 * yyyy年MM月dd日HH时
	 * 
	 * @param date
	 * @return yyyy年MM月dd日HH时
	 */
	public synchronized static final String getCDate(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return cdf.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public synchronized static final String getCHDate(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return chdf.format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public synchronized static final String getFDate(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return fdf.format(date);
	}

	/**
	 * yyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public synchronized static final String getSDate(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 星期X
	 * 
	 * @param date
	 * @return
	 */
	public synchronized static final String getWeekday(Date date) {
		if (date == null) {
			return "";
		}
		if (spaceDate == date.getTime()) {
			return "";
		}
		return wdf.format(date);
	}

	/**
	 * 取日期第一秒开始的时间
	 * 
	 * @param day
	 * @return
	 */
	public synchronized static final Date getBeginTimeOfDay(Date day) {
		if (day == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 最日期最后一秒的时间
	 * 
	 * @param day
	 * @return
	 */
	public synchronized static final Date getEndTimeOfDay(Date day) {
		if (day == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 取小时分钟秒
	 * 
	 * @param day
	 * @return
	 */
	public synchronized static final String getTime(Date date) {
		if (date == null) {
			return "";
		}
		String time = getFDate(date);
		if (time != null && time.length() > 10) {
			return time.substring(10);
		}
		return time;
	}

	/**
	 * 取日期的整数表示
	 * 
	 * @param date 指定的日期
	 * @param days 之前/后的天数
	 * @return yyyyMMdd
	 */
	public synchronized static final int getIntDayOf(Date date, int days) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (days != 0) {
			cal.add(Calendar.DATE, days);
		}
		return Integer.parseInt(FormatUtil.getLongDate(cal.getTime()));
	}

	/**
	 * 是否为前一天（0时0分0秒）
	 * 
	 * @param yesterday
	 * @param today
	 * @return
	 */
	public static final boolean isPreviousDay(Date previousDay, Date today) {
		return (today.getTime() - previousDay.getTime()) == 86400000L;// 24 * 60
		// * 60
		// *
		// 1000
	}

	/**
	 * 是否为前一个月(yyyy-MM)
	 * 
	 * @param previousMonth
	 * @param currentMonth
	 * @return
	 */
	public static final boolean isPreviousMonth(String previousMonth, String currentMonth) {
		return (currentMonth.substring(0, 4).equals(previousMonth.substring(0, 4)) && (Integer.parseInt(currentMonth.substring(5))
				- Integer.parseInt(previousMonth.substring(5)) == 1))
				|| (Integer.parseInt(currentMonth.substring(5)) == 1 && Integer.parseInt(previousMonth.substring(5)) == 12 && Integer
						.parseInt(currentMonth.substring(0, 4))
						- Integer.parseInt(previousMonth.substring(0, 4)) == 1);
	}

	/**
	 * 是否为前一季(yyyy-M)
	 * 
	 * @param previousQuarter
	 * @param currentQuarter
	 * @return
	 */
	public static final boolean isPreviousQuarter(String previousQuarter, String currentQuarter) {
		return (currentQuarter.substring(0, 4).equals(previousQuarter.substring(0, 4)) && (Integer.parseInt(currentQuarter.substring(5))
				- Integer.parseInt(previousQuarter.substring(5)) == 1))
				|| (Integer.parseInt(currentQuarter.substring(5)) == 1 && Integer.parseInt(previousQuarter.substring(5)) == 4 && Integer
						.parseInt(currentQuarter.substring(0, 4))
						- Integer.parseInt(previousQuarter.substring(0, 4)) == 1);
	}

	/**
	 * 取指定日期所在月份的第一天，未指定日期为当月
	 * 
	 * @param day
	 * @return
	 */
	public synchronized static final Date getFirstDayOfMonth(Date day) {
		Calendar cal = Calendar.getInstance();
		if (day != null) {
			cal.setTime(day);
		}
		int minDate = cal.getActualMinimum(Calendar.DATE);
		cal.set(Calendar.DAY_OF_MONTH, minDate);
		return cal.getTime();
	}

	/**
	 * 取指定日期所在月份的最后一天，未指定日期为当月
	 * 
	 * @param day
	 * @return
	 */
	public synchronized static final Date getLastDayOfMonth(Date day) {
		Calendar cal = Calendar.getInstance();
		if (day != null) {
			cal.setTime(day);
		}
		int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, maxDate);
		return cal.getTime();
	}

	/**
	 * 取指定当前日期后几个月的最后一天
	 * 
	 * @param afterMonth
	 * @return
	 */
	public synchronized static final Date getLastDayAfterMonth(int afterMonth) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, afterMonth);
		Date day = cal.getTime();
		return getLastDayOfMonth(day);
	}

	/**
	 * 取几个月后的一天
	 * 
	 * @param afterMonth
	 * @return
	 */
	public synchronized static final Date getDayAfterMonth(int afterMonth) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, afterMonth);
		Date day = cal.getTime();
		return day;
	}

	/**
	 * 取指定日期后几天
	 * 
	 * @param date null - 取当天
	 * @param afterMonth
	 * @return
	 */
	public synchronized static final Date getTomrrow(Date date, int afterMonth) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.DAY_OF_MONTH, afterMonth);
		return cal.getTime();
	}

	/**
	 * 取指定日期后几年
	 * 
	 * @param date null - 取当天
	 * @param years
	 * @return
	 */
	public static final Date getDayAfterYear(Date date, int years) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	/**
	 * 取两个日期间的天数
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int getDaysBetween(Date begin, Date end) {
		Date d1 = getBeginTimeOfDay(begin);
		Date d2 = getBeginTimeOfDay(end);
		int days = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		return days;
	}

	/**
	 * 检查两个日期是否在同一个月
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isSameMonth(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return false;
		}
		return mdf.format(d1).equals(mdf.format(d2));
	}

	public static String formartObjectToString(Object obj) {
		return ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
	public static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
	public static final Double MAX_VALUE = 9999999999999.0;

	public static String getCHMoney(Double v) {
		if (v < 0 || v > MAX_VALUE) {
			return "非法参数!";
		}
		Long l = Math.round(v * 100);
		if (l == 0) {
			return "";
		}
		String strValue = l.toString();
		int i = 0;
		int j = UNIT.length() - strValue.length();
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);
			char strUnit = UNIT.charAt(j);
			if (ch == '0') {
				isZero = true;
				if (strUnit == '亿' || strUnit == '万' || strUnit == '元') {
					rs = rs + strUnit;
					isZero = false;
				}
			} else {
				if (isZero) {
					rs = rs + "零";
					isZero = false;
				}
				rs = rs + DIGIT.charAt(ch - '0') + strUnit;
			}
		}
		if (!String.valueOf(rs.charAt(rs.length() - 1)).matches("角|分")) {
			rs = rs + "整";
		}
		rs.replaceAll("亿万", "亿");
		if (rs.startsWith("壹拾")) {
			rs = rs.substring(1);
		}
		return rs;
	}

	public static Date parseDate(DateFormat format, String date) throws ParseException {
		Date rs = null;
		if (date != null && date.length() > 0) {
			rs = format.parse(date);
		}
		return rs;
	}

	public static String minConvertHourMin(long min) {
		String html = "0分";
		if (min > 0) {
			String format = "";
			Object[] array = null;
			int days = (int) (min / (60 * 24));
			int hours = (int) (min / (60) - days * 24);
			int minutes = (int) (min - hours * 60 - days * 24 * 60);
			if (days > 0) {
				format = "%1$,d天%2$,d时%3$,d分";
				array = new Object[] { days, hours, minutes };
			} else if (hours > 0) {
				format = "%1$,d时%2$,d分";
				array = new Object[] { hours, minutes };
			} else {
				format = "%1$,d分";
				array = new Object[] { minutes };
			}
			html = String.format(format, array);
		}
		return html;
	}

	public static void main(String[] args) {
		// System.out.println(getCHMoney(9999999999999.0));
		// System.out.println(getCHMoney(1117.1));
		// System.out.println(getCHMoney(17.13));
		// System.out.println(getCHMoney(200.0));
		// System.out.println(getEDate(getFirstDayOfMonth(null)));
		// System.out.println(getEDate(getLastDayOfMonth(null)));
		// System.out.println(getOnlineTime(0));
		// System.out.println(getOnlineTime(10));
		// System.out.println(getOnlineTime(1000));
		// System.out.println(getOnlineTime(1001));
		// System.out.println(getOnlineTime(10000));
		// System.out.println(getOnlineTime(100001));
		// System.out.println(getOnlineTime(1000000));
		// System.out.println(getOnlineTime(36000000));
		// System.out.println(getOnlineTime(36001000));

		// System.out.println(isPreviousMonth("2009-08", "2009-09"));
		// System.out.println("2009-10".substring(0,4));
		// System.out.println("2009-10".substring(5));

		// String s = "101101";
		// System.out.println(s.substring(1,3));
		//
		// System.out.println(Math.pow(2,4));
		// System.out.println(Math.exp(2));
		// System.out.println(Math.log(2));

		// int[] i = getBinaryArray(6, 8);
		// for (int j : i) {
		// System.out.println(j);
		// }
		// System.out.println(FormatUtil.formatInteger(122223567, 6));
		System.out.println(DigestUtils.md5Hex("18674877787").toUpperCase());
	}
}
