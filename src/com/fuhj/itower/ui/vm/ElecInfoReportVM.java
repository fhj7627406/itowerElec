/**
 * 
 */
package com.fuhj.itower.ui.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Space;

import com.fuhj.itower.model.BaseModel;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.model.Users;
import com.fuhj.itower.ui.export.ExportUtil;
import com.fuhj.itower.ui.model.GenElecReportItem;
import com.fuhj.itower.ui.model.Summary;
import com.fuhj.log.AppLogger;
import com.fuhj.util.ExcelUtil;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2017-1-11
 */
public class ElecInfoReportVM {
	private Component view;
	@Getter
	@Setter
	private String fristHeaderLabel = "";
	@Getter
	@Setter
	private Summary summary = new Summary();
	@Getter
	@Setter
	private Date start, end;
	@Getter
	@Setter
	private GenElecReportItem sumReprotItem = new GenElecReportItem();
	private GelecService gelecService;
	private LocationService locationService;
	@Wire
	private Grid reportGid;
	@Wire
	private Listbox areaLbx;
	@Wire
	private Datebox startDbx, endDbx;
	@Wire
	private Button areaBtn;
	@Wire
	private Div chart;
	Users currentUser;
	@Getter
	@Setter
	private String selectedArea;

	@Init
	public void init() {
		gelecService = SpringUtil.getBean(GelecService.class);
		locationService = SpringUtil.getBean(LocationService.class);
		currentUser = WebAppUtil.getSessionUser();
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		areaLbxInit();
		reportGidInit();
	}

	public void reportGidInit() {
		reportGid.setRowRenderer(new RowRenderer<GenElecReportItem>() {

			@Override
			public void render(Row row, GenElecReportItem data, int index) throws Exception {
				row.appendChild(new Label(data.getShowName()));

				row.appendChild(new A(String.valueOf(data.getDone())));
				row.appendChild(new A(String.valueOf(data.getIng())));
				row.appendChild(new A(String.valueOf(data.getSum())));
			}
		});
	}

	public void areaLbxInit() {
		areaLbx.setItemRenderer(new ListitemRenderer<BaseModel>() {

			@Override
			public void render(Listitem item, BaseModel data, int index) throws Exception {
				item.setValue(data);
				String text = "";
				if (data instanceof ITProvince) {
					text = ((ITProvince) data).getPname() + "分公司";
					item.appendChild(new Listcell(text));
					item.setSelected(true);
				}
				if (data instanceof ITCity) {
					Listcell cell = new Listcell();
					Hlayout hlayout = new Hlayout();
					Space space = new Space();
					space.setWidth("5px");
					space.setOrient("horizontal");
					hlayout.appendChild(space);
					text = ((ITCity) data).getCname();
					Label label = new Label(text);
					hlayout.appendChild(label);
					cell.appendChild(hlayout);
					item.appendChild(cell);
				}
				item.setAttribute("itemLabel", text);
			}
		});
		if (currentUser != null && StringUtils.isNotEmpty(currentUser.getPerm())) {
			String[] temp = currentUser.getPerm().split(",");
			ITCity city = locationService.getCityById(temp[0]);
			if (city == null) {
				return;
			}
			List<BaseModel> list = new ArrayList<BaseModel>();
			String provinceId = city.getItProvinceId();
			ITProvince province = locationService.getProvinceById(provinceId);
			list.add(province);
			List<ITCity> citys = locationService.findAllCityByProvinceId(provinceId);
			list.addAll(citys);
			areaLbx.setModel(new SimpleListModel<BaseModel>(list));
		}
	}

	@Command
	public void queryReport() {
		Date startDate = startDbx.getValue();
		Date endDate = endDbx.getValue();
		if (startDate != null && endDate != null && endDate.before(startDate)) {
			Messagebox.show("结束时间在开始时间之前!", "提示", Messagebox.OK, Messagebox.ERROR);
		}
		setStart(startDate);
		setEnd(endDate);
		Object obj = areaLbx.getSelectedItem().getValue();
		List<GenElecReportItem> list = null;
		if (obj instanceof ITProvince) {
			ITProvince iTProvince = (ITProvince) obj;
			list = gelecService.getGReportByProvince(iTProvince.getItProvinceId(), startDate, endDate);
			setFristHeaderLabel("地市");
			calcSummary_p(iTProvince.getItProvinceId(), iTProvince.getPname());
		}
		if (obj instanceof ITCity) {
			ITCity iTCity = (ITCity) obj;
			list = gelecService.getGReportByCity(iTCity.getItCityId(), startDate, endDate);
			setFristHeaderLabel("区县");
			calcSummary_c(iTCity.getItCityId(), iTCity.getCname());
		}
		if (list != null && list.size() > 0) {
			drawBars(list);
			reportGid.setModel(new SimpleListModel<GenElecReportItem>(list));
			calcSum(list);
		}
		BindUtils.postNotifyChange(null, null, this, "fristHeaderLabel");
	}

