/**
 * 
 */
package com.fuhj.weixin;

import java.awt.image.BufferedImage;
import java.util.Date;

import com.fuhj.exception.ServiceException;
import com.fuhj.weixin.json.MessageJson;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-25
 */
public interface IUICallBack {
	void received(MessageJson received, String displayName, String content, Date time) throws ServiceException;

	void sent(MessageJson msg, String reply, Date time) throws ServiceException;

	void sent(MessageJson msg, BufferedImage reply, Date time) throws ServiceException;

	void loginCompleted() throws ServiceException;

	void initCompleted() throws ServiceException;
}
