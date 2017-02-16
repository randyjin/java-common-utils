package io.github.randyjin.util.excel;

import io.github.randyjin.exception.ExcelOutOfMaxException;
import io.github.randyjin.util.excel.ExcelParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * ExcelUtilsTest
 *
 * @author 奕超
 * @date 2017/2/15
 */
public class ExcelUtilsTest {

	@Test
	public void testXlsxRemoveBlankRow() throws IOException, ExcelOutOfMaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.xlsx").getFile());
		List<List<String>> excelContent = ExcelParser.parseExcelOrNumber(file,0, 0,5,0,5, true);
		System.out.println(excelContent);
	}

	@Test
	public void testXlsxWithRowAndCell() throws IOException, ExcelOutOfMaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.xlsx").getFile());
		List<List<String>> excelContent = ExcelParser.parseExcelOrNumber(file,0, 0,4,0,4);
		System.out.println(excelContent);
	}

	@Test
	public void testXlsxWithoutRowAndCellWithRemoveBlankRow() throws IOException, ExcelOutOfMaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.xlsx").getFile());
		List<List<String>> excelContent = ExcelParser.parseExcelOrNumber(file,0, true);
		System.out.println(excelContent);
	}

	@Test
	public void testXlsxWithoutRowAndCell() throws IOException, ExcelOutOfMaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.xlsx").getFile());
		List<List<String>> excelContent = ExcelParser.parseExcelOrNumber(file,0);
		System.out.println(excelContent);
	}

	@Test
	public void testXls() throws IOException, ExcelOutOfMaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test2.xls").getFile());
		List<List<String>> excelContent = ExcelParser.parseExcelOrNumber(file,0, 0,4,0,4, true);
		System.out.println(excelContent);
	}

	@Test
	public void testNumbers() {

	}
}
