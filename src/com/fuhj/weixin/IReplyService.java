/**
 * 
 */
package com.fuhj.weixin;

import com.fuhj.exception.ServiceException;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-25
 */
public interface IReplyService {
	String localService(String content, String fromId, int type) throws ServiceException;

	String aiService(String content, String fromId) throws ServiceException;

	String otherService(String content, String fromId) throws ServiceException;

	String help() throws ServiceException;

	String invalidService() throws ServiceException;
}
