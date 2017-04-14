/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.AlarmQueryLog;
import com.fuhj.itower.model.BaseModel;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.MainService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.itower.ui.export.ExportUtil;
import com.fuhj.itower.ui.model.AlarmComparator;
import com.fuhj.itower.ui.model.AlarmHisQueryParam;
import com.fuhj.itower.ui.model.AlarmHistoryModel;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.LiveAlHisListModel;
import com.fuhj.itower.ui.model.QueryResult;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.itower.ui.model.TDSiteVoltage;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ConfigReader;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SecurityUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-18
 */
@NoArgsConstructor
public class TdMonitorVM {
	@Wire
	private Listbox pfalarmLbx, pfalarmHisLbx;
	@Wire
	private A querySumLal;
	@Wire
	private Label countLbl, timerLbl;
	@Wire
	private Button queryBtn, queryHisBtn, exportBtn;
	@Wire
	private Tabbox atabbox;
	@Wire
	private Button areaBtn;
	@Wire
	private Tree areaTree;
	@Wire
	private Popup areapp;
	@Wire
	private Intbox autoQueryIbx;
	@Wire
	private Timer timer;
	@Wire
	private Checkbox autoQueryCbx;
	@Wire
	private Tab tab1, tab2;
	@Wire
	private Textbox hisTNOTxt, hisSTNameTxt;

	private Desktop desktop;
	private Users currentUser = WebAppUtil.getSessionUser();
	private static final int COUNTNUM = 60 * 5;
	private static final int MINI_COUNTNUM = 60 * 5;
	private int countNum = COUNTNUM;
	private boolean queryCompleted = false;
	private Component view;
	private MainService mainService;
	private LocationService locationService;
	private StationService stationService;
	@Getter
	private AlarmComparator atimeAsc = new AlarmComparator(true, 1);
	@Getter
	private AlarmComparator atimeDesc = new AlarmComparator(false, 1);
	@Getter
	private AlarmComparator aadAsc = new AlarmComparator(true, 2);
	@Getter
	private AlarmComparator aadDesc = new AlarmComparator(false, 2);
	@Getter
	private AlarmComparator aecAsc = new AlarmComparator(true, 3);
	@Getter
	private AlarmComparator aecDesc = new AlarmComparator(false, 3);
	@Getter
	private AlarmComparator wlAsc = new AlarmComparator(true, 4);
	@Getter
	private AlarmComparator wlDesc = new AlarmComparator(false, 4);
	@Getter
	private AlarmComparator vtAsc = new AlarmComparator(true, 5);
	@Getter
	private AlarmComparator vtDesc = new AlarmComparator(false, 5);
	@Getter
	@Setter
	private AlarmModel selectedAlarm;
	private ItowerImpl itower = new ItowerImpl();

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		mainService = SpringUtil.getBean(MainService.class);
		stationService = SpringUtil.getBean(StationService.class);
		locationService = SpringUtil.getBean(LocationService.class);

		desktop = Executions.getCurrent().getDesktop();

		if (!desktop.isServerPushEnabled()) {
			desktop.enableServerPush(true);
		}

