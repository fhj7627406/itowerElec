package com.fuhj.util;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

import com.fuhj.itower.service.model.Users;
import com.fuhj.log.AppLogger;

/**
 * 登录/退出/密码验证安全工具
 * 
 * @author yuanzy
 * 
 */
public class SecurityUtil {

	/** 是否测试模式 */
	public static final boolean IS_DEBUG = Boolean.parseBoolean(ConfigReader.getProperty("IS_DEBUG_MODEL"));

	/** 已登录用户表 */
	private static final Map<String, Users> LOGINED_USER_MAP = Collections.synchronizedMap(new HashMap<String, Users>());

	/**
	 * 密码摘要（明文->MD5->转大写）
	 * 
	 * @param clearTxt
	 * @return
	 */
	public static String password(String clearTxt) {
		String secTxt = DigestUtils.md5Hex(clearTxt);
		return secTxt.toUpperCase();
	}

	/**
	 * 显示登录用户字符串(首先清空无效用户)
	 * 
	 * @return
	 */
	public static String listLoginedUser() {
		if (IS_DEBUG) {
			return "";
		}
		synchronized (LOGINED_USER_MAP) {
			// 清除因非正常退出或Session过期的无效用户
			Set<String> removeLoginUsers = new HashSet<String>();
			for (Users user : LOGINED_USER_MAP.values()) {
				boolean remove = false;
				HttpSession session = user.getHttpSession();
				if (session == null) {
					remove = true;
				} else {
					try {
						if (System.currentTimeMillis() - session.getLastAccessedTime() > session.getMaxInactiveInterval() * 1000) {
							session.invalidate();
							remove = true;
						}
					} catch (Exception e) {
						// java.lang.IllegalStateException: getLastAccessedTime:
						// Session already invalidated
						remove = true;
					}
				}
				if (remove) {
					// AppLogger.sysInfo("因非正常退出或Session过期, 此用户已失效: " +
					// user.getCorpName() + ":" + user.getLoginName());
					removeLoginUsers.add(user.getLoginname());
				}
			}
			for (String LoginName : removeLoginUsers) {
				LOGINED_USER_MAP.remove(LoginName);
			}

			StringBuilder sb = new StringBuilder();
			for (Users user : LOGINED_USER_MAP.values()) {
				sb.append("\r\n[LoginTime:").append(user.getLoginTime()).append(", LastAccessTime:")
						.append(user.getHttpSession() != null ? FormatUtil.getFDate(new Date(user.getHttpSession().getLastAccessedTime())) : "Expired").append("] LoginName:")
						.append(user.getLoginname()).append(" : LoginIp:").append(user.getLastloginip());
			}
			return sb.toString();
		}
	}

	/**
	 * 用户登入
	 * 
	 * @param user
	 */
	public static void login(Users user) {
		synchronized (LOGINED_USER_MAP) {
			// Users loginedUser = LOGINED_USER_MAP.remove(user.getLoginname());
			// if (loginedUser != null) { // 此用户已登录
			// HttpSession session = loginedUser.getHttpSession();
			// if (session != null) {
			// AppLogger.sysInfo("用户重新登录，清除此用户原登录信息[SessionId:" +
			// session.getId() + "]");
			// try {
			// session.removeAttribute(WebAppUtil.USER_SESSION_KEY);
			// session.invalidate();
			// } catch (Exception e) {
			// // TODO: >>java.lang.IllegalStateException:
			// // invalidate: Session already invalidated
			// }
			// }
			// }
			user.setHttpSession(WebAppUtil.getHttpSession());
			user.setLoginTime(FormatUtil.getFDate(new Date()));
			LOGINED_USER_MAP.put(user.getLoginname(), user);
			WebAppUtil.setWebSessionAttribute(WebAppUtil.USER_SESSION_KEY, user);
			AppLogger.sysInfo("用户登入: " + user.getLoginname());
		}
	}

	/**
	 * 用户登出
	 * 
	 * @param user
	 * @param isClickLogout
	 */
	public static void logout(Users user, boolean isClickLogout) {
		synchronized (LOGINED_USER_MAP) {
			if (user != null) {
				Users removed = LOGINED_USER_MAP.remove(user.getLoginname());
				if (removed != null) {
					HttpSession session = removed.getHttpSession();
					if (session != null) {
						try {
							session.removeAttribute(WebAppUtil.USER_SESSION_KEY);
							AppLogger.sysInfo("用户" + (isClickLogout ? "主动" : "闲置") + "退出: " + user.getLoginname() + (removed != null ? "成功" : "失败"));
							// session.invalidate();
						} catch (Exception e) {
							// TODO: >>java.lang.IllegalStateException:
							// invalidate: Session already invalidated
						}
					}
					if (isClickLogout) {
						Clients.showBusy("注销中");
						Executions.getCurrent().sendRedirect("/");
						Clients.clearBusy();
					}
				}
			}
			// AppLogger.sysInfo("在线用户：" + listLoginedUser());
		}
	}
}
