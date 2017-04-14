/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ItemRenderer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Vlayout;

import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-14
 */
public class GElecIndexVM {

	private LocationService locationService;
	private GelecService gelecService;
	private GElecUser current_gelec_user;
	@Wire
	Selectbox provincesbx, citysbx, districtsbx;
	@Wire
	Label help_p, help_c, help_d, help_t;
	@Wire
	Listbox itBillLbx;
	@Wire
	Grid itBillGrid;
	@Wire
	Bandbox keyworkbdx;
	private Map<Integer, String> provinceIndexMap = new HashMap<Integer, String>();
	private Map<Integer, String> cityIndexMap = new HashMap<Integer, String>();
	private Map<Integer, String> districtIndexMap = new HashMap<Integer, String>();

	public GElecIndexVM() {
		locationService = SpringUtil.getBean(LocationService.class);
		gelecService = SpringUtil.getBean(GelecService.class);
		WebAppUtil.setElecPageTitle("当前停电工单查询");
		Object obj = WebAppUtil.getWebSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY);
		if (obj != null) {
			current_gelec_user = (GElecUser) obj;
			// GElecInfo geiInProgress = gelecService.getGEIInProgress(current_gelec_user.getGelecUserId());
			// if (geiInProgress != null) {
			// ITBill itBill = gelecService.getITBillById(geiInProgress.getItBillId());
			// geiInProgress.setTempObject(itBill);
			// WebAppUtil.setWebSessionAttribute("gElecInfo", geiInProgress);
			// Executions.sendRedirect("gElec_detail.zul");
			// }
		} else {
			Executions.sendRedirect("gelogin.zul");
		}
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);

		ITProvince p1 = locationService.getProvinceById("0001928");
		ITProvince p2 = locationService.getProvinceById("0098364");
		List<ITProvince> list = new ArrayList<ITProvince>();
		list.add(p1);
		list.add(p2);
		ListModel<ITProvince> listModel = new ListModelList<ITProvince>(list);
		provincesbxInit();
		citysbxInit();
		districtsbxInit();
		provincesbx.setModel(listModel);

		itBillLbx.setItemRenderer(new ListitemRenderer<ITBill>() {

			@Override
			public void render(Listitem item, ITBill data, int index) throws Exception {
				item.appendChild(new Listcell(String.valueOf(index + 1)));
				Listcell cell = new Listcell();
				Vlayout vl = new Vlayout();
				vl.setSpacing("5px");
				Label bCodeLbl=new Label(data.getBillCode());
				bCodeLbl.setSclass("pull-left");
				bCodeLbl.setStyle("font-size:12px;width:100%;color:#8E8E8E");
				Label bDetailLbl=new Label(data.getAlarmDetail());
				bDetailLbl.setSclass("pull-left");
				bDetailLbl.setStyle("font-size:12px;color:#8E8E8E");
				Label stNameLbl=new Label(data.getStationName());
				stNameLbl.setStyle("font-size:14px");
				vl.appendChild(stNameLbl);
				vl.appendChild(bCodeLbl);
				vl.appendChild(bDetailLbl);
				cell.appendChild(vl);
				item.appendChild(cell);
				item.setValue(data);
			}
		});
	}

	public void provincesbxInit() {
		provincesbx.setItemRenderer(new ItemRenderer<ITProvince>() {
			@Override
			public String render(Component owner, ITProvince data, int index) throws Exception {
				String pid = data.getItProvinceId();
				provinceIndexMap.put(index, pid);
				if (current_gelec_user != null && pid.equals(current_gelec_user.getItProvinceId())) {
					provincesbx.setSelectedIndex(index);
					Events.postEvent(-1, new Event(Events.ON_SELECT, provincesbx));
				}
				return data.getPname();
			}
		});
		provincesbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				help_p.setValue("");
				String selectedPId = provinceIndexMap.get(provincesbx.getSelectedIndex());
				cityIndexMap.clear();
				ListModel<ITCity> listModel = new ListModelList<ITCity>(locationService.findAllCityByProvinceId(selectedPId));
				citysbx.setModel(listModel);
			}
		});
	}

	public void citysbxInit() {
		citysbx.setItemRenderer(new ItemRenderer<ITCity>() {
			@Override
			public String render(Component owner, ITCity data, int index) throws Exception {
				String cid = data.getItCityId();
				cityIndexMap.put(index, cid);
				if (current_gelec_user != null && cid.equals(current_gelec_user.getItCityId())) {
					citysbx.setSelectedIndex(index);
					Events.postEvent(-1, new Event(Events.ON_SELECT, citysbx));
				}
				return data.getCname();
			}
		});
		citysbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				help_c.setValue("");
				String selectedCId = cityIndexMap.get(citysbx.getSelectedIndex());
				districtIndexMap.clear();
				ListModel<ITDistrict> listModel = new ListModelList<ITDistrict>(locationService.findAllDistrictByCityId(selectedCId));
				districtsbx.setModel(listModel);
			}
		});
	}

	public void districtsbxInit() {
		districtsbx.setItemRenderer(new ItemRenderer<ITDistrict>() {
			@Override
			public String render(Component owner, ITDistrict data, int index) throws Exception {
				String did = data.getItDistrictId();
				districtIndexMap.put(index, did);
				if (current_gelec_user != null && did.equals(current_gelec_user.getItDistrictId())) {
					districtsbx.setSelectedIndex(index);
					Events.postEvent(-1, new Event(Events.ON_SELECT, districtsbx));
				}
				return data.getDname();
			}
		});
		districtsbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				help_d.setValue("");
			}
		});
	}

	@Command
	public void nextBtnOnClick() {
		if (itBillLbx.getSelectedItem() != null) {
			ITBill selectedITBill = itBillLbx.getSelectedItem().getValue();
			WebAppUtil.setWebSessionAttribute("selectedITBill", selectedITBill);
			WebAppUtil.getElecIncludePage().setSrc("gestart.zul");
		}
	}

	@Command
	public void queryBtnOnClick() {
		String selectedPId = provinceIndexMap.get(provincesbx.getSelectedIndex());
		String selectedCId = cityIndexMap.get(citysbx.getSelectedIndex());
		String selectedDId = districtIndexMap.get(districtsbx.getSelectedIndex());
		if (selectedPId == null) {
			help_p.setValue("请选择省份");
			provincesbx.focus();
			return;
		}
		if (selectedCId == null) {
			help_c.setValue("请选择城市");
			citysbx.focus();
			return;
		}
		if (selectedDId == null) {
			help_d.setValue("请选择区县");
			districtsbx.focus();
			return;
		}
		String stationNameKeywork = keyworkbdx.getRawText();
		List<ITBill> itBillList = gelecService.getITBill(selectedPId, selectedCId, selectedDId, stationNameKeywork);
		if (itBillList.size() > 0) {
			help_t.setValue("更新时间：" + FormatUtil.getFDate(itBillList.get(0).getCreateTime()));
		} else {
			help_t.setValue("更新时间：" + FormatUtil.getFDate(new Date()));
		}
		itBillLbx.setModel(new SimpleListModel<ITBill>(itBillList));
		itBillLbx.setRows(itBillList.size());

		// Clients.evalJavaScript("jq('.z-listitem').on('touchmove',function(e){e.preventDefault();e.stopPropagation(); var cy=e.targetTouches[0].clientY; var py=e.targetTouches[0].pageY; console.log('clentY:'+cy);console.log('clentY:'+py);});");
	}
}
