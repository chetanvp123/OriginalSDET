package com.crmSDETDataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromTheXMLFile {
	@Test 
	public void fetchTheData (XmlTest xml)  {
		
		String browser=xml.getParameter("browser");
		System.out.println(browser);
		
		String username = xml.getParameter("url");
		System.out.println(username);
		
		String  password = xml.getParameter("browser");
		System.out.println(password);
	}

}
