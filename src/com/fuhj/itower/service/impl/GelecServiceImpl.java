/**
 * 
 */
package com.fuhj.itower.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.dao.DbField;
import com.fuhj.itower.dao.Example;
import com.fuhj.itower.dao.GenericMapper;
import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.GElecInfoCriteria;
import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.GElecUserCriteria;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.model.ITBillCriteria;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.ui.model.GelecUserModel;
import com.fuhj.itower.ui.model.GenElecReportItem;
import com.fuhj.itower.ui.model.Summary;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SecurityUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-27
 */
public class GelecServiceImpl extends AbstractServiceImpl implements GelecService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2187518671343955731L;
	@Setter
	private GenericMapper<ITBill> itBillMapper;
	@Setter
	private GenericMapper<GElecInfo> gElecInfoMapper;
	@Setter
	private GenericMapper<GElecUser> gElecUserMapper;
	@Setter
	private LocationService locationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.MainService#addITBills(java.util.List)
	 */
	@Override
	public void addITBills(List<ITBill> list) throws ServiceException {
		// TODO Auto-generated method stub
		for (ITBill itBill : list) {
			itBillMapper.insert(itBill);
		}
	}

	public static final DateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.MainService#addITBillsByXLS(org.apache.poi.hssf.
	 * usermodel.HSSFWorkbook)
	 */
	@Override
	public void addITBillsByXLS(String itProvinceId, String itCityId, HSSFWorkbook wb) throws ServiceException {

		try {
			deleteITBillByArea(itProvinceId, itCityId);
			String[][] data = ExcelUtil.readSheet(wb, null, null);
			if (data.length <= 1) {
				return;
			}

			Date now = new Date();
			for (int i = 1; i < data.length; i++) {
				String[] row = data[i];
				ITBill bill = new ITBill();
				bill.setBillCode(row[0]);
				bill.setBillStatus(row[1]);
				bill.setAcceptTime(FormatUtil.parseDate(fdf, row[2]));
				bill.setDispatchTime(FormatUtil.parseDate(fdf, row[3]));
				bill.setReceiveTime(FormatUtil.parseDate(fdf, row[4]));
				bill.setAlarmTime(FormatUtil.parseDate(fdf, row[5]));
				bill.setTimeLimit(row[6]);
				bill.setReceiptTime(FormatUtil.parseDate(fdf, row[7]));
				bill.setFiledTime(FormatUtil.parseDate(fdf, row[8]));
				bill.setFaultSource(row[9]);
				bill.setAlarmName(row[10]);
				bill.setAlarmStatus(row[11]);
				bill.setAlarmDetail(row[12]);
				bill.setAlarmLevel(row[13]);
				bill.setStationCode(row[14]);
				bill.setStationName(row[15]);
				bill.setProvince(row[16].replace("分公司", ""));
				bill.setCity(row[17].replace("分公司", ""));
				bill.setDistrict(row[18]);
				bill.setItProvinceId(itProvinceId);
				bill.setItCityId(itCityId);
				bill.setItDistrictId(locationService.getDistrictIdByFullName(itProvinceId, itCityId, bill.getDistrict()));
				bill.setGoStation(row[19]);
				bill.setFaultReason(row[20]);
				bill.setImmunity(row[21]);
				bill.setDisclaimer(row[22]);
				bill.setImmunityReason(row[23]);
				bill.setAlarmClearTime(FormatUtil.parseDate(fdf, row[24]));
				bill.setAlarmReplyContent(row[25]);
				bill.setFaultDeviceType(row[26]);
				bill.setHasPressed(row[27]);
				bill.setIsReceiptTimeout(row[28]);
				bill.setReceiptPerson(row[29]);
				bill.setAgentsCorp(row[30]);
				bill.setBillProcess(row[31]);
				bill.setMachineRoomType(row[32]);
				bill.setPowerSupplyMode(row[33]);
				bill.setFsuNetworkCardType(row[34]);
				bill.setFsuManufactor(row[35]);
				bill.setAcManufactor(row[36]);
				bill.setBatteryManufactor(row[37]);
				bill.setSwitchManufactor(row[38]);
				bill.setElecConditions(row[39]);
				bill.setBatteryCount(row[40]);
				bill.setBatteryCapacity(row[41]);
				bill.setTotalCurrent(row[42]);
				bill.setBatteryGuarantee(row[43]);
				bill.setAlarmDuration(row[44]);
				bill.setBillDuration(row[45]);
				bill.setBillHandler(row[46]);
				bill.setReceiptTerminal(row[47]);
				bill.setReceiveDuration(row[48]);
				bill.setFirstReplyTime(FormatUtil.parseDate(fdf, row[49]));
				bill.setIsReceiveTimeout(row[50]);
				bill.setOperator(row[51]);
				bill.setFaultConfirmContent(row[52]);
				bill.setAreaManager(row[53]);
				bill.setDataOrigin(row[54]);
				bill.setReceiveTerminal(row[55]);
				bill.setSignTime(FormatUtil.parseDate(fdf, row[56]));
				bill.setSignLng(row[57]);
				bill.setSignLat(row[58]);
				bill.setStationLng(row[59]);
				bill.setStationLat(row[60]);
				bill.setIsElecGenerBill(row[61]);
				bill.setFaultType(row[62]);
				bill.setCreateTime(now);
				bill.setStatus(1);
				itBillMapper.insert(bill);
			}
			AppLogger.sysDebug("addITBillsByXLS done,provinceId:" + itProvinceId + " cityId:" + itCityId + " locationName:" + locationService.getLocationName(itProvinceId, itCityId, null) + " count:"
					+ (data.length - 1));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.MainService#deleteITBillByArea(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void deleteITBillByArea(String itProvinceId, String itCityId) throws ServiceException {
		final DbField itBillStatusField = new DbField(ITBill.STATUS, 0);
		List<DbField> fieldList = new ArrayList<DbField>();
		fieldList.add(itBillStatusField);
		Example<ITBillCriteria> e = Example.getExample(ITBillCriteria.class);
		ITBillCriteria c = e.createCriteria();
		c.andItProvinceIdEqualTo(itProvinceId);
		c.andItCityIdEqualTo(itCityId);
		c.andStatusEqualTo(1);
		itBillMapper.updateFieldsByExample(fieldList, e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getITBill(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ITBill> getITBill(String provinceId, String cityId) throws ServiceException {
		return getITBill(provinceId, cityId, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.MainService#getITBill(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<ITBill> getITBill(String provinceId, String cityId, String districtId) throws ServiceException {
		return getITBill(provinceId, cityId, districtId, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.MainService#getITBill(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ITBill> getITBill(String provinceId, String cityId, String districtId, String nameKeyword) throws ServiceException {
		Example<ITBillCriteria> e = Example.getExample(ITBillCriteria.class);
		ITBillCriteria c = e.createCriteria();
		c.andStatusNotEqualTo(0);
		c.andStatusNotEqualTo(9);
		c.andItProvinceIdEqualTo(provinceId);
		c.andItCityIdEqualTo(cityId);
		if (StringUtils.isNotEmpty(districtId)) {
			c.andItDistrictIdEqualTo(districtId);
		}
		if (StringUtils.isNotEmpty(nameKeyword)) {
			c.andStationNameLike("%" + nameKeyword + "%");
		}
		e.setOrderByClause(ITBill.STATUS + " DESC," + ITBill.IT_BILL_ID);
		return itBillMapper.selectByExample(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.MainService#getITBill(java.util.List,
	 * java.lang.String)
	 */
	@Override
	public List<ITBill> getITBill(List<String> districtId, String nameKeyword) throws ServiceException {
		Example<ITBillCriteria> e = Example.getExample(ITBillCriteria.class);
		ITBillCriteria c = e.createCriteria();
		c.andStatusNotEqualTo(0);
		c.andStatusNotEqualTo(9);
		c.andItDistrictIdIn(districtId);
		if (StringUtils.isNotEmpty(nameKeyword)) {
			c.andStationNameLike("%" + nameKeyword + "%");
		}
		e.setOrderByClause(ITBill.STATUS + " DESC," + ITBill.IT_BILL_ID);
		return itBillMapper.selectByExample(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.MainService#addGElecInfo(com.fuhj.itower.model.
	 * GElecInfo)
	 */
	@Override
	public void addGElecInfo(GElecInfo info) throws ServiceException {
		info.setgCode(getNextGElecInfoCode());
		gElecInfoMapper.insertSelective(info);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.MainService#addGElecUser(com.fuhj.itower.model.
	 * GElecUser)
	 */
	@Override
	public void addGElecUser(GElecUser user) throws ServiceException {
		user.setRegTime(new Date());
		user.setLoginPwd(SecurityUtil.password(user.getLoginPwd()));
		user.setStatus(1);
		gElecUserMapper.insertSelective(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.MainService#gelecLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public GElecUser gelecLogin(String loginName, String pwd) throws ServiceException {
		Example<GElecUserCriteria> e = Example.getExample(GElecUserCriteria.class);
		GElecUserCriteria c = e.createCriteria();
		c.andLoginNameEqualTo(loginName);
		c.andLoginPwdEqualTo(SecurityUtil.password(pwd));
		c.andStatusEqualTo(1);
		e.setOrderByClause("reg_time desc");
		List<GElecUser> list = gElecUserMapper.selectByExample(e);
		return list.size() > 0 ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.MainService#checkGelcLoginName(java.lang.String)
	 */
	@Override
	public boolean checkGelcLoginName(String loginName) throws ServiceException {
		Example<GElecUserCriteria> e = Example.getExample(GElecUserCriteria.class);
		GElecUserCriteria c = e.createCriteria();
		c.andLoginNameEqualTo(loginName);
		c.andStatusEqualTo(1);
		List<GElecUser> list = gElecUserMapper.selectByExample(e);
		return list.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGElecInfo(int, int)
	 */
	@Override
	public List<GElecInfo> getGElecInfo(int gelec_user_id, List<Integer> statusList) throws ServiceException {
		Example<GElecInfoCriteria> e = Example.getExample(GElecInfoCriteria.class);
		GElecInfoCriteria c = e.createCriteria();
		c.andCreatorIdEqualTo(gelec_user_id);
		c.andStatusIn(statusList);
		e.setOrderByClause(GElecInfo.CREATE_TIME + " DESC");
		return gElecInfoMapper.selectByExample(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGElecInfoInProgress(int)
	 */
	@Override
	public GElecInfo getGEIInProgress(int gelec_user_id) throws ServiceException {
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(2);
		List<GElecInfo> list = getGElecInfo(gelec_user_id, statusList);
		return list.size() > 0 ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getITBillById(int)
	 */
	@Override
	public ITBill getITBillById(int id) throws ServiceException {
		return itBillMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#updateGElecInfoEnd(com.fuhj.itower.
	 * model.GElecInfo)
	 */
	@Override
	public void updateGElecInfoEnd(GElecInfo info) throws ServiceException {
		gElecInfoMapper.updateByPrimaryKeySelective(info);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#updateGElecInfoCancel(int)
	 */
	@Override
	public void updateGElecInfoCancel(int gElecInfoId) throws ServiceException {
		List<DbField> fields = new ArrayList<DbField>();
		DbField field = new DbField(GElecInfo.STATUS, 9);
		fields.add(field);
		Example<GElecInfoCriteria> example = Example.getExample(GElecInfoCriteria.class);
		example.createCriteria().andGelecInfoIdEqualTo(gElecInfoId);
		gElecInfoMapper.updateFieldsByExample(fields, example);
	}

	private static final Object giLock = new Object();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getNextContractCode(com.fuhj.itower.
	 * model.GElecUser)
	 */
	@Override
	public String getNextGElecInfoCode() throws ServiceException {
		synchronized (giLock) {
			String typeCode = "E";
			Date now = new Date();
			Date beginTime = FormatUtil.getBeginTimeOfDay(now);
			Date endTime = FormatUtil.getEndTimeOfDay(now);

			Map<String, Object> paraMap = new HashMap<String, Object>();
			// paraMap.put("corpId", user.getCorpId());
			paraMap.put("beginTime", beginTime);
			paraMap.put("endTime", endTime);
			List<String> list = gElecInfoMapper.selectByCustom("customSelectMaxCode", paraMap);
			if (list.size() > 0) {
				String code = list.get(0);
				if (code.equals("") || code.length() < 7) {
					code = FormatUtil.getSDate(now) + "-" + typeCode + "0000";
				}
				String max = getNextCode(code, now, typeCode);
				return max;
			}
		}
		return null;
	}

	/**
	 * 组合代码yyMMdd-X1234
	 * 
	 * @param maxCode
	 * @param date
	 * @return
	 */
	private String getNextCode(String maxCode, Date date, String typeCode) {
		String code = FormatUtil.getSDate(date) + "-";
		if ("0".equals(maxCode)) {
			code += typeCode + FormatUtil.formatInteger(1);
		} else {
			String tmp = maxCode.substring(8);
			int next = FormatUtil.parseInteger(tmp) + 1;
			if (next > 9999) {
				throw new IllegalArgumentException("maxCode is too large: " + maxCode);
			}
			code += typeCode + FormatUtil.formatInteger(next);
		}
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGElecCount(int,
	 * java.util.List)
	 */
	@Override
	public int getGElecCount(int gelec_user_id, List<Integer> statusList) throws ServiceException {
		Example<GElecInfoCriteria> example = Example.getExample(GElecInfoCriteria.class);
		GElecInfoCriteria criteria = example.createCriteria();
		criteria.andCreatorIdEqualTo(gelec_user_id);
		criteria.andStatusIn(statusList);
		return gElecInfoMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getAllGElecInfo(java.util.List,
	 * com.fuhj.itower.model.GElecInfo)
	 */
	@Override
	public List<GElecInfo> getGElecInfo(List<String> districtId, GElecInfo queryArg) throws ServiceException {
		if ((districtId == null || districtId.size() > 0) && queryArg == null) {
			return null;
		}
		Example<GElecInfoCriteria> example = Example.getExample(GElecInfoCriteria.class);
		GElecInfoCriteria criteria = example.createCriteria();
		if (districtId != null && districtId.size() > 0) {
			criteria.andItDistrictIdIn(districtId);
		}

		if (queryArg != null) {
			if (queryArg.getStartTime() != null) {
				criteria.andStartTimeGreaterThanOrEqualTo(FormatUtil.getBeginTimeOfDay(queryArg.getStartTime()));
			}
			if (queryArg.getStatus() == -1) {
				criteria.andStatusNotEqualTo(0);
				criteria.andStatusNotEqualTo(9);

			} else {
				criteria.andStatusEqualTo(queryArg.getStatus());
				if (queryArg.getStatus() == 2) {
					if (queryArg.getEndTime() != null) {
						criteria.andStartTimeLessThanOrEqualTo(FormatUtil.getEndTimeOfDay(queryArg.getEndTime()));
					}
				} else {
					if (queryArg.getEndTime() != null) {
						criteria.andEndTimeLessThanOrEqualTo(FormatUtil.getEndTimeOfDay(queryArg.getEndTime()));
					}
				}
			}
		} else {
			criteria.andStatusNotEqualTo(0);
			criteria.andStatusNotEqualTo(9);
		}
		example.setOrderByClause(GElecInfo.CREATE_TIME + " DESC");
		return gElecInfoMapper.selectByExample(example);
	}

	@Override
	public void addITBill(ITBill bill) throws ServiceException {
		itBillMapper.insertSelective(bill);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGReportByProvince(java.lang.
	 * String)
	 */
	@Override
	public List<GenElecReportItem> getGReportByProvince(String itProvinceId, Date startDate, Date endDate) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("itProvinceId", itProvinceId);
		paraMap.put("startDate", FormatUtil.getBeginTimeOfDay(startDate));
		paraMap.put("endDate", FormatUtil.getEndTimeOfDay(endDate));
		return gElecInfoMapper.selectByCustom("customSelectGelecReport_p", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getGReportByCity(java.lang.String)
	 */
	@Override
	public List<GenElecReportItem> getGReportByCity(String itCityId, Date startDate, Date endDate) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("itCityId", itCityId);
		paraMap.put("startDate", FormatUtil.getBeginTimeOfDay(startDate));
		paraMap.put("endDate", FormatUtil.getEndTimeOfDay(endDate));
		return gElecInfoMapper.selectByCustom("customSelectGelecReport_c", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getGSummaryByProvince(java.lang.
	 * String)
	 */
	@Override
	public Summary getGSummaryByProvince(String itProvinceId) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		Date now = new Date();
		paraMap.put("itProvinceId", itProvinceId);
		paraMap.put("monthBegin", FormatUtil.getBeginTimeOfDay(FormatUtil.getFirstDayOfMonth(now)));
		paraMap.put("monthEND", FormatUtil.getEndTimeOfDay(FormatUtil.getLastDayOfMonth(now)));
		paraMap.put("todayBegin", FormatUtil.getBeginTimeOfDay(now));
		paraMap.put("todayEnd", FormatUtil.getEndTimeOfDay(now));
		return gElecInfoMapper.selectModelByCustom("customSelectSummary_p", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getGSummaryByCity(java.lang.String)
	 */
	@Override
	public Summary getGSummaryByCity(String itCityId) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		Date now = new Date();
		paraMap.put("itCityId", itCityId);
		paraMap.put("monthBegin", FormatUtil.getBeginTimeOfDay(FormatUtil.getFirstDayOfMonth(now)));
		paraMap.put("monthEND", FormatUtil.getEndTimeOfDay(FormatUtil.getLastDayOfMonth(now)));
		paraMap.put("todayBegin", FormatUtil.getBeginTimeOfDay(now));
		paraMap.put("todayEnd", FormatUtil.getEndTimeOfDay(now));
		return gElecInfoMapper.selectModelByCustom("customSelectSummary_c", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGElecUser(java.util.List,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<GElecUser> getGElecUserBydistrict(List<String> range, String loginName, String userName, String userPhone) throws ServiceException {
		Example<GElecUserCriteria> example = Example.getExample(GElecUserCriteria.class);
		GElecUserCriteria criteria = example.createCriteria();
		criteria.andItDistrictIdIn(range);
		if (StringUtils.isNotEmpty(loginName)) {
			criteria.andLoginNameEqualTo(loginName);
		}
		if (StringUtils.isNotEmpty(userName)) {
			criteria.andUserNameEqualTo(userName);
		}
		if (StringUtils.isNotEmpty(userPhone)) {
			criteria.andUserPhoneEqualTo(userPhone);
		}
		example.setOrderByClause(GElecUser.GELEC_USER_ID);
		return gElecUserMapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#getGElecUser(java.util.List)
	 */
	@Override
	public List<GElecUser> getGElecUserBydistrict(List<String> range) throws ServiceException {
		return getGElecUserBydistrict(range, null, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getGElecUserByProvince(java.lang.
	 * String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<GelecUserModel> getGElecUserByProvince(String itProvinceId, String loginName, String userName, String userPhone) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(itProvinceId)) {
			paraMap.put("itProvinceId", itProvinceId);
		}
		if (StringUtils.isNotEmpty(loginName)) {
			paraMap.put("loginName", loginName);
		}
		if (StringUtils.isNotEmpty(userName)) {
			paraMap.put("userName", userName);
		}
		if (StringUtils.isNotEmpty(userPhone)) {
			paraMap.put("userPhone", userPhone);
		}
		return gElecUserMapper.selectByCustom("customSelectGelecUser", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#getGElecUserByProvince(java.lang.
	 * String)
	 */
	@Override
	public List<GelecUserModel> getGElecUserByProvince(String itProvinceId) throws ServiceException {
		return getGElecUserByProvince(itProvinceId, null, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.itower.service.GelecService#updateLastLoginTime(int,
	 * java.util.Date)
	 */
	@Override
	public void updateLastLoginTime(int gelecUserId, Date time) throws ServiceException {
		Example<GElecUserCriteria> example = Example.getExample(GElecUserCriteria.class);
		GElecUserCriteria criteria = example.createCriteria();
		criteria.andGelecUserIdEqualTo(gelecUserId);
		List<DbField> fields = new ArrayList<DbField>();
		fields.add(new DbField(GElecUser.LAST_LOGIN_TIME, time));
		gElecUserMapper.updateFieldsByExample(fields, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fuhj.itower.service.GelecService#updateGelecUserPwd(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void updateGelecUserPwd(int gelecUserId, String newPwd) throws ServiceException {
		Example<GElecUserCriteria> example = Example.getExample(GElecUserCriteria.class);
		GElecUserCriteria criteria = example.createCriteria();
		criteria.andGelecUserIdEqualTo(gelecUserId);
		List<DbField> fields = new ArrayList<DbField>();
		fields.add(new DbField(GElecUser.LOGIN_PWD, SecurityUtil.password(newPwd)));
		gElecUserMapper.updateFieldsByExample(fields, example);
	}
}
