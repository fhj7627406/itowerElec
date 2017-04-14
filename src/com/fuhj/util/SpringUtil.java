package com.fuhj.util;

import java.io.Serializable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fuhj.itower.fliter.SecurityFilter;
import com.fuhj.itower.service.LocationService;
import com.fuhj.log.AppLogger;

public class SpringUtil extends HttpServlet implements Serializable {

	private static final long serialVersionUID = -1881452288402690657L;

	// private static Log logger = LogFactory.getLog(SpringUtil.class);

	private static ServletContext application;
	private static String webAppPath;

	@Override public void init(ServletConfig config) throws ServletException {
		super.init(config);
		synchronized (SpringUtil.class) {
			System.setProperty("jsse.enableSNIExtension", "false");
			if (application == null) {
				application = config.getServletContext();
				reload();
			}
		}
		webAppPath = application.getRealPath("/");
		AppLogger.sysInfo("webContextPath:" + SecurityFilter.getContextPath());
		AppLogger.sysInfo("webAppPath:" + webAppPath);
	}

	private void reload() {
		getBean(LocationService.class).reloadLocation();
		// getBean(OperationLogService.class).initModuleCache();
		// getBean(CustomerService.class).reloadCustomer();
	}

	public static String getWebAppPath() {
		return webAppPath;
	}

	/**
	 * Get the spring application context.
	 */
	private static ApplicationContext getApplicationContext() {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(application);
	}

	/**
	 * Get the spring bean by the specified name and class.
	 */
	@SuppressWarnings("unchecked") public static <T> T getBean(Class<T> clazz) {
		Object o = null;
		try {
			o = getApplicationContext().getBean(getBeanName(clazz));
		} catch (BeansException e) {
			// logger.error(e);
		}
		return (T) o;
	}

	private static final String getBeanName(Class<?> clazz) {
		String name = clazz.getSimpleName();
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name;
	}

}
