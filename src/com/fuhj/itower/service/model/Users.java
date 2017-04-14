package com.fuhj.itower.service.model;

import javax.servlet.http.HttpSession;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fuhj.itower.model.SysUser;

@Data @EqualsAndHashCode(callSuper = false) @NoArgsConstructor public class Users extends SysUser {
	private HttpSession httpSession;
	private String loginTime;

	public Users(SysUser s) {
		setLoginname(s.getLoginname());
		setLoginpwd(s.getLoginpwd());
		setId(s.getId());
		setCreatetime(s.getCreatetime());
		setLastloginip(s.getLastloginip());
		setLastlogintime(s.getLastlogintime());
		setPerm(s.getPerm());
		setStatus(s.getStatus());
		setRemark(s.getRemark());
		setUsername(s.getUsername());
		setLevel(s.getLevel());
	}
}
