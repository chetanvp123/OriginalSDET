package com.crmSDETDataDrivenTesting;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


public class WriteTheDataFromExcelSheet {
	@Test
	public void writeData() throws Throwable  {
		
		FileInputStream file = new FileInputStream("./data/Data.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
			
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(6);
		cell.setCellValue("WIPRO");
		
		FileOutputStream file2 = new FileOutputStream("./data/ExcelData");
		workbook.write(file2);
		workbook.close();
	}

}
