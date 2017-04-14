/**
 * 
 */
package com.fuhj.itower.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Setter;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.dao.DbField;
import com.fuhj.itower.dao.Example;
import com.fuhj.itower.dao.GenericMapper;
import com.fuhj.itower.model.SysUser;
import com.fuhj.itower.model.SysUserCriteria;
import com.fuhj.itower.model.UpdateLog;
import com.fuhj.itower.service.LoginService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.util.SecurityUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2014-11-26
 */
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5073405202571123639L;
	@Setter private GenericMapper<SysUser> sysUserMapper;
	@Setter private GenericMapper<UpdateLog> updateLogMapper;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.gaogenet.singerEnroll.service.LoginService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override public SysUser login(String name, String pwd) throws ServiceException {
		Example<SysUserCriteria> e = Example.getExample(SysUserCriteria.class);
		SysUserCriteria c = e.createCriteria();
		c.andLoginnameEqualTo(name);
		c.andLoginpwdEqualTo(SecurityUtil.password(pwd));
		e.setOrderByClause("createtime desc");
		List<SysUser> list = sysUserMapper.selectByExample(e);
		return list.size() > 0 ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.gaogenet.singerEnroll.service.LoginService#modifyLoginIp(com.gaogenet
	 * .singerEnroll.model.Users, java.lang.String)
	 */
	@Override public void modifyLoginIp(Users user) throws ServiceException {
		SysUser u = new SysUser();
		u.setId(user.getId());
		u.setLastloginip(user.getLastloginip());
		u.setLastlogintime(new Date());
		u.setStatus(user.getStatus());
		u.setLevel(user.getLevel());
		sysUserMapper.updateByPrimaryKeySelective(u);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.fuhj.itower.service.LoginService#modyfyUserPerm(java.lang.String)
	 */
	@Override public void modifyUserPerm(int id, String perm) throws ServiceException {
		Example<SysUserCriteria> example = Example.getExample(SysUserCriteria.class);
		example.createCriteria().andIdEqualTo(id);
		List<DbField> fList = new ArrayList<DbField>();
		fList.add(new DbField(SysUser.PERM, perm));
		sysUserMapper.updateFieldsByExample(fList, example);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.fuhj.itower.service.LoginService#saveUpdateLog(com.fuhj.itower.model
	 * .UpdateLog)
	 */
	@Override public void addUpdateLog(UpdateLog model) throws ServiceException {
		updateLogMapper.insertSelective(model);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LoginService#getLatestUpdateLog()
	 */
	@Override public UpdateLog getLatestUpdateLog() throws ServiceException {
		return updateLogMapper.selectModelByCustom("selectLatestLogByCustom", null);
	}
}
