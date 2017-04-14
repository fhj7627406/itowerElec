/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;

import com.fuhj.itower.model.GElecInfo;
import com.fuhj.itower.model.GElecUser;
import com.fuhj.itower.service.GelecService;
import com.fuhj.util.SpringUtil;
import com.fuhj.util.WebAppUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-28
 */
public class GElecDetailVM {
	private GelecService gelecService;
	private GElecUser current_gelec_user;
	@Wire private Image pic1Img;
	@Getter @Setter private GElecInfo gElecInfo;

	@AfterCompose public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Selectors.wireEventListeners(view, this);
		gelecService = SpringUtil.getBean(GelecService.class);
		Object obj = WebAppUtil.getWebSessionAttribute("gElecInfo");
		if (obj != null) {
			setGElecInfo((GElecInfo) obj);
			File f = new File(gElecInfo.getPic1());
			if (f.exists()) {
				try {
					pic1Img.setContent(ImageIO.read(f));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			Executions.sendRedirect("gemain.zul");
		}
	}

	@Command public void goSubmitGelec() {
		Executions.sendRedirect("gesubmit.zul");
	}

	@Command public void cancelGelec() {
		if (Messagebox.OK == Messagebox.show("取消发电任务？", "取消发电", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, Messagebox.OK)) {
			gelecService.updateGElecInfoCancel(gElecInfo.getGelecInfoId());
			WebAppUtil.removeWebSessionAttribute("gElecInfo");
			Executions.sendRedirect("gemain.zul");
		}
	}

	public static String getImgPath(String path) {
		return path;
	}
}
