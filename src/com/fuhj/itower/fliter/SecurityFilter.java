package com.fuhj.itower.fliter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.fuhj.log.AppLogger;
import com.fuhj.util.WebAppUtil;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {
	private static String contextPath;
	private static String[] securityPages = new String[0];

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	public static String getContextPath() {
		return contextPath;
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String reqURI = request.getRequestURI();
		if (!reqURI.endsWith(".htm")) {
			boolean isSecurityPage = false;
			for (String securityPage : securityPages) {
				if (reqURI.endsWith(securityPage)) {
					isSecurityPage = true;
					break;
				}
			}

			if (!isSecurityPage && "/".equals(reqURI.substring(contextPath.length()))) {
				isSecurityPage = true;
			}

			if (!isSecurityPage && (reqURI.endsWith("zul") || reqURI.endsWith("jsp"))
					&& request.getSession().getAttribute(WebAppUtil.USER_SESSION_KEY) == null) {
				try {
					AppLogger.sysDebug("contextPath:" + reqURI);
					response.sendRedirect(contextPath);
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			chain.doFilter(req, resp);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		contextPath = config.getServletContext().getContextPath();
		String allSecurityPages = config.getInitParameter("securityPages");
		if (!StringUtils.isEmpty(allSecurityPages)) {
			List<String> pageList = new ArrayList<String>();
			String[] checkPages = allSecurityPages.trim().split(",");
			for (String securityPage : checkPages) {
				if (!StringUtils.isEmpty(securityPage)) {
					pageList.add(securityPage.trim());
				}
			}
			securityPages = pageList.toArray(securityPages);
		}
	}
}