	@Command
	public void exportReport() {
		ListModel<GenElecReportItem> listmodel = reportGid.getModel();
		List<GenElecReportItem> list = new ArrayList<GenElecReportItem>(listmodel.getSize());
		for (int i = 0; i < listmodel.getSize(); i++) {
			list.add(listmodel.getElementAt(i));
		}
		HSSFWorkbook wb = ExportUtil.createGelecReportXLS(list, getSummary().getShowText(), getStart(), getEnd());

		Date now = new Date();
		String fileName = "export_gElecReport_" + FormatUtil.getLongAllDate(now) + ".xls";
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
	}

	public void calcSummary_p(String itProvinceId, String showText) {
		Summary sry = gelecService.getGSummaryByProvince(itProvinceId);
		sry.setShowText(showText);
		setSummary(sry);
		BindUtils.postNotifyChange(null, null, this, "summary");
	}

	public void calcSummary_c(String itCityId, String showText) {
		Summary sry = gelecService.getGSummaryByCity(itCityId);
		sry.setShowText(showText);
		setSummary(sry);
		BindUtils.postNotifyChange(null, null, this, "summary");
	}

	public void calcSum(List<GenElecReportItem> list) {
		int sum_done = 0, sum_ing = 0, sum_sum = 0;
		for (GenElecReportItem item : list) {
			sum_done += item.getDone();
			sum_ing += item.getIng();
			sum_sum += item.getSum();
		}
		getSumReprotItem().setDone(sum_done);
		getSumReprotItem().setIng(sum_ing);
		getSumReprotItem().setSum(sum_sum);
		BindUtils.postNotifyChange(null, null, this, "sumReprotItem");
	}

	public void closePopup(Listbox listbox) {
		Popup popup = (Popup) listbox.getParent();
		if (popup != null && popup.isVisible())
			popup.close();
	}

	@Command
	@NotifyChange("selectedArea")
	public void areaOnSelect(@BindingParam("target") Component target) {
		Listbox listbox = (Listbox) target;
		closePopup(listbox);
		setSelectedArea(listbox.getSelectedItem().getAttribute("itemLabel").toString());
	}

	public void drawBars(List<GenElecReportItem> list) {
		JSONArray data = new JSONArray();
		JSONArray first = new JSONArray();
		JSONArray xaxis_ticks = new JSONArray();
		first.add(0.5);
		first.add(0);
		data.add(first);

		for (int i = 0; i < list.size(); i++) {
			JSONArray child = new JSONArray();
			int ticks = i + 1;
			child.add(ticks);
			int num = list.get(i).getDone();
			child.add(num);
			data.add(child);
			JSONArray xaxis_ticks_child = new JSONArray();
			xaxis_ticks_child.add(ticks + 0.25);
			xaxis_ticks_child.add(list.get(i).getShowName());
			xaxis_ticks.add(xaxis_ticks_child);
		}
		JSONArray last = new JSONArray();
		last.add(list.size() + 0.5);
		last.add(0);
		data.add(last);

		StringBuffer script = new StringBuffer();
		script.append("(function($){var options={};function init(plot){function onResize(){var placeholder=plot.getPlaceholder();if(placeholder.width()==0||placeholder.height()==0)return;plot.resize();plot.setupGrid();plot.draw();/*setTimeout(function(){zk.afterResize(onResize);});*/}zk.afterResize(onResize);}$.plot.plugins.push({init:init,options:options,name:'resize',version:'1.0'})})(jQuery);zk.afterResize(function(){var d2=");
		script.append(data);
		script.append(";var plot=$.plot($(\".chart\"),[{data:d2,bars:{show:true,lineWidth:0,barWidth:0.5,fill:true,fillColor:\"#2091CF\",align:\"left\"},label:\"");
		script.append("各");
		script.append(getFristHeaderLabel());
		script.append("已完成统计");
		script.append("\",color:\"#2091CF\"}],{xaxis:{font:{size:13,color:\"#636363\"},ticks:");
		script.append(xaxis_ticks);
		script.append("},grid:{hoverable:true,borderWidth:1}});/*var unicorn={flot_tooltip:function(x,y,contents){$('<div id=\"tooltip\">'+contents+'</div>').css({top:y+5,left:x+5}).appendTo(\"body\").fadeIn(200);}}; var previousPoint=null;$(\".chart\").bind(\"plothover\",function(event,pos,item){if(item){console.log(item);if(previousPoint!=item.dataIndex){previousPoint=item.dataIndex; $('#tooltip').fadeOut(200,function(){$(this).remove();});var x=item.datapoint[0].toFixed(2),y=item.datapoint[1].toFixed(2);unicorn.flot_tooltip(item.pageX,item.pageY,item.series.xaxis.ticks[item.dataIndex-1].label+\" = \"+parseInt(y));}}else{$('#tooltip').fadeOut(200,function(){$(this).remove();});previousPoint=null;}});*/});");
		// AppLogger.sysDebug(data);
		// AppLogger.sysDebug(xaxis_ticks);
		// AppLogger.sysDebug(script);
		Clients.evalJavaScript(script.toString());
	}
}
