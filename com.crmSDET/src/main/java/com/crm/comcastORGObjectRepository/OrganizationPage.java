package com.crm.comcastORGObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
		
	WebDriver driver;
	
	public OrganizationPage (WebDriver driver)  {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy (id = "search_txt")
	private WebElement searchOrgName;
	
	@FindBy (name = "search")
	private WebElement searchBtn;
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	public WebElement getSearchOrgName() {
		return searchOrgName;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	public void searchOrgNa (String orgnzName )   {
		searchOrgName.sendKeys(orgnzName);
		searchOrgName.click();
		searchBtn.click();
		
	}


	
}
