package com.crmSDETDataDrivenTesting;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
@Test
public class GetDataExcel {
		
		
		
	public void getData () throws Throwable, IOException  {
		// getting different type of data from excel
		FileInputStream fis = new FileInputStream ("./data/ExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		 String browser = workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		 String url = workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		 String username = workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheet("Sheet1").getRow(1).getCell(3).toString();
		double phone = workbook.getSheet("Sheet1").getRow(1).getCell(4).getNumericCellValue();
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(phone);
	}
}
