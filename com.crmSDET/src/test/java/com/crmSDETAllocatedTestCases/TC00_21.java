package com.crmSDETAllocatedTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcastGenricUtility.ExcelUtility;
import com.crm.comcastGenricUtility.FileUtility;
import com.crm.comcastGenricUtility.JavaUtility;
import com.crm.comcastGenricUtility.WebDriverUtility;

public class TC00_21 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileUtility fLib = new FileUtility ();
		ExcelUtility eLib = new ExcelUtility ();
		WebDriverUtility wLib= new  WebDriverUtility ();
		JavaUtility jLib= new JavaUtility ();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
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
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		String ranDom = jLib.getRandomNumber();
		
		/*login the application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*action on lead page*/
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		/*alert has to accpet if it shows the last cant be empty*/
		wLib.swithToAlertWindowAndAccept(driver);
		System.out.println("accepted");
	}

}
