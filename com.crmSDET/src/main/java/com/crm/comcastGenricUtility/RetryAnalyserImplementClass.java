package com.crm.comcastGenricUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementClass implements IRetryAnalyzer{
	
	int count=0;
	int retrycount =4;
	
	public boolean retry(ITestResult result) {
	
		while (count<retrycount) 
		{
			count++;
			return true;
		}
	return false;
	}

	
	
}
