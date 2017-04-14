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
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radiogroup;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.GElecInfo;
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
public class GElecSubmitVM extends AbstractValidator {
	private Component view;
	private Desktop desktop;
	private ValidationContext vcx;
	private GelecService gelecService;
	private StationService stationService;
	private final ItowerImpl itower = new ItowerImpl();
//	@Wire
//	private Image vloaddingImg;
//	@Wire
//	private Label vLbl;
	@Wire
	private Button uploadBtn2;
	@Wire
	private Image pic2;

	@Getter
	@Setter
	private GElecInfo genElecInfo;

	@Init
	public void init() {
		WebAppUtil.setElecPageTitle("上传结束发电信息");
		gelecService = SpringUtil.getBean(GelecService.class);
		stationService = SpringUtil.getBean(StationService.class);
		Object obj = WebAppUtil.getWebSessionAttribute("gElecInfo");
		if (obj != null) {
			setGenElecInfo((GElecInfo) obj);
			getGenElecInfo().setMachineCount(1);
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
		uploadBtn2.addEventListener(Events.ON_UPLOAD, new UploadEventListener(pic2));
	}

	@Command
	public void submitForm() {
		try {
			getGenElecInfo().setStatus(1);
			getGenElecInfo().setEndTime(new Date());

			String[] arrayStr = genElecInfo.getPic2().split("\\.");
			String markedPicPath = arrayStr[0] + "_marked" + "." + arrayStr[1];
			ElecImgMark.mark(genElecInfo.getPic2(), markedPicPath, Color.WHITE, genElecInfo, 2);
			genElecInfo.setPic2(markedPicPath);
			gelecService.updateGElecInfoEnd(getGenElecInfo());
			WebAppUtil.removeWebSessionAttribute("gElecInfo");
		} catch (Exception e) {
			e.printStackTrace();
			WebAppUtil.getElecIncludePage().setSrc("geindex.zul");
		}
		WebAppUtil.getElecIncludePage().setSrc("gesuccess.zul");
	}

	@Command
	public void machinePowerOnSelect(@BindingParam("target") Component target) {
		Listbox listbox = (Listbox) target;
		getGenElecInfo().setMachinePower(listbox.getSelectedItem().getLabel());
	}

	@Command
	public void machineTypeonCheck(@BindingParam("target") Component target) {
		Radiogroup radiogroup = (Radiogroup) target;
		getGenElecInfo().setMachineType(radiogroup.getSelectedItem().getLabel());
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
			String machineNo = beanProps.get("machineNo").getValue().toString().trim();
			if (machineNo.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写油机编号!");
		}
		try {
			String reason = beanProps.get("reason").getValue().toString().trim();
			if (reason.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写发电原因!");
		}
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
		try {
			String odometer = beanProps.get("odometer").getValue().toString().trim();
			if (odometer.length() == 0)
				throw new RuntimeException();
		} catch (RuntimeException e) {
			addInvalidMessage(vcx, "key", "请填写往返公里数!");
		}

		if (StringUtils.isEmpty(getGenElecInfo().getPic2())) {
			addInvalidMessage(vcx, "key", "请上传一张结束发电照片!");
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
				String path = dirPath + java.io.File.separator + getGenElecInfo().getBillCode()
						+ "_" + System.currentTimeMillis() + ".jpg";
				BufferedImage bi = ImageIO.read(img.getStreamData());
				ImageUtil.scaleImage2(bi, path, 0.5, "jpg");

				imgComp.setContent(ImageIO.read(new File(path)));
				if (imgComp == pic2) {
					genElecInfo.setPic2(path);
				}
			} else {

			}
		}
	}

//	class QueryVoltageTask implements Runnable {
//
//		public void run() {
//			try {
//				if (view.getPage() == null || desktop == null || !desktop.isAlive()) {
//					Thread.currentThread().interrupt();
//					return;
//				}
//				String voltage = "";
//				final ExecutorService service = Executors.newSingleThreadExecutor();
//				Future<String> f = service.submit(new Callable<String>() {
//					@Override
//					public String call() throws Exception {
//						String v = QueryResult.NODATA.getValue();
//						StationBattery stab = stationService.getStationBattery(getGenElecInfo().getStationCode());
//						
//						if (stab != null) {
//							try {
//							v = itower.queryVoltageRT(getGenElecInfo().getItProvinceId(), getGenElecInfo().getItCityId(), stab.getStationsid(),
//											stab.getStationcode(), stab.getBatteryid());
//							} catch (ServiceException e) {
//								v = QueryResult.TIMEOUT.getValue();
//							}
//						} 
//						return ItowerImpl.formatVoltage(v);
//					}
//				});
//				try {
//					voltage = f.get(30, TimeUnit.SECONDS);
//				} catch (InterruptedException e) {
//					f.cancel(true);
//					voltage = QueryResult.INTERRUPT.getValue();
//				} catch (ExecutionException e) {
//					f.cancel(true);
//					voltage = QueryResult.TIMEOUT.getValue();
//				} catch (TimeoutException e) {
//					f.cancel(true);
//					voltage = QueryResult.TIMEOUT.getValue();
//				} finally {
//					service.shutdown();
//				}
//				if (StringUtils.isNotEmpty(voltage)) {
//					try {
//						if (desktop != null && desktop.isAlive()) {
//							Executions.activate(desktop);
//							genElecInfo.setEndVoltage(voltage);
//							vloaddingImg.setVisible(false);
//							vLbl.setValue(voltage);
//							Executions.deactivate(desktop);
//						}
//					} catch (DesktopUnavailableException e) {
//						return;
//					} catch (InterruptedException e) {
//						return;
//					}
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}
//	}
}
