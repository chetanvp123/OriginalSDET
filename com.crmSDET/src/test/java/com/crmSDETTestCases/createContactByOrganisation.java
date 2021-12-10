package com.crmSDETTestCases;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.Generic.utils.ExcelUtility;
import com.crm.SDET25.Generic.utils.FileUtility;

@Test
public class createContactByOrganisation  {
	WebDriver driver;
		public  void Createcontact () throws Throwable   {
			
			FileUtility fLib = new FileUtility ();
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
			
			
			driver.get(URL);
			String parentwid = driver.getWindowHandle();
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			String org = eLib.getStringExcelData("Sheet1", 1, 1);
			driver.findElement(By.name("lastname")).sendKeys(org);
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			
			Set<String> wid = driver.getWindowHandles();
			for (String s:wid)
			{
				driver.switchTo().window(s);
			}
			
			driver.findElement(By.xpath("//a[text()='Wipro1']")).click();
			driver.switchTo().window(parentwid);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		}
}
