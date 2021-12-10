package com.crm.comcastORGObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
		
		
	public class OrganizationInformationPage {
		
		WebDriver driver;
		public OrganizationInformationPage (WebDriver driver)   {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (className="dvHeaderText")
		private WebElement succusfulmsg;
		
		@FindBy (id="dtlview_Industry")
		private WebElement industrySucInfo;
		
		@FindBy (id ="dtlview_Type")
		private WebElement industryTypesucInfo;
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getSuccusfulmsg() {
			return succusfulmsg;
		}

		public WebElement getIndustrySucInfo() {
			return industrySucInfo;
		}

		public WebElement getIndustryTypesucInfo() {
			return industryTypesucInfo;
		}
		
		
		
}
