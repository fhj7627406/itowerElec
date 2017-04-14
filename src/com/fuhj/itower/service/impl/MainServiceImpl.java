/**
 * 
 */
package com.fuhj.itower.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.dao.Example;
import com.fuhj.itower.dao.GenericMapper;
import com.fuhj.itower.model.AlarmHistory;
import com.fuhj.itower.model.AlarmHistoryCriteria;
import com.fuhj.itower.model.AlarmQueryLog;
import com.fuhj.itower.model.BotChatLog;
import com.fuhj.itower.model.BotChatLogCriteria;
import com.fuhj.itower.service.MainService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.model.AlarmHisQueryParam;
import com.fuhj.itower.ui.model.AlarmHistoryModel;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.util.FormatUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-19
 */
public class MainServiceImpl extends AbstractServiceImpl implements MainService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5976535966549309238L;
	@Setter private GenericMapper<AlarmHistory> alarmHistoryMapper;
	@Setter private GenericMapper<AlarmQueryLog> alarmQueryLogMapper;
	@Setter private GenericMapper<BotChatLog> botChatLogMapper;
	

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addAlarmQueryLog(com.fuhj.itower. model.AlarmQueryLog, com.fuhj.itower.ui.model.AlarmModel)
	 */
	@Override public void addAlarmQueryLog(AlarmQueryLog log) throws ServiceException {
		alarmQueryLogMapper.insertSelective(log);
		if (log.getTempObject() != null) {
			List<AlarmModel> list = (List<AlarmModel>) log.getTempObject();
			for (AlarmModel model : list) {
				AlarmHistory ah = new AlarmHistory();
				BeanUtils.copyProperties(model, ah);
				if (model.getSas() != null) {
					ah.setCharge(model.getSas().getAgstaffname());
					ah.setChargephone(model.getSas().getAgstafftel());
				}
				ah.setLogId(log.getLogId());
				ah.setAlarmType(1);
				ah.setStatus(1);
				alarmHistoryMapper.insertSelective(ah);
			}
		}
	}

	public AlarmQueryLog createQueryLog(Users currentUser, List<AlarmModel> list, Date queryBegin, String range) throws ServiceException {
		Date queryEnd = new Date();
		long temp = queryEnd.getTime() - queryBegin.getTime();
		int timetaking = (int) temp / 1000;
		AlarmQueryLog log = new AlarmQueryLog();
		log.setTimetaking(timetaking);
		if (currentUser != null) {
			log.setUserid(currentUser.getId());
			log.setRange(currentUser.getPerm());
		} else {
			log.setRange(range);
		}
		log.setQuerytime(queryBegin);
		log.setReturncode(1);
		log.setReturncount(list.size());
		log.setTempObject(list);
		return log;
	}

	public AlarmQueryLog createQueryLog(Users currentUser, List<AlarmModel> list, Date queryBegin) throws ServiceException {
		return createQueryLog(currentUser, list, queryBegin, "");
	}

	public AlarmQueryLog createQueryLog(List<AlarmModel> list, Date queryBegin, String range) throws ServiceException {
		return createQueryLog(null, list, queryBegin, range);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getAlarmHisCount(com.fuhj.itower. ui.model.AlarmHisQueryParam)
	 */
	@Override public int getAlarmHisCount(AlarmHisQueryParam param) throws ServiceException {
		Example<AlarmHistoryCriteria> example = Example.getExample(AlarmHistoryCriteria.class);
		AlarmHistoryCriteria c = example.createCriteria();
		if (param != null) {
			if (StringUtils.isNotEmpty(param.getTroubleno())) {
				c.andTroublenoEqualTo(param.getTroubleno());
			}
			if (StringUtils.isNotEmpty(param.getStationName())) {
				c.andStationnameEqualTo(param.getStationName());
			}
		}
		return alarmHistoryMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getAlarmHistorys(com.fuhj.itower. ui.model.AlarmHisQueryParam, int, int)
	 */
	@Override public List<AlarmHistoryModel> getAlarmHistorys(AlarmHisQueryParam param, int index, int pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("offset", index);
		paramMap.put("limit", pageSize);
		if (param != null) {
			if (StringUtils.isNotEmpty(param.getTroubleno())) {
				paramMap.put("troubleno", param.getTroubleno());
			}
			if (StringUtils.isNotEmpty(param.getStationName())) {
				paramMap.put("stationName", param.getStationName());
			}
		}
		return alarmHistoryMapper.selectByCustom("selectAlarmHisByCustom", paramMap);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addBotChatLog(com.fuhj.itower.model.BotChatLog)
	 */
	@Override public void addBotChatLog(BotChatLog log) throws ServiceException {
		botChatLogMapper.insertSelective(log);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getBotChatLog(java.lang.String, java.util.Date)
	 */
	@Override public List<BotChatLog> getBotChatLog(String userid, Date date) throws ServiceException {
		Example<BotChatLogCriteria> e = Example.getExample(BotChatLogCriteria.class);
		BotChatLogCriteria c = e.createCriteria();
		c.andFromuserEqualTo(userid);
		c.andTouserEqualTo(userid);
		c.andLogtimeBetween(FormatUtil.getBeginTimeOfDay(date), FormatUtil.getEndTimeOfDay(date));
		return botChatLogMapper.selectByExample(e);
	}
}
