/**
 * 
 */
package com.fuhj.itower.ui.vm;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;

import com.fuhj.itower.service.model.Users;
import com.fuhj.util.SecurityUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author thinkpad
 * @date 2014-12-23
 */
public class MenubarVM {
	@Wire Menuitem setItem;
	private Users user;

	@Init(superclass = true) public void init() {
		user = WebAppUtil.getSessionUser();
	}

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		// setItem.setVisible(user.getLevel() == 1);
	}

	@Command public void logout() {
		if (Messagebox.OK == Messagebox.show("确认注销当前登录账户？", "注销登录", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, Messagebox.OK)) {
			SecurityUtil.logout(WebAppUtil.getSessionUser(), true);
		}
	}

	@Command public void userManage() {
		// WebAppUtil.getIncludePage().setSrc("content/userManage.zul");
	}
}
