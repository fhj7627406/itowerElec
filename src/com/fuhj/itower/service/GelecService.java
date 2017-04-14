/**
 * 
 */
package com.fuhj.itower.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.ui.model.GelecUserModel;
import com.fuhj.itower.ui.model.GenElecReportItem;
import com.fuhj.itower.ui.model.Summary;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-27
 */
public interface GelecService extends AbstractService {
	void addITBill(ITBill bill) throws ServiceException;

	void addITBills(List<ITBill> list) throws ServiceException;

	void addITBillsByXLS(String itProvinceId, String itCityId, HSSFWorkbook wb) throws ServiceException;

	void deleteITBillByArea(String itProvinceId, String itCityId) throws ServiceException;

	List<ITBill> getITBill(String provinceId, String cityId) throws ServiceException;

	List<ITBill> getITBill(String provinceId, String cityId, String districtId) throws ServiceException;

	List<ITBill> getITBill(String provinceId, String cityId, String districtId, String nameKeyword) throws ServiceException;

	List<ITBill> getITBill(List<String> districtId, String nameKeyword) throws ServiceException;

	ITBill getITBillById(int id) throws ServiceException;

	void addGElecInfo(GElecInfo info) throws ServiceException;

	void updateGElecInfoEnd(GElecInfo info) throws ServiceException;

	void updateGElecInfoCancel(int gElecInfoId) throws ServiceException;

	List<GElecInfo> getGElecInfo(List<String> districtId, GElecInfo queryArg) throws ServiceException;

	List<GElecInfo> getGElecInfo(int gelec_user_id, List<Integer> statusList) throws ServiceException;

	int getGElecCount(int gelec_user_id, List<Integer> statusList) throws ServiceException;

	GElecInfo getGEIInProgress(int gelec_user_id) throws ServiceException;;

	void addGElecUser(GElecUser user) throws ServiceException;

	GElecUser gelecLogin(String loginName, String pwd) throws ServiceException;

	void updateLastLoginTime(int gelecUserId, Date time) throws ServiceException;

	boolean checkGelcLoginName(String loginName) throws ServiceException;

	String getNextGElecInfoCode() throws ServiceException;

	List<GenElecReportItem> getGReportByProvince(String itProvinceId, Date startDate, Date endDate) throws ServiceException;

	List<GenElecReportItem> getGReportByCity(String itCityId, Date startDate, Date endDate) throws ServiceException;

	Summary getGSummaryByProvince(String itProvinceId) throws ServiceException;

	Summary getGSummaryByCity(String itCityId) throws ServiceException;

	List<GElecUser> getGElecUserBydistrict(List<String> range, String loginName, String userName, String userPhone) throws ServiceException;

	List<GElecUser> getGElecUserBydistrict(List<String> range) throws ServiceException;

	List<GelecUserModel> getGElecUserByProvince(String itProvinceId, String loginName, String userName, String userPhone) throws ServiceException;

	List<GelecUserModel> getGElecUserByProvince(String itProvinceId) throws ServiceException;

	void updateGelecUserPwd(int gelecUserId, String newPwd) throws ServiceException;
}
