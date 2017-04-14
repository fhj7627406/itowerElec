/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.model.ITBill;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.service.GelecService;
import com.fuhj.itower.service.StationService;
import com.fuhj.util.ImageUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-14
 */
public class GElecStartVM extends AbstractValidator {
	private Component view;
	private Desktop desktop;
	private ValidationContext vcx;
	private GelecService gelecService;
	private GElecUser current_gelec_user;
	private final ItowerImpl itower = new ItowerImpl();
	private StationService stationService;
	// @Wire
	// private Image vloaddingImg;
	// @Wire
	// private Label vLbl;
	@Wire
	private Button uploadBtn1;
	@Wire
	private Image pic1;
	@Getter
	private ITBill selectedITBill;
	@Getter
	@Setter
	private GElecInfo genElecInfo = new GElecInfo();

	@Init
	public void init() {
		WebAppUtil.setElecPageTitle("上传开始发电信息");
		gelecService = SpringUtil.getBean(GelecService.class);
		stationService = SpringUtil.getBean(StationService.class);
		Object obj_gelec_user = WebAppUtil.getWebSessionAttribute(WebAppUtil.GELEC_USER_SESSION_KEY);
		if (obj_gelec_user != null) {
			current_gelec_user = (GElecUser) obj_gelec_user;
		}
		if (current_gelec_user != null) {
			genElecInfo.setCreatorId(current_gelec_user.getGelecUserId());
			genElecInfo.setPerson(current_gelec_user.getUserName());
			genElecInfo.setContact(current_gelec_user.getUserPhone());
		}
		Object obj = WebAppUtil.getWebSessionAttribute("selectedITBill");
		if (obj != null) {
			selectedITBill = (ITBill) obj;
			try {
				BeanUtils.copyProperties(selectedITBill, genElecInfo,
								new String[] { GElecInfo.CREATE_TIME, GElecInfo.STATUS, GElecInfo.REMARK });
				ItStation itst=stationService.queryStaBySID(selectedITBill.getStationCode());
				if(itst!=null){
					genElecInfo.setStationSysCode(itst.getStationSysCode());
					genElecInfo.setOperCode(String.valueOf(itst.getOperator()));
				}
			} catch (Exception e) {
				WebAppUtil.getElecIncludePage().setSrc("geindex.zul");
			}
		} else {
			WebAppUtil.getElecIncludePage().setSrc("geindex.zul");
		}
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		this.view = view;
		desktop = Executions.getCurrent().getDesktop();

		// if (!desktop.isServerPushEnabled()) {
		// desktop.enableServerPush(true);
		// }
		// new Thread(new QueryVoltageTask()).start();
		uploadBtn1.addEventListener(Events.ON_UPLOAD, new UploadEventListener(pic1));
	}

