/**
 * 
 */
package com.fuhj.itower.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fuhj.log.AppLogger;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SecurityUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2014-2-12
 */

public class TestBean {
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private Date birth;

	public static void main(String[] args) throws Exception {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// Connection con = null;
		// PreparedStatement pstmt = null;
		// String sql =
		// "INSERT INTO station
		// (province_id,city_id,district_id,stationName,stationCode,fsuName,fsuCode,fsuip,fsuManufactor,lat,lng,charge,chargePhone,power,interfaceCount)
		// VALUES(0,0,0,?,?,?,?,?,?,?,?,?,?,?,?)";
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://182.92.6.151:3306/itowerdb",
		// "dadaowebdb", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		//
		// pstmt = con.prepareStatement(sql);
		// String[][] excel =
		// ExcelUtil.readSheet("C:/Users/fu/Downloads/站址信息及设备数量统计表 (2).xls",
		// "REPORT_ ", 0);
		// for (String[] row : excel) {
		// pstmt.setString(1, row[3]);
		// pstmt.setString(2, row[4]);
		// pstmt.setString(3, row[6]);
		// pstmt.setString(4, row[7]);
		// pstmt.setString(5, row[8]);
		// pstmt.setString(6, row[9]);
		// if (StringUtils.isNotEmpty(row[11]) && Float.parseFloat(row[11]) <
		// 1000) {
		// pstmt.setFloat(7, Float.parseFloat(row[11]));
		// } else {
		// pstmt.setFloat(7, 0f);
		// }
		//
		// if (StringUtils.isNotEmpty(row[10]) && Float.parseFloat(row[10]) <
		// 1000) {
		// pstmt.setFloat(8, Float.parseFloat(row[10]));
		// } else {
		// pstmt.setFloat(8, 0f);
		// }
		//
		// pstmt.setString(9, row[13]);
		// pstmt.setString(10, row[14]);
		// pstmt.setFloat(11, StringUtils.isEmpty(row[15]) ? 0f :
		// Float.parseFloat(row[15]));
		// pstmt.setInt(12, StringUtils.isEmpty(row[16]) ? 0 :
		// Integer.parseInt(row[16]));
		// int i = pstmt.executeUpdate();
		// System.out.println(i + " lat:" + row[11] + " lng:" + row[10]);
		// }
		// con.commit();
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// try {
		// con.rollback();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// } finally {
		// try {
		// if (pstmt != null)
		// pstmt.close();
		// if (con != null)
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }

		// Connection con = null;
		// PreparedStatement pstmt_query = null;
		// PreparedStatement pstmt_update = null;
		// ResultSet rs = null;
		// try {
		// String[][] excel =
		// ExcelUtil.readSheet("C:/Users/fu/Downloads/站址信息及设备数量统计表 (2).xls",
		// "REPORT_ ", 0);
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://182.92.6.151:3306/itowerdb",
		// "dadaowebdb", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_query =
		// con.prepareStatement("select * from it_district where
		// it_province_id='0001928' and dname=?");
		//
		// pstmt_update =
		// con.prepareStatement("update station set
		// it_province_id='0001928',it_city_id=?,it_district_id=? where
		// stationcode=?");
		// for (int i = 0; i < excel.length; i++) {
		// String[] row = excel[i];
		// pstmt_query.setString(1, row[2]);
		// rs = pstmt_query.executeQuery();
		// if (rs.next()) {
		// pstmt_update.setString(1, rs.getString(3));
		// pstmt_update.setString(2, rs.getString(1));
		// pstmt_update.setString(3, row[4]);
		// int update_tag = pstmt_update.executeUpdate();
		// System.out.println(row[4] + " district_id:" + rs.getString(1) +
		// " city_id:" + rs.getString(3) + " update_tag:" + update_tag);
		// if (i % 500 == 0) {
		// con.commit();
		// }
		// }
		// }
		// con.commit();
		// } catch (Exception e) {
		// try {
		// con.rollback();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// e.printStackTrace();
		// } finally {
		//
		// try {
		// rs.close();
		// pstmt_query.close();
		// pstmt_update.close();
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
		// String sql =
		// "INSERT INTO agents_staff (staff_name,
		// it_city_id,it_district_id,staff_idno,tel) VALUES(?,(SELECT it_city_id
		// FROM it_city WHERE cname=REPLACE(?, '分公司', '')),(SELECT
		// it_district_id FROM it_district WHERE dname=?),?,?)";
		// Connection con = null;
		// PreparedStatement pstmt_update = null;
		// ResultSet rs = null;
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://182.92.6.151:3306/itowerdb",
		// "dadaowebdb", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_update = con.prepareStatement(sql);
		// String[][] excel =
		// ExcelUtil.readSheet("C:/Users/fu/Desktop/湖南代维/代维人员-导出.xls", "代维人员信息",
		// 0);
		// for (int i = 1; i < excel.length; i++) {
		// String[] row = excel[i];
		// System.out.println(row[0] + "|" + row[2] + "|" + row[3] + "|" +
		// row[5] + "|" + row[10]);
		// pstmt_update.setString(1, row[0]);
		// pstmt_update.setString(2, row[2]);
		// pstmt_update.setString(3, row[3]);
		// pstmt_update.setString(4, row[5]);
		// pstmt_update.setString(5, row[10]);
		// pstmt_update.executeUpdate();
		// }
		// con.commit();
		// } catch (Exception e) {
		// try {
		// con.rollback();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// e.printStackTrace();
		// } finally {
		// try {
		// pstmt_update.close();
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
		// INSERT INTO agents_corp (agents_corp_name) VALUES('agents_corp_id')

