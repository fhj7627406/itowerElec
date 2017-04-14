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

import javax.imageio.ImageIO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Detail;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Space;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.fuhj.itower.model.BaseModel;
import com.fuhj.itower.model.GElecInfo;
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
public class GenElecInfoVM {
	private Component view;

	private LocationService locationService;
	private GelecService gelecService;

	private Users currentUser = WebAppUtil.getSessionUser();
	@Getter
	@Setter
	private String selectedStatus;
	@Wire
	private Button areaBtn;
	@Wire
	private Tree areaTree;
	@Wire
	private Popup areapp;
	@Wire
	Grid gElecInfoGrd;
	@Wire
	Datebox startDbx, endDbx;
	@Wire
	Listbox statusLbx;

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
		gElecInfoGrdInit();
		areaTreeInit();
	}

	private Hlayout createStartAddrHlayout(GElecInfo data) {
		Hlayout hlayout = new Hlayout();
		Label textLable1 = new Label("开始发电经度：");
		Label textLable2 = new Label("开始发电纬度：");
		Label textLable3 = new Label("开始发电地点：");

		Label valueLable1 = new Label(String.valueOf(data.getStartLng()));
		Label valueLable2 = new Label(String.valueOf(data.getStartLat()));
		Label valueLable3 = new Label(data.getStartAddr());
		valueLable1.setSclass("heavy");
		valueLable2.setSclass("heavy");
		valueLable3.setSclass("heavy");
		hlayout.appendChild(textLable1);
		hlayout.appendChild(valueLable1);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable2);
		hlayout.appendChild(valueLable2);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable3);
		hlayout.appendChild(valueLable3);

		if (data.getStartLng() != 0 && data.getStartLat() != 0) {
			hlayout.appendChild(new Space());
			String popup_id = "popup_start" + data.getGelecInfoId();
			A showMap = new A("查看地图");
			Popup p = new Popup();
			p.setSclass("mapPopup");
			p.setId(popup_id);
			p.setDraggable("false");
			p.setDroppable("false");
			p.setHeight("400px");
			p.setWidth("400px");
			Iframe frame = new Iframe();
			frame.setWidth("100%");
			frame.setHeight("100%");
			frame.setSrc("/locationBMap.jsp?lng=" + data.getStartLng() + "&lat=" + data.getStartLat());
			p.appendChild(frame);
			p.setParent(showMap);
			showMap.setPopup(popup_id + ", position = after_end,type=toggle");
			hlayout.appendChild(showMap);
		}
		return hlayout;
	}

	private Hlayout createEndAddrHlayout(GElecInfo data) {
		Hlayout hlayout = new Hlayout();
		Label textLable1 = new Label("结束发电经度：");
		Label textLable2 = new Label("结束发电纬度：");
		Label textLable3 = new Label("结束发电地点：");

		Label valueLable1 = new Label(String.valueOf(data.getEndLng()));
		Label valueLable2 = new Label(String.valueOf(data.getEndLat()));
		Label valueLable3 = new Label(data.getEndAddr());
		valueLable1.setSclass("heavy");
		valueLable2.setSclass("heavy");
		valueLable3.setSclass("heavy");
		hlayout.appendChild(textLable1);
		hlayout.appendChild(valueLable1);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable2);
		hlayout.appendChild(valueLable2);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable3);
		hlayout.appendChild(valueLable3);

		if (data.getEndLng() != 0 && data.getEndLat() != 0) {
			hlayout.appendChild(new Space());
			String popup_id = "popup_end" + data.getGelecInfoId();
			A showMap = new A("查看地图");
			Popup p = new Popup();
			p.setSclass("mapPopup");
			p.setId(popup_id);
			p.setDraggable("false");
			p.setDroppable("false");
			p.setHeight("400px");
			p.setWidth("400px");
			Iframe frame = new Iframe();
			frame.setWidth("100%");
			frame.setHeight("100%");
			frame.setSrc("/locationBMap.jsp?lng=" + data.getEndLng() + "&lat=" + data.getEndLat());
			p.appendChild(frame);
			p.setParent(showMap);
			showMap.setPopup(popup_id + ", position = after_end,type=toggle");
			hlayout.appendChild(showMap);
		}
		return hlayout;
	}

	private Hlayout createYJHlayout(GElecInfo data) {
		Hlayout hlayout = new Hlayout();
		Label textLable1 = new Label("发电油机：");
		Label textLable2 = new Label("油机编号：");
		Label textLable3 = new Label("往返里程：");

		Label valueLable1 = new Label(data.getMachinePower());
		Label valueLable2 = new Label(data.getMachineType());
		Label valueLable3 = new Label(data.getMachineCount() + "台");
		Label valueLable4 = new Label(data.getMachineNo());
		Label valueLable5 = new Label(data.getOdometer());
		valueLable1.setSclass("heavy");
		valueLable2.setSclass("heavy");
		valueLable3.setSclass("heavy");
		valueLable4.setSclass("heavy");
		valueLable5.setSclass("heavy");
		hlayout.appendChild(textLable1);
		hlayout.appendChild(valueLable1);

		hlayout.appendChild(valueLable2);
		hlayout.appendChild(valueLable3);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable2);
		hlayout.appendChild(valueLable4);
		hlayout.appendChild(new Space());
		hlayout.appendChild(textLable3);
		hlayout.appendChild(valueLable5);
		return hlayout;
	}

	private Hlayout createReasonHlayout(GElecInfo data) {
		Hlayout hlayout = new Hlayout();
		Label textLable1 = new Label("发电原因：");
		Label valueLable1 = new Label(data.getReason());
		valueLable1.setSclass("heavy");
		hlayout.appendChild(textLable1);
		hlayout.appendChild(valueLable1);
		return hlayout;
	}

	public void gElecInfoGrdInit() {
		gElecInfoGrd.setRowRenderer(new RowRenderer<GElecInfo>() {

			@Override
			public void render(Row row, GElecInfo data, int index) throws Exception {
				row.setStyle("text-align:center;");
				Detail detail = new Detail();
				Hlayout detailHlaout = new Hlayout();
				detailHlaout.setStyle("padding-left:15px;padding-bottom:10px;");
				Vlayout detailVlaout = new Vlayout();

				detailVlaout.appendChild(createYJHlayout(data));
				detailVlaout.appendChild(createStartAddrHlayout(data));
				if (data.getEndTime() != null) {
					detailVlaout.appendChild(createEndAddrHlayout(data));
				}
				detailVlaout.appendChild(createReasonHlayout(data));
				detailHlaout.appendChild(detailVlaout);
				detail.appendChild(detailHlaout);

				row.appendChild(new Label(String.valueOf(index + 1)));
				row.appendChild(detail);
				row.appendChild(new Label(data.getgCode()));
				row.appendChild(new Label(data.getCity()));
				row.appendChild(new Label(data.getDistrict()));
				Label billCodeLbl = new Label(data.getBillCode());
				billCodeLbl.setStyle("color:#d53f40;");
				row.appendChild(billCodeLbl);
				A a_asn = new A(data.getStationName());
				row.appendChild(a_asn);
				row.appendChild(new Label(data.getStationCode()));
				row.appendChild(new Label(data.getOperator()));
				row.appendChild(new Label(data.getDataOrigin()));
				Label statusLable = null;
				switch (data.getStatus()) {
				case 1:
					statusLable = new Label("已完成");
					statusLable.setSclass("green");
					break;
				case 2:
					statusLable = new Label("进行中");
					statusLable.setSclass("red");
					break;

				}
				row.appendChild(statusLable);

				row.appendChild(new Label(FormatUtil.getFDate(data.getStartTime())));
				row.appendChild(new Label(FormatUtil.getFDate(data.getEndTime())));
				Label durationLable = new Label("");
				if (data.getEndTime() != null) {
					long durationNum = data.getEndTime().getTime() - data.getStartTime().getTime();
					if (durationNum > 0) {
						durationLable.setValue(FormatUtil.minConvertHourMin(durationNum / (1000 * 60)));
					}
				}
				row.appendChild(durationLable);
				row.appendChild(new Label(data.getPerson()));
				row.appendChild(new Label(data.getContact()));

				if (StringUtils.isNotEmpty(data.getPic1())) {
					A a_pic1 = new A("查看图片");
					a_pic1.addEventListener(Events.ON_CLICK, new PicLinkListener(data.getPic1()));
					row.appendChild(a_pic1);
				} else {
					row.appendChild(new Label(""));
				}

				if (StringUtils.isNotEmpty(data.getPic2())) {
					A a_pic2 = new A("查看图片");
					a_pic2.addEventListener(Events.ON_CLICK, new PicLinkListener(data.getPic2()));
					row.appendChild(a_pic2);
				} else {
					row.appendChild(new Label(""));
				}
				row.appendChild(new Label(""));
				row.setValue(data);
			}
		});
		gElecInfoGrd.getPagingChild().setMold("os");
	}

	@AllArgsConstructor
	class PicLinkListener implements EventListener<Event> {
		private String imgPath;

		@Override
		public void onEvent(Event event) throws Exception {
			if (StringUtils.isNotEmpty(imgPath)) {
				File file = new File(imgPath);
				if (!file.exists()) {
					return;
				}
				Window win = new Window();
				win.setTitle("查看图片");
				win.setClosable(true);
				win.setSizable(false);
				win.setBorder("normal");
				win.setPosition("top,center");
				win.setWidth("600px");
				Vlayout v = new Vlayout();
				Image img = new Image();

				img.setContent(ImageIO.read(file));
				img.setWidth("100%");
				v.appendChild(img);
				win.appendChild(v);
				win.setPage(Executions.getCurrent().getDesktop().getPage("mainPage"));
				win.doModal();
			}
		}
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
		if (startDbx.getValue() != null && endDbx.getValue() != null) {
			if (startDbx.getValue().after(endDbx.getValue())) {
				Messagebox.show("开始时间大于结束时间！", "提示", Messagebox.OK,
						Messagebox.INFORMATION);
				return;
			}
		}
		GElecInfo arg = new GElecInfo();
		arg.setStatus(-1);
		arg.setStartTime(startDbx.getValue());
		arg.setEndTime(endDbx.getValue());
		if (statusLbx.getSelectedItem() != null) {
			String status = statusLbx.getSelectedItem().getValue();
			arg.setStatus(Integer.parseInt(status));
		}

		List<GElecInfo> list = gelecService.getGElecInfo(range, arg);
		gElecInfoGrd.setModel(new SimpleListModel<GElecInfo>(list));
		gElecInfoGrd.setSizedByContent(true);
	}

	@Command
	public void export(@BindingParam("target") Component target) {
		if (gElecInfoGrd.getModel() == null) {
			return;
		}
		Clients.showBusy(gElecInfoGrd, "正在导出...请稍后...");
		List<GElecInfo> list = new ArrayList<GElecInfo>();
		ListModel<GElecInfo> lm = gElecInfoGrd.getModel();
		for (int i = 0; i < lm.getSize(); i++) {
			list.add(lm.getElementAt(i));
		}
		HSSFWorkbook wb = ExportUtil.createGelecInfoXLS(list);
		Date now = new Date();
		String fileName = "export_ginfo_" + FormatUtil.getLongAllDate(now) + ".xls";
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
		Clients.clearBusy(gElecInfoGrd);
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

	public void closePopup(Listbox listbox) {
		Popup popup = (Popup) listbox.getParent();
		if (popup != null && popup.isVisible())
			popup.close();
	}

	@Command
	@NotifyChange("selectedStatus")
	public void statusOnSelect(@BindingParam("target") Component target) {
		Listbox listbox = (Listbox) target;
		closePopup(listbox);
		setSelectedStatus((listbox.getSelectedItem().getLabel()));
	}
}