	@Command
	public void submitForm() {
		try {
			// genElecInfo.setItBillId(selectedITBill.getItBillId());
			genElecInfo.setStartTime(new Date());
			genElecInfo.setStatus(2);
			String[] arrayStr = genElecInfo.getPic1().split("\\.");
			String markedPicPath = arrayStr[0] + "_marked" + "." + arrayStr[1];
			ElecImgMark.mark(genElecInfo.getPic1(), markedPicPath, Color.WHITE, genElecInfo, 1);

			genElecInfo.setPic1(markedPicPath);
			gelecService.addGElecInfo(genElecInfo);
			WebAppUtil.setWebSessionAttribute("gElecInfo", genElecInfo);
			WebAppUtil.getElecIncludePage().setSrc("gelist.zul");
		} catch (Exception e) {
			e.printStackTrace();
			WebAppUtil.getElecIncludePage().setSrc("geindex.zul");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.bind.Validator#validate(org.zkoss.bind.ValidationContext)
	 */
	@Override
	public void validate(ValidationContext ctx) {
		this.vcx = ctx;
		Map<String, Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
		try {
			String person = beanProps.get("person").getValue().toString().trim();
			if (person.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写发电人!");
		}
		try {
			String contact = beanProps.get("contact").getValue().toString().trim();
			if (contact.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写联系方式!");
		}

		if (StringUtils.isEmpty(getGenElecInfo().getPic1())) {
			addInvalidMessage(vcx, "key", "请上传一张开始发电照片!");
		}
	}

	class UploadEventListener implements EventListener<UploadEvent> {
		private Image imgComp;

		public UploadEventListener(Image imgComp) {
			this.imgComp = imgComp;
		}

		/*
		 * (non-Javadoc)
		 * @see org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss.zk.ui.event.Event)
		 */
		@Override
		public void onEvent(UploadEvent event) throws Exception {
			org.zkoss.util.media.Media media = event.getMedia();
			if (media instanceof org.zkoss.image.Image) {
				org.zkoss.image.Image img = (org.zkoss.image.Image) media;

				// if (img.getWidth() > img.getHeight()) {
				// if (img.getHeight() > 90) {
				// imgComp.setHeight("90px");
				// imgComp.setWidth(img.getWidth() * 90 / img.getHeight() + "px");
				// }
				// }
				// if (img.getHeight() > img.getWidth()) {
				// if (img.getWidth() > 100) {
				// imgComp.setWidth("100px");
				// imgComp.setHeight(img.getHeight() * 100 / img.getWidth() + "px");
				// }
				// }
				imgComp.setWidth("100%");
				String dirPath = "/data/itower/genElec-upload";
				java.io.File dir = new java.io.File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String path = dirPath + java.io.File.separator + getSelectedITBill().getBillCode()
						+ "_" + System.currentTimeMillis() + ".jpg";
				BufferedImage bi = ImageIO.read(img.getStreamData());
				// 缩放并存储
				ImageUtil.scaleImage2(bi, path, 0.5, "jpg");

				imgComp.setContent(ImageIO.read(new File(path)));
				if (imgComp == pic1) {
					genElecInfo.setPic1(path);
				}
			} else {

			}
		}
	}

	// class QueryVoltageTask implements Runnable {
	//
	// public void run() {
	// try {
	// if (view.getPage() == null || desktop == null || !desktop.isAlive()) {
	// Thread.currentThread().interrupt();
	// return;
	// }
	// String voltage = "";
	// final ExecutorService service = Executors.newSingleThreadExecutor();
	// Future<String> f = service.submit(new Callable<String>() {
	// @Override
	// public String call() throws Exception {
	// String v = QueryResult.NODATA.getValue();
	// StationBattery stab = stationService.getStationBattery(selectedITBill.getStationCode());
	// if (stab != null) {
	// try {
	// v = itower.queryVoltageRT(selectedITBill.getItProvinceId(), selectedITBill.getItCityId(), stab.getStationsid(),
	// stab.getStationcode(), stab.getBatteryid());
	// } catch (ServiceException e) {
	// v = QueryResult.TIMEOUT.getValue();
	// }
	// }
	// return ItowerImpl.formatVoltage(v);
	// }
	// });
	// try {
	// voltage = f.get(30, TimeUnit.SECONDS);
	// } catch (InterruptedException e) {
	// f.cancel(true);
	// voltage = QueryResult.INTERRUPT.getValue();
	// } catch (ExecutionException e) {
	// f.cancel(true);
	// voltage = QueryResult.TIMEOUT.getValue();
	// } catch (TimeoutException e) {
	// f.cancel(true);
	// voltage = QueryResult.TIMEOUT.getValue();
	// } finally {
	// service.shutdown();
	// }
	// if (StringUtils.isNotEmpty(voltage)) {
	// try {
	// if (desktop != null && desktop.isAlive()) {
	// Executions.activate(desktop);
	// genElecInfo.setStartVoltage(voltage);
	// vloaddingImg.setVisible(false);
	// vLbl.setValue(voltage);
	// Executions.deactivate(desktop);
	// }
	// } catch (DesktopUnavailableException e) {
	// return;
	// } catch (InterruptedException e) {
	// return;
	// }
	// }
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }
	// }
}