		view.addEventListener(Events.ON_PIGGYBACK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				AppLogger.sysDebug("view ON_PIGGYBACK");
				queryCompleted = true;
				queryBtn.setDisabled(false);
				exportBtn.setDisabled(false);
				countLbl.setVisible(false);
				timerLbl.setVisible(false);

				if (autoQueryCbx.isChecked()) {
					Thread.sleep(1000);
					timerRestart();
				}
				ExecutorService service = Executors.newSingleThreadExecutor();
				service.execute(new Runnable() {
					@Override
					public void run() {
						ListModel<AlarmModel> listModel = pfalarmLbx.getModel();
						List<AlarmModel> list = new ArrayList<AlarmModel>();
						for (int i = 0; i < listModel.getSize(); i++) {
							list.add(listModel.getElementAt(i));
						}
						AlarmQueryLog log = mainService.createQueryLog(currentUser, list, queryBegin);
						mainService.addAlarmQueryLog(log);
					}
				});
				service.shutdown();
			}
		});
		pfalarmLbxInit();
		pfalarmHisLbxInit();
		areaTreeInit();
		autoQueryIbx.setValue(COUNTNUM);
		autoQueryCbx.setChecked(true);
	}

	private void pfalarmLbxInit() {
		pfalarmLbx.setItemRenderer(new ListitemRenderer<AlarmModel>() {

			@Override
			public void render(Listitem item, final AlarmModel am, int index) {
				try {

					am.setIndex(index);
					item.setStyle("text-align:center;");
					int wl = am.getElecWarninglevel();
					// TODO wl==null
					Listcell wlcell = new Listcell();
					Label wllabel = new Label();
					switch (wl) {
					case 1:
						item.setSclass("task-red");
						wllabel.setSclass("label label-danger arrowed");
						wllabel.setValue("一级告警");
						break;
					case 2:
						item.setSclass("task-orange");
						wllabel.setSclass("label label-warning arrowed");
						wllabel.setValue("二级告警");
						break;
					case 3:
						item.setSclass("task-yellow");
						wllabel.setSclass("label label-yellow arrowed");
						wllabel.setValue("三级告警");
						break;
					default:
						item.setSclass("task-green");
						wllabel.setSclass("label label-success arrowed");
						wllabel.setValue("无需发电");
						break;
					}

					wlcell.appendChild(wllabel);
					item.appendChild(new Listcell(String.valueOf(index + 1)));
					item.appendChild(new Listcell(StringUtils.isNotEmpty(am.getCity()) ? am.getCity() : locationService.getCityById(am.getItCityId()).getCname()));

					item.appendChild(new Listcell(StringUtils.isNotEmpty(am.getDistrict()) ? am.getDistrict() : locationService.getDistrictById(am.getItDistrictId()).getDname()));

					A tnLink = new A(am.getTroubleno());
					tnLink.setStyle("color:#d53f40;");
					Menupopup tnLink_popup = new Menupopup();
					tnLink_popup.setWidth("120px");
					tnLink_popup.setClass("rowPopup");
					Menuitem mitem1 = new Menuitem("故障单详情");
					mitem1.setIconSclass("z-icon-external-link");
					// TODO:关联COOKIE
					mitem1.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						@Override
						public void onEvent(Event arg0) throws Exception {
							String uri = ItowerImpl.ITOWER_SYS_URL + "/billDeal/monitoring/detail/monBillDetail.xhtml?isSearchHis=N&billSn=" + am.getTroubleno();
							Iframe frame = new Iframe(uri);
							String cookieValue = MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie");
							if (StringUtils.isNotEmpty(cookieValue) && itower.hasLogin(cookieValue)) {
								AppLogger.sysDebug("uri:" + uri);
								frame.setWidth("100%");
								frame.setHeight("900px");
								frame.setStyle("border:0");
								Tab tab = new Tab("故障单信息");
								tab.setClosable(true);
								atabbox.getTabs().appendChild(tab);
								Tabpanel tpanel = new Tabpanel();
								tpanel.appendChild(frame);
								atabbox.getTabpanels().appendChild(tpanel);
								tab.setSelected(true);
							}

						}
					});
					Menuitem mitem2 = new Menuitem("故障单历史");
					mitem2.setIconSclass("z-icon-external-link");
					// mitem2.addEventListener(Events.ON_CLICK, new
					// EventListener<Event>() {
					// @Override public void onEvent(Event arg0) throws
					// Exception {
					// hisTNOTxt.setValue(am.getTroubleno());
					// hisSTNameTxt.setValue(null);
					// tab2.setSelected(true);
					// Events.postEvent(new Event(Events.ON_CLICK,
					// queryHisBtn));
					// }
					// });
					tnLink_popup.appendChild(mitem1);
					tnLink_popup.appendChild(mitem2);
					tnLink.setPopup(tnLink_popup);
					tnLink_popup.setParent(tnLink);
					Listcell tncell = new Listcell();
					tncell.appendChild(tnLink);
					item.appendChild(tncell);

					A a_asn = new A(am.getStationname());
					// a_asn.addEventListener(Events.ON_CLICK, new
					// EventListener<Event>() {
					//
					// @Override public void onEvent(Event arg0) throws
					// Exception {
					// hisSTNameTxt.setValue(am.getStationname());
					// hisTNOTxt.setValue(null);
					// tab2.setSelected(true);
					// Events.postEvent(new Event(Events.ON_CLICK,
					// queryHisBtn));
					// }
					// });
					Listcell asncell = new Listcell();
					asncell.appendChild(a_asn);
					item.appendChild(asncell);
					item.appendChild(new Listcell(am.getStationcode()));
					item.appendChild(new Listcell(am.getStationFrom()));
					item.appendChild(new Listcell(FormatUtil.getFDate(am.getAlarmtime())));
					item.appendChild(new Listcell(String.valueOf(am.getAlarmduration())));
					String voltage = am.getVoltage();
					if (StringUtils.isEmpty(voltage)) {
						Listcell cell = new Listcell();
						Image img = new Image("img/spin_1.gif");
						cell.appendChild(img);
						item.appendChild(cell);
					} else {
						Listcell vCell = new Listcell(ItowerImpl.formatVoltage(am.getVoltage()));
						vCell.setStyle("font-weight:bold;");
						item.appendChild(vCell);
					}
					item.appendChild(new Listcell(am.getAgentMaintainCorp()));
					if (am.getSas() != null) {
						Listcell sasNamecell = new Listcell();
						Listcell stafftelcell = new Listcell();
						String sasName = am.getSas().getAgstaffname();
						String stafftel = am.getSas().getAgstafftel();
						A a_sasName = new A();
						A a_stafftel = new A();
						Popup popup = createTipsPopup(a_sasName, sasName, stafftel);
						popup.setId("xxxtipsPopup_" + index);
						if (sasName.split(",").length > 2) {
							a_sasName.setLabel(sasName.substring(0, 7) + "...");
							a_stafftel.setLabel(stafftel.substring(0, 23) + "...");
							String popupset = popup.getId() + ",position=after_start";
							a_sasName.setPopup(popupset);
							a_stafftel.setPopup(popupset);
						} else {
							a_sasName.setLabel(sasName);
							a_stafftel.setLabel(stafftel);
						}
						sasNamecell.appendChild(a_sasName);
						item.appendChild(sasNamecell);
						stafftelcell.appendChild(a_stafftel);
						item.appendChild(stafftelcell);
					} else {
						item.appendChild(new Listcell(" "));
						item.appendChild(new Listcell(" "));
					}
					item.appendChild(wlcell);

					item.appendChild(new Listcell(am.getFsuManufacturer()));

					// item.appendChild(new
					// Listcell(String.valueOf(am.getSpareelecduration())));
					// item.appendChild(new
					// Listcell(String.valueOf(am.getWayofduration())));
					// item.appendChild(new
					// Listcell(String.valueOf(am.getEleccountdown())));
					// item.appendChild(new Listcell(" "));
					// item.appendChild(new Listcell(" "));
					// item.appendChild(new Listcell(" "));
					item.setValue(am);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// pfalarmLbx.setMultiple(true);
	}

	public Popup createTipsPopup(Component parent, String names, String tels) {
		Popup p = new Popup();
		p.setDraggable("false");
		p.setDroppable("false");
		p.setSclass("tipspopup");
		p.setWidth("250px");
		Grid grid = new Grid();
		Columns cols = new Columns();
		Column col1 = new Column();
		Column col2 = new Column();
		cols.appendChild(col1);
		cols.appendChild(col2);
		grid.appendChild(cols);
		String[] name_array = names.split(",");
		String[] tel_array = tels.split("\\/", name_array.length);

		List<StaAgtStaff> sasList = new ArrayList<StaAgtStaff>();

		for (int i = 0; i < name_array.length; i++) {
			StaAgtStaff sas = new StaAgtStaff();
			sas.setAgstaffname(name_array[i]);
			try {
				sas.setAgstafftel(tel_array[i]);
			} catch (IndexOutOfBoundsException e) {
				sas.setAgstafftel("");
			}
			sasList.add(sas);
		}

		grid.setModel(new SimpleListModel<StaAgtStaff>(sasList));
		grid.setRowRenderer(new RowRenderer<StaAgtStaff>() {

			@Override
			public void render(Row row, StaAgtStaff data, int index) throws Exception {
				row.appendChild(new Label(data.getAgstaffname()));
				row.appendChild(new Label(data.getAgstafftel()));
				row.setHeight("20px");
				row.setValue(data);
			}
		});
		p.appendChild(grid);
		grid.setSizedByContent(true);
		p.setParent(parent);
		return p;
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
		areaTree.setItemRenderer(new TreeitemRenderer<DefaultTreeNode<BaseModel>>() {

			@Override
			public void render(final Treeitem item, DefaultTreeNode<BaseModel> data, int index) throws Exception {
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
					Events.postEvent(-1, Events.ON_OPEN, areapp, null);
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

	class QueryVoltageTask implements Runnable {
		private AlarmModel model;
		private ListModelList<AlarmModel> dynamicListModel;
		private String range;

		public QueryVoltageTask(ListModelList<AlarmModel> dynamicListModel, AlarmModel model, String range) {
			this.dynamicListModel = dynamicListModel;
			this.model = model;
			this.range = range;
		}

		public void run() {
			try {
				if (view.getPage() == null || desktop == null || !desktop.isAlive()) {
					Thread.currentThread().interrupt();
					return;
				}

				String voltage = "";
				final ExecutorService service = Executors.newSingleThreadExecutor();
				Future<String> f = service.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						return itower.queryVoltageRT(model.getItProvinceId(), range, model.getStationsid(), model.getStationcode(), model.getDid());
					}
				});
				try {
					voltage = f.get(60, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					f.cancel(true);
					voltage = QueryResult.INTERRUPT.getValue();
				} catch (ExecutionException e) {
					f.cancel(true);
					voltage = QueryResult.TIMEOUT.getValue();
				} catch (TimeoutException e) {
					f.cancel(true);
					voltage = QueryResult.TIMEOUT.getValue();
				} finally {
					service.shutdown();
				}
				if (StringUtils.isNotEmpty(voltage)) {
					try {
						if (desktop != null && desktop.isAlive()) {
							Executions.activate(desktop);
							model.setVoltage(voltage);
							dynamicListModel.set(model.getIndex(), model);
							Executions.deactivate(desktop);
						}
					} catch (DesktopUnavailableException e) {
						return;
					} catch (InterruptedException e) {
						return;
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class WaitFinished implements Runnable {
		private ExecutorService exe;

		public WaitFinished(ExecutorService exe) {
			this.exe = exe;
		}

		@Override
		public void run() {
			while (true) {
				if (view.getPage() == null || desktop == null || !desktop.isAlive()) {
					exe.shutdownNow();
					return;
				}
				if (exe.isTerminated()) {
					try {
						if (desktop != null && desktop.isAlive()) {
							Executions.activate(desktop);
							Events.postEvent(new Event(Events.ON_PIGGYBACK, view));
							Executions.deactivate(desktop);
						}
					} catch (DesktopUnavailableException e) {
						e.printStackTrace();
						exe.shutdownNow();
					} catch (InterruptedException e) {
						exe.shutdownNow();
						e.printStackTrace();
					}
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private int queryCompletedCount;
	private int meter;

	private void query(String range) {
		querybegin();
		try {
			final List<AlarmModel> list = itower.queryItowerAlarm(range, ItowerImpl.ALARM_TD);
			if (list != null && list.size() > 0) {
				List<String> sidList = new ArrayList<String>(list.size());
				for (AlarmModel model : list) {
					sidList.add(model.getStationcode());
					int countDown = model.getSpareelecduration() - model.getWayofduration() - model.getAlarmduration();
					model.setEleccountdown(countDown > 0 ? countDown : 0);
					if (countDown <= 60) {
						if (countDown <= 40) {
							if (countDown <= 20) {
								model.setElecWarninglevel(1);
							} else {
								model.setElecWarninglevel(2);
							}
						} else {
							model.setElecWarninglevel(3);
						}
					} else {
						model.setElecWarninglevel(0);
					}
				}
				Map<String, StationModel> map = stationService.queryStaSBySCode(sidList);
				ListModelList<AlarmModel> dynamicListModel = new ListModelList<AlarmModel>(list);

				Map<String, TDSiteVoltage> tdvMap = itower.queryTDsiteV(range);

				ExecutorService pool = Executors.newSingleThreadExecutor();

				for (AlarmModel model : dynamicListModel) {
					StationModel dbStmodel = map.get(model.getStationcode());
					if (dbStmodel != null) {
						if (!model.getStationname().equals(dbStmodel.getStationName())) {
							AppLogger.sysDebug("update station:" + dbStmodel.getItStationId());
							stationService.updateStaName(dbStmodel.getItStationId(), model.getStationname());
						}
						model.setCity(dbStmodel.getCity());
						model.setDistrict(dbStmodel.getDistrict());
						model.setItProvinceId(dbStmodel.getItProvinceId());
						model.setItCityId(dbStmodel.getItCityId());
						model.setItDistrictId(dbStmodel.getItDistrictId());
						if (dbStmodel.getAgstaffname() == null && dbStmodel.getAgstafftel() == null) {
							StaAgtStaff sas = itower.getStaAgtStaffByCode(range, model.getStationcode());
							if (sas != null) {
								model.setSas(new StaAgtStaff(sas.getAgstaffname(), sas.getAgstafftel()));
								stationService.addStaAgtStaff(sas);
							}
						} else {
							model.setSas(new StaAgtStaff(dbStmodel.getAgstaffname(), dbStmodel.getAgstafftel()));
						}
						model.setDid(dbStmodel.getBatteryId());
					} else {
						ItStation site = itower.getStationByCode(range, model.getStationcode());
						if (site != null) {
							model.setItProvinceId(site.getItProvinceId());
							model.setItCityId(site.getItCityId());
							model.setItDistrictId(site.getItDistrictId());
							stationService.addStation(site);
						}
						StaAgtStaff sas = itower.getStaAgtStaffByCode(range, model.getStationcode());
						if (sas != null) {
							model.setSas(new StaAgtStaff(sas.getAgstaffname(), sas.getAgstafftel()));
							stationService.addStaAgtStaff(sas);
						}
					}

					TDSiteVoltage tdv = tdvMap.get(model.getStationcode());
					if (tdv != null) {
						model.setVoltage(tdv.getVoltage());
					} else {
						pool.execute(new QueryVoltageTask(dynamicListModel, model, range));
					}
				}
				pfalarmLbx.setModel(dynamicListModel);
				queryCompletedCount = dynamicListModel.size();
				new Thread(new WaitFinished(pool)).start();
				pool.shutdown();
			} else {
				pfalarmLbx.setModel(new ListModelList<AlarmModel>(list));
				Events.postEvent(new Event(Events.ON_PIGGYBACK, view));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		querySumLal.setLabel("共查询到 " + queryCompletedCount + " 条记录");
		querySumLal.setIconSclass("glyphicon glyphicon-info-sign");
		pfalarmLbx.setSizedByContent(true);
	}

	private void login() {
		Component comp = Executions.getCurrent().getDesktop().getPage("mainPage").getFellowIfAny("itloginwindow");
		if (comp != null) {
			return;
		}
		Map<String, Object> loginItowerMap = new HashMap<String, Object>();
		if (SecurityUtil.IS_DEBUG) {
			loginItowerMap.put("loginName", ConfigReader.getProperty("ITOWER_DEBUG_USER"));
			loginItowerMap.put("pwd", ConfigReader.getProperty("ITOWER_DEBUG_PWD"));
		} else {
			loginItowerMap.put("loginName", ConfigReader.getProperty("ITOWER_USER"));
			loginItowerMap.put("pwd", ConfigReader.getProperty("ITOWER_PWD"));
		}
		Map<String, String> fristHeader;
		try {
			fristHeader = itower.makeFristHeader();
			BufferedImage img = itower.getValidateCode(fristHeader);
			loginItowerMap.put("ocrimg", img);
			loginItowerMap.put("cookie", fristHeader.get("Cookie"));
			Window w = (Window) Executions.createComponents("login_itower.zul", view, loginItowerMap);
			w.setPosition("center");
			w.doModal();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Command
	public void querybegin() {
		queryCompleted = false;
		queryCompletedCount = 0;
		timer.stop();
		// Executions.schedule(desktop, new EventListener<Event>() {
		// @Override public void onEvent(Event arg0) throws Exception {
		// AppLogger.sysDebug("Executions.schedule");
		queryBtn.setDisabled(true);
		exportBtn.setDisabled(true);
		countLbl.setVisible(false);
		timerLbl.setVisible(false);
		// }
		// }, new Event(Events.ON_CLICK));

	}

	private Date queryBegin;

	@Command
	public void queryBtnOnClick() {
		queryBegin = new Date();
		StringBuffer params = new StringBuffer();
		for (Iterator<Treeitem> it = areaTree.getSelectedItems().iterator(); it.hasNext();) {
			Treeitem item = it.next();
			BaseModel model = item.getValue();
			if (model instanceof ITCity) {
				ITCity city = (ITCity) model;
				params.append(city.getItCityId()).append(",");
			}
			if (model instanceof ITDistrict) {
				Treeitem parent = (Treeitem) item.getParent().getParent();
				if (!parent.isSelected()) {
					ITDistrict district = (ITDistrict) model;
					params.append(district.getItDistrictId()).append(",");
				}
			}
		}
		if (params.length() > 0) {
			params.deleteCharAt(params.length() - 1);
		} else {
			Messagebox.show("未选择查询地区！", "提示", Messagebox.OK, Messagebox.INFORMATION);
			return;
		}
		String cookieValue = MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie");
		if (StringUtils.isNotEmpty(cookieValue) && itower.hasLogin(cookieValue)) {
			query(params.toString());
		} else {
			timer.stop();
			do {
				itower.autoLogin();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (!itower.hasLogin(MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie")));
			query(params.toString());
		}
	}

	@Command
	public void queryHisBtnOnClick() {
		AlarmHisQueryParam param = new AlarmHisQueryParam();
		param.setTroubleno(hisTNOTxt.getValue());
		param.setStationName(hisSTNameTxt.getValue());
		// TODO:重大BUG 内存爆增 SQL需优化
		pfalarmHisLbx.setModel(new LiveAlHisListModel(mainService, param, pfalarmHisLbx.getPageSize()));
		pfalarmHisLbx.setSizedByContent(true);
	}

	@Command
	public void pfalarmHisLbxInit() {
		pfalarmHisLbx.setItemRenderer(new ListitemRenderer<AlarmHistoryModel>() {

			@Override
			public void render(Listitem item, final AlarmHistoryModel am, int index) throws Exception {
				item.setStyle("text-align:center;");
				item.appendChild(new Listcell(String.valueOf(index + 1)));
				item.appendChild(new Listcell(FormatUtil.getFDate(am.getQueryTime())));
				item.appendChild(new Listcell(am.getCity()));
				item.appendChild(new Listcell(am.getDistrict()));

				A tnLink = new A(am.getTroubleno());
				// TODO:关联COOKIE
				// tnLink.addEventListener(Events.ON_CLICK, new
				// EventListener<Event>() {
				//
				// @Override public void onEvent(Event arg0) throws Exception {
				// Iframe frame = new
				// Iframe("http://180.153.49.130:9000/billDeal/monitoring/detail/monBillDetail.xhtml?billIdParam="
				// + am.getBillid());
				//
				// String cookieValue =
				// MyProperties.getValueByKey(MyProperties.COOKIEFILE,
				// "Cookie");
				// if (StringUtils.isNotEmpty(cookieValue) &&
				// ItowerServiceImpl.hasLogin(cookieValue)) {
				// String uri =
				// "http://180.153.49.130:9000/billDeal/monitoring/detail/monBillDetail.xhtml?billIdParam="
				// + am.getBillid();
				// AppLogger.sysDebug("uri:" + uri);
				// frame.setWidth("100%");
				// frame.setHeight("900px");
				// frame.setStyle("border:0");
				// Tab tab = new Tab("故障单信息");
				// tab.setClosable(true);
				// atabbox.getTabs().appendChild(tab);
				// Tabpanel tpanel = new Tabpanel();
				// tpanel.appendChild(frame);
				// atabbox.getTabpanels().appendChild(tpanel);
				// tab.setSelected(true);
				// }
				// }
				// });
				tnLink.setStyle("color:#d53f40;text-decoration:underline;");

				Menupopup tnLink_popup = new Menupopup();
				tnLink_popup.setWidth("120px");
				tnLink_popup.setClass("rowPopup");
				Menuitem mitem1 = new Menuitem("故障单详情");
				mitem1.setIconSclass("z-icon-external-link");
				Menuitem mitem2 = new Menuitem("故障单历史");
				mitem2.setIconSclass("z-icon-external-link");
				tnLink_popup.appendChild(mitem1);
				tnLink_popup.appendChild(mitem2);
				tnLink.setPopup(tnLink_popup);
				tnLink_popup.setParent(tnLink);
				Listcell tncell = new Listcell();
				tncell.appendChild(tnLink);
				item.appendChild(tncell);
				A a_asn = new A(am.getStationname());
				Listcell asncell = new Listcell();
				asncell.appendChild(a_asn);
				item.appendChild(asncell);

				item.appendChild(new Listcell(am.getStationcode()));
				item.appendChild(new Listcell(FormatUtil.getFDate(am.getAlarmtime())));
				item.appendChild(new Listcell(String.valueOf(am.getAlarmduration())));
				String voltageStr = "";
				String voltage = am.getVoltage();
				if (!voltage.matches(QueryResult.getAllStrRegx())) {
					try {
						voltageStr = String.valueOf(FormatUtil.formatNumber(Double.parseDouble(voltage), 2));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					item.appendChild(new Listcell(voltageStr));
				} else {
					item.appendChild(new Listcell(voltage));
				}
				item.appendChild(new Listcell(""));
				item.appendChild(new Listcell(""));
				item.appendChild(new Listcell(""));
				item.setValue(am);
			}
		});
		pfalarmHisLbx.getPagingChild().setMold("os");
		// Events.postEvent(-1, queryHisBtn, new Event(Events.ON_CLICK));
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
	public void onTimer() {
		if (countNum == 0) {
			AppLogger.sysDebug("onTimer countNum=0");
			if (queryCompleted) {
				queryBtnOnClick();
			}
			return;
		}
		int minute = countNum / 60;
		int second = countNum - minute * 60;
		timerLbl.setValue(new StringBuffer().append(minute).append(" 分").append(second).append(" 秒").toString());
		countNum--;
	}

	@Command
	public void export(@BindingParam("target") Component target) {
		if (pfalarmLbx.getModel() == null) {
			return;
		}
		Clients.showBusy(pfalarmLbx, "正在导出...请稍后...");
		List<AlarmModel> list = new ArrayList<AlarmModel>();
		for (Listitem item : pfalarmLbx.getItems()) {
			AlarmModel model = item.getValue();
			list.add(model);
		}

		HSSFWorkbook wb = ExportUtil.createAlarmXLS(list);
		Date now = new Date();
		String fileName = "export_alarm_" + FormatUtil.getLongAllDate(now) + ".xls";
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
		Clients.clearBusy(pfalarmLbx);
	}

	private void timerRestart() {
		if (autoQueryIbx.getValue() < MINI_COUNTNUM) {
			countNum = MINI_COUNTNUM;
			autoQueryIbx.setValue(countNum);
		} else {
			countNum = autoQueryIbx.getValue();
		}
		countLbl.setVisible(true);
		timerLbl.setVisible(true);
		timer.start();
	}
}
