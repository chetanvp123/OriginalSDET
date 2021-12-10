package com.crm.comcastGenricUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@SuppressWarnings("deprecation")
public class ListenerImplementatationClass implements ITestListener {
	
		public void onTestFailure(ITestResult result) {
		
		String mehtodname= result.getMethod().getMethodName();
		
		JavaUtility jLib= new JavaUtility ();
		EventFiringWebDriver drive= new EventFiringWebDriver (BaseClass.sdriver);
		File src = drive.getScreenshotAs(OutputType.FILE);
		File dest = new File ("./errorshots/"+jLib.getSystemDate()+mehtodname+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public void onTestStart(ITestResult result) {
	
	
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

	

}
