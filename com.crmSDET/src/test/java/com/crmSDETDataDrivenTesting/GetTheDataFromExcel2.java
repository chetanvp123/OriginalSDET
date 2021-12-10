package com.crmSDETDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetTheDataFromExcel2 {
@Test
		
	public void getData1 () throws Throwable  {
	//check the cell, has if it is there fetch next cell value
	
	FileInputStream  file =  new FileInputStream ("./data/ExcelData.xlsx");
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet("Sheet1");
	int rowNo = sheet.getLastRowNum();
	  String actualValue = sheet.getRow(1).getCell(2).getStringCellValue();
	  String expectedValue = "admin";
	  if (actualValue.equals(expectedValue))  {
		  sheet.getRow(1).getCell(3).toString();
		  //workbook.getSheet("Sheet1").getRow(1).getCell(3).toString();
		  //workbook.getSheet("Sheet1").getRow(2).getCell(1).toString();
		  //workbook.getSheet("Sheet1").getRow(2).getCell(2).toString();
	  }
	  else {
		  System.out.println("no data please quite");
		  
	  }
	
}


}