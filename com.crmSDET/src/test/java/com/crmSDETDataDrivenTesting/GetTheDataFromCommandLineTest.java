package com.crmSDETDataDrivenTesting;

import org.testng.annotations.Test;

public class GetTheDataFromCommandLineTest {
@Test 
	public void getData ()  {
	
	String url = System.getProperty("url");
	String username = System.getProperty("username");
	String password = System.getProperty("password");
	
	System.out.println(url);
	System.out.println(username);
	System.out.println(password);
	
	
}
}
