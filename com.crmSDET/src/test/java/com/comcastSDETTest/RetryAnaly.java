package com.comcastSDETTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.OrganizationPage;

@Listeners (com.crm.comcastGenricUtility.ListenerImplementatationClass.class)
public class RetryAnaly extends BaseClass  {
	
	@Test //(retryAnalyzer=com.crm.comcastGenricUtility.RetryAnalyserImplementClass.class)
	
	
	public void anylyse  ()  {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op= new OrganizationPage (driver);
		op.getCreateOrgImg().click();
		Assert.fail("failed");
		
		
	}

}
