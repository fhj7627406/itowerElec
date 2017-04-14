/**
 * 
 */
package com.fuhj.itower.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-16
 */
public class TaskReader {
	public List<ConfigTask> getDZConfigTasks(String xmlFileName) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(getClass().getResource(xmlFileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		Element tasks = root.element("tasks");
		List<ConfigTask> dzConfigTasks = new ArrayList<ConfigTask>();
		for (@SuppressWarnings("rawtypes") Iterator it = tasks.elements("task").iterator(); it.hasNext();) {
			Element task = (Element) it.next();
			ConfigTask taskConfig = new ConfigTask();
			for (@SuppressWarnings("rawtypes") Iterator itChild = task.elements().iterator(); itChild.hasNext();) {
				Element taskChild = (Element) itChild.next();
				if (taskChild.getName().equals(ConfigTask.CHATROOMNAME)) {
					taskConfig.setChatRoomName(taskChild.getText());
				}
				if (taskChild.getName().equals(ConfigTask.RANGE)) {
					taskConfig.setRange(taskChild.getText());
				}
			}
			dzConfigTasks.add(taskConfig);
		}
		return dzConfigTasks;
	}
}
