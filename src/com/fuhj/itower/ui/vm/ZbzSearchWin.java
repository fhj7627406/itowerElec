/**
 * 
 */
package com.fuhj.itower.ui.vm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

import com.fuhj.itower.service.StationService;
import com.fuhj.itower.ui.model.LiveStaListModel;
import com.fuhj.itower.ui.model.StaQueryParam;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-11
 */
public class ZbzSearchWin extends SelectorComposer<Component> {
	private StationService stationService;
	@Wire private Listbox staLbx;
	@Wire private Textbox stNameTxt, stCodeTxt;

	@Override public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		stationService = SpringUtil.getBean(StationService.class);
		staLbx.setItemRenderer(new ListitemRenderer<StationModel>() {

			@Override public void render(Listitem item, StationModel data, int index) throws Exception {
				item.setStyle("text-align:center;");
				item.appendChild(new Listcell("" + (index + 1)));
				item.appendChild(new Listcell(data.getProvince()));
				item.appendChild(new Listcell(data.getCity()));
				item.appendChild(new Listcell(data.getDistrict()));
				item.appendChild(new Listcell(data.getStationName()));
				item.appendChild(new Listcell(data.getStationCode()));
				item.setValue(data);
			}
		});
	}

	@Listen("onClick=#searchBtn") public void searchSite(Event event) {
		System.out.println("search");
		StaQueryParam staParm = new StaQueryParam();
		try {
			staLbx.setModel(new LiveStaListModel(stationService, staParm, staLbx.getPageSize()));
			staLbx.setSizedByContent(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
