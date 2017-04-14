/**
 * 
 */
package com.fuhj.itower.ui.vm;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.model.LiveStaListModel;
import com.fuhj.itower.ui.model.StaQueryParam;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-20
 */
public class StaManageVM {

	private StationService stationService;
	@Wire
	private Listbox staLbx;
	@Wire
	private Textbox stNameTxt, stCodeTxt;
	@Getter
	@Setter
	private StationModel selectedSta;
	private Users currentUser = WebAppUtil.getSessionUser();

	public StaManageVM() {

	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		stationService = SpringUtil.getBean(StationService.class);
		staLbx.setItemRenderer(new ListitemRenderer<StationModel>() {

			@Override
			public void render(Listitem item, StationModel data, int index) throws Exception {
				item.setStyle("text-align:center;");
				item.appendChild(new Listcell("" + (index + 1)));
				item.appendChild(new Listcell(data.getProvince()));
				item.appendChild(new Listcell(data.getCity()));
				item.appendChild(new Listcell(data.getDistrict()));
				item.appendChild(new Listcell(data.getStationName()));
				item.appendChild(new Listcell(data.getStationCode()));
				item.appendChild(new Listcell(data.getStationSysCode()));
				item.appendChild(new Listcell(data.getAgstaffname()));
				item.appendChild(new Listcell(data.getAgstafftel()));
				item.appendChild(new Listcell(""));
				item.appendChild(new Listcell(data.getAreaManager()));
				item.appendChild(new Listcell(data.getAreaManagerPhone()));
				item.appendChild(new Listcell(data.getFsuManufactor()));
				item.appendChild(new Listcell(""));
				item.setValue(data);
			}
		});
		staLbx.getPagingChild().setMold("os");
	}

	@Listen("onClick = #queryBtn")
	public void query() {
		// List<ApplicantModel> list = mainService.getApplicant(aname,
		// contactno, period, agegrade, begin, end, loginUser, page,index,);
		final String[] perm = currentUser.getPerm().split(",");

		StaQueryParam staParm = new StaQueryParam(stNameTxt.getValue(), stCodeTxt.getValue());
		staParm.setItCityId(perm[0]);
		try {
			staLbx.setModel(new LiveStaListModel(stationService, staParm, staLbx.getPageSize()));
			staLbx.setSizedByContent(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
