package com.crmSDETDataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetExcelData {
	@Test
	
	public void readExcelData() throws Throwable   {
		//fetch only 1st and 2nd column data from all the rows
 		FileInputStream fis = new FileInputStream ("./data/ExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowNo = sheet.getLastRowNum();//2
		int rowNo1 = sheet.getPhysicalNumberOfRows();//3
		
		for (int i=1; i<=rowNo;i++)   {
				
			Row row = sheet.getRow(1);
			System.out.println(row.getCell(0).getStringCellValue());
			System.out.println(row.getCell(1).getStringCellValue());
			System.out.println(rowNo);
			System.out.println(rowNo1);
		}
		
		
	}
}
