/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Excel2007Utils.java
 * Author:   奕超
 * Date:    2017/2/16 上午9:43
 * Description:
 */
package io.github.randyjin.util.excel;

import io.github.randyjin.exception.ExcelOutOfMaxException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Excel2007Utils
 *
 * @author 奕超
 * @date 2017/2/16
 */
public class Excel2007Utils extends ExcelCommonUtils {

	/**
	 * 读取excel数据
	 *
	 * @param excelStream
	 *            excel数据流
	 * @param sheetIndex
	 *            第sheetIndex个表格,从0开始计算
	 * @param rowStart
	 *            第一行为0
	 * @param rowEnd
	 *            数据包含rowEnd行
	 * @param cellStart
	 *            第一列为0
	 * @param cellEnd
	 *            数据包含cellEnd列
	 * @param removeBlankRow
	 *            是否移除空行
	 * @return excel数据,里层List为每行数据
	 * @throws IOException
	 */
	public static List<List<String>> parseExcelInputStream(InputStream excelStream, int sheetIndex, int rowStart,
	        int rowEnd, int cellStart, int cellEnd, boolean removeBlankRow) throws IOException, ExcelOutOfMaxException {
		checkRowStartAndRowEnd(rowStart, rowEnd);
		checkCellStartAndCellEnd(cellStart, cellEnd);
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(excelStream);
			int sheetSize = workbook.getNumberOfSheets();
			if (sheetIndex >= sheetSize) {
				return null;
			}
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			checkMaxRowAndMaxCell(sheet, rowEnd, cellEnd);
			return readRows(sheet, rowStart, rowEnd, cellStart, cellEnd, removeBlankRow);
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (excelStream != null) {
				try {
					excelStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读取excel数据
	 *
	 * @param excelStream
	 *            excel数据流
	 * @param sheetIndex
	 *            第sheetIndex个表格,从0开始计算
	 * @param rowStart
	 *            第一行为0
	 * @param rowEnd
	 *            数据包含rowEnd行
	 * @param cellStart
	 *            第一列为0
	 * @param cellEnd
	 *            数据包含cellEnd列
	 * @return excel数据,里层List为每行数据
	 * @throws IOException
	 */
	public static List<List<String>> parseExcelInputStream(InputStream excelStream, int sheetIndex, int rowStart,
	        int rowEnd, int cellStart, int cellEnd) throws IOException, ExcelOutOfMaxException {
		return parseExcelInputStream(excelStream, sheetIndex, rowStart, rowEnd, cellStart, cellEnd, false);
	}

	/**
	 * 读取excel数据
	 *
	 * @param excelStream
	 *            excel数据流
	 * @param sheetIndex
	 *            第sheetIndex个表格,从0开始计算
	 * @param removeBlankRow
	 *            是否移除空行
	 * @return excel数据,里层List为每行数据
	 * @throws IOException
	 */
	public static List<List<String>> parseExcelInputStream(InputStream excelStream, int sheetIndex,
	        boolean removeBlankRow) throws IOException, ExcelOutOfMaxException {
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(excelStream);
			int sheetSize = workbook.getNumberOfSheets();
			if (sheetIndex >= sheetSize) {
				return null;
			}
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			return ExcelCommonUtils.readRows(sheet, 0, ExcelCommonUtils.getRowNumber(sheet), 0,
			        ExcelCommonUtils.getCellNumber(sheet), removeBlankRow);
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (excelStream != null) {
				try {
					excelStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 读取excel数据
	 *
	 * @param excelStream
	 *            excel数据流
	 * @param sheetIndex
	 *            第sheetIndex个表格,从0开始计算
	 * @return excel数据,里层List为每行数据
	 * @throws IOException
	 */
	public static List<List<String>> parseExcelInputStream(InputStream excelStream, int sheetIndex)
	        throws IOException, ExcelOutOfMaxException {
		return parseExcelInputStream(excelStream, sheetIndex, false);
	}

}
