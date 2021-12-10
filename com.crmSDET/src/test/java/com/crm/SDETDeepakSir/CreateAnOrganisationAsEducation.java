package com.crm.SDETDeepakSir;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAnOrganisationAsEducation {

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
				
				
				//login
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
						
				driver.findElement(By.linkText("Organizations")).click();
				
				//create the organization
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
				
				driver.findElement(By.name("accountname")).sendKeys(cel+" "+ran);
				
				WebElement industry = driver.findElement(By.name("industry"));
				Select s = new Select (industry);
				s.selectByVisibleText("Education");
				driver.findElement(By.cssSelector("[title='Save [Alt+S]']"));

				//logout
				
				Actions act = new Actions (driver);
				
				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
