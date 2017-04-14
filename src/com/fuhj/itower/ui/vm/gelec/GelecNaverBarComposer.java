/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.util.ArrayList;

import org.zkoss.bind.GlobalCommandEvent;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.ui.select.annotation.Subscribe;
import org.zkoss.zul.A;
import org.zkoss.zul.Label;
import org.zkoss.zul.Popup;

import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.service.GelecService;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-12-4
 */
public class GelecNaverBarComposer extends SelectorComposer<Component> {
	private GelecService gelecService;
	private GElecUser current_gelec_user;
	@Wire A pHeaderTxt;
	@Wire Label ingLbl, doneLbl, allLbl, noticeLbl;
	@Wire Popup notiepp;
	private static final long serialVersionUID = 1L;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		gelecService = SpringUtil.getBean(GelecService.class);
		Object obj = WebAppUtil.getWebSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY);
		if (obj != null) {
			current_gelec_user = (GElecUser) obj;
			summaryInit();
		}
	}

	@Listen("onClick=#logoutBtn") public void logout() {
		if (Messagebox.OK == Messagebox.show("确认注销当前登录账户？", "注销登录", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, Messagebox.OK)) {
			WebAppUtil.removeWebSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY);
			WebAppUtil.saveCookie(GElecLoginVM.LOCAL_LOGINNAME, "", 0);
			WebAppUtil.saveCookie(GElecLoginVM.LOCAL_LOGINPWD, "", 0);
			Executions.sendRedirect("gelogin.zul");
		}
	}

	@Listen("onClick=#ahome") public void gohome() {
		WebAppUtil.getElecIncludePage().setSrc("geindex.zul");
	}

	@Listen("onClick=#ingPBtn") public void ingPBtnClick() {
		WebAppUtil.getElecIncludePage().setSrc("gelist.zul");
		Component tabbox = WebAppUtil.getElecIncludePage().getFellow("listTabox");
		if (tabbox != null) {
			Events.postEvent(new Event(Events.ON_PIGGYBACK, tabbox, "ing"));
		}
	}

	@Listen("onClick=#donePBtn") public void donePBtnClick() {
		WebAppUtil.getElecIncludePage().setSrc("gelist.zul");
		Component tabbox = WebAppUtil.getElecIncludePage().getFellow("listTabox");
		if (tabbox != null) {
			Events.postEvent(new Event(Events.ON_PIGGYBACK, tabbox, "done"));
		}
	}

	@Listen("onClick=#allPBtn") public void allPBtnClick() {
		WebAppUtil.getElecIncludePage().setSrc("gelist.zul");
		Component tabbox = WebAppUtil.getElecIncludePage().getFellow("listTabox");
		if (tabbox != null) {
			Events.postEvent(new Event(Events.ON_PIGGYBACK, tabbox, "all"));
		}
	}

	@Subscribe("myqueue") public void callSummaryInit(Event evt) {
		if (evt instanceof GlobalCommandEvent) {
			if ("callSummaryInit".equals(((GlobalCommandEvent) evt).getCommand())) {
				summaryInit();
			}
		}
	}

	public void summaryInit() {
		@SuppressWarnings("serial") int ingCount = gelecService.getGElecCount(current_gelec_user.getGelecUserId(), new ArrayList<Integer>() {
			{
				add(2);
			}
		});
		@SuppressWarnings("serial") int doneCount = gelecService.getGElecCount(current_gelec_user.getGelecUserId(), new ArrayList<Integer>() {
			{
				add(1);
			}
		});
		if (ingCount > 0) {
			noticeLbl.setValue(String.valueOf(ingCount));
			pHeaderTxt.setLabel(" " + ingCount + "条发电任务待完成");

		} else {
			noticeLbl.setValue("");
			pHeaderTxt.setLabel(" 我的发电任务");
		}
		ingLbl.setValue(String.valueOf(ingCount));
		doneLbl.setValue(String.valueOf(doneCount));
		allLbl.setValue(String.valueOf(ingCount + doneCount));
	}
}
