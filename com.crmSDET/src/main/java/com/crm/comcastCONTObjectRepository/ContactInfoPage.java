package com.crm.comcastCONTObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage (WebDriver driver)   {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
		@FindBy (name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy (xpath="//input[@name='account_id']/following-sibling::img")
		private WebElement addContImg;
		
		@FindBy (className="dvHeaderText")
		private WebElement succusfulmsg;
		
		public WebElement getSuccusfulmsg() {
			return succusfulmsg;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getAddContImg() {
			return addContImg;
		}
		
		public void orgLookup (String lastname)  {
			lastNameEdt.sendKeys(lastname);
			addContImg.click();
		}
} 
