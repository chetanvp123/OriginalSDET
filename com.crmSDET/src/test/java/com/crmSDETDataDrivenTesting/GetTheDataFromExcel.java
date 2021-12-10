package com.crmSDETDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcel {
	@Test
	public void GetDataExcel () throws Throwable  {
		// basic program how to fetch data 
		FileInputStream fis = new FileInputStream ("./data/ExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row rowNo = sheet.getRow(0);
		Cell cellNo = rowNo.getCell(0);
		String cellValue = cellNo.getStringCellValue();
		System.out.println(cellValue);
	}

}
