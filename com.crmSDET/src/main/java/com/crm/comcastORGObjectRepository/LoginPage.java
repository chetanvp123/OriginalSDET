package com.crm.comcastORGObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastGenricUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility   {
	
	WebDriver driver;
	WebDriverUtility wLib;
	public LoginPage (WebDriver driver)  {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="user_name")
	private WebElement userNameEdt;
	
	@FindBy (name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy (id="submitButton")
	private WebElement loginbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void loginToApp (String url,String username, String password)   {     
        driver.get(url);
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginbtn.click();
		 
		
	}

}
