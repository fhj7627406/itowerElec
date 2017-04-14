package com.fuhj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fuhj.log.AppLogger;

public class ExcelUtil {

	/**
	 * 读Excel文件到二维字符串数组
	 * 
	 * @param fileName
	 * @param sheetName
	 * @param sheetIndex
	 * @return
	 * @throws Exception
	 */
	public static String[][] readSheet(String fileName, String sheetName, Integer sheetIndex) throws Exception {

		File file = new File(fileName);
		if (!file.exists() || !file.canRead()) {
			throw new IllegalArgumentException("指定的Excel文件不存在或不可读:" + fileName);
		}
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		return readSheet(workbook, sheetName, sheetIndex);
	}

	public static String[][] readSheet(HSSFWorkbook workbook, String sheetName, Integer sheetIndex) throws Exception {
		List<String[]> dataList = new ArrayList<String[]>();
		try {
			if (workbook == null) {
				throw new IllegalArgumentException("指定的Excel文件不存在或不可读");
			}

			HSSFSheet sheet = null;
			if (sheetName != null) {
				sheet = workbook.getSheet(sheetName);
			} else if (sheetIndex != null) {
				sheet = workbook.getSheetAt(sheetIndex);
			} else {
				sheet = workbook.getSheetAt(0);
			}
			if (sheet == null) {
				throw new IllegalArgumentException("指定的Sheet不存在.");
			}
			String[] data = null;
			int rows = sheet.getPhysicalNumberOfRows();
			for (int rowNum = 0; rowNum < rows; rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					String value = "";
					for (int cellNum = 0; cellNum < cells; cellNum++) {
						HSSFCell cell = row.getCell(cellNum);
						if (cell != null) {
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_FORMULA:
								value = "";
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								
								value = String.valueOf(cell.getNumericCellValue());
								break;
							case HSSFCell.CELL_TYPE_STRING:
								value = cell.getStringCellValue().replaceAll(" ", "");
								break;
							default:
								value = "";
							}
							if (cellNum == 0) {
								data = new String[cells];
								dataList.add(data);
							}
							data[cellNum] = value;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		String[][] array = new String[dataList.size()][];
		for (int i = 0; i < array.length; i++) {
			array[i] = dataList.get(i);
		}
		return array;
	}

	/**
	 * 将Excel对象写入文件
	 * 
	 * @param fileName 文件名
	 * @param wb Excel对象
	 * @return
	 */
	public static File writeWorkbook(final String fileName, final HSSFWorkbook wb) {
		AppLogger.sysDebug("writeWorkbook:" + fileName);
		if (wb == null) {
			return null;
		}
		try {
			File file = new File(fileName);
			if (file.exists()) {
				file.delete();
			}
			if (!file.createNewFile()) {
				throw new IllegalArgumentException("文件创建失败:" + fileName);
			}
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
			return file;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// public static File writeWorkbook(final String fileName, final
	// XSSFWorkbook wb) {
	// if (wb == null) {
	// return null;
	// }
	// try {
	// File file = new File(fileName);
	// if (!file.exists()) {
	// if (!file.createNewFile()) {
	// throw new IllegalArgumentException("文件创建失败:" + fileName);
	// }
	// }
	// FileOutputStream fileOut = new FileOutputStream(file);
	// wb.write(fileOut);
	// fileOut.close();
	//
	// return file;
	// } catch (IOException e) {
	// return null;
	// }
	// }
}
