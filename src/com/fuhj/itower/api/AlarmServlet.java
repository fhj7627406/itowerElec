package com.fuhj.itower.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuhj.itower.service.model.AlarmJson;
import com.fuhj.log.AppLogger;
import com.fuhj.util.JsonUtil;
import com.fuhj.util.SpringUtil;

/**
 * Servlet implementation class ItowerElecAPIServlet
 */
@WebServlet("/api/alarm") public class AlarmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_CHARSET = "UTF-8";
	private APIService apiService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlarmServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		apiService = SpringUtil.getBean(APIService.class);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppLogger.sysDebug("API " + request.getRequestURI());
		request.setCharacterEncoding(DEFAULT_CHARSET);
		response.setCharacterEncoding(DEFAULT_CHARSET);
		response.setContentType("application/json");
		final String atype = request.getParameter("atype");
		final String range = request.getParameter("range");
		final String slave = request.getParameter("slave");
		PrintWriter pw = response.getWriter();
		try {
			AlarmJson json = apiService.queryPFAlarm(atype, range, slave);
			pw.write(JsonUtil.getJsonStringFromObject(json));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
