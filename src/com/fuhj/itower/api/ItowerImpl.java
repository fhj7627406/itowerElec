/**
 * 
 */
package com.fuhj.itower.api;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasParentFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.FormTag;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.model.StationBattery;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.tasks.KeepItowerLogin;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.FSUMonitorModel;
import com.fuhj.itower.ui.model.MonitorMapBean;
import com.fuhj.itower.ui.model.QueryResult;
import com.fuhj.itower.ui.model.TDSiteVoltage;
import com.fuhj.log.AppLogger;
import com.fuhj.ocr.ItowerOCRHelper;
import com.fuhj.util.ConfigReader;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.JsonUtil;
import com.fuhj.util.RequestHelper;
import com.fuhj.util.SecurityUtil;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-9
 */
public class ItowerImpl {

	/**
	 * http://101.227.240.110:8989/baf/jsp/uiframe/login.jsp 备用地址
	 * http://180.153.49.130:9000/baf/jsp/uiframe/login.jsp
	 */
	private static final long serialVersionUID = 1990500373122623880L;
	private static DateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static DateFormat ddf = new SimpleDateFormat("MM/yyyy");
	private static final String JSF_VIEWSTATE_PATTERN = "<input type=\"hidden\" name=\"javax.faces.ViewState\".*?/>";
	public static final String DEFAULT_CHARSET = "UTF-8";
	@Setter
	private static String currentCookie = null;

	private static FormParm alarmFP = null;
	private static FormParm perfFP = null;
	private static FormParm realTimeperFP = null;
	private static FormParm listfsuFP = null;
	private static FormParm netlistSiteFP = null;
	private static FormParm sitelistSiteFP = null;
	private static FormParm tdSiteVFP = null;
	private static FormParm billListFP = null;
	private static Object lockObj = new Object();
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
	public static final String ALARM_FSU = "FSU离线";
	public static final String ALARM_DZTF = "脱离";
	public static final String ALARM_TD = "停电";

	/** 重试3次 */
	private static final int RETRY_TIME = 3;

	public static final String ITOWER_SYS_URL = ConfigReader.getProperty("ITOWER_SYS_URL");
	public static final String ITOWER_HOST = ITOWER_SYS_URL.substring("http://".length());
	public static final String URL_ORG = ITOWER_SYS_URL + "/baf/jsp/org/user/orgtree.jsp";
	public static final String URL_OCRIMG = ITOWER_SYS_URL + "/servlet/ValidateCodeServlet";
	public static final String URL_CHECK_LOGIN = ITOWER_SYS_URL + "/jf/login/checkLogin";
	public static final String URL_LOGIN = ITOWER_SYS_URL + "/baf/jsp/uiframe/login.jsp";
	public static final String URL_LISTALARM = ITOWER_SYS_URL + "/business/resMge/alarmMge/listAlarm.xhtml";
	public static final String URL_PERFDATA = ITOWER_SYS_URL + "/business/resMge/pwMge/performanceMge/perfdata.xhtml";
	public static final String URL_RTDATA = ITOWER_SYS_URL + "/business/resMge/pwMge/realTimePerformanceMge/realTimeperfdata.xhtml";
	public static final String URL_MONITORMAP = ITOWER_SYS_URL + "/business/resMge/pwMge/fsuMge/map/MonitorMap.xhtml";
	public static final String URL_LISTFSU = ITOWER_SYS_URL + "/business/resMge/pwMge/fsuMge/listFsu.xhtml";
	public static final String URL_NETLISTSITE = ITOWER_SYS_URL + "/business/resMge/netMge/listSite.xhtml";
	public static final String URL_SITELISTSITE = ITOWER_SYS_URL + "/business/resMge/siteMge/listSite.xhtml";
	public static final String URL_POWERREALDATA = ITOWER_SYS_URL + "/business/resMge/pwMge/interfacelogMge/powerRealDataList.xhtml";
	public static final String URL_MONITORING = ITOWER_SYS_URL + "/billDeal/monitoring/list/billMonitorCountList.xhtml";
	public static final String URL_BILLLIST = ITOWER_SYS_URL + "/billDeal/monitoring/list/billList.xhtml";
	public static final String IT_LOGINCODE_PROPERTY_NAME = "itowerLoginCode";
	public static final String DEFAULT_FORMNAME = "queryForm";

	public void getOrgTree(String id) throws Exception {

		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Cookie", currentCookie);
		String param = "?id=";
		String requestURI = "";
		if (StringUtils.isEmpty(id)) {
			requestURI = URL_ORG;
		} else {
			requestURI = URL_ORG + param + id;
		}

		String root = RequestHelper.request(requestURI, RequestHelper.METHOD_GET, headerMap, "", DEFAULT_CHARSET, "GBK");
		Parser p = new Parser(root);
		NodeList child = p.parse(new TagNameFilter("item"));
		for (int i = 0; i < child.size(); i++) {
			Node node = child.elementAt(i);
			Tag tag = (Tag) node;
			String compText = tag.getAttribute("text");
			String compid = tag.getAttribute("id");
			// System.out.println("INSERT INTO
			// it_city(it_city_id,it_province_id,cname) VALUES ('"
			// + compid + "','"+id+"','" + compText.replace("分公司", "") + "');");
			getOrgTree_child(compid);
		}
	}

