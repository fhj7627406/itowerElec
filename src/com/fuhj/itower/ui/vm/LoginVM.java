package com.fuhj.itower.ui.vm;



import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Captcha;

import com.fuhj.itower.model.SysUser;
import com.fuhj.itower.service.LoginService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.log.AppLogger;
import com.fuhj.util.SecurityUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2014-11-27
 */

public class LoginVM extends AbstractValidator {
	private ValidationContext vcx;
	private Users user = new Users();
	private LoginService loginService;

	@Wire Captcha captcha;

	@Init(superclass = true) public void init() {
		loginService = SpringUtil.getBean(LoginService.class);
	}

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireEventListeners(view, this);
		Selectors.wireComponents(view, this, false);

		if (SecurityUtil.IS_DEBUG) {
			user.setLoginname("admin");
			user.setLoginpwd("fUhg@888");
			user.setTempStr(captcha.getValue());
		}
	}

	@Command public void login() {
		SysUser u = loginService.login(user.getLoginname(), user.getLoginpwd());
		if (u != null) {
			if (u.getStatus() == 0) {
				addInvalidMessage(vcx, "key", "账户已停用!");
				captcha.randomValue();
			} else {
				Clients.showBusy("登陆中...");
				AppLogger.sysDebug("WebAppUtil.getIpAddress():" + WebAppUtil.getIpAddress());
				Users user = new Users(u);
				user.setLastloginip(WebAppUtil.getIpAddress());
				SecurityUtil.login(user);
				loginService.modifyLoginIp(user);
				Executions.getCurrent().sendRedirect("main.zul");
			}
		} else {
			addInvalidMessage(vcx, "key", "用户名/密码错误!");
			captcha.randomValue();
		}
	}

	/**
	 * @return the infoList
	 */
	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	@Listen("onClick = #captcha") public void changeCaptchaValue() {
		captcha.randomValue();
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.bind.Validator#validate(org.zkoss.bind.ValidationContext)
	 */
	@Override public void validate(ValidationContext ctx) {
		this.vcx = ctx;
		Object loginname = null, loginpwd = null, captchaStr = null;
		try {
			loginname = ctx.getProperties("loginname")[0].getValue();
			loginpwd = ctx.getProperties("loginpwd")[0].getValue();
			captchaStr = ctx.getProperties("tempStr")[0].getValue();
		} catch (NullPointerException e) {
			user.setLoginname("");
			user.setLoginpwd("");
			user.setTempStr("");
		}

		loginname = loginname != null ? loginname.toString() : "";
		if (StringUtils.isEmpty(loginname.toString())) {
			addInvalidMessage(ctx, "key", "用户名不能为空");
		}

		loginpwd = loginpwd != null ? loginpwd.toString() : "";
		if (StringUtils.isEmpty(loginpwd.toString())) {
			addInvalidMessage(ctx, "key", "登录密码不能为空");
		}

		captchaStr = captchaStr != null ? captchaStr.toString() : "";
		if (StringUtils.isEmpty(captchaStr.toString())) {
			addInvalidMessage(ctx, "key", "验证码不能为空");
		}
		String captchaStr_comp = captcha.getValue().toLowerCase();
		if (!captchaStr_comp.equals(captchaStr.toString().toLowerCase())) {
			addInvalidMessage(ctx, "key", "验证码错误");
		}
	}
}