/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
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
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import com.fuhj.itower.model.BaseModel;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.export.ExportUtil;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-16
 */
public class GenElecQueryVM {
	private Component view;

	private LocationService locationService;
	private GelecService gelecService;

	private Users currentUser = WebAppUtil.getSessionUser();
	@Wire
	private Listbox tdITBlillLbx;
	@Wire
	private Button areaBtn;
	@Wire
	private Tree areaTree;
	@Wire
	private Popup areapp;

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
		tdITBlillLbxInit();
		areaTreeInit();
	}

	public void tdITBlillLbxInit() {
		tdITBlillLbx.setItemRenderer(new ListitemRenderer<ITBill>() {

			@Override
			public void render(Listitem item, ITBill bill, int index) throws Exception {
				// TODO Auto-generated method stub
				item.setStyle("text-align:center;");
				item.appendChild(new Listcell(String.valueOf(index + 1)));
				// item.appendChild(new Listcell());
				item.appendChild(new Listcell(bill.getCity()));
				item.appendChild(new Listcell(bill.getDistrict()));

				Listcell billCodeCell = new Listcell(bill.getBillCode());
				billCodeCell.setStyle("color:#d53f40;");
				item.appendChild(billCodeCell);

				item.appendChild(new Listcell(bill.getFaultDeviceType()));
				item.appendChild(new Listcell(bill.getAlarmDetail()));
				item.appendChild(new Listcell(bill.getAlarmLevel()));
				item.appendChild(new Listcell(bill.getAlarmStatus()));
				item.appendChild(new Listcell(bill.getBillStatus()));

				A a_asn = new A(bill.getStationName());

				Listcell asncell = new Listcell();
				asncell.appendChild(a_asn);
				item.appendChild(asncell);
				item.appendChild(new Listcell(bill.getStationCode()));
				item.appendChild(new Listcell(FormatUtil.getFDate(bill.getDispatchTime())));
				item.appendChild(new Listcell(FormatUtil.getFDate(bill.getReceiveTime())));
				item.appendChild(new Listcell(FormatUtil.getFDate(bill.getAlarmTime())));
				item.appendChild(new Listcell(bill.getFaultSource()));
				item.appendChild(new Listcell(bill.getAgentsCorp()));
				item.appendChild(new Listcell(bill.getBillDuration()));
				item.appendChild(new Listcell(bill.getReceiveDuration()));
				item.appendChild(new Listcell(bill.getOperator()));
				item.appendChild(new Listcell(bill.getDataOrigin()));
				item.appendChild(new Listcell(bill.getElecConditions()));
				item.appendChild(new Listcell(bill.getFsuManufactor()));
				item.appendChild(new Listcell(bill.getSwitchManufactor()));
				item.appendChild(new Listcell(bill.getIsElecGenerBill()));
				item.setValue(bill);
			}
		});
		tdITBlillLbx.getPagingChild().setMold("os");
	}

	private void areaTreeInit() {
		final String[] perm = currentUser.getPerm().split(",");
		List<TreeNode<BaseModel>> citysNodeList = new ArrayList<TreeNode<BaseModel>>(perm.length);
		for (int i = 0; i < perm.length; i++) {
			ITCity city = locationService.getCityById(perm[i]);
			List<ITDistrict> districts = locationService.findAllDistrictByCityId(perm[i]);
			List<TreeNode<BaseModel>> districtNodeList = new ArrayList<TreeNode<BaseModel>>(districts.size());
			for (ITDistrict district : districts) {
				districtNodeList.add(new DefaultTreeNode<BaseModel>(district));
			}
			citysNodeList.add(new DefaultTreeNode<BaseModel>(city, districtNodeList));
		}

		TreeNode<BaseModel> root = new DefaultTreeNode<BaseModel>(null, citysNodeList);
		areaTree.setModel(new DefaultTreeModel<BaseModel>(root));
		areaTree.setItemRenderer(new
				TreeitemRenderer<DefaultTreeNode<BaseModel>>() {

					@Override
					public void render(final Treeitem item,
							DefaultTreeNode<BaseModel> data, int index) throws Exception {
						BaseModel c = data.getData();
						if (c instanceof ITDistrict) {
							ITDistrict district = (ITDistrict) c;
							Treerow tr = new Treerow();
							Treecell cell = new Treecell();
							Label lbl = new Label(district.getDname());
							cell.appendChild(lbl);
							tr.appendChild(cell);
							item.appendChild(tr);
							item.setValue(district);
							tr.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
								@Override
								public void onEvent(Event event) throws Exception {
									Treeitem parent = item.getParentItem();
									boolean allSelected = true;
									for (Component c : parent.getChildren()) {
										if (c instanceof Treechildren) {
											Treechildren t_child = (Treechildren) c;
											for (Treeitem t_child_item : t_child.getItems()) {
												if (!t_child_item.isSelected()) {
													allSelected = false;
													break;
												}
											}
										}
									}
									parent.setSelected(allSelected);
									parent.setAttribute("allSelected", allSelected);
								}
							});
						} else if (c instanceof ITCity) {
							ITCity city = (ITCity) c;
							Treerow tr = new Treerow();
							Treecell cell = new Treecell(city.getCname() + "分公司");
							cell.setStyle("font-weight:bold;");
							tr.appendChild(cell);
							item.appendChild(tr);
							item.setOpen(true);
							item.setValue(city);
							item.setSelected(true);
							Events.postEvent(-1, Events.ON_CLICK, tr, null);
							Events.postEvent(-2, Events.ON_OPEN, areapp, null);
							tr.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
								@Override
								public void onEvent(Event event) throws Exception {
									for (Component c : item.getChildren()) {
										if (c instanceof Treechildren) {
											Treechildren t_child = (Treechildren) c;
											for (Treeitem t_child_item : t_child.getItems()) {
												t_child_item.setSelected(item.isSelected());
											}
										}
									}
									item.setAttribute("allSelected", item.isSelected());
								}
							});
						}
					}
				});
		areaTree.setMultiple(true);
		areaTree.setCheckmark(true);
	}

	@Command
	public void areappOnOpen() {
		if (!areapp.isVisible()) {
			String str = "";
			for (Treeitem item : areaTree.getItems()) {
				Object obj = item.getValue();
				if (item.isSelected()) {
					if (obj instanceof ITCity) {
						ITCity itc = (ITCity) obj;
						Object allSelected = item.getAttribute("allSelected");
						if (allSelected != null && Boolean.valueOf(allSelected.toString())) {
							str += itc.getCname() + " ";
						}
					} else if (obj instanceof ITDistrict) {
						Object allSelected = item.getParentItem().getAttribute("allSelected");
						if (allSelected == null || !Boolean.valueOf(allSelected.toString())) {
							ITDistrict itd = (ITDistrict) obj;
							str += itd.getDname() + " ";
						}
					}
				}
			}
			if (str.equals("")) {
				areaBtn.setLabel("--请选择--");
			} else {
				areaBtn.setLabel(str.length() > 8 ? str.substring(0, 8) + "..." : str);
			}
		}
	}

	@Command
	public void query() {
		List<String> range = getRange();
		if (range == null || range.size() == 0) {
			Messagebox.show("未选择查询地区！", "提示", Messagebox.OK,
					Messagebox.INFORMATION);
			return;
		}
		List<ITBill> list = gelecService.getITBill(range, "");
		tdITBlillLbx.setModel(new SimpleListModel<ITBill>(list));
		tdITBlillLbx.setSizedByContent(true);
	}

	private List<String> getRange() {
		List<String> range = new ArrayList<String>();
		for (Iterator<Treeitem> it = areaTree.getSelectedItems().iterator(); it.hasNext();) {
			Treeitem item = it.next();
			BaseModel model = item.getValue();
			if (model instanceof ITDistrict) {
				ITDistrict district = (ITDistrict) model;
				range.add(district.getItDistrictId());
			}
		}
		return range;
	}

	@Command
	public void export(@BindingParam("target") Component target) {
		if (tdITBlillLbx.getModel() == null) {
			return;
		}
		Clients.showBusy(tdITBlillLbx, "正在导出...请稍后...");
		ListModel<ITBill> model = tdITBlillLbx.getModel();
		List<ITBill> list = new ArrayList<ITBill>(model.getSize());
		for (int i = 0; i < model.getSize(); i++) {
			list.add(model.getElementAt(i));
		}

		HSSFWorkbook wb = ExportUtil.createITBillXLS(list);
		Date now = new Date();
		String fileName = "export_bill_" + FormatUtil.getLongAllDate(now) + ".xls";
		String dirPath = SpringUtil.getWebAppPath().replaceAll("\\\\", "/") + "export";
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = ExcelUtil.writeWorkbook(dir.getAbsolutePath().replaceAll("\\\\", "/") + File.separator + fileName, wb);
		if (file != null) {
			try {
				AppLogger.sysDebug("Filedownload begin... file path:" + file.getAbsolutePath());
				Filedownload.save(file, "application/vnd.ms-excel");
				AppLogger.sysDebug("Filedownload done...");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Clients.clearBusy(tdITBlillLbx);
	}

	@Command
	public void addBill(@BindingParam("target") Component target) {
		Window w = (Window) Executions.createComponents("addBill.zul", view, null);
		w.setPosition("center");
		w.doModal();
	}
}
