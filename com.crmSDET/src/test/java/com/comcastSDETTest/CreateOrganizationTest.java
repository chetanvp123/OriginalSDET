package com.comcastSDETTest;

import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.CreateNewOrganizationPage;
import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.OrganizationInformationPage;
import com.crm.comcastORGObjectRepository.OrganizationPage;


public class CreateOrganizationTest extends BaseClass {

	@Test (groups= {"smokeTest"})
	
	public void TestCase  () throws Throwable   {
				
		         /* step 3 : navigate to org */ 
		         HomePage hp = new HomePage (driver);
		        hp.getOrgLink().click();

		        /* step 4 :  navigate to Create  Org Page */
		         OrganizationPage op = new OrganizationPage (driver);
		         op.getCreateOrgImg().click();
		         
		      /* step 5 : create org */
		         Random ranDomName = new Random();
		         String lastName = eLib.getDataFromExcel("contact", 2, 2)+ranDomName;
				 CreateNewOrganizationPage cnop = new CreateNewOrganizationPage (driver);
		         cnop.createOrganization(lastName);
		   
		         
		        /* step 6 : verify  */
		         OrganizationInformationPage oip = new OrganizationInformationPage (driver);
		         
		         String status = oip.getSuccusfulmsg().getText();
		         
		         SoftAssert soft = new  SoftAssert ();
		         soft.assertEquals(status, lastName);
		         
		         soft.assertAll();
		         
		         /*
		        if (actualSucMsg.contains(lastName)) {
					System.out.println(lastName + "org is created==PASS");
				}
		        else{
					System.out.println(lastName + "org is not created==FAIL");

				}  */
	}


		@Test(groups={"RegressionTest"})
		public void createOrgTypeIndustry () throws Throwable {
			
			 /* read test data from Excel File*/
				String lastName = eLib.getDataFromExcel("contact", 2, 2)+jLib.getRandomNumber();
				String industry = eLib.getDataFromExcel("contact", 1, 1);
				String  type  =  eLib.getDataFromExcel("contact", 1, 3); 
				
		         
		         /* step 3 : navigate to org */ 
		         HomePage hp = new HomePage (driver);
		         hp.getOrgLink().click();

		        /* step 4 :  navigate to Create  Org Page */
		         OrganizationPage op = new OrganizationPage (driver);
		         op.getCreateOrgImg().click();
		         
			      /* step 5 : create org */
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage (driver);
		         cnop.createOrganization(lastName, industry, type);
		         
		         /*step: 6 verify */
		         OrganizationInformationPage oip = new OrganizationInformationPage (driver);
		        
		         String status = oip.getSuccusfulmsg().getText();
		         String statusindustry = oip.getIndustrySucInfo().getText();
		         String statusindustryTyp  = oip.getIndustryTypesucInfo().getText();
		         
		         
		         SoftAssert soft = new SoftAssert ();
		         soft.assertEquals(status, lastName);
		         
		         soft.assertEquals(statusindustry, industry);
		         
		         
		         soft.assertEquals(statusindustryTyp, type);
		         
		         soft.assertAll();
		         
		      /*  if (status.contains(lastName)) {
					System.out.println(lastName + "org is created==PASS");
				}
		        else{
					System.out.println(lastName + "org is not created==FAIL");

				}
		        
		        if (statusindustry.contains(industry)) {
					System.out.println(industry + "industry is created==PASS");
				}
		        else{
					System.out.println(industry + "industry is not created==FAIL");

				}
		         
		        if (statusindustryTyp.contains(type)) {
					System.out.println(type + "type is created==PASS");
				}
		        else{
					System.out.println(type + "type is not created==FAIL");

				}  */
		        
		        /* step 7 : logout */
		        hp.getLogoutLink();
		        
		        /* step 8*/           
		        
		        driver.quit();               
		}	

}