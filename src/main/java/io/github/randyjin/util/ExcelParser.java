package io.github.randyjin.util;

import io.github.randyjin.enu.ExcelTypeEnu;
import io.github.randyjin.exception.ExcelOutOfMaxException;
import io.github.randyjin.util.excel.Excel2003Utils;
import io.github.randyjin.util.excel.Excel2007Utils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.util.List;

/**
 * ExcelUtils
 *
 * @author 奕超
 * @date 2017/2/15
 */
public class ExcelParser {

	public static List<List<String>> parseExcelOrNumber(File file, int sheetIndex, int rowStart, int rowEnd,
	        int cellStart, int cellEnd, boolean removeBlankRow) throws IOException, ExcelOutOfMaxException {
		InputStream stream = new BufferedInputStream(new FileInputStream(file));
		ExcelTypeEnu excelType = getExcelType(stream);
		if (ExcelTypeEnu.EXCEL_2007.equals(excelType)) {
			return Excel2007Utils.parseExcelInputStream(stream, sheetIndex, rowStart, rowEnd, cellStart, cellEnd,
			        removeBlankRow);
		} else if (ExcelTypeEnu.EXCEL_2003.equals(excelType)) {
			return Excel2003Utils.parseExcelInputStream(stream, sheetIndex, rowStart, rowEnd, cellStart, cellEnd,
			        removeBlankRow);
		}
		return null;
	}

	public static List<List<String>> parseExcelOrNumber(File file, int sheetIndex, int rowStart, int rowEnd,
	        int cellStart, int cellEnd) throws IOException, ExcelOutOfMaxException {
		InputStream stream = new BufferedInputStream(new FileInputStream(file));
		ExcelTypeEnu excelType = getExcelType(stream);
		if (ExcelTypeEnu.EXCEL_2007.equals(excelType)) {
			return Excel2007Utils.parseExcelInputStream(stream, sheetIndex, rowStart, rowEnd, cellStart, cellEnd);
		} else if (ExcelTypeEnu.EXCEL_2003.equals(excelType)) {
			return Excel2003Utils.parseExcelInputStream(stream, sheetIndex, rowStart, rowEnd, cellStart, cellEnd);
		}
		return null;
	}

	public static List<List<String>> parseExcelOrNumber(File file, int sheetIndex, boolean removeBlankRow)
	        throws IOException, ExcelOutOfMaxException {
		InputStream stream = new BufferedInputStream(new FileInputStream(file));
		ExcelTypeEnu excelType = getExcelType(stream);
		if (ExcelTypeEnu.EXCEL_2007.equals(excelType)) {
			return Excel2007Utils.parseExcelInputStream(stream, sheetIndex, removeBlankRow);
		} else if (ExcelTypeEnu.EXCEL_2003.equals(excelType)) {
			return Excel2003Utils.parseExcelInputStream(stream, sheetIndex, removeBlankRow);
		}
		return null;
	}

	public static List<List<String>> parseExcelOrNumber(File file, int sheetIndex)
	        throws IOException, ExcelOutOfMaxException {
		InputStream stream = new BufferedInputStream(new FileInputStream(file));
		ExcelTypeEnu excelType = getExcelType(stream);
		if (ExcelTypeEnu.EXCEL_2007.equals(excelType)) {
			return Excel2007Utils.parseExcelInputStream(stream, sheetIndex);
		} else if (ExcelTypeEnu.EXCEL_2003.equals(excelType)) {
			return Excel2003Utils.parseExcelInputStream(stream, sheetIndex);
		}
		return null;
	}

	private static ExcelTypeEnu getExcelType(InputStream inputStream) throws IOException {
		if (POIXMLDocument.hasOOXMLHeader(inputStream)) {
			return ExcelTypeEnu.EXCEL_2007;
		} else if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {
			return ExcelTypeEnu.EXCEL_2003;
		}
		return null;
	}
}
