package com.youe.cd.test.dao;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PoiExcelDao {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void checkExcelValid(String excelFilePath) throws Exception{
        File file = new File(excelFilePath);

        if(!file.exists()) {
            throw new Exception("文件不存在: " + excelFilePath);
        }

        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new Exception("文件不是Excel: " + excelFilePath);
        }
    }

    public static Sheet getExcelSheet(String excelFilePath) {
        Workbook wb = null;
        Sheet sheet = null;

        try {
            checkExcelValid(excelFilePath);

            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);

            if(file.getName().endsWith(EXCEL_XLS)) {
                wb = new HSSFWorkbook(fis);
            } else if(file.getName().endsWith(EXCEL_XLSX)) {
                wb = new XSSFWorkbook(fis);
            }

            sheet = wb.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sheet;
    }

    public static Sheet getExcelSheet(String excelFilePath, int sheetNum) {
        Workbook wb = null;
        Sheet sheet = null;

        try {
            checkExcelValid(excelFilePath);

            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);

            if(file.getName().endsWith(EXCEL_XLS)) {
                wb = new HSSFWorkbook(fis);
            } else if(file.getName().endsWith(EXCEL_XLSX)) {
                wb = new XSSFWorkbook(fis);
            }

            sheet = wb.getSheetAt(sheetNum);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sheet;
    }

    /**
     * 行数(从0开始）,注意：包括所有有使用的行（包括表格等）
     * @param excelFilePath
     * @return
     */
    public static int getExcelSheetRowsSize(String excelFilePath) {
        Sheet sheet = getExcelSheet(excelFilePath);
        int rowsSize = sheet.getLastRowNum();

        return rowsSize;
    }

    public static String getCellContent(String excelFilePath, int x, int y) {
        String cellContentStr = null;

        Sheet sheet = getExcelSheet(excelFilePath, 0);
        Row row = sheet.getRow(y);
        Cell cell = row.getCell(x);
        cell.setCellType(CellType.STRING);  //重要：设置cell类型。有number类型的数据时，需要把它转化为纯String类型
        cellContentStr = cell.getStringCellValue();

        return cellContentStr;
    }

}
