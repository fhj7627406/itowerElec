/**
 * 
 */
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

import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-28
 */
public class GelecFilter implements Filter {

	private static String[] securityPages = new String[0];

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
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
			if (!isSecurityPage && (reqURI.endsWith("zul") || reqURI.endsWith("jsp"))
					&& request.getSession().getAttribute(WebAppUtil.GELEC_USER_SESSION_KEY) == null) {
				try {
					response.sendRedirect("gElec_login.zul");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			chain.doFilter(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override public void init(FilterConfig config) throws ServletException {
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
