/**
 * 
 */
package com.fuhj.itower.service;

import java.util.Date;
import java.util.List;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.AlarmQueryLog;
import com.fuhj.itower.model.BotChatLog;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.model.AlarmHisQueryParam;
import com.fuhj.itower.ui.model.AlarmHistoryModel;
import com.fuhj.itower.ui.model.AlarmModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-19
 */
public interface MainService extends AbstractService {
	void addAlarmQueryLog(AlarmQueryLog log) throws ServiceException;

	int getAlarmHisCount(AlarmHisQueryParam param) throws ServiceException;

	List<AlarmHistoryModel> getAlarmHistorys(AlarmHisQueryParam param, int index, int pageSize) throws ServiceException;

	AlarmQueryLog createQueryLog(Users currentUser, List<AlarmModel> list, Date queryBegin, String range) throws ServiceException;

	AlarmQueryLog createQueryLog(Users currentUser, List<AlarmModel> list, Date queryBegin) throws ServiceException;

	AlarmQueryLog createQueryLog(List<AlarmModel> list, Date queryBegin, String range) throws ServiceException;

	void addBotChatLog(BotChatLog log) throws ServiceException;

	List<BotChatLog> getBotChatLog(String userid, Date date) throws ServiceException;

}
