/**
 * 
 */
package com.fuhj.itower.ui.export;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.GenElecReportItem;
import com.fuhj.util.FormatUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-30
 */
public class ExportUtil {

	public static HSSFWorkbook createAlarmXLS(List<AlarmModel> list) {
		if (list == null || list.size() == 0)
			return null;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();

		HSSFCellStyle headStyle = wb.createCellStyle();
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont headFont1 = wb.createFont();
		headFont1.setFontHeightInPoints((short) 13);
		headStyle.setFont(headFont1);
		headStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle centerStyle = wb.createCellStyle();
		centerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		dateStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		int rowIndex = 0;

		HSSFRow header = sheet.createRow(rowIndex++);
		header.setHeightInPoints(50.f);
		createHSSFCell(header, 0, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("序号");
		createHSSFCell(header, 1, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("地市");
		createHSSFCell(header, 2, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("区县");
		createHSSFCell(header, 3, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障单编号");
		createHSSFCell(header, 4, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站名");
		createHSSFCell(header, 5, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站点编码");
		createHSSFCell(header, 6, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址来源");
		createHSSFCell(header, 7, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警时间");
		createHSSFCell(header, 8, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警历时(M)");
		createHSSFCell(header, 9, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("实时电压(V)");
		createHSSFCell(header, 10, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("代维公司");
		createHSSFCell(header, 11, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("机房(动环)维护人员");
		createHSSFCell(header, 12, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("机房(动环)维护人员联系电话");
		createHSSFCell(header, 13, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电预警");
		createHSSFCell(header, 14, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("FSU厂家");

		for (AlarmModel am : list) {
			HSSFRow row = sheet.createRow(rowIndex++);
			row.setHeightInPoints(25.f);
			createHSSFCell(row, 0, cellStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(rowIndex - 1);
			createHSSFCell(row, 1, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getCity());
			createHSSFCell(row, 2, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getDistrict());
			createHSSFCell(row, 3, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getTroubleno());
			createHSSFCell(row, 4, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getStationname());
			createHSSFCell(row, 5, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getStationcode());
			createHSSFCell(row, 6, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getStationFrom());
			createHSSFCell(row, 7, dateStyle, -1).setCellValue(am.getAlarmtime());
			createHSSFCell(row, 8, centerStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(am.getAlarmduration());
			createHSSFCell(row, 9, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(ItowerImpl.formatVoltage(am.getVoltage()));
			String sasName = "";
			String stafftel = "";
			if (am.getSas() != null) {
				sasName = am.getSas().getAgstaffname();
				stafftel = am.getSas().getAgstafftel();
			}
			createHSSFCell(row, 10, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getAgentMaintainCorp());
			createHSSFCell(row, 11, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(sasName);
			createHSSFCell(row, 12, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(stafftel);
			createHSSFCell(row, 13, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getElecWarninglevel());
			createHSSFCell(row, 14, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(am.getFsuManufacturer());
		}
		sheet.setColumnWidth(0, 36 * 45);
		sheet.setColumnWidth(1, 36 * 60);
		sheet.setColumnWidth(2, 36 * 60);
		sheet.setColumnWidth(3, 36 * 200);
		sheet.setColumnWidth(4, 36 * 250);
		sheet.setColumnWidth(5, 36 * 120);
		sheet.setColumnWidth(6, 36 * 85);
		sheet.setColumnWidth(7, 36 * 150);
		sheet.setColumnWidth(8, 36 * 100);
		sheet.setColumnWidth(9, 36 * 100);
		sheet.setColumnWidth(10, 36 * 250);
		sheet.setColumnWidth(11, 36 * 250);
		sheet.setColumnWidth(12, 36 * 250);
		sheet.setColumnWidth(13, 36 * 85);
		sheet.setColumnWidth(14, 36 * 85);
		return wb;
	}

	public static HSSFWorkbook createITBillXLS(List<ITBill> list) {
		if (list == null || list.size() == 0)
			return null;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("停电工单-导出");
		HSSFCellStyle headStyle = wb.createCellStyle();
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont headFont1 = wb.createFont();
		headFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headStyle.setFont(headFont1);
		headStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle centerStyle = wb.createCellStyle();
		centerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		dateStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		int rowIndex = 0;
		HSSFRow header = sheet.createRow(rowIndex++);
		header.setHeightInPoints(50.f);
		createHSSFCell(header, 0, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障单编码");
		createHSSFCell(header, 1, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("工单状态");
		createHSSFCell(header, 2, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("受理时间");
		createHSSFCell(header, 3, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("派单时间");
		createHSSFCell(header, 4, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("接单时间");
		createHSSFCell(header, 5, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警时间");
		createHSSFCell(header, 6, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("时限");
		createHSSFCell(header, 7, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("回单时间");
		createHSSFCell(header, 8, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("归档时间");
		createHSSFCell(header, 9, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障来源");
		createHSSFCell(header, 10, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警名称");
		createHSSFCell(header, 11, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警状态");
		createHSSFCell(header, 12, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警描述");
		createHSSFCell(header, 13, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警等级");
		createHSSFCell(header, 14, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址运维ID");
		createHSSFCell(header, 15, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址名称");
		createHSSFCell(header, 16, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("所属省份");
		createHSSFCell(header, 17, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("所属地市");
		createHSSFCell(header, 18, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("所属区县");
		createHSSFCell(header, 19, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否上站");
		createHSSFCell(header, 20, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障原因");
		createHSSFCell(header, 21, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否免责");
		createHSSFCell(header, 22, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("免责条款");
		createHSSFCell(header, 23, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("具体免责原因");
		createHSSFCell(header, 24, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警清除时间");
		createHSSFCell(header, 25, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("回复内容");
		createHSSFCell(header, 26, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障设备类型");
		createHSSFCell(header, 27, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否催办");
		createHSSFCell(header, 28, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("回单是否超时");
		createHSSFCell(header, 29, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("回单人");
		createHSSFCell(header, 30, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("代维公司");
		createHSSFCell(header, 31, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("处理过程");
		createHSSFCell(header, 32, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("机房类型");
		createHSSFCell(header, 33, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("供电方式");
		createHSSFCell(header, 34, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("FSU上网卡类型");
		createHSSFCell(header, 35, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("FSU厂家");
		createHSSFCell(header, 36, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("空调生产厂商");
		createHSSFCell(header, 37, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("电池生产厂商");
		createHSSFCell(header, 38, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("开关电源厂家");
		createHSSFCell(header, 39, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否具备发电条件");
		createHSSFCell(header, 40, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("单体电池组数");
		createHSSFCell(header, 41, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("单组额定容量（AH）");
		createHSSFCell(header, 42, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("直流负载总电流（A）");
		createHSSFCell(header, 43, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("蓄电池基础保障服务备电时长");
		createHSSFCell(header, 44, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("告警历时（分钟）");
		createHSSFCell(header, 45, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("工单处理历时（分钟）");
		createHSSFCell(header, 46, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("处理人/部门");
		createHSSFCell(header, 47, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("回单操作终端");
		createHSSFCell(header, 48, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("接单时长（分钟）");
		createHSSFCell(header, 49, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("首次反馈时间");
		createHSSFCell(header, 50, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("接单是否超时");
		createHSSFCell(header, 51, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("所属运营商");
		createHSSFCell(header, 52, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障确认内容");
		createHSSFCell(header, 53, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("区域经理");
		createHSSFCell(header, 54, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("数据来源");
		createHSSFCell(header, 55, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("接单操作终端");
		createHSSFCell(header, 56, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("签到时间");
		createHSSFCell(header, 57, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("签到经度");
		createHSSFCell(header, 58, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("签到纬度");
		createHSSFCell(header, 59, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址经度");
		createHSSFCell(header, 60, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址纬度");
		createHSSFCell(header, 61, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否是发电工单");
		createHSSFCell(header, 62, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障类型");

		for (ITBill itbill : list) {
			HSSFRow row = sheet.createRow(rowIndex++);
			row.setHeightInPoints(25.f);
			createHSSFCell(row, 0, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBillCode() != null ? itbill.getBillCode() : "");
			createHSSFCell(row, 1, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBillStatus());
			if (itbill.getAcceptTime() != null) {
				createHSSFCell(row, 2, dateStyle, -1).setCellValue(itbill.getAcceptTime());
			} else {
				createHSSFCell(row, 2, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			if (itbill.getDispatchTime() != null) {
				createHSSFCell(row, 3, centerStyle, -1).setCellValue(itbill.getDispatchTime());
			} else {
				createHSSFCell(row, 3, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			if (itbill.getReceiveTime() != null) {
				createHSSFCell(row, 4, dateStyle, -1).setCellValue(itbill.getReceiveTime());
			} else {
				createHSSFCell(row, 4, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			if (itbill.getAlarmTime() != null) {
				createHSSFCell(row, 5, dateStyle, -1).setCellValue(itbill.getAlarmTime());
			} else {
				createHSSFCell(row, 5, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 6, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getTimeLimit());
			if (itbill.getReceiptTime() != null) {
				createHSSFCell(row, 7, dateStyle, -1).setCellValue(itbill.getReceiptTime());
			} else {
				createHSSFCell(row, 7, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			if (itbill.getFiledTime() != null) {
				createHSSFCell(row, 8, dateStyle, -1).setCellValue(itbill.getFiledTime());
			} else {
				createHSSFCell(row, 8, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 9, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFaultSource());
			createHSSFCell(row, 10, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmName());
			createHSSFCell(row, 11, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmStatus());
			createHSSFCell(row, 12, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmDetail());
			createHSSFCell(row, 13, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmLevel());
			createHSSFCell(row, 14, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getStationCode());
			createHSSFCell(row, 15, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getStationName());
			createHSSFCell(row, 16, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getProvince());
			createHSSFCell(row, 17, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getCity());
			createHSSFCell(row, 18, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getDistrict());
			createHSSFCell(row, 19, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getGoStation());
			createHSSFCell(row, 20, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFaultReason());
			createHSSFCell(row, 21, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getImmunity());
			createHSSFCell(row, 22, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getDisclaimer());
			createHSSFCell(row, 23, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getImmunityReason());
			if (itbill.getAlarmClearTime() != null) {
				createHSSFCell(row, 24, dateStyle, -1).setCellValue(itbill.getAlarmClearTime());
			} else {
				createHSSFCell(row, 24, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 25, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmReplyContent());
			createHSSFCell(row, 26, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFaultDeviceType());
			createHSSFCell(row, 27, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getHasPressed());
			createHSSFCell(row, 28, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getIsReceiptTimeout());
			createHSSFCell(row, 29, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getReceiptPerson());
			createHSSFCell(row, 30, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAgentsCorp());
			createHSSFCell(row, 31, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBillProcess());
			createHSSFCell(row, 32, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getMachineRoomType());
			createHSSFCell(row, 33, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getPowerSupplyMode());
			createHSSFCell(row, 34, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFsuNetworkCardType());
			createHSSFCell(row, 35, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFsuManufactor());
			createHSSFCell(row, 36, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAcManufactor());
			createHSSFCell(row, 37, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBatteryManufactor());
			createHSSFCell(row, 38, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getSwitchManufactor());
			createHSSFCell(row, 39, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getElecConditions());
			createHSSFCell(row, 40, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBatteryCount());
			createHSSFCell(row, 41, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBatteryCapacity());
			createHSSFCell(row, 42, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getTotalCurrent());
			createHSSFCell(row, 43, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBatteryGuarantee());
			createHSSFCell(row, 44, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAlarmDuration());
			createHSSFCell(row, 45, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBillDuration());
			createHSSFCell(row, 46, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getBillHandler());
			createHSSFCell(row, 47, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getReceiptTerminal());
			createHSSFCell(row, 48, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getReceiveDuration());
			if (itbill.getFirstReplyTime() != null) {
				createHSSFCell(row, 49, dateStyle, -1).setCellValue(itbill.getFirstReplyTime());
			} else {
				createHSSFCell(row, 49, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 50, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getIsReceiveTimeout());
			createHSSFCell(row, 51, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getOperator());
			createHSSFCell(row, 52, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFaultConfirmContent());
			createHSSFCell(row, 53, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getAreaManager());
			createHSSFCell(row, 54, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getDataOrigin());
			createHSSFCell(row, 55, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getReceiveTerminal());
			if (itbill.getSignTime() != null) {
				createHSSFCell(row, 56, dateStyle, -1).setCellValue(itbill.getSignTime());
			} else {
				createHSSFCell(row, 56, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 57, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getSignLng());
			createHSSFCell(row, 58, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getSignLat());
			createHSSFCell(row, 59, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getStationLng());
			createHSSFCell(row, 60, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getStationLat());
			createHSSFCell(row, 61, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getIsElecGenerBill());
			createHSSFCell(row, 62, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(itbill.getFaultType());

		}
		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			sheet.autoSizeColumn(i);
		}
		return wb;
	}

	public static HSSFWorkbook createGelecInfoXLS(List<GElecInfo> list) {
		if (list == null || list.size() == 0)
			return null;
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet("发电信息-导出");
		HSSFCellStyle headStyle = wb.createCellStyle();
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		headStyle.setWrapText(true);
		HSSFFont headFont1 = wb.createFont();
		headFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headStyle.setFont(headFont1);
		headStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle centerStyle = wb.createCellStyle();
		centerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		dateStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		int rowIndex = 0;
		HSSFRow header = sheet.createRow(rowIndex++);
		header.setHeightInPoints(80.f);
		createHSSFCell(header, 0, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("编号");
		createHSSFCell(header, 1, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("故障单编码");
		createHSSFCell(header, 2, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("省份");
		createHSSFCell(header, 3, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("地市");
		createHSSFCell(header, 4, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("区县");
		createHSSFCell(header, 5, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址名称");
		createHSSFCell(header, 6, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址编码");
		createHSSFCell(header, 7, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("资源站址编码");
		createHSSFCell(header, 8, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("运营商名称");
		createHSSFCell(header, 9, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("运营商编码");
		createHSSFCell(header, 10, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电日期");
		createHSSFCell(header, 11, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电开始时间");
		createHSSFCell(header, 12, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电结束时间");
		createHSSFCell(header, 13, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电时长（小时）");
		createHSSFCell(header, 14, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("往返行驶里程（公里）");
		createHSSFCell(header, 15, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("实时油价（北京、内蒙古、河南、云南、广西、广东 必填）（元/升）");
		createHSSFCell(header, 16, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("油机数量（云南 必填）（个）");
		createHSSFCell(header, 17, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否空跑（青海、山西 必填）");
		createHSSFCell(header, 18, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否铁塔油机（江苏 必填）");
		createHSSFCell(header, 19, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否自动油机（广东 必填）");
		createHSSFCell(header, 20, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("地理系数（陕西 必填）");
		createHSSFCell(header, 21, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("特殊区域类型（广西 必填）");
		createHSSFCell(header, 22, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("每小时油耗（L）（广东、广西必填，广西（4.5 0r 2.75））");
		createHSSFCell(header, 23, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("站址来源（山东 必填）");
		createHSSFCell(header, 24, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("系统数（山西 必填）");
		createHSSFCell(header, 25, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("所属项目部");
		createHSSFCell(header, 26, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("是否长期发电");
		createHSSFCell(header, 27, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电原因");
		createHSSFCell(header, 28, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("备注");
		createHSSFCell(header, 29, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("油机功率");
		createHSSFCell(header, 30, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("油机类型");
		createHSSFCell(header, 31, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("油机编号");
		createHSSFCell(header, 32, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电人");
		createHSSFCell(header, 33, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("发电人联系电话");
		createHSSFCell(header, 34, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("开始发电实时电压（开关电源）");
		createHSSFCell(header, 35, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("结束发电实时电压（开关电源）");
		createHSSFCell(header, 36, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("状态");
		for (GElecInfo gi : list) {
			HSSFRow row = sheet.createRow(rowIndex++);
			row.setHeightInPoints(25.f);
			createHSSFCell(row, 0, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getgCode());
			createHSSFCell(row, 1, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getBillCode());
			createHSSFCell(row, 2, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getProvince() + "分公司");
			createHSSFCell(row, 3, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getCity() + "分公司");
			createHSSFCell(row, 4, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getDistrict());
			createHSSFCell(row, 5, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getStationName());
			createHSSFCell(row, 6, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getStationCode());
			createHSSFCell(row, 7, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getStationSysCode());
			createHSSFCell(row, 8, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getOperator());
			createHSSFCell(row, 9, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 10, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(FormatUtil.getEDate(gi.getCreateTime()));
			createHSSFCell(row, 11, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(FormatUtil.getFDate(gi.getStartTime()));
			createHSSFCell(row, 12, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(FormatUtil.getFDate(gi.getEndTime()));

			if (gi.getEndTime() != null && gi.getStartTime() != null) {
				Long dd = gi.getEndTime().getTime() - gi.getStartTime().getTime();
				String duration = FormatUtil.formatNumber(dd.doubleValue() / (1000 * 60 * 60), 2);

				createHSSFCell(row, 13, centerStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(Double.parseDouble(duration));
			} else {
				createHSSFCell(row, 13, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			}
			createHSSFCell(row, 14, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getOdometer());
			createHSSFCell(row, 15, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getPetrolPrice());
			createHSSFCell(row, 16, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getMachineCount());
			createHSSFCell(row, 17, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 18, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 19, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 20, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 21, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getAreaType());
			createHSSFCell(row, 22, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 23, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getDataOrigin());
			createHSSFCell(row, 24, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 25, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 26, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 27, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getReason());
			createHSSFCell(row, 28, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getRemark());
			createHSSFCell(row, 29, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getMachinePower());
			createHSSFCell(row, 30, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getMachineType());
			createHSSFCell(row, 31, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getMachineNo());
			createHSSFCell(row, 32, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getPerson());
			createHSSFCell(row, 33, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getContact());
//			createHSSFCell(row, 34, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getStartVoltage());
//			createHSSFCell(row, 35, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(gi.getEndVoltage());
			createHSSFCell(row, 34, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			createHSSFCell(row, 35, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
			String status = "";
			switch (gi.getStatus()) {
			case 1:
				status = "已完成";
				break;
			case 2:
				status = "进行中";
				break;
			}
			createHSSFCell(row, 36, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(status);
		}
		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			sheet.autoSizeColumn(i);
		}
		return wb;
	}

	public static HSSFWorkbook createGelecReportXLS(List<GenElecReportItem> list, String queryArea, Date start, Date end) {
		if (list == null || list.size() == 0)
			return null;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("发电数据统计-导出");
		HSSFCellStyle headStyle = wb.createCellStyle();
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		headStyle.setWrapText(true);
		HSSFFont headFont1 = wb.createFont();
		headFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headStyle.setFont(headFont1);
		headStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		headStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle centerStyle = wb.createCellStyle();
		centerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		dateStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);

		int rowIndex = 0;
		HSSFRow header = sheet.createRow(rowIndex++);
		header.setHeightInPoints(40.f);
		createHSSFCell(header, 0, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("地区");
		createHSSFCell(header, 1, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("已完成");
		createHSSFCell(header, 2, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("进行中");
		createHSSFCell(header, 3, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("总数量");
		GenElecReportItem sumItem = new GenElecReportItem();
		for (GenElecReportItem item : list) {
			HSSFRow row = sheet.createRow(rowIndex++);
			row.setHeightInPoints(25.f);
			createHSSFCell(row, 0, centerStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(item.getShowName());
			createHSSFCell(row, 1, centerStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(item.getDone());
			createHSSFCell(row, 2, centerStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(item.getIng());
			createHSSFCell(row, 3, centerStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(item.getSum());
			sumItem.setDone(sumItem.getDone() + item.getDone());
			sumItem.setIng(sumItem.getIng() + item.getIng());
			sumItem.setSum(sumItem.getSum() + item.getSum());
		}
		HSSFRow sumrow = sheet.createRow(rowIndex++);
		sumrow.setHeightInPoints(40.f);
		createHSSFCell(sumrow, 0, headStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("合计");
		createHSSFCell(sumrow, 1, headStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(sumItem.getDone());
		createHSSFCell(sumrow, 2, headStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(sumItem.getIng());
		createHSSFCell(sumrow, 3, headStyle, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(sumItem.getSum());

		StringBuffer sb = new StringBuffer();
		sb.append("  查询区域： ");
		sb.append(queryArea);
		sb.append("，查询时间范围： ");
		if (start == null && end == null) {
			sb.append("不限 ");
		} else {
			if (start != null && end != null) {
				sb.append("从 ");
				sb.append(FormatUtil.getEDate(start));
				sb.append(" 至 ");
				sb.append(FormatUtil.getEDate(end));
			} else if (start != null) {
				sb.append("从 ");
				sb.append(FormatUtil.getEDate(start));
				sb.append(" 至今");
			} else if (end != null) {
				sb.append(" 截止至 ");
				sb.append(FormatUtil.getEDate(end));
			}
		}
		HSSFRow tipsrow = sheet.createRow(rowIndex);
		createHSSFCell(tipsrow, 0, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue(sb.toString());
		createHSSFCell(tipsrow, 1, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
		createHSSFCell(tipsrow, 2, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
		createHSSFCell(tipsrow, 3, cellStyle, HSSFCell.CELL_TYPE_STRING).setCellValue("");
		tipsrow.setHeightInPoints(25.f);
		sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 3));
		sheet.setColumnWidth(0, 36 * 200);
		sheet.setColumnWidth(1, 36 * 200);
		sheet.setColumnWidth(2, 36 * 200);
		sheet.setColumnWidth(3, 36 * 200);
		return wb;
	}

	public static HSSFCell createHSSFCell(HSSFRow row, int index, HSSFCellStyle style, int cellTpye) {
		HSSFCell cell = row.createCell(index);
		if (style != null) {
			cell.setCellStyle(style);
		}
		if (cellTpye != -1) {
			cell.setCellType(cellTpye);
		}
		return cell;
	}

	public static HSSFCell createHSSFCell(HSSFRow row, int index) {
		return createHSSFCell(row, index, null, HSSFCell.CELL_TYPE_STRING);
	}

	public static HSSFCell createHSSFCell(HSSFRow row, int index, int cellType) {
		return createHSSFCell(row, index, null, cellType);
	}
}
