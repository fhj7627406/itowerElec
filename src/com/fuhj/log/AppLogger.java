package com.fuhj.log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fuhj.itower.service.model.Users;
import com.fuhj.util.ConfigReader;
import com.fuhj.util.WebAppUtil;

public class AppLogger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3042544628652791771L;
	private static final Map<String, Level> LOG_LEVEL_MAP = new HashMap<String, Level>();
	private static final Logger SYSTEM_LOGGER = Logger.getLogger("SystemLogger");
	private static final Logger USER_LOGGER = Logger.getLogger("UserLogger");
	private static final boolean SHOW_CODE_LINE = new Boolean(ConfigReader.getProperty("SHOW_SRC_LINE_NUMBER"));

	/**
	 * 初始化变量，判断是否显示调试代码行号
	 */
	static {
		USER_LOGGER.setLevel(Level.DEBUG);
		readLogLevelMap();
	}

	/**
	 * 从log4j.properties读取日志配置级别
	 */
	private static final void readLogLevelMap() {
		ResourceBundle resource = null;
		try {
			resource = ResourceBundle.getBundle("log4j");
		} catch (MissingResourceException e) {
			sysError("文件未找到: log4j.properties");
			throw new IllegalArgumentException("log4j");
		}

		for (String key : resource.keySet()) {
			if (key.startsWith("log4j.logger.")) {
				String catalog = key.substring("log4j.logger.".length());
				Level level = convert(resource.getString(key));
				LOG_LEVEL_MAP.put(catalog, level);
			}
		}
	}

	/**
	 * 根据配置级别转换为日志级别
	 * 
	 * @param name
	 * @return
	 */
	private static final Level convert(String name) {
		String tmp = name.trim();
		if ("INFO".equalsIgnoreCase(tmp)) {
			return Level.INFO;
		} else if ("WARN".equalsIgnoreCase(tmp)) {
			return Level.WARN;
		} else if ("ERROR".equalsIgnoreCase(tmp)) {
			return Level.ERROR;
		} else if ("FATAL".equalsIgnoreCase(tmp)) {
			return Level.FATAL;
		} else {
			return Level.DEBUG;
		}
	}

	/**
	 * 查找最匹配的日志级别
	 * 
	 * @param className
	 * @return
	 */
	private static final Level matchLogLevel(String className) {
		Level level = null;
		String tmp = className;
		while (true) {
			level = LOG_LEVEL_MAP.get(tmp);
			if (level != null) {
				break;
			} else {
				int dotIndex = tmp.lastIndexOf(".");
				if (dotIndex < 0) {
					break;
				}
				tmp = tmp.substring(0, dotIndex);
			}
		}
		if (level == null) {
			level = Level.DEBUG; // 缺省日志级别
			LOG_LEVEL_MAP.put(className, level);
		}
		return level;
	}

	public static final void userOperate(Integer permissionId, String desc) {
		userOperate(permissionId, desc, null, null, null);
	}

	public static final void userOperate(Integer permissionId, String desc, Throwable e) {
		userOperate(permissionId, desc, null, null, e);
	}

	public static final void userOperate(Integer permissionId, String desc, Long srcId, Long destId, Throwable e) {
		Users user = WebAppUtil.getSessionUser();
		String info = null;
		if (user == null) {
			info = "未登录";
		} else {
			info = user.getLoginname();
		}
		info += (desc == null ? "" : "," + desc) + (srcId == null ? "" : "," + srcId) + (destId == null ? "" : "," + destId)
				+ (e == null ? "" : "," + e.getMessage());

		int logLevel = 1;
		if (e == null) {
			logLevel = 2;
			USER_LOGGER.info(info);
		} else {
			if (e instanceof Exception) {
				logLevel = 3;
			} else if (e instanceof Error) {
				logLevel = 4;
			}
			USER_LOGGER.error(info, e);
		}

		// String[] names = operationLogService.getPermissionName(permissionId);
		// OperationLog log = new OperationLog();
		// log.useValue(logLevel, user, names, e, desc, srcId, destId);
		// operationLogService.addOperationLog(log);

		// sysInfo(info);
	}

	public static final void sysDebug(Object object) {
		sysDebug(object, null);
	}

	public static final void sysDebug(Throwable e) {
		sysDebug(null, e);
	}

	public static final void sysDebug(Object object, Throwable e) {
		log(object, e, Level.DEBUG);
	}

	public static final void sysInfo(Object object) {
		sysInfo(object, null);
	}

	public static final void sysInfo(Throwable e) {
		sysInfo(null, e);
	}

	public static final void sysInfo(Object object, Throwable e) {
		log(object, e, Level.INFO);
	}

	public static final void sysWarning(Object object) {
		sysWarning(object, null);
	}

	public static final void sysWarning(Throwable e) {
		sysWarning(null, e);
	}

	public static final void sysWarning(Object object, Throwable e) {
		log(object, e, Level.WARN);
	}

	public static final void sysError(Object object) {
		sysError(object, null);
	}

	public static final void sysError(Throwable e) {
		sysError(null, e);
	}

	public static final void sysError(Object object, Throwable e) {
		log(object, e, Level.ERROR);
	}

	public static final void log(Object object, Throwable e, Level level) {
		if (object == null && e == null) {
			return;
		}

		Level matchLevel = Level.DEBUG;
		if (SHOW_CODE_LINE) {
			String printClassName = null;
			StringBuilder sb = new StringBuilder();

			StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
			if (steArray.length > 0) {
				String printFileName = null;
				String curFileName = null;
				int lastInfoLen = 0;
				for (int i = steArray.length - 1; i >= 0; i--) {
					StackTraceElement ste = steArray[i];
					curFileName = ste.getFileName();
					String className = ste.getClassName();
					if (printClassName == null) {
						printClassName = className;
					}
					if (ste.getLineNumber() > 0 && !"AppLogger.java".equals(curFileName) && className.startsWith("com.fuhj.itower")) {
						if (printFileName == null) {
							printFileName = curFileName;
						} else if (!printFileName.equals(curFileName)) {
							break;
						}
						String classAndLine = "" + className + "." + ste.getMethodName() + "(" + ste.getLineNumber() + "): ";
						lastInfoLen = classAndLine.length();
						if (sb.length() > 0) {
							sb.insert(0, classAndLine + "\r\n\t");
						} else {
							sb.append(classAndLine);
						}
					}
				}
				if (object == null) {
					object = sb.toString();
				} else {
					object = sb.insert(lastInfoLen, object.toString()).toString();
				}
			}

			if (printClassName != null) {
				matchLevel = matchLogLevel(printClassName);
			}
		}

		synchronized (matchLevel) {
			// 打印级别高于设定级别才打印日志
			SYSTEM_LOGGER.setLevel(matchLevel);
			if (level.equals(Level.DEBUG)) {
				if (e == null) {
					SYSTEM_LOGGER.debug(object);
				} else {
					SYSTEM_LOGGER.debug(object, e);
				}
			} else if (level.equals(Level.INFO)) {
				if (e == null) {
					SYSTEM_LOGGER.info(object);
				} else {
					SYSTEM_LOGGER.info(object, e);
				}
			} else if (level.equals(Level.WARN)) {
				if (e == null) {
					SYSTEM_LOGGER.warn(object);
				} else {
					SYSTEM_LOGGER.warn(object, e);
				}
			} else {
				if (e == null) {
					SYSTEM_LOGGER.error(object);
				} else {
					SYSTEM_LOGGER.error(object, e);
				}
			}
		}
	}
}
