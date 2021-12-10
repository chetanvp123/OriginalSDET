package com.crm.comcastGenricUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.LoginPage;



public class BaseClass {
	

	public JavaUtility jLib= new JavaUtility ();
	public ExcelUtility eLib = new ExcelUtility ();
	public FileUtility fLib = new FileUtility ();
	public WebDriverUtility wLib = new WebDriverUtility ();
	public WebDriver driver =null;
	 static WebDriver sdriver;
	@BeforeSuite
	public void bSMethod ()   {
		System.out.println("DataBase connected");
		System.out.println("======before suite =======");
	}
	
	@Parameters ("BROWSER")
	
	@BeforeClass(groups= {"RegressionTest","smokeTest"})
	public void bClassMethod () throws Throwable  {
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		 if(BROWSER.equals("chrome")) {
             driver = new ChromeDriver();
        }
        else if(BROWSER.equals("firefox")){
       	  driver = new FirefoxDriver();
        }
        else if(BROWSER.equals("ie")){
      	  driver = new InternetExplorerDriver();
       }
        else {
           driver = new ChromeDriver();
       }
		 System.out.println("======browser opened=======");
	}
	
	
	
	@BeforeMethod  (groups= {"RegressionTest","smokeTest"})
	public void bMethod () throws Throwable  {
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		 String URL =  fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
		 sdriver = driver;
		 
		 LoginPage lp = new  LoginPage (driver);
         lp.loginToApp(URL, USERNAME, PASSWORD);
         System.out.println("======before method successfully=======");
	}
	
	@AfterMethod (groups= {"RegressionTest","smokeTest"})
	public void aMethod ()    {
		HomePage hp = new HomePage (driver);
		hp.getLogoutLink();
		System.out.println("===App Logout====");
	}
	
	@AfterClass  (groups= {"RegressionTest","smokeTest"})
	public void aClass ()  {
		 driver.quit();
		 System.out.println("=======Close the browser====");
	}
	
	@AfterSuite  (groups= {"RegressionTest","smokeTest"})
	public void aSuite()  {
		System.out.println("===DataBase connection closed===");
	}
}
