/**
 * 
 */
package com.fuhj.itower.ui.vm;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.ui.model.GelecUserModel;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2017-3-8
 */
public class ResetGelecUserPwdVM {
	private Component view;
	private GelecService gelecService;
	@Getter
	@Setter
	private GelecUserModel gelecUser;
	@Wire
	private Textbox pwdtxt1, pwdtxt2;

	@Init
	public void init() {
		gelecService = SpringUtil.getBean(GelecService.class);
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		setGelecUser((GelecUserModel) Executions.getCurrent().getArg().get("gElecUser"));
	}

	@Command
	public void submit() {
		if (check()) {
			if (Messagebox.OK == Messagebox.show("确认重设用户" + gelecUser.getLoginName() + "登录密码?重设成功后请务必通知使用者.", "操作确认", Messagebox.OK
					| Messagebox.CANCEL, Messagebox.QUESTION, Messagebox.OK)) {
				gelecService.updateGelecUserPwd(gelecUser.getGelecUserId(), pwdtxt1.getRawText());
				Messagebox.show("重设密码成功!", "成功", Messagebox.OK, Messagebox.INFORMATION);
				view.detach();
			}
		}
	}

	public boolean check() {
		String pwd1 = pwdtxt1.getRawText();
		String pwd2 = pwdtxt2.getRawText();
		if (StringUtils.isEmpty(pwd1) || StringUtils.isEmpty(pwd2)) {
			Messagebox.show("密码不能为空!", "提示", Messagebox.OK, Messagebox.INFORMATION);
			return false;
		}
		if (pwd1.length() < 6 || pwd2.length() < 6) {
			Messagebox.show("密码必须大于6位!", "提示", Messagebox.OK, Messagebox.INFORMATION);
			return false;
		}
		if (!pwd1.equals(pwd2)) {
			Messagebox.show("两次密码输入不一致!", "提示", Messagebox.OK, Messagebox.INFORMATION);
			return false;
		}
		return true;
	}
}
