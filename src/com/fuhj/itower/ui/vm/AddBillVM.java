/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Popup;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;

import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.log.AppLogger;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2017-1-5
 */
public class AddBillVM extends AbstractValidator {
	private Component view;
	private ValidationContext vcx;
	private LocationService locationService;
	private GelecService gelecService;
	private StationService stationService;
	private Users currentUser;
	@Getter
	@Setter
	private ITBill bill;
	@Wire
	Listbox provinceLbx, cityLbx, districtLbx, stNameRSLbx, faultSourceLbx;
	@Wire
	Bandbox stNameBdx;
	@Wire
	Textbox stationCodeTxt;
	@Wire
	Button provinceBtn, cityBtn, districtBtn, faultSourceBtn;
	@Getter
	@Setter
	private ITCity defaultCity;

	@Init
	public void init() {
		bill = new ITBill();
		bill.setFaultType("停电");
		locationService = SpringUtil.getBean(LocationService.class);
		gelecService = SpringUtil.getBean(GelecService.class);
		stationService = SpringUtil.getBean(StationService.class);
		currentUser = WebAppUtil.getSessionUser();
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		cityLbxInit();
		districtLbxInit();
		stNameRSLbxInit();
	}

	public void closePopup(Listbox listbox) {
		Popup popup = (Popup) listbox.getParent();
		if (popup != null && popup.isVisible())
			popup.close();
	}

	@Command
	public void provinceonCreate(@BindingParam("target") Component target) {
		if (currentUser != null && StringUtils.isNotEmpty(currentUser.getPerm())) {
			String[] temp = currentUser.getPerm().split(",");
			ITCity city = locationService.getCityById(temp[0]);
			if (city == null) {
				return;
			}
			setDefaultCity(city);
			if (target instanceof Listbox) {
				Listbox lbx = (Listbox) target;
				for (Listitem item : lbx.getItems()) {
					if (item.getValue().equals(city.getItProvinceId())) {
						item.setSelected(true);
						Events.postEvent(Events.ON_SELECT, provinceLbx, null);
						break;
					}
				}
			}
		}
	}

	public void cityLbxInit() {
		cityLbx.setItemRenderer(new ListitemRenderer<ITCity>() {

			@Override
			public void render(Listitem item, ITCity data, int index) throws Exception {
				item.appendChild(new Listcell(data.getCname()));
				item.setValue(data);
				if (index == 0) {
					cityLbx.setSelectedItem(item);
					Events.postEvent(-1, Events.ON_SELECT, cityLbx, null);
				}
				if (getDefaultCity() != null && data.getItCityId().equals(getDefaultCity().getItCityId())) {
					cityLbx.setSelectedItem(item);
					Events.postEvent(-1, Events.ON_SELECT, cityLbx, null);
				}
			}
		});
	}

	public void districtLbxInit() {
		districtLbx.setItemRenderer(new ListitemRenderer<ITDistrict>() {

			@Override
			public void render(Listitem item, ITDistrict data, int index) throws Exception {
				item.appendChild(new Listcell(data.getDname()));
				item.setValue(data);
				if (index == 0) {
					districtLbx.setSelectedItem(item);
					Events.postEvent(-1, Events.ON_SELECT, districtLbx, null);
				}
			}
		});
	}

	public void stNameRSLbxInit() {
		stNameRSLbx.setItemRenderer(new ListitemRenderer<ItStation>() {

			@Override
			public void render(Listitem item, ItStation data, int index) throws Exception {
				item.appendChild(new Listcell(data.getStationName()));
				item.appendChild(new Listcell(data.getStationCode()));
				item.appendChild(new Listcell(data.getOriginId() + ""));
				item.setValue(data);
				// item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
				//
				// @Override
				// public void onEvent(Event event) throws Exception {
				// stNameBdx.close();
				//
				// }
				// });
			}
		});
	}

	@Command
	public void provinceonSelect(@BindingParam("target") Component target) {
		String province = provinceLbx.getSelectedItem().getLabel();
		provinceBtn.setLabel(province);
		getBill().setProvince(province);
		closePopup(provinceLbx);
		List<ITCity> list = locationService.findAllCityByProvinceId(provinceLbx.getSelectedItem().getValue().toString());
		cityLbx.setModel(new SimpleListModel<ITCity>(list));
	}

