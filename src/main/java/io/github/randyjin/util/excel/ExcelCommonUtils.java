package io.github.randyjin.util.excel;

import com.google.common.collect.Lists;
import io.github.randyjin.exception.ExcelOutOfMaxException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * ExcelCommonUtils
 *
 * @author 奕超
 * @date 2017/2/16
 */
public class ExcelCommonUtils {

    protected static List<List<String>> readRows(Sheet sheet, int rowStart, int rowEnd, int cellStart, int cellEnd,
                                               boolean removeBlankRow) {
        List<List<String>> result = Lists.newArrayList();

        for (int rowIndex = rowStart; rowIndex <= rowEnd; rowIndex++) {
            List<String> rowContent = Lists.newArrayList();
            Row row = sheet.getRow(rowIndex);
            boolean isAllBlank = true;
            for (int cellIndex = cellStart; cellIndex <= cellEnd; cellIndex++) {
                String content = readString(row.getCell(cellIndex));
                if (StringUtils.isNotBlank(content)) {
                    isAllBlank = false;
                } else {
                    content = "";
                }
                rowContent.add(content);
            }
            if (removeBlankRow && isAllBlank) {
                continue;
            }
            result.add(rowContent);
        }
        return result;
    }

    protected static int getCellNumber(Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstRow.getPhysicalNumberOfCells();
    }

    protected static int getRowNumber(Sheet sheet) {
        return sheet.getLastRowNum();
    }

    protected static String readString(Cell cell) {
        return StringUtils.trim(readString(cell, ""));
    }

    protected static String readString(Cell cell, String defaultValue) {
        if (cell == null) {
            return defaultValue;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                double val = cell.getNumericCellValue();
                if (Math.floor(val) == val) {
                    return String.valueOf((int) val);
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case Cell.CELL_TYPE_BOOLEAN:
                return Boolean.valueOf(cell.getBooleanCellValue()).toString();
            case Cell.CELL_TYPE_FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    case Cell.CELL_TYPE_STRING:
                        return cell.getRichStringCellValue().getString();
                }
            case Cell.CELL_TYPE_BLANK:
                return defaultValue;
        }
        return defaultValue;
    }

    protected static void checkMaxRowAndMaxCell(Sheet sheet, int rowEnd, int cellEnd) throws ExcelOutOfMaxException {
        if (ExcelCommonUtils.getCellNumber(sheet) < cellEnd) {
            throw new ExcelOutOfMaxException("cellEnd is large than total cell");
        }
        if (ExcelCommonUtils.getRowNumber(sheet) < rowEnd) {
            throw new ExcelOutOfMaxException("rowEnd is large than total row");
        }
    }

    protected static void checkRowStartAndRowEnd(int rowStart, int rowEnd) throws ExcelOutOfMaxException {
        if (rowEnd < rowStart) {
            throw new ExcelOutOfMaxException("rowStart is large than rowEnd");
        }
    }

    protected static void checkCellStartAndCellEnd(int cellStart, int cellEnd) throws ExcelOutOfMaxException {
        if (cellEnd < cellStart) {
            throw new ExcelOutOfMaxException("cellStart is large than cellEnd");
        }
    }
}
