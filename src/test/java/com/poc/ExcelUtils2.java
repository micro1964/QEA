package com.poc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtils2 {

	// Use the below declarations
	public static File src;

	public static String exfilepath = "InvoiceData.xlsx";

	public static FileInputStream fileip;

	public static FileOutputStream fileop;

	public static XSSFWorkbook workbook;

	public static XSSFSheet sheet;

	public static XSSFCell cell;

	public static XSSFRow Row;

	public static int row;

	public static String[] testval = new String[8];

	public static void readExcelData(int rownum, String sheetname) { // Do not change the method signature

		// Assign rownum to 'row'
		row = rownum;
		// Using the sheet name passed to this method,read the data and store it in a string array
		try {
			// Get the excel file path
			// String[] testval = null;

			String fs = System.getProperty("file.separator");
			String file_path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
					+ "data" + fs + "InvoiceData.xlsx";

			src = new File(file_path);

			// Create an object of FileInputStream class to create reading of data from excel file
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);

			// Excel sheet name 'TestData' is passed as parameter 'sheetname'
			sheet = workbook.getSheet("TestData");

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			// Store the parsed data from 'testval[0] to testval[7]'
			// Store only the 8 column values in the array.
			for (int i = 1; i <= rowCount; i++) {
				Row = sheet.getRow(i);
				int colCount = sheet.getRow(i).getLastCellNum();
				for (int j = 0; j <= colCount; j++) {
					cell = Row.getCell(j);
					if (cell.getCellType() == 1) {
						testval[j] = cell.getStringCellValue();
					} else if (cell.getCellType() == 0) {
						testval[j] = ((long) cell.getNumericCellValue()) + "";
					}
				}
			}
			// Close input stream
			fileip.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeExcelData(String writeData) {

		String fs = System.getProperty("file.separator");
		String sFileLocation = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "data" + fs + "InvoiceData.xlsx";

		src = new File(sFileLocation);
		try {

			for (int i = 1; i <= 2; i++) {
				FileInputStream fileip = new FileInputStream(src);
				Workbook workbook = new XSSFWorkbook(fileip);
				Sheet sheet = workbook.getSheet("TestData");
				//Sheet sheet = workbook.createSheet("TestData");
				int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
				// sheet.createRow(i).createCell(8).setCellValue(writeData);
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(8);
				/*
				if(cell==null) {
					cell = row.createCell(8);
					}
				*/
				cell.setCellValue(writeData);
				System.out.println("Write to Excel: " + writeData);

				fileop = new FileOutputStream(src);
				workbook.write(fileop);
				workbook.close();
				fileop.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
