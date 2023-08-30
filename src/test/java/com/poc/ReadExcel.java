package com.poc;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	static XSSFWorkbook myExcelWorkBook;
	static XSSFSheet myExcelSheet;
	
	public static void main(String[] args) {
		
		String fs = System.getProperty("file.separator");
		String excelFile = System.getProperty("user.dir")+fs+"src"+fs+"test"+fs+"resources"+fs+"data"+fs+"CustReg.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(excelFile);
			myExcelWorkBook = new XSSFWorkbook(inputStream);
			myExcelSheet = myExcelWorkBook.getSheet("Sheet1");
			int numOfRows = myExcelSheet.getLastRowNum() - myExcelSheet.getFirstRowNum();
				
			for(int i=0; i<=numOfRows;i++) {
				XSSFRow row = myExcelSheet.getRow(i);
				for(int j=0; j<row.getLastCellNum();j++) {
					if(row.getCell(j).getCellType()==Cell.CELL_TYPE_STRING) {
						System.out.print(row.getCell(j).getStringCellValue()+"\t");
						}
					else if(row.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC) {
							System.out.print(row.getCell(j).getNumericCellValue()+"\t");
						}
					}
				System.out.println(" ");
				}
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				}
	}

}
