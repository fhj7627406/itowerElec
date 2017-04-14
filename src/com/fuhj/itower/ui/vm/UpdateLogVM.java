/**
 * 
 */
package com.fuhj.itower.ui.vm;

import lombok.Getter;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

import com.fuhj.itower.model.UpdateLog;
import com.fuhj.itower.service.LoginService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-31
 */
public class UpdateLogVM {
	private Component view;
	private LoginService loginService;
	@Wire Button updateBtn;
	@Getter Users currentUser = WebAppUtil.getSessionUser();
	@Getter private UpdateLog latestLog;

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		loginService = SpringUtil.getBean(LoginService.class);
		latestLog = loginService.getLatestUpdateLog();
		if (currentUser.getLevel() == 9) {
			updateBtn.setVisible(true);
		}
	}

	@Command public void update() {
		Window w = (Window) Executions.createComponents("logWrite.zul", view, null);
		w.setPosition("center");
		w.doModal();
	}
}
