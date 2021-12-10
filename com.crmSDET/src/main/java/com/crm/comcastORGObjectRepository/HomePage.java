package com.crm.comcastORGObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastGenricUtility.WebDriverUtility;
	

	public class HomePage extends WebDriverUtility {
		WebDriver driver;
		
	public HomePage (WebDriver driver)  {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy (linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy (xpath="//img[src='themes/softed/images/user.PNG']")
	private WebElement adminstratorLink;
	
	@FindBy (xpath="//a[text()=Sign Out']")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminstratorLink() {
		return adminstratorLink;
	}
	public void logout ()   {
		Actions act = new Actions (driver);
		act.moveToElement(logoutLink).perform();;
		act.click();
	}

}
