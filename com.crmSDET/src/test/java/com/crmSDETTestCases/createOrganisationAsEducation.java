package com.crmSDETTestCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.SDET25.Generic.utils.ExcelUtility;
import com.crm.SDET25.Generic.utils.FileUtility;




public class createOrganisationAsEducation {
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test
	public void  createEducationOrganisation() throws Throwable {
		//import from utility
		FileUtility fLib= new FileUtility ();
		ExcelUtility eLib = new ExcelUtility ();
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//verify the browser
		if (BROWSER.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver ();
		}
		else if  (BROWSER.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver ();
		}
		else {
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Organizations")).click();
		
		//create the organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(5000);
		String org = eLib.getStringExcelData("Sheet1", 2, 1);
		driver.findElement(By.name("accountname")).sendKeys(org);
		
		WebElement industry = driver.findElement(By.name("industry"));
		Select s = new Select (industry);
		s.selectByVisibleText("Education");
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']"));
		
		
		//logout
		Thread.sleep(5000);
		Actions act = new Actions (driver);
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}