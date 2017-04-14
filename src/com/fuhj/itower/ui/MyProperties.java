/**
 * 
 */
package com.fuhj.itower.ui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.fuhj.log.AppLogger;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-19
 */
public class MyProperties {
	public static final String COOKIEFILE = SpringUtil.getWebAppPath() + "WEB-INF" + File.separator + "cookie.properties";

	public static synchronized String getValueByKey(String filePath, String key) {
		Properties pps = new Properties();
		try {
			File f = new File(filePath);
			if (!f.exists())
				return null;

			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			pps.load(in);
			String value = pps.getProperty(key);
//			AppLogger.sysDebug("getValueByKey:" + key + " = " + value);
			in.close();
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 写入Properties信息
	public static synchronized void writeProperties(String filePath, String pKey, String pValue) throws IOException {
		AppLogger.sysDebug("writeProperties:" + filePath + " " + pKey + " = " + pValue);
		Properties pps = new Properties();
		File f = new File(filePath);
		if (!f.exists())
			f.createNewFile();

		InputStream in = new FileInputStream(filePath);
		// 从输入流中读取属性列表（键和元素对）
		pps.load(in);
		// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
		// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
		OutputStream out = new FileOutputStream(filePath);
		pps.setProperty(pKey, pValue);
		// 以适合使用 load 方法加载到 Properties 表中的格式，
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		pps.store(out, "Update " + pKey);
		out.close();
		in.close();
	}
}
