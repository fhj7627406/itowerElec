package com.fuhj.itower.service;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.SysUser;
import com.fuhj.itower.model.UpdateLog;
import com.fuhj.itower.service.model.Users;

/**
 * @Description: TODO
 * @author fu
 * @date 2014-11-26
 */
public interface LoginService extends AbstractService {

	SysUser login(String name, String pwd) throws ServiceException;

	void modifyLoginIp(Users user) throws ServiceException;

	void modifyUserPerm(int id, String perm) throws ServiceException;

	void addUpdateLog(UpdateLog model) throws ServiceException;

	UpdateLog getLatestUpdateLog() throws ServiceException;
}
