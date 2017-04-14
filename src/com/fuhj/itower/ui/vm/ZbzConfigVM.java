/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.model.ZbzItem;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.model.StaQueryParam;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-10
 */
public class ZbzConfigVM {
	private StationService stationService;

	private LocationService locationService;
	private Component view;
	@Wire private Combobox provinceCmb, cityCmb, districtCmb;
	private ITProvince province = null;
	private Users sessionUser = null;

	public ZbzConfigVM() {

	}

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		sessionUser = WebAppUtil.getSessionUser();
		stationService = SpringUtil.getBean(StationService.class);
		locationService = SpringUtil.getBean(LocationService.class);
		province = locationService.getProvinceById("0001928");
		provinceCmbInit();
		cityCmbInit();
		districtCmbInit();
	}

	@Command public void configBtnOnclick() {
		ItowerImpl itower = new ItowerImpl();
		// Component comp = Executions.getCurrent().getDesktop().getPage("mainPage").getFellowIfAny("zbzSearchWin");
		// if (comp != null) {
		// return;
		// } else {
		// Window w = (Window) Executions.createComponents("zbz_search.zul", view, null);
		// w.setPosition("center");
		// w.doModal();
		// }
		try {
			String[][] data = ExcelUtil.readSheet("C:\\Users\\fu\\Desktop\\湖南代维\\广西站点\\贺州站址清单.xls", "Sheet1", 1);
			for (int i = 1; i < data.length; i++) {
				String siteName = data[i][3];
				String siteCode = data[i][5];
				StaQueryParam param = new StaQueryParam();
				param.setItCityId("0099990");
				if (StringUtils.isEmpty(siteCode)) {
					System.out.println(siteName + "|" + siteCode + "|站点编码为空");
				} else {
					// param.setStName(siteName);
					param.setStCode(siteCode);
					List<StationModel> list = stationService.getStations(param, 0, 10);
					if (list.size() == 0) {
						System.out.println(siteName + "|" + siteCode + "|未找到对应编码的站点");
						ItStation s = itower.getStationByCode("0099990", siteCode);
						if (s != null) {
							stationService.addStation(s);
							StaAgtStaff sas = itower.getStaAgtStaffByCode("0099990", siteCode);
							if (sas != null) {
								System.out.println(ToStringBuilder.reflectionToString(sas));
								stationService.addStaAgtStaff(sas);
							}
						}
					} else if (list.size() == 1) {
						StationModel stationModel = list.get(0);
						ZbzItem item = new ZbzItem();
						item.setItProvinceId(stationModel.getItProvinceId());
						item.setItCityId(stationModel.getItCityId());
						item.setItDistrictId(stationModel.getItDistrictId());
						item.setStationId(stationModel.getItStationId());
						item.setUpdateUser(sessionUser.getId());
						item.setUpdateTime(new Date());
						item.setStatus(1);
						stationService.addZbzItem(item);
					} else {
						System.out.println(siteName + "|" + siteCode + "|many");
					}
				}
			}
			System.out.println("end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void provinceCmbInit() {
		provinceCmb.setItemRenderer(new ComboitemRenderer<ITProvince>() {

			@Override public void render(Comboitem item, ITProvince data, int index) throws Exception {
				item.setLabel(data.getPname());
				item.setValue(data);
				provinceCmb.setSelectedItem(item);
			}
		});
		provinceCmb.setModel(new ListModelList<ITProvince>(new ITProvince[] { province }));

	}

	private void cityCmbInit() {
		cityCmb.setItemRenderer(new ComboitemRenderer<ITCity>() {

			@Override public void render(Comboitem item, ITCity data, int index) throws Exception {
				item.setLabel(data.getCname());
				String[] permArray = sessionUser.getPerm().split(",");
				if (data.getItCityId().equals(permArray[0])) {
					cityCmb.setSelectedItem(item);
				}
				item.setValue(data);
			}
		});
		List<ITCity> citys = locationService.findAllCityByProvinceId(province.getItProvinceId());
		cityCmb.setModel(new ListModelList<ITCity>(citys));
	}

	private void districtCmbInit() {
		districtCmb.setItemRenderer(new ComboitemRenderer<ITDistrict>() {

			@Override public void render(Comboitem item, ITDistrict data, int index) throws Exception {
				item.setLabel(data.getDshortname());
				item.setValue(data);
			}
		});

	}
}
