package com.fuhj.util;

import java.io.Serializable;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.fuhj.itower.fliter.SecurityFilter;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.IncludeDiv;

public class WebAppUtil implements Serializable {
	private static final long serialVersionUID = 2415268553769076841L;
	public static final String USER_SESSION_KEY = "CURRENT_USER_KEY";
	public static final String SEC_SESSION_KEY = "SEC_SESSION_KEY";
	public static final String GELEC_USER_SESSION_KEY = "CURRENT_GELEC_USER_KEY";

	/**
	 * 取ZK Session中当前用户对象
	 * 
	 * @return 当前用户对象
	 */
	public static Users getSessionUser() {
		return (Users) getWebSessionAttribute(USER_SESSION_KEY);
	}

	/**
	 * 设置ZK Session属性名称/值
	 * 
	 * @param name
	 * @param value
	 */
	public static void setWebSessionAttribute(String name, Object value) {
		Session session = Sessions.getCurrent();
		if (session != null) {
			session.setAttribute(name, value);
		}
	}

	/**
	 * 取ZK Session属性值
	 * 
	 * @param name
	 * @return
	 */
	public static Object getWebSessionAttribute(String name) {
		Session session = Sessions.getCurrent();
		if (session != null) {
			return session.getAttribute(name);
		}
		return null;
	}

	/**
	 * 移除ZK Session属性值
	 * 
	 * @param name
	 */
	public static Object removeWebSessionAttribute(String name) {
		Session session = Sessions.getCurrent();
		if (session != null) {
			return session.removeAttribute(name);
		}
		return null;
	}

	/**
	 * 设置HttpSession属性名称/值
	 * 
	 * @param name
	 * @param value
	 */
	public static void setHttpSessionAttribute(String name, Object value) {
		HttpSession session = getHttpSession();
		session.setAttribute(name, value);
	}

	/**
	 * 取HttpSession属性值
	 * 
	 * @param name
	 * @return
	 */
	public static Object getHttpSessionAttribute(String name) {
		HttpSession session = getHttpSession();
		return session.getAttribute(name);
	}

	/**
	 * 移除HttpSession属性值
	 * 
	 * @param name
	 */
	public static Object removeHttpSessionAttribute(String name) {
		HttpSession session = getHttpSession();
		Object obj = session.getAttribute(name);
		session.removeAttribute(name);
		return obj;
	}

	/**
	 * 显示ZK Session所有属性
	 */
	public static void showWebSessionAllAttribute() {
		Session session = Sessions.getCurrent();
		if (session != null) {
			Set<String> keys = session.getAttributes().keySet();
			System.out.println("session attributes: ");
			for (String key : keys) {
				System.out.println(key + ": " + getWebSessionAttribute(key));
			}
		}
	}

	/**
	 * 移除ZK Session中所有属性值
	 * 
	 * @param name
	 */
	public static void removeWebSessionAllAttribute() {
		Session session = Sessions.getCurrent();
		if (session != null) {
			Set<String> keys = session.getAttributes().keySet();
			for (String key : keys) {
				session.removeAttribute(key);
			}
		}
	}

	/**
	 * 取当前HttpSession对象
	 * 
	 * @return
	 */
	public static HttpSession getHttpSession() {
		HttpSession httpSession = null;
		Session zkSession = Sessions.getCurrent();
		if (zkSession != null) {
			httpSession = ((HttpSession) zkSession.getNativeSession());
		}
		return httpSession;
	}

	/**
	 * 删除当前HttpSession对象
	 */
	public static void destroySession() {
		HttpSession httpSession = getHttpSession();
		if (httpSession != null) {
			httpSession.invalidate();
		}
	}

	public static void saveCookie(String name, String value, int expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiry);
		String cp = SecurityFilter.getContextPath();
		if (cp.length() == 0) {
			cp = "/";
		}
		cookie.setPath(cp);
		HttpServletResponse response = ((HttpServletResponse) Executions.getCurrent().getNativeResponse());
		response.addCookie(cookie);
	}

	/**
	 * 取页面中显示内容的Include对象
	 * 
	 * @return
	 */
	public static IncludeDiv getIncludePage() {
		// AppLogger.sysDebug(Executions.getCurrent().getDesktop().getPages());
		return (IncludeDiv) Executions.getCurrent().getDesktop().getPage("mainPage").getFellow("xcontents");
	}

	public static IncludeDiv getElecIncludePage() {
		// AppLogger.sysDebug(Executions.getCurrent().getDesktop().getPages());
		return (IncludeDiv) Executions.getCurrent().getDesktop().getPage("elecMainPage").getFellow("elecContent");
	}

	public static void setElecPageTitle(String title) {
		Executions.getCurrent().getDesktop().getPage("elecMainPage").setTitle(title);
	}

	/**
	 * 取客户端IP地址
	 * 
	 * @return
	 */
	public static String getIpAddress() {
		Execution execution = Executions.getCurrent();
		if (execution == null) {
			return "";
		}
		String ip = execution.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = execution.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = execution.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = execution.getRemoteAddr();
		}
		return ip;
	}
}
