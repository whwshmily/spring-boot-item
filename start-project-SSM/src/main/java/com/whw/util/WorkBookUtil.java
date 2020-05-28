package com.whw.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WorkBookUtil {

    public static HSSFWorkbook createWorkBook(String sheetName, String[] title,String[][] data){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i <title.length ; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        for (int i = 0; i <data.length ; i++) {
           row = sheet.createRow(i+1);
            for (int j = 0; j <data[i].length ; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }
        return workbook;
    }


}
