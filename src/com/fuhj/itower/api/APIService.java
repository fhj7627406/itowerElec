/**
 * 
 */
package com.fuhj.itower.api;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.service.AbstractService;
import com.fuhj.itower.service.model.AlarmJson;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-18
 */
public interface APIService extends AbstractService {

	AlarmJson queryPFAlarm(String atype, String range, String slave) throws ServiceException;
}
