package com.fuhj.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.fuhj.log.AppLogger;

public class ConfigReader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8848806147397673927L;
	private static final String APP_CONFIG_PATH = SpringUtil.getWebAppPath() + "/WEB-INF/classes/";
	private static final Map<String, Properties> CACHED_PROPERTY_FILE = new HashMap<String, Properties>();
	private static final Map<String, Long> PROPERTY_LOAD_TIME = new HashMap<String, Long>();
	private static final String DEFAULT_PROPERTY_NAME = "itowerElec";

	/**
	 * 从默认的配置文件中读取路径
	 * 
	 * @param propertyKey 路径对应的属性名称
	 * @param createPath 路径不存在时是否创建该路径
	 * @return
	 */
	public static String getPath(String propertyKey, boolean createPath) {
		String fullPathName = getProperty(propertyKey);
		File path = new File(fullPathName);
		if (!path.exists() || !path.isDirectory()) {
			fullPathName = path.getAbsolutePath().replaceAll("\\\\", "/");
			if (createPath && ((fullPathName.startsWith("/") && fullPathName.length() > 1) || fullPathName.length() > 3)) {
				if (!path.mkdirs()) {
					throw new IllegalArgumentException("目录创建失败：" + fullPathName);
				}
			}
		}
		return path.getAbsolutePath() + File.separator;
	}

	/**
	 * 从默认的配置文件中读取文件路径
	 * 
	 * @param propertyKey 文件对应的属性名称
	 * @param createFile 文件不存在时是否创建
	 * @return
	 */
	public static String getFile(String propertyKey, boolean createFile) {
		String fullFileName = getProperty(propertyKey);
		File file = new File(fullFileName);
		if (!file.exists() || !file.isFile()) {
			if (createFile) {
				String fullPath = file.getAbsolutePath().replaceAll("\\\\", "/");
				int idx = fullPath.lastIndexOf("/");
				if (idx > 0) {
					fullPath = fullPath.substring(0, idx);
					if (fullPath.startsWith("/") || (fullPath.length() > 3)) {
						File path = new File(fullPath);
						if (!path.exists() || !path.isDirectory()) {
							if (!path.mkdirs()) {
								throw new IllegalArgumentException("文件创建失败：" + fullFileName);
							}
						}
					}
				}
				try {
					if (!file.createNewFile()) {
						throw new IllegalArgumentException("文件创建失败：" + fullFileName);
					}
				} catch (IOException e) {
					throw new IllegalArgumentException("文件创建失败：", e);
				}
			}
		}
		return file.getAbsolutePath();
	}

	/**
	 * 从默认的配置文件中读取属性值
	 * 
	 * @param propertyKey
	 * @return
	 */
	public static String getProperty(String propertyKey) {
		return getProperty(DEFAULT_PROPERTY_NAME, propertyKey, false);
	}

	/**
	 * 从指定的配置文件中读取属性值
	 * 
	 * @param propertyFileName
	 * @param propertyKey
	 * @return
	 */
	public static String getProperty(String propertyFileName, String propertyKey) {
		return getProperty(propertyFileName, propertyKey, false);
	}

	/**
	 * 从指定的配置文件中读取属性值
	 * 
	 * @param propertyFileName
	 * @param propertyKey
	 * @param reload
	 * @return
	 */
	public static String getProperty(String propertyFileName, String propertyKey, boolean reload) {
		try {
			loadProperty(propertyFileName, reload);
			Properties prop = CACHED_PROPERTY_FILE.get(propertyFileName);
			String value = prop.getProperty(propertyKey);
			if (value != null) {
				return value;
			} else {
				throw new NullPointerException(propertyFileName + ": " + propertyKey);
			}
		} catch (MissingResourceException e) {
			throw new NullPointerException(propertyFileName);
		}
	}

	/**
	 * 重新加载属性文件到缓存
	 * 
	 * @param propertyFileName 属性文件
	 * @param reload 是否重新加载
	 * @throws MissingResourceException
	 */
	private static void loadProperty(String propertyFileName, boolean reload) throws MissingResourceException {
		if (reload || CACHED_PROPERTY_FILE.get(propertyFileName) == null) {
			Properties prop = new Properties();
			try {
				ResourceBundle res = ResourceBundle.getBundle(propertyFileName);
				Enumeration<String> keys = res.getKeys();
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					String value = res.getString(key);
					prop.put(key, value);
					// System.out.println(key + ":" + value);
				}
				CACHED_PROPERTY_FILE.put(propertyFileName, prop);
				PROPERTY_LOAD_TIME.put(propertyFileName, new Date().getTime());
			} catch (MissingResourceException e) {
				AppLogger.sysError("读取配置文件错误: 文件未找到->" + propertyFileName + ".properties", e);
				throw e;
			}
		}
	}

	// -----------------------------liao added the following

	/**
	 * 检查配置文件上次读取后是否已修改，如果修改就重新读取
	 * 
	 * @param propertyFileName
	 */
	public static void reloadFileIfModified(String propertyFileName) {
		Long propertyLoadTime = PROPERTY_LOAD_TIME.get(propertyFileName);
		Long fileModifiedTime = 0L;

		File file = new File(APP_CONFIG_PATH + propertyFileName + ".properties");
		fileModifiedTime = file.lastModified();

		if (propertyLoadTime == null || (fileModifiedTime > propertyLoadTime)) {
			loadProperty(propertyFileName, true);
		}

	}

	/**
	 * 根据文件名取得所有属性
	 * 
	 * @param propertyFileName
	 * @return
	 */
	public static Properties getProperties(String propertyFileName) {
		if (CACHED_PROPERTY_FILE.get(propertyFileName) == null) {
			loadProperty(propertyFileName, false);
		}
		return CACHED_PROPERTY_FILE.get(propertyFileName);
	}

	public static void main(String[] args) {
		// System.out.println(Locale.getDefault());
		// System.out.println(Locale.getDefault().getCountry());
		// System.out.println(Locale.getDefault().getLanguage());
		// loadProperty(DEFAULT_PROPERTY_NAME, true);
	}
}
