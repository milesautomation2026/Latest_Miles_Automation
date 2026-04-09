package com.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;
    private FileInputStream fileInputStream;

    public ExcelUtils(String excelFilePath) {
        try {
            fileInputStream = new FileInputStream(new File(excelFilePath));
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get row count in a sheet
    public int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }

    // Get column count in a sheet
    public int getColumnCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // Get data from a cell
    public String getCellData(String sheetName, int rowNum, int colNum) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.toString();
    }

    // Write data to a cell
    public void setCellData(String sheetName, int rowNum, int colNum, String value) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);

        try (FileOutputStream fos = new FileOutputStream(new File("path_to_your_excel_file.xlsx"))) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Close the workbook
    public void closeWorkbook() throws IOException {
        workbook.close();
        fileInputStream.close();
    }
}
