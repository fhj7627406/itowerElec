/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Space;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Vlayout;

import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.service.GelecService;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.ImageUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-12-4
 */
public class GElecListVM {
	private GelecService gelecService;
	private GElecUser current_gelec_user;
	@Wire Div btnDiv;
	@Wire Tabbox listTabox;
	@Wire Tab ingTab, doneTab, allTab, detailTab;
	@Wire Listbox ingLbx, doneLbx, allLbx;
	@Wire Space endGelecSpace;
	@Wire Button showDetailBtn, endGelecBtn;
	@Wire Image pic1Img, pic2Img;
	@Getter @Setter private GElecInfo selected;

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		WebAppUtil.setElecPageTitle("我的发电");
		gelecService = SpringUtil.getBean(GelecService.class);
		listTaboxInit();
		Object obj = WebAppUtil.getWebSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY);
		if (obj != null) {
			current_gelec_user = (GElecUser) obj;
			@SuppressWarnings("serial") List<Integer> statusList = new ArrayList<Integer>() {
				{
					add(1);
					add(2);
				}
			};
			List<GElecInfo> list = gelecService.getGElecInfo(current_gelec_user.getGelecUserId(), statusList);
			List<GElecInfo> ingList = new ArrayList<GElecInfo>();
			List<GElecInfo> doneList = new ArrayList<GElecInfo>();
			for (GElecInfo model : list) {
				switch (model.getStatus()) {
				case 1:
					doneList.add(model);
					break;
				case 2:
					ingList.add(model);
					break;
				default:
					break;
				}
			}

			ListitemRenderer<GElecInfo> listRender = new GElecListRender();
			ListboxListenner listboxListenner = new ListboxListenner();
			allLbx.setItemRenderer(listRender);
			allLbx.addEventListener(Events.ON_SELECT, listboxListenner);
			allLbx.setRows(list.size());
			allLbx.setModel(new SimpleListModel<GElecInfo>(list));

			ingLbx.setItemRenderer(listRender);
			ingLbx.addEventListener(Events.ON_SELECT, listboxListenner);
			ingLbx.setRows(ingList.size());
			ingLbx.setModel(new SimpleListModel<GElecInfo>(ingList));

			doneLbx.setItemRenderer(listRender);
			doneLbx.addEventListener(Events.ON_SELECT, listboxListenner);
			doneLbx.setRows(doneList.size());
			doneLbx.setModel(new SimpleListModel<GElecInfo>(doneList));

		}
	}

	public void listTaboxInit() {
		listTabox.addEventListener(Events.ON_PIGGYBACK, new EventListener<Event>() {

			@Override public void onEvent(Event event) throws Exception {
				String eventData = event.getData().toString();
				if (eventData.equals("ing")) {
					if (!ingTab.isSelected()) {
						ingTab.setSelected(true);
						Events.postEvent(-1, new Event(Events.ON_SELECT, ingTab));
					}
				} else if (eventData.equals("done")) {
					if (!doneTab.isSelected()) {
						doneTab.setSelected(true);
						Events.postEvent(-1, new Event(Events.ON_SELECT, doneTab));
					}
				} else if (eventData.equals("all")) {
					if (!allTab.isSelected()) {
						allTab.setSelected(true);
						Events.postEvent(-1, new Event(Events.ON_SELECT, allTab));
					}
				} else if (eventData.equals("detail")) {
					if (!detailTab.isSelected()) {
						detailTab.setSelected(true);
						Events.postEvent(-1, new Event(Events.ON_SELECT, detailTab));
					}
				}
			}
		});
		listTabox.addEventListener(Events.ON_SELECT, new EventListener<Event>() {

			@Override public void onEvent(Event event) throws Exception {
				Component target = event.getTarget();

				if (target == ingTab) {
					doneLbx.clearSelection();
					allLbx.clearSelection();
				} else if (target == doneTab) {
					ingLbx.clearSelection();
					allLbx.clearSelection();
				} else if (target == allTab) {
					ingLbx.clearSelection();
					doneLbx.clearSelection();
				}

				boolean ingTabSelected = ingTab.isSelected();

				endGelecBtn.setVisible(ingTabSelected);
				endGelecBtn.setDisabled(!ingTabSelected);
				btnDiv.setVisible(!detailTab.isSelected());
				showDetailBtn.setVisible(!detailTab.isSelected());

				if (detailTab.isSelected()) {
					if (getSelected() != null && getSelected().getStatus() == 2) {
						btnDiv.setVisible(true);
						endGelecBtn.setVisible(true);
						endGelecBtn.setDisabled(false);
					} else {
						btnDiv.setVisible(false);
						endGelecBtn.setVisible(false);
						endGelecBtn.setDisabled(true);
					}
					if (getSelected() != null) {
//						ITBill itBill = gelecService.getITBillById(getSelected().getItBillId());
//						getSelected().setTempObject(itBill);
						BindUtils.postNotifyChange(null, null, GElecListVM.this, "selected");
						if (StringUtils.isNotEmpty(getSelected().getPic1())) {
							File f = new File(getSelected().getPic1());
							if (f.exists()) {
								try {
									BufferedImage img = ImageIO.read(f);
									if (img.getWidth() > 768) {
										pic1Img.setContent(ImageUtil.scaleImage3(ImageIO.read(f), 0.5));
									} else {
										pic1Img.setContent(img);
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						if (StringUtils.isNotEmpty(getSelected().getPic2())) {
							File f = new File(getSelected().getPic2());
							if (f.exists()) {
								try {
									BufferedImage img = ImageIO.read(f);
									if (img.getWidth() > 768) {
										pic2Img.setContent(ImageUtil.scaleImage3(ImageIO.read(f), 0.5));
									} else {
										pic2Img.setContent(img);
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
				endGelecSpace.setVisible(showDetailBtn.isVisible() && endGelecBtn.isVisible());
			}
		});
	}

	@Command public void goDetail() {
		if (getSelected() != null) {
			detailTab.setSelected(true);
			Events.postEvent(Events.ON_SELECT, listTabox, null);
		}
	}

	@Command public void endGelec() {
	
		if (ingLbx.getSelectedItem() != null) {
//			if (getSelected().getTempObject() == null) {
//				ITBill itBill = gelecService.getITBillById(getSelected().getItBillId());
//				getSelected().setTempObject(itBill);
//			}
			WebAppUtil.setWebSessionAttribute("gElecInfo", getSelected());
			WebAppUtil.getElecIncludePage().setSrc("gesubmit.zul");
		} else {
			if (ingLbx.getModel().getSize() == 1) {
				ingLbx.setSelectedItem(ingLbx.getItemAtIndex(0));
				GElecInfo model = ingLbx.getSelectedItem().getValue();
				setSelected(model);
				Events.postEvent(Events.ON_SELECT, ingLbx, null);
				endGelec();
			}
		}
		// Executions.sendRedirect("gElec_detail.zul");
	}

	class ListboxListenner implements EventListener<Event> {
		@Override public void onEvent(Event event) throws Exception {
			Listbox lbx = (Listbox) event.getTarget();
			if (lbx.getSelectedItem() != null) {
				GElecInfo model = lbx.getSelectedItem().getValue();
				setSelected(model);
				WebAppUtil.setWebSessionAttribute("gElecInfo", getSelected());
				pic1Img.setSrc("");
				pic2Img.setSrc("");
			}
		}
	}

	class GElecListRender implements ListitemRenderer<GElecInfo> {

		/*
		 * (non-Javadoc)
		 * @see org.zkoss.zul.ListitemRenderer#render(org.zkoss.zul.Listitem, java.lang.Object, int)
		 */
		@Override public void render(Listitem item, GElecInfo data, int index) throws Exception {
			item.setValue(data);
			item.appendChild(new Listcell(String.valueOf(index + 1)));
			Vlayout vlayout = new Vlayout();
			vlayout.setSpacing("0");
			Hbox hbox1 = new Hbox();
			Label hbox1_head = new Label("编号：");

			Label hbox1_text = new Label(data.getgCode());
			hbox1_text.setSclass("heavy");
			hbox1.appendChild(hbox1_head);
			hbox1.appendChild(hbox1_text);

			Hbox hbox2 = new Hbox();
			Label hbox2_head = new Label("站点：");
			hbox2_head.setStyle("white-space:nowrap;");
			Label hbox2_text = new Label(data.getStationName());
			hbox2_text.setSclass("blue");
			hbox2.appendChild(hbox2_head);
			hbox2.appendChild(hbox2_text);

			Hbox hbox3 = new Hbox();
			Label hbox3_head = new Label("工单号：");

			Label hbox3_text = new Label(data.getBillCode());
			hbox3_text.setSclass("red");
			hbox3.appendChild(hbox3_head);
			hbox3.appendChild(hbox3_text);

			Hbox hbox4 = new Hbox();
			Label hbox4_head = new Label("开始发电：");

			Label hbox4_text = new Label(FormatUtil.getFDate(data.getStartTime()));
			hbox4.appendChild(hbox4_head);
			hbox4.appendChild(hbox4_text);
			Hbox hbox5 = new Hbox();
			Label hbox5_head = new Label("结束发电：");
			Label hbox5_text = new Label(FormatUtil.getFDate(data.getEndTime()));
			hbox5.appendChild(hbox5_head);
			hbox5.appendChild(hbox5_text);
			vlayout.appendChild(hbox1);
			vlayout.appendChild(hbox2);
			vlayout.appendChild(hbox3);
			vlayout.appendChild(hbox4);
			vlayout.appendChild(hbox5);
			Listcell cellinfo = new Listcell();
			cellinfo.appendChild(vlayout);
			item.appendChild(cellinfo);

			Label lblstatus = new Label();
			switch (data.getStatus()) {
			case 1:
				lblstatus.setSclass("green");
				lblstatus.setValue("已完成");
				break;
			case 2:
				lblstatus.setSclass("red");
				lblstatus.setValue("进行中");
				break;
			default:
				break;
			}
			Listcell cellstatus = new Listcell();
			cellstatus.appendChild(lblstatus);
			item.appendChild(cellstatus);
		}
	}
}