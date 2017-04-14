package com.fuhj.itower.ui;

import java.util.Date;

import lombok.Getter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

import com.fuhj.itower.service.model.Users;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.WebAppUtil;

public class SidebarComposer extends SelectorComposer<Component> {
	@Wire
	Navbar navbar;
	@Wire
	Div sidebar;
	@Wire
	A toggler, timeLbl;
	@Wire
	Nav nav1, nav2, nav3;
	@Wire
	Navitem wxbotNav;
	/**
	 * 
	 */
	@Getter
	private Users loginUser;
	private static final long serialVersionUID = 1L;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Date now = new Date();
		timeLbl.setLabel(FormatUtil.getCDate(now) + "  " + FormatUtil.getWeekday(now));

		loginUser = WebAppUtil.getSessionUser();
		if (loginUser.getLevel() <= 1) {
			// nav3.setBadgeText("3");
			nav3.getFellow("accountSettingNav").setVisible(false);
		}

		if (loginUser.getLevel() <= 3) {
			wxbotNav.setVisible(false);
		}
	}

	// Toggle sidebar to collapse or expand
	@Listen("onClick = #toggler")
	public void toggleSidebarCollapsed() {
		if (navbar.isCollapsed()) {
			sidebar.setSclass("sidebar");
			navbar.setCollapsed(false);
			toggler.setIconSclass("z-icon-angle-double-left");
		} else {
			sidebar.setSclass("sidebar sidebar-min");
			navbar.setCollapsed(true);
			toggler.setIconSclass("z-icon-angle-double-right");
		}
		// Force the hlayout contains sidebar to recalculate its size
		Clients.resize(sidebar.getRoot().query("#main"));
	}

	@Listen("onClick = navitem")
	public void navitemOnclick(Event e) {
		Label lbl = (Label) Executions.getCurrent().getDesktop().getPage("mainPage").getFellow("breadcrumblbl");
		Navitem navitem = (Navitem) e.getTarget();
		IncludeDiv include = WebAppUtil.getIncludePage();
		String id = navitem.getId();
		if ("mainNav".equals(id)) {
			// include.setSrc("icon.zul");
		} else if ("staManageNav".equals(id)) {
			include.setSrc("stamanage.zul");
		} else if ("tdMonitorNav".equals(id)) {
			include.setSrc("tdmonitor.zul");
		} else if ("accountSettingNav".equals(id)) {
			include.setSrc("perm.zul");
		} else if ("updateLogNav".equals(id)) {
			include.setSrc("updateLog.zul");
		} else if ("wxbotNav".equals(id)) {
			include.setSrc("weixinbot.zul");
		} else if ("zbzConfigNav".equals(id)) {
			include.setSrc("zbzConfig.zul");
		} else if ("gElecQueryNav".equals(id)) {
			include.setSrc("gElecQuery.zul");
		} else if ("gElecInfoNav".equals(id)) {
			include.setSrc("gElecInfo.zul");
		} else if ("gElecUserNav".equals(id)) {
			include.setSrc("gElecUser.zul");
		} else if ("gElecInfoReportNav".equals(id)) {
			include.setSrc("gElecInfoReport.zul");
		}
		Component c = navitem.getParent();
		if (c instanceof Nav) {
			Nav nav = (Nav) c;
			lbl.setValue(nav.getLabel());
		} else {
			lbl.setValue("");
		}
	}
}