		// Connection con = null;
		// PreparedStatement pstmt_update = null;
		//
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://182.92.6.151:3306/itowerdb",
		// "dadaowebdb", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_update =
		// con.prepareStatement("INSERT INTO agents_corp (agents_corp_name)
		// VALUES(?)");
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("C:/Users/fu/Desktop/湖南代维/代维公司1.txt")));
		// int i = 0;
		// String str = "";
		// while ((str = br.readLine()) != null) {
		// if (i == 1) {
		// pstmt_update.setString(1, str);
		// pstmt_update.executeUpdate();
		// }
		// i++;
		// if (str.equals("")) {
		// System.out.println();
		// i = 0;
		// }
		// }
		// con.commit();
		// } catch (Exception e) {
		// try {
		// con.rollback();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// e.printStackTrace();
		// } finally {
		// try {
		// pstmt_update.close();
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
		// String sql = "insert into sta_agt_staff_copy
		// (stationCode,agstaffName,agstaffTel) values(?,?,?)";
		// Connection con = null;
		// PreparedStatement pstmt_update = null;
		//
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb",
		// "root", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_update = con.prepareStatement(sql);
		//
		// File dir = new
		// File("C:\\Users\\fu\\Desktop\\湖南代维\\站址管理信息-导出20160813");
		// File[] fileArray = dir.listFiles();
		// for (File f : fileArray) {
		// System.out.println(f.getName());
		// String[][] excel = ExcelUtil.readSheet(f.getAbsolutePath(),
		// "站址管理信息-导出", 0);
		// for (int i = 2; i < excel.length; i++) {
		//
		// String[] row = excel[i];
		// pstmt_update.setString(1, row[1]);
		// pstmt_update.setString(2, row[16]);
		// pstmt_update.setString(3, row[17]);
		// pstmt_update.executeUpdate();
		// if (i % 500 == 0) {
		// con.commit();
		// }
		// System.out.println(row[0] + " " + row[1] + " " + row[15] + " " +
		// row[16]);
		// }
		// con.commit();
		// }
		// } catch (Exception e) {
		// con.rollback();
		// e.printStackTrace();
		// } finally {
		// pstmt_update.close();
		// con.close();
		// }

		// String sql_station =
		// "INSERT INTO station
		// (it_province_id,it_city_id,it_district_id,stationName,stationCode,stationSYSCode,stationOrigin,stationAddress,lat,lng,areaManager,areaManagerPhone,spareElecDuration,fsuManufactor,acceptDate,remark,status)
		// VALUES('0098364',(select it_city_id from it_city where cname=? and
		// it_province_id='0098364'),(Select it_district_id from it_district
		// where dname=? and
		// it_province_id='0098364'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// String sql_stastaff = "insert into sta_agt_staff
		// (stationCode,agstaffName,agstaffTel) values(?,?,?)";
		// Connection con = null;
		// PreparedStatement pstmt_station = null;
		// PreparedStatement pstmt_stastaff = null;
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb",
		// "root", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_station = con.prepareStatement(sql_station);
		// pstmt_stastaff = con.prepareStatement(sql_stastaff);
		// File dir = new File("C:/Users/fu/Desktop/广西铁塔/站址管理导出-20161017");
		// File[] fileArray = dir.listFiles();
		// for (File f : fileArray) {
		// String[][] excel = ExcelUtil.readSheet(f.getAbsolutePath(),
		// "站址管理信息-导出", 0);
		// for (int i = 2; i < excel.length; i++) {
		// String[] row = excel[i];
		// pstmt_station.setString(1, row[1].replace("分公司", ""));
		// pstmt_station.setString(2, row[2]);
		// pstmt_station.setString(3, row[3]);
		// pstmt_station.setString(4, row[5]);
		// pstmt_station.setString(5, row[4]);
		// pstmt_station.setString(6, row[12]);
		// pstmt_station.setString(7, row[11]);
		//
		// if (StringUtils.isNotEmpty(row[7]) && Float.parseFloat(row[7]) <
		// 1000) {
		// pstmt_station.setFloat(8, Float.parseFloat(row[7]));
		// } else {
		// pstmt_station.setFloat(8, 0f);
		// }
		// if (StringUtils.isNotEmpty(row[6]) && Float.parseFloat(row[6]) <
		// 1000) {
		// pstmt_station.setFloat(9, Float.parseFloat(row[6]));
		// } else {
		// pstmt_station.setFloat(9, 0f);
		// }
		//
		// pstmt_station.setString(10, row[37]);
		// pstmt_station.setString(11, row[38]);
		//
		// try {
		// if (StringUtils.isNotEmpty(row[75]) && Float.parseFloat(row[75]) <
		// 9999) {
		// pstmt_station.setInt(12, Integer.parseInt(row[75]));
		// } else {
		// pstmt_station.setInt(12, 0);
		// }
		// } catch (NumberFormatException e) {
		// pstmt_station.setInt(12, 0);
		// }
		// pstmt_station.setString(13, row[64]);
		//
		// if (StringUtils.isNotEmpty(row[10])) {
		// try {
		// Date d = sdf.parse(row[10]);
		// pstmt_station.setDate(14, new java.sql.Date(d.getTime()));
		// } catch (ParseException e) {
		// pstmt_station.setDate(14, null);
		// } catch (Exception e) {
		// pstmt_station.setDate(14, null);
		// }
		// } else {
		// pstmt_station.setDate(14, null);
		// }
		// pstmt_station.setString(15, row[99]);
		// pstmt_station.setInt(16, 1);
		// pstmt_stastaff.setString(1, row[5]);
		// pstmt_stastaff.setString(2, row[40]);
		// pstmt_stastaff.setString(3, row[41]);
		//
		// pstmt_station.executeUpdate();
		// pstmt_stastaff.executeUpdate();
		//
		// if (i % 500 == 0) {
		// con.commit();
		// }
		// System.out.println(i + " " + row[3] + " " + row[5]);
		// }
		// con.commit();
		// }
		// } catch (Exception e) {
		// con.rollback();
		// e.printStackTrace();
		// } finally {
		// pstmt_station.close();
		// con.close();
		// }
		// Gson gson = new Gson();
		// File dir = new File("C:/Users/fu/Desktop/站点设备入库");
		//
		// Connection con = null;
		// PreparedStatement pstmt = null;
		// String sql =
		// "INSERT INTO itowerdb.station_device
		// (station_sys_id,device_name,device_code,model,manufacturer,point,update_time,actual_value,units)
		// VALUES(?,?,?,?,?,?,?,?,?)";
		//
		// BufferedReader br = null;
		// int i = 1;
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb",
		// "root", "2UeBBrAThS6aGNNRCPJX");
		// pstmt = con.prepareStatement(sql);
		// con.setAutoCommit(false);
		// for (File file : dir.listFiles()) {
		// AppLogger.sysDebug(file.getName());
		// br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(file)));
		// String line = "";
		// while ((line = br.readLine()) != null) {
		// StationDevice sd = gson.fromJson(line, StationDevice.class);
		// pstmt.setString(1, sd.getStationSysId());
		// pstmt.setString(2, sd.getDeviceName());
		// pstmt.setString(3, sd.getDeviceCode());
		// pstmt.setString(4, sd.getModel());
		// pstmt.setString(5, sd.getManufacturer());
		// pstmt.setString(6, sd.getPoint());
		// pstmt.setTimestamp(7, new Timestamp(sd.getUpdateTime().getTime()));
		// pstmt.setString(8, sd.getActualValue());
		// pstmt.setString(9, sd.getUnits());
		// pstmt.executeUpdate();
		// con.commit();
		// if (i % 5000 == 0) {
		// con.commit();
		// AppLogger.sysDebug("commit");
		// }
		// i++;
		// }
		// }
		// con.commit();
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// br.close();
		// pstmt.close();
		// con.close();
		// }
		// File f = new File("C:/Users/fu/Desktop/站点设备/device_冷水江市.txt");
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(f)));
		// String sql =
		// "INSERT INTO station_device
		// (station_sys_id,device_name,device_code,model,manufacturer,point,update_time,actual_value,units)
		// VALUES(?,?,?,?,?,?,?,?,?);";
		// String line = "";
		// while ((line = br.readLine()) != null) {
		// StationDevice sd = gson.fromJson(line, StationDevice.class);
		// String sqlReplace = sql.replaceFirst("\\?", "'" +
		// sd.getStationSysId() + "'")
		// .replaceFirst("\\?", "'" + sd.getDeviceName() + "'")
		// .replaceFirst("\\?", "'" + sd.getDeviceCode() + "'")
		// .replaceFirst("\\?", "'" + sd.getModel() + "'")
		// .replaceFirst("\\?", "'" + sd.getManufacturer() + "'")
		// .replaceFirst("\\?", "'" + sd.getPoint() + "'")
		// .replaceFirst("\\?", "'" + FormatUtil.getFDate(sd.getUpdateTime()) +
		// "'")
		// .replaceFirst("\\?", "'" + sd.getActualValue() + "'")
		// .replaceFirst("\\?", "'" + sd.getUnits() + "'");
		// System.out.println(sqlReplace);
		// }
		// String seperator = " ";
		// File dir = new File("C:/Users/fu/Desktop/补充");
		// File destFile = new File("C:/Users/fu/Desktop/dest_补充.txt");
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(destFile)));
		// BufferedReader br = null;
		// for (File file : dir.listFiles()) {
		// br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(file)));
		// String line = "";
		// int count = 0;
		// while ((line = br.readLine()) != null) {
		// StationDevice sd = gson.fromJson(line, StationDevice.class);
		// StringBuffer sb = new StringBuffer();
		// sb.append(sd.getStationSysId()).append(seperator)
		// .append(sd.getDeviceName()).append(seperator)
		// .append(sd.getDeviceCode()).append(seperator)
		// .append(sd.getModel()).append(seperator)
		// .append(sd.getManufacturer()).append(seperator)
		// .append(sd.getPoint()).append(seperator)
		// .append(FormatUtil.getFDate(sd.getUpdateTime())).append(seperator)
		// .append(sd.getActualValue()).append(seperator)
		// .append(sd.getUnits());
		// bw.write(sb.toString());
		// bw.newLine();
		// count++;
		// }
		// AppLogger.sysDebug(file.getName() + " count:" + count);
		// bw.flush();
		// }
		// bw.close();
		// br.close();
		// double d=0.00;
		// System.out.println(d==0);
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("C:/Users/fu/Desktop/新建文本文档 (3).txt"), "gbk"));
		// StringBuffer sb = new StringBuffer();
		// String line = "";
		// while ((line = br.readLine()) != null) {
		// sb.append(line);
		// }
		//
		// Parser parser = new Parser(sb.toString());
		//
		// NodeList nodeList = parser.parse(null);
		// TableTag tt = (TableTag) nodeList.elementAt(0);
		//
		// TableRow[] rows = tt.getRows();
		// for (int i = 0; i < rows.length; i++) {
		// TableColumn[] cols = rows[i].getColumns();
		// LinkTag link = (LinkTag) cols[4].getChild(1);
		// String hrefText = link.getAttribute("href");
		// Pattern p1 =
		// Pattern.compile("javascript:showBillDetail\\('(.*?)','(.*?)','(.*?)'\\)");
		// Matcher m1 = p1.matcher(hrefText);
		// String billId = m1.find() ? m1.group(1) : "";
		// Tag troubleNOTag = (Tag) cols[4].getChild(1).getFirstChild();
		// String alarmIndex = cols[1].getChild(1).getText().trim();
		// String troubleNO = troubleNOTag.getAttribute("title");
		// String alarmTime = cols[9].toPlainTextString();
		// String alarmName = cols[5].toPlainTextString();
		// String alarmDetail = cols[6].getChild(1).getText().trim();
		// LinkTag siteNamelink = (LinkTag) cols[7].getChild(1);
		// String siteNamehrefText = siteNamelink.getAttribute("href");
		// Pattern p2 =
		// Pattern.compile("javascript:showStationDetailFunc\\('(.*?)','(.*?)'\\)");
		// Matcher m2 = p2.matcher(siteNamehrefText);
		// String stationsid = m2.find() ? m2.group(1) : "";
		// String siteName =
		// cols[7].getChild(1).getFirstChild().getText().trim();
		// String siteCode =
		// cols[13].getChild(1).getFirstChild().getText().trim();
		// String duration = cols[11].toPlainTextString();
		// System.out.println(alarmIndex + "|" + billId + "|" + troubleNO + "|"
		// + alarmName + "|" + alarmDetail + "|" + alarmTime + "|" + stationsid
		// + "|" + siteCode
		// + "|" + siteName
		// + "|" + duration);
		// }
		// Matcher gElecMatcher =
		// Pattern.compile("(.*?)(发电|我要发电|提交发电信息|我要提交发电信息).*?").matcher("提交发电信息");
		// System.out.println(gElecMatcher.find());

		// System.out.println("nanning "+SecurityUtil.password("nanning"));
		// System.out.println("liuzhou "+SecurityUtil.password("liuzhou"));
		// System.out.println("guilin "+SecurityUtil.password("guilin"));
		// System.out.println("yulin "+SecurityUtil.password("yulin"));
		// System.out.println("guigang "+SecurityUtil.password("guigang"));
		// System.out.println("baise "+SecurityUtil.password("baise"));
		// System.out.println("hechi "+SecurityUtil.password("hechi"));
		// System.out.println("qinzhou "+SecurityUtil.password("qinzhou"));
		// System.out.println("wuzhou "+SecurityUtil.password("wuzhou"));
		// System.out.println("beihai "+SecurityUtil.password("beihai"));
		// System.out.println("fangchenggang
		// "+SecurityUtil.password("fangchenggang"));
		// System.out.println("chongzuo "+SecurityUtil.password("chongzuo"));
		// System.out.println("laibin "+SecurityUtil.password("laibin"));
		// System.out.println("hezhou "+SecurityUtil.password("hezhou"));
		// String
		// str="F:/data/itower/genElec-upload/FS-43-001-20161129-459306_1480390686629.jpg";
		// for(String s:str.split("\\.")){
		// AppLogger.sysDebug(s);
		// }
		// System.out.println(SecurityUtil.password("yang172168"));
		// 1 2 4
		// 移动 联通 电信

		// int[] array = FormatUtil.getBinaryArray(11, 3);
		// ArrayUtils.reverse(array);
		// System.out.println(ToStringBuilder.reflectionToString(array));
		// DateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date begin = FormatUtil.parseDate(fdf, "2016-12-25 13:23:10");
		// Date end = FormatUtil.parseDate(fdf, "2016-12-25 18:52:31");
		// Long dd = end.getTime() - begin.getTime();
		// System.out.println(FormatUtil.formatNumber(dd.doubleValue() / (1000 *
		// 60 * 60), 2));
		// "http://121.197.3.240:9898/itowerElec/bz.jsp?qid=1470659496493")
		// try {
		// Desktop.getDesktop().browse(new
		// URL("http://121.197.3.240:9898/itowerElec/bz.jsp?qid=1470659496493").toURI());
		// Robot robot = new Robot();
		// robot.delay(1000);
		// Dimension d = new
		// Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		// int width = (int) d.getWidth();
		// int height = (int) d.getHeight();
		// robot.keyRelease(KeyEvent.VK_F11);
		// robot.delay(1000);
		// Image image = robot.createScreenCapture(new Rectangle(0, 61, width,
		// height-61));
		// BufferedImage bi = new BufferedImage(width, height,
		// BufferedImage.TYPE_INT_RGB);
		// Graphics g = bi.createGraphics();
		// g.drawImage(image, 0, 0, width, height, null);
		// // 保存图片
		// ImageIO.write(bi, "jpg", new File("D:/temp.jpg"));
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// String src="<span class=\\\"emoji emoji1f449\\\"><\\/span>//";
		// System.out.println(src);
		// System.out.println(src.replace("\\\"","\"").replace("\\/", "/"));
		// Map<String, Integer> opMap = new HashMap<String, Integer>();
		// opMap.put("移动", 1);
		// opMap.put("联通", 2);
		// opMap.put("电信", 4);
		//
		// String sql_station = "insert into itowerdb.it_station
		// (it_province_id,it_city_id,it_district_id,station_name,station_code,station_sys_code,lng,lat,address,origin_id,operator,scene_id,alias_cm,alias_cu,alias_ct,station_type_id,area_manager,area_manager_phone,fsu_manufactor,maintenance_corp,acceptance_date,outside_customer,remark,status,update_time)
		// values('0098364',(select it_city_id from it_city where cname=? and
		// it_province_id='0098364'),(select it_district_id from it_district
		// where dname=? and it_province_id='0098364'),?,?,?,?,?,?,(select
		// it_origin_id from it_origin where origin_name =?),?,(select
		// it_scene_id from it_scene where scene_name =?),?,?,?,(SELECT
		// it_station_type_id FROM it_station_type WHERE type_name
		// =?),?,?,?,?,?,?,?,1,(SELECT NOW() FROM DUAL));";
		// String sql_staff = "insert into sta_agt_staff_copy
		// (stationCode,agstaffName,agstaffTel) values(?,?,?)";
		// Connection con = null;
		// PreparedStatement pstmt_station = null;
		// PreparedStatement pstmt_stastaff = null;
		// String[] row_line = null;
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con =
		// DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb",
		// "root", "2UeBBrAThS6aGNNRCPJX");
		// con.setAutoCommit(false);
		// pstmt_station = con.prepareStatement(sql_station);
		// pstmt_stastaff = con.prepareStatement(sql_staff);
		// String[][] excel =
		// ExcelUtil.readSheet("C:/Users/fu/Desktop/湖南代维/广西站点20170302.xls",
		// "站址管理信息-导出", 0);
		// AppLogger.sysDebug("start...");
		// for (int i = 2; i < excel.length; i++) {
		// String[] row = excel[i];
		// row_line = excel[i];
		// pstmt_station.setString(1, row[1].replace("分公司", ""));
		// pstmt_station.setString(2, row[2]);
		// pstmt_station.setString(3, row[4]);
		// pstmt_station.setString(4, row[6]);
		// pstmt_station.setString(5, row[5]);
		// pstmt_station.setString(6, row[7]);
		// pstmt_station.setString(7, row[8]);
		// pstmt_station.setString(8, row[12]);
		// pstmt_station.setString(9, row[14]);
		// if (row[15] == null || row[15].trim().length() == 0) {
		// pstmt_station.setInt(10, 0);
		// } else {
		// String[] op_array = row[15].split("，", 3);
		// int oper_calc = 0;
		// for (String op_str : op_array) {
		// oper_calc += opMap.get(op_str);
		// }
		// pstmt_station.setInt(10, oper_calc);
		// }
		//
		// pstmt_station.setString(11, row[16]);
		// pstmt_station.setString(12, row[24]);
		// pstmt_station.setString(13, row[32]);
		// pstmt_station.setString(14, row[40]);
		// pstmt_station.setString(15, row[97]);
		// pstmt_station.setString(16, row[42]);
		// pstmt_station.setString(17, row[43]);
		// pstmt_station.setString(18, row[68]);
		// pstmt_station.setString(19, row[89]);
		//
		// if (row[11] != null && row[11].trim().length() > 0) {
		// pstmt_station.setString(20, row[11]);
		// } else {
		// pstmt_station.setNull(20, java.sql.Types.DATE);
		// }
		//
		// pstmt_station.setString(21, row[106]);
		// pstmt_station.setString(22, row[108]);
		//
		// pstmt_station.executeUpdate();
		// pstmt_stastaff.setString(1, row[6]);
		// pstmt_stastaff.setString(2, row[44]);
		// pstmt_stastaff.setString(3, row[45]);
		// pstmt_stastaff.executeUpdate();
		// if (i % 500 == 0) {
		// AppLogger.sysDebug(i);
		// con.commit();
		// }
		// }
		// con.commit();
		// AppLogger.sysDebug("end...");
		// } catch (Exception e) {
		// e.printStackTrace();
		// AppLogger.sysError(ToStringBuilder.reflectionToString(row_line));
		// } finally {
		// if (pstmt_station != null)
		// pstmt_station.close();
		// if (con != null)
		// con.close();
		// }
		// System.out.println(SecurityUtil.password("12345678"));

		Connection con = null;
		PreparedStatement pstmt_query = null;
		PreparedStatement pstmt_query_666 = null;
		ResultSet rs = null;
		ResultSet rs_666 = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb", "root", "2UeBBrAThS6aGNNRCPJX");

			pstmt_query_666 = con.prepareStatement("SELECT b.logtime,TIMESTAMPDIFF(DAY,b.logtime,NOW()) diff  FROM (SELECT logtime FROM botchatlog WHERE fromUsername=? ORDER BY logtime LIMIT 0,1) b");
			pstmt_query = con.prepareStatement(
					"SELECT * FROM(SELECT COUNT(*) AS lx FROM botchatlog WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([lL][xX]|离线)(.{0,20})$')  UNION  ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([vV]|电压|告警电压)(.{0,20})$') UNION ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([bB][zZ]|保障)(.{0,20})$') UNION ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([tT]|退服)(.{0,20})$') UNION ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([tT][dD]|停电统计)(.{0,20})$') UNION ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND (content REGEXP '^@.*<br/>([zZ][bB]|重保)(.{0,20})$') UNION ALL SELECT COUNT(*) AS vv FROM botchatlog  WHERE fromUsername=? AND LOCATE('@监控值班机器人',content)>0) t");

			List<String> lines = IOUtils.readLines(new FileInputStream("C:/Users/lex/Desktop/新建文本文档 (4).txt"), "GBK");
			for (String line : lines) {
				System.out.print(line + "|");
				pstmt_query.setString(1, line);
				pstmt_query.setString(2, line);
				pstmt_query.setString(3, line);
				pstmt_query.setString(4, line);
				pstmt_query.setString(5, line);
				pstmt_query.setString(6, line);
				pstmt_query.setString(7, line);
				pstmt_query_666.setString(1, line);

				rs = pstmt_query.executeQuery();
				rs_666 = pstmt_query_666.executeQuery();

				if (rs_666.next()) {
					Date joinTime = new Date(rs_666.getTimestamp(1).getTime());
					int diff = rs_666.getInt(2);
					System.out.print(FormatUtil.getFDate(joinTime) + "|" + diff + "|");
				}

				while (rs.next()) {
					int count = rs.getInt(1);
					System.out.print(count + "|");
				}

				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt_query.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
}
