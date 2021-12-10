package com.crm.comcastORGObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastGenricUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateNewOrganizationPage(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy (name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy (name="button")
	private WebElement saveButton;
	
	@FindBy (name="industry")
	private WebElement industryListBox;
	
	@FindBy (name ="accounttype")
	private WebElement industryTypeListBox;
	
	@FindBy (name="lastname")
	private WebElement contNameEdt;
	
	@FindBy (name="button")
	private WebElement saveContButton;
	
	@FindBy (name="support_end_date")
	private WebElement supportDate;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndystryListBox() {
		return industryListBox;
	}

	public WebElement getIndystryTypeListBox() {
		return industryTypeListBox;
	}
	
	public void createOrganization  (String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveButton.click();
	}
	

	public WebElement getIndustryListBox() {
		return industryListBox;
	}

	public WebElement getIndustryTypeListBox() {
		return industryTypeListBox;
	}

	public WebElement getContNameEdt() {
		return contNameEdt;
	}

	public WebElement getSaveContButton() {
		return saveContButton;
	}

	public WebElement getSupportDate() {
		return supportDate;
	}
	
	public void createOrganization (String orgName,String industry, String industryType)    {
		orgNameEdt.sendKeys(orgName);
		select(industryListBox,industry);
		select(industryTypeListBox,industryType);
		saveButton.click();
	}
	
	public void createContact (String lastName)   {
		contNameEdt.sendKeys(lastName);
		saveContButton.click();
	}

	
	
}