	@Command
	public void cityonSelect(@BindingParam("target") Component target) {
		ITCity city = cityLbx.getSelectedItem().getValue();
		cityBtn.setLabel(city.getCname());
		getBill().setCity(city.getCname());
		getBill().setItCityId(city.getItCityId());
		closePopup(cityLbx);
		List<ITDistrict> list = locationService.findAllDistrictByCityId(city.getItCityId());
		districtLbx.setModel(new SimpleListModel<ITDistrict>(list));
	}

	@Command
	public void districtonSelect(@BindingParam("target") Component target) {
		ITDistrict district = districtLbx.getSelectedItem().getValue();
		districtBtn.setLabel(district.getDname());
		getBill().setDistrict(district.getDname());
		getBill().setItDistrictId(district.getItDistrictId());
		closePopup(districtLbx);
	}

	@Command
	public void faultSourceLbxonSelect(@BindingParam("target") Component target) {
		closePopup(faultSourceLbx);
		faultSourceBtn.setLabel(faultSourceLbx.getSelectedItem().getLabel());
	}

	@Listen("onQuery=#stNameBdx")
	public void querySTName(Event e) {
		String value = String.valueOf(e.getData());
		if (StringUtils.isNotEmpty(value)) {
			String[] temp = currentUser.getPerm().split(",");
			String itProvinceId = null;
			String itCityId = null;
			ITCity city = locationService.getCityById(temp[0]);
			if (city != null) {
				itProvinceId = city.getItProvinceId();
				if (temp.length == 1) {
					itCityId = city.getItCityId();
				}
			}
			List<ItStation> stations;
			if (NumberUtils.isNumber(value)) {
				stations = stationService.getStations(itProvinceId, itCityId, null, value);
			} else {
				stations = stationService.getStations(itProvinceId, itCityId, value, null);
			}
			stNameRSLbx.setModel(new SimpleListModel<ItStation>(stations));
		}
		Clients.clearBusy(stNameRSLbx);
	}

	@Command
	public void stNameBdxOnChanging(@BindingParam("target") Component target, @BindingParam("e") InputEvent event) {
		if (!(target instanceof Bandbox)) {
			return;
		}
		String value = event.getValue();
		Clients.showBusy(stNameRSLbx, "正在搜索,请稍候...");
		Events.echoEvent("onQuery", stNameBdx, value);
	}

	@Command
	@NotifyChange("selectStation")
	public void stNameRSLbxonSelect(@BindingParam("target") Component target) {
		stNameBdx.close();
		if (stNameRSLbx.getSelectedItem() != null) {
			ItStation station = stNameRSLbx.getSelectedItem().getValue();
			stNameBdx.setRawValue(station.getStationName());
			Events.postEvent(-1, Events.ON_CHANGE, stNameBdx, null);
			stationCodeTxt.setRawValue(station.getStationCode());
			Events.postEvent(-1, Events.ON_CHANGE, stationCodeTxt, null);
		}
	}

	@Command
	public void submit() {
		AppLogger.sysDebug(getBill());
		getBill().setStatus(3);
		getBill().setCreateTime(new Date());
		gelecService.addITBill(getBill());
	}

	@Override
	public void validate(ValidationContext ctx) {
		this.vcx = ctx;
		Object billCode = null, stationName = null, stationCode = null;
		try {
			billCode = ctx.getProperties("billCode")[0].getValue();
			stationName = ctx.getProperties("stationName")[0].getValue();
			stationCode = ctx.getProperties("stationCode")[0].getValue();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		billCode = billCode != null ? billCode.toString() : "";
		if (StringUtils.isEmpty(billCode.toString())) {
			addInvalidMessage(ctx, "key", "工单编码不能为空");
		}

		stationName = stationName != null ? stationName.toString() : "";
		if (StringUtils.isEmpty(stationName.toString())) {
			addInvalidMessage(ctx, "key", "站址名称不能为空");
		}

		stationCode = stationCode != null ? stationCode.toString() : "";
		if (StringUtils.isEmpty(stationCode.toString())) {
			addInvalidMessage(ctx, "key", "站址运维ID不能为空");
		}
	}
}
