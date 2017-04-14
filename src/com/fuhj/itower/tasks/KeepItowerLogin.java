/**
 * 
 */
package com.fuhj.itower.tasks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ConfigReader;
import com.fuhj.util.SecurityUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.WebWX;
import com.fuhj.weixin.WebWXService;
import com.fuhj.weixin.json.ContactItem;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-17
 */
public class KeepItowerLogin {
	public static boolean isLogin = false;
	public static BufferedImage cbi = null;
	public static Map<String, String> cFristHeader = null;
	static int sum = 0;

	public void execute() {
		AppLogger.sysDebug("KeepItowerLogin execute()");
		try {
			if (SpringUtil.getWebAppPath() == null) {
				return;
			}
			final ItowerImpl itower = new ItowerImpl();
			String cookieValue = MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie");
			if (StringUtils.isNotEmpty(cookieValue)) {
				isLogin = itower.hasLogin(cookieValue);
			}
			if (SecurityUtil.IS_DEBUG) {
				return;
			}
			if (!isLogin) {
				int i = 0;
				boolean autoLoginSuccess = false;
				do {
					if (itower.autoLogin()) {
						autoLoginSuccess = true;
						break;
					}
					Thread.sleep(2000);
				} while (i < 5);
				if (!autoLoginSuccess) {
					WebWXService wxService = WebWXService.getInstance();
					if (wxService.isWebwxStart()) {
						cFristHeader = itower.makeFristHeader();
						cbi = itower.getValidateCode(cFristHeader);

						// 获取登录验证码通过微信发送至管理员
						WebWX webwx = wxService.getWebwx();
						Map<String, ContactItem> contactMap = webwx.getFullContactNickNameMap();
						List<ContactItem> cItems = new ArrayList<ContactItem>();
						cItems.add(contactMap.get("fool喊姜"));
						cItems.add(contactMap.get("陈亮"));
						cItems.add(contactMap.get("曹高"));
						for (ContactItem cItem : cItems) {
							if (cItem != null) {
								webwx.sendTxtMsg(cItem.getUserName(), "与运监系统断开连接，请输入下方验证码尝试重新登陆！");
								webwx.sendImgMsg(cItem.getUserName(), cbi, "jpg");
							}
						}
					}
				}
			} else {
				final LocationService locationService = SpringUtil.getBean(LocationService.class);
				final GelecService gelecService = SpringUtil.getBean(GelecService.class);
				List<ITCity> citys1 = locationService.findAllCityByProvinceId("0001928");// 湖南
				List<ITCity> citys2 = locationService.findAllCityByProvinceId("0098364");// 广西
				final ExecutorService pool = Executors.newSingleThreadExecutor();
				sum = 0;
				for (final ITCity city : citys1) {
					pool.execute(new Runnable() {
						@Override
						public void run() {
							HSSFWorkbook wb = itower.queryItowerBill(city.getItCityId(), "停电");
							if (wb != null) {
								gelecService.addITBillsByXLS("0001928", city.getItCityId(), wb);
								sum += wb.getSheetAt(0).getPhysicalNumberOfRows() - 1;
							}
						}
					});
				}
				for (final ITCity city : citys2) {
					pool.execute(new Runnable() {
						@Override
						public void run() {
							HSSFWorkbook wb = itower.queryItowerBill(city.getItCityId(), "停电");
							if (wb != null) {
								gelecService.addITBillsByXLS("0098364", city.getItCityId(), wb);
								sum += wb.getSheetAt(0).getPhysicalNumberOfRows() - 1;
							}
						}
					});
				}
				// new Thread(new Runnable() {
				//
				// @Override public void run() {
				// while (true) {
				// if (pool.isTerminated()) {
				// AppLogger.sysDebug("共存储:" + sum + "条停电工单");
				// break;
				// }
				// try {
				// Thread.sleep(500);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				// }
				// }
				// }).start();
				pool.shutdown();
			}
			AppLogger.sysDebug("KeepItowerLogin:" + isLogin);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean reLoginItower(String ocr) {
		ItowerImpl itower = new ItowerImpl();
		return isLogin = itower.loginITower(ConfigReader.getProperty("ITOWER_USER"), ConfigReader.getProperty("ITOWER_PWD"), ocr, cFristHeader.get("Cookie"));
	}
}
