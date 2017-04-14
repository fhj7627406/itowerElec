/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Space;

import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.LoginService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.log.AppLogger;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-31
 */
public class PermVM {
	private Component view;
	private LoginService loginService;
	private LocationService locationService;
	@Wire Listbox queryRangeLbx;
	Users currentUser = WebAppUtil.getSessionUser();

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		loginService = SpringUtil.getBean(LoginService.class);
		locationService = SpringUtil.getBean(LocationService.class);
		queryRangeLbxInit();
	}

	public void queryRangeLbxInit() {
		ITProvince itp = locationService.getProvinceById("0001928");
		List<ITCity> citys = locationService.findAllCityByProvinceId(itp.getItProvinceId());
		queryRangeLbx.setItemRenderer(new ListitemRenderer<ITCity>() {

			@Override public void render(Listitem item, ITCity data, int index) throws Exception {
				Listcell cell = new Listcell();
				Space sp = new Space();
				sp.setHeight("3px");
				cell.appendChild(sp);
				cell.appendChild(new Label(data.getCname()));
				item.appendChild(cell);
				if (currentUser.getPerm().contains(data.getItCityId())) {
					item.setSelected(true);
				}
				item.setValue(data);
			}
		});
		queryRangeLbx.setModel(new SimpleListModel<ITCity>(citys));
		queryRangeLbx.setCheckmark(true);
		queryRangeLbx.setMultiple(true);
	}

	@Command public void save() {
		Set<Listitem> set = queryRangeLbx.getSelectedItems();
		if (set.size() == 0) {
			Messagebox.show("请至少选择一项进行保存!", "提示", Messagebox.OK, Messagebox.EXCLAMATION);
			return;
		}
		StringBuffer permSB = new StringBuffer();
		for (Listitem listitem : set) {
			ITCity city = listitem.getValue();
			permSB.append(city.getItCityId()).append(",");
		}
		permSB.deleteCharAt(permSB.length() - 1);
		String perm = permSB.toString();
		AppLogger.sysDebug("save perm:" + perm);
		loginService.modifyUserPerm(currentUser.getId(), perm);
		currentUser.setPerm(perm);
		Messagebox.show("保存成功!", "成功", Messagebox.OK, Messagebox.INFORMATION);
	}
}
