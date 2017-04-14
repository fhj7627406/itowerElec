/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.service.GelecService;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-27
 */
public class GElecLoginVM extends AbstractValidator {
	public static final String LOCAL_LOGINNAME = "local_loginName";
	public static final String LOCAL_LOGINPWD = "local_loginPwd";
	public static final int COOKIE_MAXAGE = 60 * 60 * 24 * 30;
	private ValidationContext vcx;
	private GelecService gelecService;
	@Wire
	private Button loginBtn;
	@Getter
	@Setter
	private GElecUser loginUser = new GElecUser();

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		gelecService = SpringUtil.getBean(GelecService.class);
		HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			String local_loginName = "";
			String local_loginPwd = "";
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(LOCAL_LOGINNAME)) {
					local_loginName = cookies[i].getValue();
				} else if (cookies[i].getName().equals(LOCAL_LOGINPWD)) {
					local_loginPwd = cookies[i].getValue();
				}
			}
			if (StringUtils.isNotEmpty(local_loginName) && StringUtils.isNotEmpty(local_loginPwd)) {
				loginUser.setLoginName(local_loginName);
				loginUser.setLoginPwd(local_loginPwd);
				Events.postEvent(-1, new Event(Events.ON_CLICK, loginBtn));
			}
		}
	}

	@Command
	public void submit() {
		String loginName = loginUser.getLoginName();
		String loginPwd = loginUser.getLoginPwd();
		GElecUser userdb = gelecService.gelecLogin(loginName, loginPwd);
		if (userdb != null) {
			setLoginUser(userdb);
			gelecService.updateLastLoginTime(userdb.getGelecUserId(), new Date());
			WebAppUtil.setHttpSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY, userdb);
			saveCookie(LOCAL_LOGINNAME, loginName);
			saveCookie(LOCAL_LOGINPWD, loginPwd);
			Executions.sendRedirect("gemain.zul");
		} else {
			addInvalidMessage(vcx, "key", "用户名/密码错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.bind.Validator#validate(org.zkoss.bind.ValidationContext)
	 */
	@Override
	public void validate(ValidationContext ctx) {
		this.vcx = ctx;
		Map<String, Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
		try {
			String loginName = beanProps.get("loginName").getValue().toString().trim();
			if (loginName.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写用户名");
		}
		try {
			String loginPwd = beanProps.get("loginPwd").getValue().toString().trim();
			if (loginPwd.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写登录密码");
		}
	}

	public void saveCookie(String name, String value) {
		WebAppUtil.saveCookie(name, value, COOKIE_MAXAGE);
	}
}
