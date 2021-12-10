package com.crmSDETDataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SDET25.Generic.utils.ExcelUtility;



public class ReadMultipleDataExcel {
	
	@DataProvider 
	public Object [] [] data () throws Throwable   {
		ExcelUtility eUtil = new ExcelUtility ();
		return eUtil.getMultipleData();
	}

	@Test (dataProvider="data")
	public void getData (String username, String password)  {
		System.out.println(username+" "+password);
	}
	
}
