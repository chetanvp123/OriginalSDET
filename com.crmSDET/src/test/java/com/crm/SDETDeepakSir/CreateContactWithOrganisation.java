package com.crm.SDETDeepakSir;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganisation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		// READ THE DATA FROM PROPERTIES FILE 
		FileInputStream fis = new FileInputStream ("./data/CommonData.Properties");
		Properties p= new Properties ();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL  = p.getProperty("url");
		String USERNAME  = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		Random ran = new Random ();
		ran.nextInt(10000);
		
		//Read the data from ExcelFile 
		FileInputStream fis1= new FileInputStream ("./data/Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		 String cel = row.getCell(3).getStringCellValue();
		
		//verify the browser
		WebDriver  driver= null ;
		
		if (BROWSER.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver ();
		}
		else if  (BROWSER.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver ();
		}
		else {
			System.out.println("chrome");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		String parentwid = driver.getWindowHandle();
		
		//login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(cel);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
			
		Set<String> wid = driver.getWindowHandles();
		for (String s:wid)
		{
			driver.switchTo().window(s);
		}
		
		driver.findElement(By.xpath("//a[text()='Wipro1']")).click();
		driver.switchTo().window(parentwid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//logout
		
		Actions act = new Actions (driver);
		
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
