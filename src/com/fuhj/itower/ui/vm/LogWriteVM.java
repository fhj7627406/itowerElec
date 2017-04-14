/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.util.Date;

import lombok.Getter;

import org.zkforge.ckez.CKeditor;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;

import com.fuhj.itower.model.UpdateLog;
import com.fuhj.itower.service.LoginService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-6
 */
public class LogWriteVM {
	private Component view;
	private LoginService loginService;
	@Wire CKeditor ulogCKeditor;
	@Getter private UpdateLog latestLog;
	Users currentUser = WebAppUtil.getSessionUser();

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		loginService = SpringUtil.getBean(LoginService.class);
		latestLog = loginService.getLatestUpdateLog();
	}

	@Command public void save() {
		UpdateLog ulog = new UpdateLog();
		ulog.setSysuserId(currentUser.getId());
		ulog.setCreatetime(new Date());
		ulog.setStatus(1);
		ulog.setContent(ulogCKeditor.getValue());
		loginService.addUpdateLog(ulog);
		Messagebox.show("保存成功!", "成功", Messagebox.OK, Messagebox.INFORMATION);
	}
}
