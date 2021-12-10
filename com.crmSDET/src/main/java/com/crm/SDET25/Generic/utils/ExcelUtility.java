package com.crm.SDET25.Generic.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/** This class contains Generic Methods for reading and writing data from Excel File
 * 
 * @author Shidlingappa 
 *
 */

public class ExcelUtility {
	/**
	 * This Method will Return String Values from Excel Sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
		public String getStringExcelData  (String sheetname, int rowNo, int cellNo) throws Throwable  {
			 FileInputStream file = new FileInputStream (IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(file);
			return workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		
		/**
		 * This method will return the numeric value from Excel sheet
		 * @param sheetname
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws Throwable
		 */
		
		public double getNumericalExcelData  (String sheetname, int rowNo, int cellNo) throws Throwable  {
			FileInputStream file = new FileInputStream (IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(file);
			return workbook.getSheet("sheetname").getRow(rowNo).getCell(cellNo).getNumericCellValue();
		}
		
		/**
		 * This Method will Return Boolean Values from Excel Sheet
		 * @param sheetname
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws Throwable
		 */
		public boolean getBooleanExcelData  (String sheetname, int rowNo,int cellNo ) throws Throwable 
		{
			FileInputStream file = new FileInputStream (IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(file);
			return workbook.getSheet("sheetname").getRow(rowNo).getCell(cellNo).getBooleanCellValue();
		}
		
		/**
		 * This Method will Write Data to Excel Sheet
		 * @param sheetname
		 * @param rowNo
		 * @param cellNo
		 * @param valueToWrite
		 * @throws Throwable
		 */
		
		public void writeDataToExcel (String sheetname, int rowNo, int cellNo, String valueToWrite) throws Throwable    {
			FileInputStream file = new FileInputStream (IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(file);
			workbook.createSheet().createRow(rowNo).createCell(cellNo).setCellValue(valueToWrite);
			
			FileOutputStream file2 = new FileOutputStream ("path");
			workbook.write(file2);
		}
		
		/**
		 * This method will return multiple set of values from excel sheet
		 * @return
		 * @throws Throwable
		 */
		
		public Object[][] getMultipleData () throws Throwable  {
			FileInputStream file = new FileInputStream (IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowNo = sheet.getPhysicalNumberOfRows();
			int cellNo = sheet.getRow(0).getLastCellNum();
			Object[][] data = new Object [rowNo] [cellNo];
			 
			for (int i=0; i<rowNo; i++)  {
				for (int j=0; j<cellNo; j++)  {
				data [i][j] = sheet.getRow(i).getCell(j).toString();
					
				}
			}
				return data;
		}
	}
