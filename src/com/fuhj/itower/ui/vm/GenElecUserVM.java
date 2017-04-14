/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.model.GelecUserModel;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-16
 */
public class GenElecUserVM {
	private Component view;

	private LocationService locationService;
	private GelecService gelecService;

	private Users currentUser = WebAppUtil.getSessionUser();
	@Getter
	@Setter
	private String provinceTxt;
	private String itProvinceId;
	@Wire
	Listbox gElecUserLbx;
	@Wire
	Textbox loginNameTxt, userNameTxt, userPhoneTxt;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;

		locationService = SpringUtil.getBean(LocationService.class);
		gelecService = SpringUtil.getBean(GelecService.class);
		// if (!desktop.isServerPushEnabled()) {
		// desktop.enableServerPush(true);
		// }

		gElecUserLbxInit();
		itProvinceId = getProvinceId(currentUser);
		setProvinceTxt(locationService.getProvinceById(itProvinceId).getPname());
	}

	private String getProvinceId(Users user) {
		String provinceId = "";
		if (user != null && StringUtils.isNotEmpty(user.getPerm())) {
			String[] temp = user.getPerm().split(",");
			ITCity city = locationService.getCityById(temp[0]);
			if (city == null) {
				return "";
			}
			provinceId = city.getItProvinceId();
		}
		return provinceId;
	}

	public void gElecUserLbxInit() {
		gElecUserLbx.setItemRenderer(new ListitemRenderer<GelecUserModel>() {

			@Override
			public void render(Listitem item, GelecUserModel data, int index) throws Exception {
				item.setStyle("text-align:center;");
				item.appendChild(new Listcell(String.valueOf(index + 1)));
				item.appendChild(new Listcell(data.getProvince()));
				item.appendChild(new Listcell(data.getCity()));
				item.appendChild(new Listcell(data.getDistrict()));
				item.appendChild(new Listcell(data.getLoginName()));
				item.appendChild(new Listcell(data.getUserName()));
				item.appendChild(new Listcell(data.getUserPhone()));
				item.appendChild(new Listcell(FormatUtil.getFDate(data.getRegTime())));
				item.appendChild(new Listcell(FormatUtil.getFDate(data.getLastLoginTime())));
				Listcell cell_done = new Listcell();
				A a_done = new A(String.valueOf(data.getDone()));
				cell_done.appendChild(a_done);
				item.appendChild(cell_done);
				Listcell cell_ing = new Listcell();
				A a_ing = new A(String.valueOf(data.getIng()));
				cell_ing.appendChild(a_ing);
				item.appendChild(cell_ing);
				Listcell cell_sum = new Listcell();
				A a_sum = new A(String.valueOf(data.getSum()));
				cell_sum.appendChild(a_sum);
				item.appendChild(cell_sum);
				Label label_status = new Label();
				if (data.getStatus() == 1) {
					label_status.setValue("正常");
					label_status.setSclass("green");
				} else {
					label_status.setValue("");
					label_status.setSclass("red");
				}
				Listcell cell_status = new Listcell();
				cell_status.appendChild(label_status);
				item.appendChild(cell_status);
				item.setValue(data);
			}
		});
		gElecUserLbx.getPagingChild().setMold("os");
	}

	@Command
	public void query() {
		String loginName = loginNameTxt.getRawText();
		String userName = userNameTxt.getRawText();
		String userPhone = userPhoneTxt.getRawText();
		List<GelecUserModel> list = gelecService.getGElecUserByProvince(itProvinceId, loginName, userName, userPhone);
		gElecUserLbx.setModel(new SimpleListModel<GElecUser>(list));
		gElecUserLbx.setSizedByContent(true);
	}

	@Command
	public void resetPwd() {
		if (gElecUserLbx.getSelectedItem() != null) {
			GelecUserModel gelecUserModel = gElecUserLbx.getSelectedItem().getValue();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gElecUser", gelecUserModel);
			Window w = (Window) Executions.createComponents("resetGelecUserPwd.zul", view, map);
			w.setPosition("center");
			w.doModal();
		} else {
			Messagebox.show("请选中一条结果进行操作!", "提示", Messagebox.OK, Messagebox.INFORMATION);
		}
	}
}
