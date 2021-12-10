package com.crm.comcastCONTObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	
	public CreateContactPage (WebDriver driver)  {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "lastname")
	private WebElement lastNam;
	
	@FindBy (name = "button")
	private WebElement saveCont;
	
	public WebElement getSaveCont() {
		return saveCont;
	}


	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getLastNam() {
		return lastNam;
	}
	
	public void lastname (String lastName)   {
		lastNam.sendKeys(lastName);
	}
}
