package com.fuhj.itower.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Menu;

import com.fuhj.util.SecurityUtil;
import com.fuhj.util.WebAppUtil;

public class NavbarComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113200125628739421L;
//	@Wire private A atask, anoti, amsg;
	@Wire private Menu userMenu;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		userMenu.setLabel(" Welcome , " + WebAppUtil.getSessionUser().getLoginname());
	}

//	@Listen("onOpen = #taskpp") public void toggleTaskPopup(OpenEvent event) {
//		toggleOpenClass(event.isOpen(), atask);
//	}
//
//	@Listen("onOpen = #notipp") public void toggleNotiPopup(OpenEvent event) {
//		toggleOpenClass(event.isOpen(), anoti);
//	}
//
//	@Listen("onOpen = #msgpp") public void toggleMsgPopup(OpenEvent event) {
//		toggleOpenClass(event.isOpen(), amsg);
//	}

	@Listen("onClick=#logoutItem") public void logout() {
		SecurityUtil.logout(WebAppUtil.getSessionUser(), true);
	}

	// Toggle open class to the component
//	public void toggleOpenClass(Boolean open, Component component) {
//		HtmlBasedComponent comp = (HtmlBasedComponent) component;
//		String scls = comp.getSclass();
//		if (open) {
//			comp.setSclass(scls + " open");
//		} else {
//			comp.setSclass(scls.replace(" open", ""));
//		}
//	}
}