	public static void main(String[] args) throws Exception {
		ItowerImpl itower = new ItowerImpl();
		currentCookie = "JSESSIONID=431FC46B69EBF86B0DEAFBFAA9BC6825;";
		itower.listFSU("0099940", 0);

		// itower.getStaAgtStaffByCode("","43040800000342");

		// itower.queryItowerAlarm("0099940", ALARM_TD);

		//
		// List<StationNew> list_rs = itower.getStations("0108377");
		// for (StationNew s : list_rs) {
		// System.out.println(JsonUtil.getJsonStringFromObject(s));
		// }
		//
		// ApplicationContext appctx = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// LocationService locationService = (LocationService)
		// appctx.getBean("locationService");
		//
		// String rootDirPath = "C:/Users/fu/Desktop/运监站点/湖南";
		// for (ITCity city :
		// locationService.findAllCityByProvinceId("0001928")) {
		// File cityDir = new File(rootDirPath + File.separator +
		// city.getCname());
		// if (!cityDir.exists()) {
		// cityDir.mkdir();
		// }
		// List<ITDistrict> dList =
		// locationService.findAllDistrictByCityId(city.getItCityId());
		// for (ITDistrict district : dList) {
		// File districtFile = new File(cityDir.getAbsolutePath() +
		// File.separator + district.getDname() + ".txt");
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(districtFile)));
		// if (districtFile.exists()) {
		// districtFile.delete();
		// } else {
		// districtFile.createNewFile();
		// }
		// List<StationNew> list_rs =
		// itower.getStations(district.getItDistrictId());
		// for (StationNew s : list_rs) {
		// bw.write(JsonUtil.getJsonStringFromObject(s));
		// bw.newLine();
		// }
		// bw.close();
		// }
		// }
		// int sum = 0;
		// File root = new File("C:/Users/fu/Desktop/运监站点/补充");
		// File destDir = new File("C:/Users/fu/Desktop/站点设备");
		// File errorFile = new File("C:/Users/fu/Desktop/站点设备/error.txt");
		// BufferedWriter bwerror = new BufferedWriter(new
		// OutputStreamWriter(new FileOutputStream(errorFile, true)));
		// File[] dirs = root.listFiles();
		// for (File dir : dirs) {
		// // System.out.println(dir.getAbsolutePath());
		// File[] files = dir.listFiles();
		// for (File f : files) {
		// // System.out.println(f.getAbsolutePath());
		//
		// File destFile = new File(destDir + File.separator + "device_" +
		// f.getName());
		// if (destFile.exists()) {
		// destFile.delete();
		// } else {
		// destFile.createNewFile();
		// }
		//
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(f), "gbk"));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(destFile)));
		// String line = "";
		// while ((line = br.readLine()) != null) {
		// System.out.println(line);
		// StationNew sn = (StationNew) JsonUtil.getObjectFromJsonString(line,
		// StationNew.class);
		// if (sn.getStationStatus().equals("交维") ||
		// sn.getStationStatus().equals("检修")) {
		// sum += 1;
		// List<StationDevice> sdList = null;
		// try {
		// sdList = itower.getDevicebyStationSysId(sn.getStationSysId());
		// } catch (Exception e) {
		// bwerror.write(line);
		// bwerror.newLine();
		// continue;
		// }
		//
		// for (StationDevice sd : sdList) {
		// bw.write(JsonUtil.getJsonStringFromObject(sd));
		// bw.newLine();
		// }
		// bw.flush();
		// Thread.sleep(1600);
		// }
		// }
		// br.close();
		// bw.close();
		// bwerror.flush();
		// }
		// }
		// bwerror.close();
	}

	public void getOrgTree_child(String id) throws Exception {

		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Cookie", currentCookie);
		String param = "?id=";
		String requestURI = "";
		if (StringUtils.isEmpty(id)) {
			requestURI = URL_ORG;
		} else {
			requestURI = URL_ORG + param + id;
		}

		String root = RequestHelper.request(requestURI, RequestHelper.METHOD_GET, headerMap, "", DEFAULT_CHARSET, "GBK");
		Parser p = new Parser(root);
		NodeList child = p.parse(new TagNameFilter("item"));
		for (int i = 0; i < child.size(); i++) {
			Node node = child.elementAt(i);
			Tag tag = (Tag) node;
			String compText = tag.getAttribute("text");
			String compid = tag.getAttribute("id");
			String temp = compText;
			if (compText.length() > 2 && !compText.equals("南昌县")) {
				if (compText.matches("^(.*?)(区|县|市)$")) {
					temp = compText.substring(0, compText.length() - 1);
				}
				if (compText.matches("^(.*?)区域")) {
					temp = compText.substring(0, compText.length() - 2);
				}
				if (compText.matches("^(.*?)区（待废弃）$")) {
					temp = compText.substring(0, compText.length() - "区（待废弃）".length());
				}
			}
			System.out
					.println("INSERT INTO it_district(it_district_id,it_province_id,it_city_id,dname,dshortname) VALUES( '" + compid + "','0098364','" + id + "','" + compText + "','" + temp + "');");
		}
	}

	public synchronized boolean autoLogin(String loginName, String pwd) throws ServiceException {
		boolean login = false;
		Map<String, String> header = makeFristHeader();
		BufferedImage ocrImg = getValidateCode(header);
		String ocr;
		try {
			ocr = ItowerOCRHelper.getOcr(ocrImg);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		if (StringUtils.isNotEmpty(ocr)) {
			login = loginITower(loginName, pwd, ocr, header.get("Cookie"));
			AppLogger.sysDebug(login ? "自动登录成功!" : "自动登录失败！");
		}
		return login;
	}

	public synchronized boolean autoLogin() throws ServiceException {
		if (SecurityUtil.IS_DEBUG) {
			return autoLogin(ConfigReader.getProperty("ITOWER_DEBUG_USER"), ConfigReader.getProperty("ITOWER_DEBUG_PWD"));
		} else {
			return autoLogin(ConfigReader.getProperty("ITOWER_USER"), ConfigReader.getProperty("ITOWER_PWD"));
		}
	}

	public synchronized boolean loginITower(String loginName, String pwd, String ocr, String cookie) throws ServiceException {
		String loginCode = checkLogin_itower(loginName, pwd, ocr, cookie);
		if (loginCode.equals("1")) {
			KeepItowerLogin.isLogin = true;
			currentCookie = cookie;
			try {
				MyProperties.writeProperties(MyProperties.COOKIEFILE, "Cookie", cookie);
			} catch (IOException e) {
				throw new ServiceException(e);
			}
			alarmFP = null;
			perfFP = null;

			listfsuFP = null;
			netlistSiteFP = null;
			realTimeperFP = null;
			sitelistSiteFP = null;
			tdSiteVFP = null;
			billListFP = null;
			return true;
		}
		return false;
	}

	public BufferedImage getValidateCode(Map<String, String> fristHeader) throws ServiceException {
		try {
			return RequestHelper.getImg(URL_OCRIMG, fristHeader);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public Map<String, String> makeFristHeader() throws ServiceException {
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		headerMap.put("Accept-Encoding", "gzip, deflate");
		headerMap.put("Accept-Language", "zh-CN,zh;q=0.8");
		headerMap.put("Connection", "keep-alive");
		headerMap.put("Host", ITOWER_HOST);
		headerMap.put("Upgrade-Insecure-Requests", "1");
		headerMap.put("User-Agent", USER_AGENT);
		try {
			URL urlSend = new URL(URL_LOGIN);
			HttpURLConnection conSend = (HttpURLConnection) urlSend.openConnection();
			conSend.setDoInput(true);
			conSend.setDoOutput(true);
			conSend.setUseCaches(false);
			conSend.setRequestMethod("GET");
			for (Entry<String, String> e : headerMap.entrySet()) {
				conSend.setRequestProperty(e.getKey(), e.getValue());
			}
			conSend.getInputStream();
			String responseCookie = conSend.getHeaderField("Set-Cookie");
			headerMap.put("Cookie", responseCookie);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return headerMap;
	}

	public static String getLoginRsText(String code) {
		Properties properties = ConfigReader.getProperties(IT_LOGINCODE_PROPERTY_NAME);
		String text = "";
		try {
			text = new String(properties.getProperty(code, "").getBytes("ISO-8859-1"), DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return text;
	}

	public String checkLogin_itower(String loginName, String pwd, String ocr, String cookie) throws ServiceException {
		String loginCode = "";
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/x-www-form-urlencoded");
		headerMap.put("Connection", "keep-alive");
		headerMap.put("Cache-Control", "no-cache");
		headerMap.put("Host", ITOWER_HOST);
		headerMap.put("Upgrade-Insecure-Requests", "1");
		headerMap.put("Cookie", cookie);
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("loginName", loginName);
		formMap.put("password", pwd);
		formMap.put("picCode", ocr);
		try {
			String rs = RequestHelper.request(URL_CHECK_LOGIN, RequestHelper.METHOD_POST, headerMap, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			if (StringUtils.isNotEmpty(rs)) {
				loginCode = JsonUtil.getMapFromJsonString(rs).get("status").toString();
			}
			AppLogger.sysDebug("checkLogin_itower:" + loginCode + " " + getLoginRsText(loginCode));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return loginCode;
	}

	public boolean hasLogin(String cookie) throws ServiceException {
		String uri = ITOWER_SYS_URL + "/layout/index.xhtml";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Host", ITOWER_HOST);
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("Cookie", cookie);
		headers.put("User-Agent", USER_AGENT);
		try {
			String rs = RequestHelper.request(uri, RequestHelper.METHOD_POST, headers, "", DEFAULT_CHARSET, DEFAULT_CHARSET);
			if (!rs.contains("您没有登录该系统或登录已超时")) {
				currentCookie = cookie;
				return true;
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return false;
	}

	public int queryItowerAlarmCount(String range, String type) throws ServiceException {
		AppLogger.sysDebug("queryItowerAlarmCount:" + range + " " + type);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Cache-Control", "no-cache, must-revalidate, max_age=0, no-store");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		headers.put("Host", ITOWER_HOST);
		headers.put("Origin", ITOWER_SYS_URL);
		headers.put("Referer", new StringBuilder(URL_LISTALARM).append("?tabId=tab_billList_3").toString());

		FormParm formParm = getAlarmFP();

		String dd = ddf.format(new Date());
		Map<String, String> formMap = new HashMap<String, String>();

		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:querySiteId", "");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:querySiteNameId", "");
		formMap.put("queryForm:serialnoText", "");
		formMap.put("queryForm:hidDeviceId", "");
		formMap.put("queryForm:objid", "");
		formMap.put("queryForm:objname", "");
		formMap.put("queryForm:querystationstatus_hiddenValue", "2");
		formMap.put("queryForm:querystationstatus", "2");
		formMap.put("queryForm:querystationcode", "");
		formMap.put("queryForm:fscidText", type);
		formMap.put("queryForm:firststarttimeInputDate", "");
		formMap.put("queryForm:firststarttimeInputCurrentDate", dd);
		formMap.put("queryForm:firstendtimeInputDate", "");
		formMap.put("queryForm:sortSelect_hiddenValue", "");
		formMap.put("queryForm:isCreateBillSel_hiddenValue", "");
		formMap.put("queryForm:faultidText", "");
		formMap.put("queryForm:refreshTime", "");
		formMap.put("queryForm:queryFactoryName_hiddenValue", "");
		formMap.put("queryForm:querySiteSource_hiddenValue", "");
		formMap.put("queryForm:queryIfConfirm_hiddenValue", "");
		formMap.put("queryForm:currPageObjId", "0");
		formMap.put("queryForm:pageSizeText", "5");
		formMap.put("queryForm:panelOpenedState", "");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		List<Integer> pageInfo = new ArrayList<Integer>();
		try {
			synchronized (lockObj) {
				rs = RequestHelper.request(URL_LISTALARM, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			}
			Parser parser = new Parser(rs);
			NodeList nodeList = parser.parse(new AndFilter(new NodeFilter[] { new TagNameFilter("td"), new HasAttributeFilter("class", "rich-datascr-info") }));
			// 页 共8页 79条记录
			if (nodeList.size() > 0) {
				Pattern p = Pattern.compile("(\\d+)");
				Matcher m = p.matcher(nodeList.asString());

				while (m.find()) {
					int num = 0;
					try {
						num = Integer.parseInt(m.group(1));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					pageInfo.add(num);
				}
			} else {
				alarmFP = null;
				throw new ServiceException();
			}

		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return pageInfo.size() > 0 ? pageInfo.get(1) : 0;
	}

	public List<AlarmModel> queryItowerAlarm(String range, String type) throws ServiceException {
		AppLogger.sysDebug("queryItowerAlarm:" + range + " " + type);
		List<AlarmModel> alarmList = new ArrayList<AlarmModel>();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Cache-Control", "no-cache, must-revalidate, max_age=0, no-store");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		headers.put("Host", ITOWER_HOST);
		headers.put("Origin", ITOWER_SYS_URL);
		headers.put("Referer", new StringBuilder(URL_LISTALARM).append("?tabId=tab_billList_3").toString());

		FormParm formParm = getAlarmFP();

		String dd = ddf.format(new Date());
		Map<String, String> formMap = new HashMap<String, String>();

		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:querySiteId", "");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:querySiteNameId", "");
		formMap.put("queryForm:serialnoText", "");
		formMap.put("queryForm:hidDeviceId", "");
		formMap.put("queryForm:objid", "");
		formMap.put("queryForm:objname", "");
		formMap.put("queryForm:querystationstatus_hiddenValue", "2");
		formMap.put("queryForm:querystationstatus", "2");
		formMap.put("queryForm:querystationcode", "");
		formMap.put("queryForm:fscidText", type);
		formMap.put("queryForm:firststarttimeInputDate", "");
		formMap.put("queryForm:firststarttimeInputCurrentDate", dd);
		formMap.put("queryForm:firstendtimeInputDate", "");
		formMap.put("queryForm:firstendtimeInputCurrentDate", dd);
		formMap.put("queryForm:sortSelect_hiddenValue", "");
		formMap.put("queryForm:isCreateBillSel_hiddenValue", "");
		formMap.put("queryForm:faultidText", "");
		formMap.put("queryForm:refreshTime", "");
		formMap.put("queryForm:queryFactoryName_hiddenValue", "");
		formMap.put("queryForm:querySiteSource_hiddenValue", "");
		formMap.put("queryForm:queryIfConfirm_hiddenValue", "");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "9999");
		formMap.put("queryForm:panelOpenedState", "");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");

		String rs;
		try {
			synchronized (lockObj) {
				rs = RequestHelper.request(URL_LISTALARM, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			}
			// NodeList nodeList = new Parser(rs).parse(null);
			// if (nodeList
			// .asString()
			// .contains(
			// "&#24744;&#27809;&#26377;&#30331;&#24405;&#35813;&#31995;&#32479;&#25110;&#30331;&#24405;&#24050;&#36229;&#26102;&#65292;&#35831;"))
			// {
			// AppLogger.sysInfo("未登录" + "--" + FormatUtil.getFDate(new
			// Date()));
			// return alarmList;
			// }
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			int index = 0;
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						LinkTag link = (LinkTag) cols[4].getChild(1);
						String hrefText = link.getAttribute("href");
						Pattern p1 = Pattern.compile("javascript:showBillDetail\\('(.*?)','(.*?)','(.*?)'\\)");
						Matcher m1 = p1.matcher(hrefText);
						String billId = m1.find() ? m1.group(1) : "";
						Tag troubleNOTag = (Tag) cols[4].getChild(1).getFirstChild();
						String alarmIndex = cols[1].toPlainTextString();
						String troubleNO = troubleNOTag.getAttribute("title");
						String alarmTime = cols[10].toPlainTextString();
						String alarmName = cols[5].toPlainTextString();
						Tag alarmDetailTag = (Tag) cols[6].getChild(1);
						String alarmDetail = alarmDetailTag.getAttribute("title");
						LinkTag siteNamelink = (LinkTag) cols[7].getChild(1);
						String siteNamehrefText = siteNamelink.getAttribute("href");
						Pattern p2 = Pattern.compile("javascript:showStationDetailFunc\\('(.*?)','(.*?)'\\)");
						Matcher m2 = p2.matcher(siteNamehrefText);
						String stationsid = m2.find() ? m2.group(1) : "";
						String siteName = cols[7].getChild(1).getFirstChild().getText().trim();
						String duration = cols[12].toPlainTextString();
						String siteCode = cols[16].toPlainTextString();
						String fsuStatus = cols[18].toPlainTextString();
						String fsuManufacturer = cols[20].toPlainTextString();
						String stationFrom = cols[21].toPlainTextString();
						String agentMaintainCorp = cols[22].toPlainTextString();
						String alarmConfirm = cols[23].toPlainTextString();
						String acTime = cols[24].toPlainTextString();
						Date alarmConfirmTime = null;
						if (StringUtils.isNotEmpty(acTime)) {
							try {
								alarmConfirmTime = FormatUtil.parseDate(fdf, acTime);
							} catch (ParseException e) {
								AppLogger.sysError(e);
							}
						}
						String alarmConfirmRemark = cols[25].toPlainTextString();
						if (ALARM_DZTF.equals(type) && !"一级低压脱离告警".equals(alarmName)) {
							continue;
						}
						AlarmModel model = new AlarmModel(billId, troubleNO, alarmName, alarmDetail, FormatUtil.parseDate(fdf, alarmTime), stationsid, siteCode, siteName, Integer.parseInt(duration),
								fsuStatus, fsuManufacturer, stationFrom, agentMaintainCorp, alarmConfirm, alarmConfirmTime, alarmConfirmRemark);
						model.setIndex(index);
						alarmList.add(model);
						index++;
						// AppLogger.sysDebug(alarmIndex + "|" + billId + "|" +
						// troubleNO + "|" + alarmName + "|" + alarmDetail + "|"
						// + alarmTime +
						// "|" + stationsid + "|" + siteCode + "|" + siteName +
						// "|" + duration + "|" + fsuStatus + "|" +
						// fsuManufacturer + "|"
						// + stationFrom + "|" + agentMaintainCorp);
					}
				}
			} else {
				alarmFP = null;
				throw new ServiceException();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return alarmList;
	}

	public HSSFWorkbook queryItowerBill(String range, String type) throws ServiceException {
		// AppLogger.sysDebug("queryItowerBill:" + range + " " + type);
		HSSFWorkbook wb = null;
		Map<String, String> headers = new HashMap<String, String>();

		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		headers.put("HOST", ITOWER_HOST);
		headers.put("Referer", new StringBuilder(URL_BILLLIST).append("?tabId=tab_billList_2").toString());

		FormParm formParm = getBillListFP();
		Date now = new Date();
		String dd = ddf.format(now);

		Map<String, String> formMap = new HashMap<String, String>();

		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm1", "queryForm1");
		formMap.put("queryForm1:msg", "0");
		formMap.put("queryForm1:isQueryHis", "N");
		formMap.put("queryForm1:queryStationId", "");
		formMap.put("queryForm1:isHasten1_hiddenValue", "");
		formMap.put("queryForm1:parm1", type);
		formMap.put("queryForm1:queryUnitId1", range);

		formMap.put("queryForm1:starttimeInputDate", FormatUtil.getFDate(DateUtils.addDays(now, -3)));
		formMap.put("queryForm1:starttimeInputCurrentDate", dd);
		formMap.put("queryForm1:endtimeInputDate", FormatUtil.getFDate(now));
		formMap.put("queryForm1:endtimeInputCurrentDate", dd);
		formMap.put("queryForm1:alarmlevel1_hiddenValue", "");
		formMap.put("queryForm1:revertstarttimeInputDate", "");
		formMap.put("queryForm1:revertstarttimeInputCurrentDate", dd);
		formMap.put("queryForm1:revertendtimeInputDate", "");
		formMap.put("queryForm1:revertendtimeInputCurrentDate", dd);
		formMap.put("queryForm1:faultDevType1_hiddenValue", "");
		formMap.put("queryForm1:dealstarttimeInputDate", "");
		formMap.put("queryForm1:dealstarttimeInputDate", "");
		formMap.put("queryForm1:dealstarttimeInputCurrentDate", dd);
		formMap.put("queryForm1:dealendtimeInputDate", "");
		formMap.put("queryForm1:dealendtimeInputCurrentDate", dd);
		formMap.put("queryForm1:isOverTime1_hiddenValue", "");
		formMap.put("queryForm1:isReplyOver1_hiddenValue", "");

		formMap.put("queryForm1:isOverTime1_hiddenValue", "");
		formMap.put("queryForm1:isReplyOver1_hiddenValue", "");
		formMap.put("queryForm1:refreshTime1", "");
		formMap.put("queryForm1:queryDWCompany", "");
		formMap.put("queryForm1:isElectric_hiddenValue", "");
		formMap.put("queryForm1:isEmptyRun_hiddenValue", "");
		formMap.put("queryForm1:panelOpenedState", "");

		// formMap.put("queryForm:currPageObjId", "1");
		// formMap.put("queryForm:pageSizeText", "9999");

		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			synchronized (lockObj) {
				rs = RequestHelper.request(URL_BILLLIST, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			}
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm1:billListTable1"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					// for (int i = 2; i < rows.length; i++) {
					// TableColumn[] cols = rows[i].getColumns();
					// System.out.println(rows[i].toPlainTextString());
					// }
					Map<String, String> eteFormMap = new HashMap<String, String>();
					for (Entry<String, String> e : formParm.getExportExcelFormMap().entrySet()) {
						if (e.getValue().equals("当页"))
							continue;
						eteFormMap.put(e.getKey(), e.getValue());
					}

					HttpURLConnection conSend = (HttpURLConnection) new URL(URL_BILLLIST).openConnection();
					conSend.setDoInput(true);
					conSend.setConnectTimeout(10000);
					conSend.setReadTimeout(30000);
					conSend.setUseCaches(false);
					conSend.setRequestMethod("POST");
					if (headers != null && headers.size() > 0) {
						for (Entry<String, String> e : headers.entrySet()) {
							conSend.setRequestProperty(e.getKey(), e.getValue());
						}
					}
					StringBuffer params = new StringBuffer();
					if (eteFormMap != null && eteFormMap.size() > 0) {
						conSend.setDoOutput(true);
						for (Entry<String, String> e : eteFormMap.entrySet()) {
							params.append(e.getKey());
							params.append("=");
							params.append(e.getValue());
							params.append("&");
						}
						params.deleteCharAt(params.length() - 1);
						OutputStreamWriter out = StringUtils.isEmpty(DEFAULT_CHARSET) ? new OutputStreamWriter(conSend.getOutputStream())
								: new OutputStreamWriter(conSend.getOutputStream(), DEFAULT_CHARSET);
						out.write(params.toString());
						out.close();
					}
					InputStream is = conSend.getInputStream();
					wb = new HSSFWorkbook(is);
				}
			} else {
				billListFP = null;
			}
		} catch (Exception e) {
			throw new ServiceException();
		}
		return wb;
	}

	public Map<String, TDSiteVoltage> queryTDsiteV(String range) throws ServiceException {
		AppLogger.sysDebug("queryTDsiteV:" + range);
		Map<String, TDSiteVoltage> map = new HashMap<String, TDSiteVoltage>();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Cache-Control", "max_age=0");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("Host", ITOWER_SYS_URL.substring("http://".length()));
		headers.put("Origin", ITOWER_SYS_URL);
		headers.put("Referer", URL_POWERREALDATA);

		headers.put("User-Agent", USER_AGENT);
		FormParm formParm = getTdSiteVFP();
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:querySerFlagHid", "N");
		formMap.put("queryForm:j_id11", "");
		formMap.put("queryForm:j_id15", "");
		formMap.put("queryForm:j_id19", "");
		formMap.put("queryForm:j_id23", "");
		formMap.put("queryForm:currPageObjId", "0");
		formMap.put("queryForm:pageSizeText", "200");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			synchronized (lockObj) {
				rs = RequestHelper.request(URL_POWERREALDATA, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			}
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						String index = cols[1].toPlainTextString();
						String siteName = cols[3].toPlainTextString();
						String siteSYSCode = cols[4].toPlainTextString();
						String siteCode = cols[5].toPlainTextString();
						// Node node = cols[5].getChild(1).getFirstChild();
						String troubleNO = cols[6].toPlainTextString();
						String voltage = cols[7].toPlainTextString();
						String updateTime = cols[15].toPlainTextString();
						TDSiteVoltage tdv = new TDSiteVoltage();
						tdv.setIndex(Integer.parseInt(index));
						tdv.setSiteName(siteName);
						tdv.setSiteSYSCode(siteSYSCode);
						tdv.setSiteCode(siteCode);
						tdv.setTroubleNO(troubleNO);
						tdv.setVoltage(formatVoltage(voltage));
						tdv.setUpdateTime(FormatUtil.parseDate(fdf, updateTime));
						map.put(siteCode, tdv);
						// AppLogger.sysDebug(index + "|" + siteName + "|" +
						// siteSYSCode + "|" + siteCode + "|" + troubleNO + "|"
						// + voltage + "|"
						// + updateTime);
					}
				}
			} else {
				tdSiteVFP = null;
				throw new ServiceException();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return map;
	}

	@Deprecated
	public synchronized String queryVoltage(String range, String stationsid) throws ServiceException {
		AppLogger.sysDebug("queryVoltage:" + range + " stationid:" + stationsid);

		String voltage = "";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);

		FormParm formParm = getPerfFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		// 按数据库对应ID查最快 queryForm:aid
		formMap.put("queryForm:aid", stationsid);
		formMap.put("queryForm:siteProvinceId", "0001928");
		formMap.put("queryForm:showFlag", "1");
		formMap.put("queryForm:queryFlag", "1");
		formMap.put("queryForm:unitHidden1", range);
		formMap.put("queryForm:unitTypeHidden", "");
		formMap.put("queryForm:siteNameId", "");
		formMap.put("queryForm:deviceName", "");
		formMap.put("queryForm:did", "");
		formMap.put("queryForm:midName", "");
		formMap.put("queryForm:mid", "");
		formMap.put("queryForm:queryStationId", "");
		formMap.put("queryForm:queryFsuId", "");
		formMap.put("queryForm:midType", "遥测");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "9999");
		formMap.put("queryForm:panelOpenedState", "");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");

		TableTag tt = null;
		try {
			String rs = RequestHelper.request(URL_PERFDATA, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);

			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			tt = (TableTag) nodeList.elementAt(0);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		if (tt == null) {
			return QueryResult.NODATA.getValue();
		}
		TableRow[] rows = tt.getRows();
		boolean hasfind = false;
		if (rows.length > 2) {
			for (int i = 2; i < rows.length; i++) {
				TableColumn[] cols = rows[i].getColumns();
				String deviceCol = cols[3].getChild(1).getFirstChild().getText();
				String devpCol = cols[6].getChild(1).getText();
				if ((deviceCol.contains("蓄电池01") || deviceCol.contains("蓄电池组01")) && devpCol.equals("总电压")) {
					voltage = cols[8].getChild(1).getText();
					hasfind = true;
					break;
				}
			}
			// 待优化
			if (!hasfind) {
				for (int i = 2; i < rows.length; i++) {
					TableColumn[] cols = rows[i].getColumns();
					String deviceCol = cols[3].getChild(1).getFirstChild().getText();
					String devpCol = cols[6].getChild(1).getText();
					if ((deviceCol.contains("蓄电池02") || deviceCol.contains("蓄电池组02")) && devpCol.equals("总电压")) {
						voltage = cols[8].getChild(1).getText();
						hasfind = true;
						break;
					}
				}
			}
		}
		if (!hasfind) {
			voltage = QueryResult.NODATA.getValue();
		}
		return voltage;
	}

	public String queryBatteryDeviceId(String itProvinceId, String range, String stationCode, String stationsid) throws ServiceException {
		AppLogger.sysDebug("queryBatteryDeviceId:" + range + " stationCode:" + stationCode + " stationid:" + stationsid);

		String deviceId = "";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);

		FormParm formParm = getPerfFP();
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		// 按数据库对应ID查最快 queryForm:aid
		formMap.put("queryForm:aid", stationsid);
		formMap.put("queryForm:siteProvinceId", itProvinceId);
		formMap.put("queryForm:showFlag", "1");
		formMap.put("queryForm:queryFlag", "1");
		formMap.put("queryForm:unitHidden1", range);
		formMap.put("queryForm:unitTypeHidden", "");
		formMap.put("queryForm:siteNameId", "");
		formMap.put("queryForm:deviceName", "");
		formMap.put("queryForm:did", "");
		formMap.put("queryForm:midName", "");
		formMap.put("queryForm:mid", "");
		formMap.put("queryForm:queryStationId", stationCode);
		formMap.put("queryForm:queryFsuId", "");
		formMap.put("queryForm:midType", "遥测");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "99");
		formMap.put("queryForm:panelOpenedState", "");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");

		try {
			String rs = "";
			synchronized (lockObj) {
				rs = RequestHelper.request(URL_PERFDATA, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			}
			boolean hasFind = false;
			Pattern p1 = Pattern.compile("<a href=\"javascript:showPwDetailFunc\\('(.*?)'\\);\">(.*?)</a>");
			Matcher m1 = p1.matcher(rs);
			while (m1.find()) {
				if (m1.group().matches("(.*?)开关电源((0?)1)?</a>")) {
					hasFind = true;
					deviceId = m1.group(1);
					break;
				}
			}
			if (!hasFind) {
				Matcher m2 = p1.matcher(rs);
				while (m2.find()) {
					if (m2.group().matches("(.*?)蓄电池(组?)(0?)1(.*?)")) {
						deviceId = m2.group(1);
						hasFind = true;
						break;
					}
				}
			}
			if (!hasFind) {
				Matcher m3 = p1.matcher(rs);
				while (m3.find()) {
					if (m3.group().matches("(.*?)蓄电池(组?)(0?)2(.*?)")) {
						deviceId = m3.group(1);
						hasFind = true;
						break;
					}
				}
			}
			if (hasFind) {
				StationService service = SpringUtil.getBean(StationService.class);
				StationBattery sbInsert = new StationBattery(stationCode, stationsid, deviceId);
				service.addStationBattery(sbInsert);
			}
			// else {
			// perfFP = null;
			// throw new ServiceException();
			// }
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		AppLogger.sysDebug("queryBatteryDeviceId return:" + deviceId);
		return deviceId;
	}

	public String queryVoltageRT(final String itProvinceId, final String range, final String stationsid, final String stationCode, final String did) throws ServiceException {
		String deviceId = "";
		if (StringUtils.isEmpty(did)) {
			try {
				deviceId = queryBatteryDeviceId(itProvinceId, range, stationCode, stationsid);
			} catch (ServiceException e) {
				throw e;
				// queryVoltageRT(itProvinceId, range, stationsid, stationCode,
				// null);
			}
		} else {
			deviceId = did;
		}

		String voltage = QueryResult.NODATA.getValue();
		if (StringUtils.isNotEmpty(deviceId)) {
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Accept-Encoding", "gzip, deflate");
			headers.put("Accept-Language", "zh-CN,zh;q=0.8");
			headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			headers.put("Cookie", currentCookie);
			headers.put("User-Agent", USER_AGENT);
			FormParm formParm;
			try {
				formParm = getRealTimeperfFP();
			} catch (ServiceException e) {
				throw e;
			}
			Map<String, String> formMap = new HashMap<String, String>();
			formMap.put("AJAXREQUEST", "_viewRoot");
			formMap.put("queryForm", "queryForm");
			formMap.put("queryForm:addOrEditAreaNameId", "");
			formMap.put("queryForm:aid", stationsid);
			formMap.put("queryForm:fsuid", "");
			formMap.put("queryForm:deviceName:", "");
			formMap.put("queryForm:did", deviceId);
			formMap.put("queryForm:midName", "");
			formMap.put("queryForm:mid", "");
			formMap.put("queryForm:panelOpenedState", "");
			formMap.put("javax.faces.ViewState", formParm.getViewState());
			formMap.put(formParm.getJ_id(), formParm.getJ_id());
			formMap.put("AJAX:EVENTS_COUNT", "1");

			try {
				String rs = RequestHelper.request(URL_RTDATA, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
				NodeList nodeList = new Parser(rs).parse(new HasAttributeFilter("id", "listForm:list"));
				TableTag tt = (TableTag) nodeList.elementAt(0);
				if (tt != null) {
					TableRow[] rows = tt.getRows();
					if (rows.length > 2) {
						for (int i = 2; i < rows.length; i++) {
							TableColumn[] cols = rows[i].getColumns();
							String zdy = cols[3].toPlainTextString();
							String v = cols[5].toPlainTextString();
							if ("直流电压".equals(zdy) && "V".equals(v)) {
								voltage = cols[4].toPlainTextString();
								break;
							}
						}
					} else {
						NodeList nl = new Parser(rs).parse(new AndFilter(new NodeFilter[] { new TagNameFilter("span"), new HasAttributeFilter("id", "_ajax:data") }));
						if (nl.size() > 0) {
							String ssss = nl.elementAt(0).getFirstChild().getText().replaceAll("!\\[CDATA\\[\\s\\'|\\'\\s\\]\\]", "");
							ssss = StringEscapeUtils.unescapeJava(ssss);
							if (ssss.contains("该设备未关联FSU")) {
								return QueryResult.NOFSUREL.getValue();
							} else if (ssss.contains("FSU出现故障")) {
								return QueryResult.FSUERROR.getValue();
							} else {
								return QueryResult.NODATA.getValue();
							}
						}
					}
				} else {
					return QueryResult.NODATA.getValue();
				}
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		} else {
			return QueryResult.NOBATTERY.getValue();
		}
		AppLogger.sysDebug("queryVoltageRT:" + range + " stationsid:" + stationsid + " did:" + did + " voltage:" + voltage);
		return voltage;
	}

	public static String formatVoltage(String v) throws ServiceException {
		String voltageStr = v;
		try {
			if (!v.matches(QueryResult.getAllStrRegx())) {
				try {
					voltageStr = String.valueOf(FormatUtil.formatNumber(Double.parseDouble(v), 2));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return voltageStr;
	}

	public FormParm getBillListFP() throws ServiceException {
		FormParm formParm = null;
		if (billListFP != null) {
			formParm = billListFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?id=\"queryForm1:btn1\".*?value=\"查询\".*?/>";
			int time = 0;
			do {
				try {
					formParm = getFormParm(URL_BILLLIST, buttonRegex, "queryForm1", "exportExcelPanelContentTable");
					billListFP = formParm;
					break;
				} catch (Exception e) {
					AppLogger.sysDebug("发生错误，重试请求");
					AppLogger.sysError(e.getMessage());
					time++;
					if (time < RETRY_TIME) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
						}
						continue;
					} else {
						throw new ServiceException(e);
					}
				}
			} while (time < RETRY_TIME);
		}
		return formParm;
	}

	public FormParm getAlarmFP() throws ServiceException {
		if (alarmFP != null) {
			return alarmFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?value=\"查询\".*?/>";
			return alarmFP = getFormParm(URL_LISTALARM, buttonRegex);
		}
	}

	public FormParm getTdSiteVFP() throws ServiceException {
		if (tdSiteVFP != null) {
			return tdSiteVFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?value=\"查询\".*?/>";
			return tdSiteVFP = getFormParm(URL_POWERREALDATA, buttonRegex);
		}
	}

	public FormParm getPerfFP() throws ServiceException {
		FormParm formParm = null;
		if (perfFP != null) {
			formParm = perfFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?value=\"查询\".*?/>";
			int time = 0;
			do {
				try {
					formParm = getFormParm(URL_PERFDATA, buttonRegex);
					perfFP = formParm;
					break;
				} catch (Exception e) {
					AppLogger.sysDebug("发生错误，重试请求");
					AppLogger.sysError(e.getMessage());
					time++;
					if (time < RETRY_TIME) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
						}
						continue;
					} else {
						throw new ServiceException(e);
					}
				}
			} while (time < RETRY_TIME);
		}
		return formParm;
	}

	public FormParm getNetListSiteFP() throws ServiceException {
		if (netlistSiteFP != null) {
			return netlistSiteFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?value=\"查询\".*?/>";
			return netlistSiteFP = getFormParm(URL_NETLISTSITE, buttonRegex);
		}
	}

	public FormParm getSiteListSiteFP() throws ServiceException {
		if (sitelistSiteFP != null) {
			return sitelistSiteFP;
		} else {
			String buttonRegex = "/><input class=\"rich-button\".*?value=\"查询\".*?/>";
			return sitelistSiteFP = getFormParm(URL_SITELISTSITE, buttonRegex);
		}
	}

	public FormParm getlistFSUFP() throws ServiceException {
		if (listfsuFP != null) {
			return listfsuFP;
		} else {
			String buttonRegex = "/><input class=\"rich-button\".*?value=\"查询\".*?/>";
			return listfsuFP = getFormParm(URL_LISTFSU, buttonRegex);
		}
	}

	public FormParm getRealTimeperfFP() throws ServiceException {
		FormParm formParm = null;
		if (realTimeperFP != null) {
			formParm = realTimeperFP;
		} else {
			String buttonRegex = "<input class=\"rich-button\".*?value=\"获取实时性能\".*?/>";
			int time = 0;
			do {
				try {
					formParm = getFormParm(URL_RTDATA, buttonRegex);
					realTimeperFP = formParm;
					break;
				} catch (Exception e) {
					AppLogger.sysDebug("发生错误，重试请求");
					// AppLogger.sysError(e.getMessage());
					time++;
					if (time < RETRY_TIME) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
						}
						continue;
					} else {
						throw new ServiceException(e);
					}
				}
			} while (time < RETRY_TIME);
		}
		return formParm;
	}

	public List<FSUMonitorModel> listFSUOffline(String range) throws ServiceException {
		return listFSU(range, 0);
	}

	/**
	 * FSU监控 查询范围为“站址状态”为“交维、检修”的基站。 注册状态 0-离线 1-在线 2-割接 站址状态 7-存量监控 1-工程 2-交维
	 * 3-退网下线 6-测试 8-检修
	 * 
	 * @param range
	 * @return
	 * @throws ServiceException
	 */
	public List<FSUMonitorModel> listFSU(String range, int status) throws ServiceException {
		AppLogger.sysDebug("listFSU: " + range);
		List<FSUMonitorModel> fsuMonitorList = new ArrayList<FSUMonitorModel>();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		headers.put("Host", ITOWER_HOST);
		headers.put("Origin", ITOWER_SYS_URL);
		headers.put("Referer", new StringBuilder(URL_LISTFSU).append("?tabId=tab_billList_5").toString());

		FormParm formParm = getlistFSUFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:queryFlag", "queryFlag");
		// 注册状态 0-离线 1-在线 2-割接
		formMap.put("queryForm:registstatusText_hiddenValue", String.valueOf(status));
		// 站址状态 7-存量监控 1-工程 2-交维 3-退网下线 6-测试 8-检修
		formMap.put("queryForm:queryStaStatusSelId_hiddenValue", "2,8");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "9999");
		formMap.put("queryForm", "queryForm");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			rs = RequestHelper.request(URL_LISTFSU, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "queryForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						String siteNamehrefText = cols[3].getChildrenHTML();
						Pattern p2 = Pattern.compile("(.*?)javascript:showStationDetail\\('(.*?),(.*?)");
						Matcher m2 = p2.matcher(siteNamehrefText);
						String stationId = m2.find() ? m2.group(2) : "";
						String stationName = cols[3].toPlainTextString();
						String stationCode = cols[4].toPlainTextString();
						String fsuCorp = cols[8].toPlainTextString();
						String charge = cols[16].toPlainTextString();
						String chargePhone = cols[17].toPlainTextString();
						String regTime = cols[21].getChild(1).getFirstChild() == null ? "" : cols[21].getChild(1).getFirstChild().getText();
						String offlineTime = cols[22].getChild(1).getFirstChild() == null ? "" : cols[22].getChild(1).getFirstChild().getText();
						String stationStatus = cols[28].toPlainTextString();
						String stationFrom = cols[29].toPlainTextString();
						// AppLogger.sysDebug(stationId + "|" + stationName +
						// "|" + stationCode + "|" + fsuCorp + "|" + charge +
						// "|" + chargePhone + "|" + regTime + "|" + offlineTime
						// + "|"
						// + stationStatus + "|" + stationFrom);
						FSUMonitorModel model = new FSUMonitorModel();
						model.setStationId(stationId);
						model.setStationName(stationName);
						model.setStationCode(stationCode);
						model.setFsuCorp(fsuCorp);
						model.setCharge(charge);
						model.setChargePhone(chargePhone);
						model.setRegTime(StringUtils.isEmpty(regTime) ? new Date() : FormatUtil.parseDate(fdf, regTime));
						model.setOfflineTime(StringUtils.isEmpty(offlineTime) ? new Date() : FormatUtil.parseDate(fdf, offlineTime));
						model.setStationStatus(stationStatus);
						model.setStationFrom(stationFrom);
						fsuMonitorList.add(model);
					}
				}
			} else {
				// tt=null 可能是JSF viewstate已失效，重新请求formParm
				listfsuFP = null;
				// TODO:其他原因tt=null 可能引起死循环，目前未发现
				// fsuMonitorList = listFSU(range);
			}
		} catch (Exception e) {
			listfsuFP = null;
			throw new ServiceException(e);
		}
		return fsuMonitorList;
	}

	public MonitorMapBean queryMonitorMap() {
		AppLogger.sysDebug("queryMonitorMap");
		MonitorMapBean bean = null;
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		headerMap.put("Accept-Encoding", "gzip, deflate");
		headerMap.put("Accept-Language", "zh-CN,zh;q=0.8");
		headerMap.put("Connection", "keep-alive");
		headerMap.put("Cookie", currentCookie);
		headerMap.put("User-Agent", USER_AGENT);
		headerMap.put("Host", ITOWER_HOST);
		headerMap.put("Origin", ITOWER_SYS_URL);
		headerMap.put("Referer", URL_MONITORMAP);

		String viewState = "";
		String j_id = "";
		String groupingId = "";
		BufferedReader reader = null;
		try {
			URL urlSend = new URL(URL_MONITORMAP);
			HttpURLConnection conSend = (HttpURLConnection) urlSend.openConnection();
			conSend.setDoInput(true);
			conSend.setRequestMethod(RequestHelper.METHOD_GET);
			if (headerMap != null && headerMap.size() > 0) {
				for (Entry<String, String> e : headerMap.entrySet()) {
					conSend.setRequestProperty(e.getKey(), e.getValue());
				}
			}
			reader = new BufferedReader(new InputStreamReader(conSend.getInputStream(), DEFAULT_CHARSET));
			String line = "";
			Pattern p1 = Pattern.compile(JSF_VIEWSTATE_PATTERN);
			Pattern p2 = Pattern.compile("showWorkBenchTitle=function\\(\\)\\{A4J.AJAX.Submit\\('(.*?)',null,\\{'similarityGroupingId':'(.*?)','parameters':\\{'(.*?)'\\} \\} \\)\\};");

			while ((line = reader.readLine()) != null) {
				Matcher m1 = p1.matcher(line);
				Matcher m2 = p2.matcher(line);
				if (m1.find()) {
					InputTag tag = (InputTag) new Parser(m1.group()).elements().nextNode();
					viewState = tag.getAttribute("value");
				}
				if (m2.find()) {
					j_id = m2.group(1);
					groupingId = m2.group(2);
				}
			}
			Map<String, String> formMap = new HashMap<String, String>();
			formMap.put("AJAXREQUEST", "_viewRoot");
			formMap.put(j_id, j_id);
			formMap.put("javax.faces.ViewState", viewState);
			formMap.put(groupingId, groupingId);
			String rs = RequestHelper.request(URL_MONITORMAP, RequestHelper.METHOD_POST, headerMap, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);

			Parser parser = new Parser(rs);
			NodeList nList = parser.parse(new HasAttributeFilter("id", "numListForm"));

			if (nList != null && nList.size() > 0) {
				TableTag table = (TableTag) nList.elementAt(0).getFirstChild();
				bean = new MonitorMapBean();
				bean.setSumStation(getMonitorText(table, 2, 0));
				bean.setDeliveredStation(getMonitorText(table, 2, 1));
				// bean.setFsuOnline(getMonitorText(table, 2, 2));
				bean.setActiveAlarm(getMonitorText(table, 2, 2));
				bean.setDzAlarm(getMonitorText(table, 2, 3));
				bean.setTdAlarm(getMonitorText(table, 2, 4));
				bean.setWdAlarm(getMonitorText(table, 2, 5));
				bean.setNrOrder(getMonitorText(table, 2, 6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AppLogger.sysDebug("MonitorMapBean:" + ToStringBuilder.reflectionToString(bean));
		return bean;
	}

	@Data
	@AllArgsConstructor
	class FormParm {
		private String viewState;
		private String j_id;
		private Map<String, String> exportExcelFormMap;

		/**
		 * @param viewState
		 * @param j_id
		 */
		public FormParm(String viewState, String j_id) {
			super();
			this.viewState = viewState;
			this.j_id = j_id;
		}

	}

	public FormParm getFormParm(String url, String buttonRegex, String formName, String exportTabelId) throws ServiceException {
		String viewState = "";
		String j_id = "";
		BufferedReader reader = null;
		FormParm fp = null;
		try {
			URL urlSend = new URL(url);
			HttpURLConnection conSend = (HttpURLConnection) urlSend.openConnection();
			conSend.setDoInput(true);
			conSend.setRequestMethod(RequestHelper.METHOD_GET);
			conSend.setRequestProperty("Cookie", currentCookie);

			reader = new BufferedReader(new InputStreamReader(conSend.getInputStream(), DEFAULT_CHARSET));
			String line = "";
			Pattern p1 = Pattern.compile(JSF_VIEWSTATE_PATTERN);
			Pattern p2 = Pattern.compile(buttonRegex);
			boolean p1find = false;

			StringBuffer tempHtml = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				line = StringEscapeUtils.unescapeHtml(line);
				tempHtml.append(line);
				if (!p1find) {
					Matcher m1 = p1.matcher(line);
					if (m1.find()) {
						InputTag tag = (InputTag) new Parser(m1.group()).elements().nextNode();
						viewState = tag.getAttribute("value");
						p1find = true;
					}
				}
				Matcher m2 = p2.matcher(line);
				if (m2.find() && p1find) {
					Pattern p3 = Pattern.compile("'implicitEventsQueue':'" + formName + ":j_id\\d+'");
					Matcher m3 = p3.matcher(m2.group());
					while (m3.find()) {
						j_id = m3.group().replaceAll("'implicitEventsQueue':'|'", "");
						break;
					}
				}
			}
			if (StringUtils.isNotEmpty(viewState) && StringUtils.isNotEmpty(j_id)) {
				fp = new FormParm(viewState, j_id);
				if (StringUtils.isNotEmpty(exportTabelId)) {
					// 取导出excel对话框表单提交参数
					Map<String, String> exportExcelFormMap = new HashMap<String, String>();
					Parser htmlParser = new Parser(tempHtml.toString());
					NodeList nodeList = htmlParser.parse(new AndFilter(new NodeFilter[] { new TagNameFilter("form"),
							new HasParentFilter(new AndFilter(new NodeFilter[] { new TagNameFilter("table"), new HasAttributeFilter("id", exportTabelId) }), true) }));
					FormTag exportForm = (FormTag) nodeList.elementAt(0);
					NodeList formInputs = exportForm.getFormInputs();
					for (SimpleNodeIterator it = formInputs.elements(); it.hasMoreNodes();) {
						InputTag input = (InputTag) it.nextNode();
						exportExcelFormMap.put(input.getAttribute("name"), input.getAttribute("value"));
					}
					fp.setExportExcelFormMap(exportExcelFormMap);
				}
			} else {
				throw new ServiceException();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		AppLogger.sysDebug(url + " " + ToStringBuilder.reflectionToString(fp, ToStringStyle.SHORT_PREFIX_STYLE));
		return fp;
	}

	public FormParm getFormParm(String url, String buttonRegex, String formName) throws ServiceException {
		return getFormParm(url, buttonRegex, formName, null);
	}

	public FormParm getFormParm(String url, String buttonRegex) throws ServiceException {
		return getFormParm(url, buttonRegex, DEFAULT_FORMNAME);
	}

	private int getMonitorText(TableTag table, int rowIndex, int colIndex) {
		return Integer.parseInt(table.getRow(rowIndex).getColumns()[colIndex].getFirstChild().getFirstChild().getText());
	}

	public StaAgtStaff getStaAgtStaffByCode(String range, String stationCode) {
		AppLogger.sysDebug("getStaAgtStaffByCode:" + stationCode);
		StaAgtStaff staStaff = null;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		FormParm formParm = getSiteListSiteFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:queryFlag1", "queryFlag1");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:j_id50", stationCode);
		formMap.put("queryForm:querystatusSelid_hiddenValue", "");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "20");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			rs = RequestHelper.request(URL_SITELISTSITE, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					staStaff = new StaAgtStaff();
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						String agstaffname = cols[15].getChild(1).toPlainTextString();
						String agstafftel = cols[16].getChild(1).toPlainTextString();
						staStaff.setAgstaffname(agstaffname);
						staStaff.setAgstafftel(agstafftel);
						staStaff.setStationcode(stationCode);
					}
				}
			} else {
				sitelistSiteFP = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staStaff;
	}

	public ItStation getStationByCode(String range, String stationCode) {
		AppLogger.sysDebug("getStationByCode:" + stationCode);
		ItStation site = null;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		FormParm formParm = getNetListSiteFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:j_id14", stationCode);
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "20");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			rs = RequestHelper.request(URL_NETLISTSITE, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					site = new ItStation();
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						String stationName = cols[2].getChild(1).toPlainTextString();
						String stationSysCode = cols[4].getChild(1).toPlainTextString();
						String province = ((Tag) cols[5].getChild(1)).getAttribute("title");
						String city = ((Tag) cols[6].getChild(1)).getAttribute("title");
						String district = ((Tag) cols[7].getChild(1)).getAttribute("title");
						String lng = cols[8].getChild(1).toPlainTextString();
						String lat = cols[9].getChild(1).toPlainTextString();
						String addr = cols[10].getChild(1).toPlainTextString();
						site.setStationCode(stationCode);
						site.setStationSysCode(stationSysCode);
						site.setStationName(stationName);
						site.setAddress(addr);
						site.setItProvinceId(province);
						site.setItCityId(city);
						site.setItDistrictId(district);
						site.setStatus(1);
						try {
							if (StringUtils.isNotEmpty(lng) && Float.parseFloat(lng) < 1000) {
								site.setLng(lng);
							} else {
								site.setLng("");
							}
						} catch (NumberFormatException e) {
							site.setLng("");
						}
						try {
							if (StringUtils.isNotEmpty(lat) && Float.parseFloat(lat) < 1000) {
								site.setLat(lat);
							} else {
								site.setLat("");
							}
						} catch (NumberFormatException e) {
							site.setLat("");
						}
					}
				}
			} else {
				netlistSiteFP = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AppLogger.sysDebug(ToStringBuilder.reflectionToString(site, ToStringStyle.SHORT_PREFIX_STYLE));
		return site;
	}

	public List<StationNew> getStations(String range) {
		// queryForm:querystatusSelid_hiddenValue:2,8
		// AppLogger.sysDebug("getStations:" + range);
		List<StationNew> list = new ArrayList<StationNew>();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		FormParm formParm = getNetListSiteFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:unitHidden", range);

		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "9999");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			rs = RequestHelper.request(URL_NETLISTSITE, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {

					for (int i = 2; i < rows.length; i++) {
						StationNew site = new StationNew();
						TableColumn[] cols = rows[i].getColumns();
						String queryIndex = cols[1].toPlainTextString();
						InputTag tag = (InputTag) cols[0].getChild(1);
						String stationSysId = tag.getAttribute("value");
						String stationName = cols[2].toPlainTextString();
						String stationCode = cols[3].toPlainTextString();
						String stationStatus = cols[10].toPlainTextString();
						String stationType = cols[13].toPlainTextString();
						String province = ((Tag) cols[4].getChild(1)).getAttribute("title");
						String city = ((Tag) cols[5].getChild(1)).getAttribute("title");
						String district = ((Tag) cols[6].getChild(1)).getAttribute("title");
						String lng = cols[7].toPlainTextString();
						String lat = cols[8].toPlainTextString();
						String addr = cols[9].toPlainTextString();
						// site.setStationsyscode(stationsyscode);
						site.setQueryIndex(queryIndex);
						site.setStationSysId(stationSysId);
						site.setStationCode(stationCode);
						site.setStationName(stationName);
						site.setStationAddr(addr);
						site.setStationStatus(stationStatus);
						site.setStationType(stationType);
						site.setItProvinceId(province);
						site.setItCityId(city);
						site.setItDistrictId(district);

						try {
							if (StringUtils.isNotEmpty(lng) && Float.parseFloat(lng) < 1000) {
								site.setLng(Float.parseFloat(lng));
							} else {
								site.setLng(0);
							}
						} catch (NumberFormatException e) {
							site.setLng(0);
						}
						try {
							if (StringUtils.isNotEmpty(lat) && Float.parseFloat(lat) < 1000) {
								site.setLat(Float.parseFloat(lat));
							} else {
								site.setLat(0);
							}
						} catch (NumberFormatException e) {
							site.setLat(0);
						}
						list.add(site);

					}
				}
			} else {
				netlistSiteFP = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AppLogger.sysDebug("getStations():" + range + " count:" + list.size());
		return list;
	}

	public List<ItStation> getStationByName(String range, String name) {
		AppLogger.sysDebug("getStationByName:" + name);
		List<ItStation> list = new ArrayList<ItStation>();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);
		FormParm formParm = getNetListSiteFP();

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		formMap.put("queryForm:unitHidden", range);
		formMap.put("queryForm:j_id10", name);
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "999");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		String rs;
		try {
			rs = RequestHelper.request(URL_NETLISTSITE, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {

					for (int i = 2; i < rows.length; i++) {
						ItStation site = new ItStation();
						TableColumn[] cols = rows[i].getColumns();
						String stationCode = cols[3].getChild(1).toPlainTextString();
						String province = ((Tag) cols[4].getChild(1)).getAttribute("title");
						String city = ((Tag) cols[5].getChild(1)).getAttribute("title");
						String district = ((Tag) cols[6].getChild(1)).getAttribute("title");
						String lng = cols[7].getChild(1).toPlainTextString();
						String lat = cols[8].getChild(1).toPlainTextString();
						String addr = cols[9].getChild(1).toPlainTextString();
						site.setStationCode(stationCode);
						site.setStationName(name);
						site.setAddress(addr);
						site.setItProvinceId(province);
						site.setItCityId(city);
						site.setItDistrictId(district);
						site.setStatus(1);
						try {
							if (StringUtils.isNotEmpty(lng) && Float.parseFloat(lng) < 1000) {
								site.setLng(lng);
							} else {
								site.setLng("");
							}
						} catch (NumberFormatException e) {
							site.setLng("");
						}
						try {
							if (StringUtils.isNotEmpty(lat) && Float.parseFloat(lat) < 1000) {
								site.setLat(lat);
							} else {
								site.setLat("");
							}
						} catch (NumberFormatException e) {
							site.setLat("");
						}
						list.add(site);
						AppLogger.sysDebug(ToStringBuilder.reflectionToString(site, ToStringStyle.SHORT_PREFIX_STYLE));
					}
				}
			} else {
				netlistSiteFP = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<StationDevice> getDevicebyStationSysId(String stationSysId) throws Exception {
		FormParm formParm = getPerfFP();
		if (formParm == null) {
			Thread.sleep(1000);
			return getDevicebyStationSysId(stationSysId);
		}
		List<StationDevice> list = new ArrayList<StationDevice>();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Cookie", currentCookie);
		headers.put("User-Agent", USER_AGENT);

		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("AJAXREQUEST", "_viewRoot");
		formMap.put("queryForm", "queryForm");
		// 按数据库对应ID查最快 queryForm:aid
		formMap.put("queryForm:aid", stationSysId);
		formMap.put("queryForm:siteProvinceId", "0001928");
		formMap.put("queryForm:showFlag", "1");
		formMap.put("queryForm:queryFlag", "1");
		formMap.put("queryForm:unitHidden1", "0001928");
		formMap.put("queryForm:unitTypeHidden", "");
		formMap.put("queryForm:siteNameId", "");
		formMap.put("queryForm:deviceName", "");
		formMap.put("queryForm:did", "");
		formMap.put("queryForm:midName", "");
		formMap.put("queryForm:mid", "");
		formMap.put("queryForm:queryStationId", "");
		formMap.put("queryForm:queryFsuId", "");
		formMap.put("queryForm:midType", "遥测");
		formMap.put("queryForm:currPageObjId", "1");
		formMap.put("queryForm:pageSizeText", "999");
		formMap.put("queryForm:panelOpenedState", "");
		formMap.put("javax.faces.ViewState", formParm.getViewState());
		formMap.put(formParm.getJ_id(), formParm.getJ_id());
		formMap.put("AJAX:EVENTS_COUNT", "1");
		try {
			String rs = "";
			try {
				rs = RequestHelper.request(URL_PERFDATA, RequestHelper.METHOD_POST, headers, formMap, DEFAULT_CHARSET, DEFAULT_CHARSET);
			} catch (Exception e) {
				perfFP = null;
				return getDevicebyStationSysId(stationSysId);
			}

			Parser p = new Parser(rs);
			NodeList nodeList = p.parse(new HasAttributeFilter("id", "listForm:list"));
			TableTag tt = (TableTag) nodeList.elementAt(0);
			if (tt != null) {
				TableRow[] rows = tt.getRows();
				if (rows.length > 2) {
					for (int i = 2; i < rows.length; i++) {
						TableColumn[] cols = rows[i].getColumns();
						String deviceLinkHtml = cols[3].getChild(1).toHtml();
						String deviceCode = "";
						String deviceName = "";
						Pattern p1 = Pattern.compile("<a href=\"javascript:showPwDetailFunc\\('(.*?)'\\);\">(.*?)</a>");
						Matcher matcher = p1.matcher(deviceLinkHtml);
						if (matcher.find()) {
							deviceCode = matcher.group(1);
							deviceName = matcher.group(2);
						}
						String manufacturer = cols[4].toPlainTextString();
						String model = cols[5].toPlainTextString();
						String point = cols[6].toPlainTextString();
						String time = cols[7].toPlainTextString();
						String actualValue = cols[8].toPlainTextString();
						String units = cols[9].toPlainTextString();
						Date updateTime = StringUtils.isEmpty(time) ? new Date() : FormatUtil.parseDate(fdf, time);
						StationDevice sd = new StationDevice(stationSysId, deviceName, deviceCode, model, manufacturer, point, updateTime, actualValue, units);
						list.add(sd);
					}
				}
			} else {
				perfFP = null;
			}
			// boolean hasFind = false;
			// Pattern p1 = Pattern.compile("<a
			// href=\"javascript:showPwDetailFunc\\('(.*?)'\\);\">(.*?)</a>");
			// Matcher m1 = p1.matcher(rs);
			// listForm:list
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		AppLogger.sysDebug("getDevicebyStationSysId:" + stationSysId + " " + list.size());
		return list;
	}
	// public static void main(String[] args) throws Exception {
	// ItowerImpl itower = new ItowerImpl();
	// currentCookie = "JSESSIONID=C57063F0C85FA5C5E089002EEB5AC014;";
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection con =
	// DriverManager.getConnection("jdbc:mysql://121.197.3.240:3307/itowerdb",
	// "root", "2UeBBrAThS6aGNNRCPJX");
	// Statement st = con.createStatement();
	// ResultSet rs = st.executeQuery("SELECT * FROM station WHERE stationCode
	// =''");
	// PreparedStatement pstmt = con.prepareStatement("update station set
	// stationCode=? where station_id=?");
	// con.setAutoCommit(true);
	// while (rs.next()) {
	// int id = rs.getInt(1);
	// String name = rs.getString(5);
	// List<Station> list = itower.getStationByName("", name);
	// if (list.size() == 1) {
	// Station station = list.get(0);
	// pstmt.setString(1, station.getStationcode());
	// pstmt.setInt(2, id);
	// int ii = pstmt.executeUpdate();
	// System.out.println(name + "|" + station.getStationcode() + "|" + ii);
	// }
	// }
	// //
	// //
	// // //
	// System.out.println(ToStringBuilder.reflectionToString(itower.getStationByCode("",
	// "43051100000032")));
	// pstmt.close();
	// rs.close();
	// st.close();
	// con.close();
	// }
}
