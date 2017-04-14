/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ItemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Selectbox;

import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-27
 */
public class GElecUserRegVM extends AbstractValidator {
	private ValidationContext vcx;

	private LocationService locationService;
	private GelecService gelecService;
	@Getter @Setter private GElecUser regUser = new GElecUser();
	@Wire Selectbox provincesbx, citysbx, districtsbx;
	private Map<Integer, String> provinceIndexMap = new HashMap<Integer, String>();
	private Map<Integer, String> cityIndexMap = new HashMap<Integer, String>();
	private Map<Integer, String> districtIndexMap = new HashMap<Integer, String>();

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		gelecService = SpringUtil.getBean(GelecService.class);
		locationService = SpringUtil.getBean(LocationService.class);
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
	}

	public void provincesbxInit() {
		provincesbx.setItemRenderer(new ItemRenderer<ITProvince>() {
			@Override public String render(Component owner, ITProvince data, int index) throws Exception {
				provinceIndexMap.put(index, data.getItProvinceId());
				return data.getPname() + "分公司";
			}
		});
		provincesbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override public void onEvent(Event event) throws Exception {
				String selectedPId = provinceIndexMap.get(provincesbx.getSelectedIndex());
				cityIndexMap.clear();
				ListModel<ITCity> listModel = new ListModelList<ITCity>(locationService.findAllCityByProvinceId(selectedPId));
				citysbx.setModel(listModel);
			}
		});
	}

	public void citysbxInit() {
		citysbx.setItemRenderer(new ItemRenderer<ITCity>() {
			@Override public String render(Component owner, ITCity data, int index) throws Exception {
				cityIndexMap.put(index, data.getItCityId());
				return data.getCname() + "分公司";
			}
		});
		citysbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override public void onEvent(Event event) throws Exception {
				String selectedCId = cityIndexMap.get(citysbx.getSelectedIndex());
				districtIndexMap.clear();
				ListModel<ITDistrict> listModel = new ListModelList<ITDistrict>(locationService.findAllDistrictByCityId(selectedCId));
				districtsbx.setModel(listModel);
			}
		});
	}

	public void districtsbxInit() {
		districtsbx.setItemRenderer(new ItemRenderer<ITDistrict>() {
			@Override public String render(Component owner, ITDistrict data, int index) throws Exception {
				districtIndexMap.put(index, data.getItDistrictId());
				return data.getDname();
			}
		});
		districtsbx.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
			@Override public void onEvent(Event event) throws Exception {

			}
		});
	}

	@Command public void submitForm() {
		String selectedPId = provinceIndexMap.get(provincesbx.getSelectedIndex());
		String selectedCId = cityIndexMap.get(citysbx.getSelectedIndex());
		String selectedDId = districtIndexMap.get(districtsbx.getSelectedIndex());
		regUser.setItProvinceId(selectedPId);
		regUser.setItCityId(selectedCId);
		regUser.setItDistrictId(selectedDId);
		gelecService.addGElecUser(regUser);
		Executions.sendRedirect("gElec_login.zul");
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.bind.Validator#validate(org.zkoss.bind.ValidationContext)
	 */
	@Override public void validate(ValidationContext ctx) {
		this.vcx = ctx;
		Map<String, Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
		String loginPwd = "";
		try {
			String loginName = beanProps.get("loginName").getValue().toString().trim();
			if (loginName.length() == 0)
				throw new RuntimeException();
			if (!loginName.matches("^[a-zA-Z0-9_]{4,20}$"))
				addInvalidMessage(vcx, "key", "用户名只能包含字母、数字和下划线且4-20字符");
			if (gelecService.checkGelcLoginName(loginName))
				addInvalidMessage(vcx, "key", "用户名已存在");
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写用户名");
		}
		try {
			loginPwd = beanProps.get("loginPwd").getValue().toString().trim();
			if (loginPwd.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写登录密码");
		}
		try {
			String userName = beanProps.get("userName").getValue().toString().trim();
			if (userName.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写真实姓名");
		}
		try {
			String userPhone = beanProps.get("userPhone").getValue().toString().trim();
			if (userPhone.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写手机号码");
		}
		try {
			String loginPwd_c = beanProps.get("tempStr").getValue().toString().trim();
			if (!loginPwd.equals(loginPwd_c))
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "两次密码输入不一致");
		}
		try {
			String selectedPId = provinceIndexMap.get(provincesbx.getSelectedIndex());
			if (selectedPId == null)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请选择省份");
		}
	}
}
