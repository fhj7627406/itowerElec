package com.fuhj.itower.ui;



import org.apache.commons.lang.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Div;

public class IncludeDiv extends Div {
	public static final String PREVIOUS_SRC = "PREVIOUS_SRC";
	public static final String CURRENT_SRC = "CURRENT_SRC";
	private Component currentComp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1835229740441303356L;

	public Component setSrc(String src) {
		if (src != null && src.equals(getAttribute(CURRENT_SRC))) {
			return currentComp;
		}
		if (currentComp != null) {
			currentComp.detach();
		}
		if (StringUtils.isEmpty(src)) {
			return null;
		}

		Component comp = null;
		try {
			comp = Executions.getCurrent().createComponents(src, this, null);
			currentComp = comp;
			setAttribute(PREVIOUS_SRC, removeAttribute(CURRENT_SRC));
			setAttribute(CURRENT_SRC, src);
		} catch (Exception e) {
			if (comp != null) {
				comp.detach();
				comp = null;
			}
		}
		return comp;
	}
}
