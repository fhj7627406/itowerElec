/**
 * 
 */
package com.fuhj.itower.ui.vm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ConfigReader;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-20
 */
public class ITowerLoginWin extends SelectorComposer<Component> {
	@Wire Window itloginwindow;
	// @Wire Textbox itloginName;
	// @Wire Textbox pwdtxt;
	@Wire Textbox itocr;
	private String cookie;
	private ItowerImpl itower = new ItowerImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -243640078938683295L;

	@Override public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String cookie = (String) Executions.getCurrent().getArg().get("cookie");
		this.cookie = cookie;
	}

	@Listen("onClick=#submit") public void submit(Event event) {
		// final String a = itloginName.getValue();
		// final String b = pwdtxt.getValue();
		final String a = ConfigReader.getProperty("ITOWER_USER");
		final String b = ConfigReader.getProperty("ITOWER_PWD");
		AppLogger.sysDebug("loginName:" + a + " pwd:" + b);
		final String c = itocr.getValue();
		try {
			itower.loginITower(a, b, c, cookie);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		itloginwindow.detach();
	}
}
