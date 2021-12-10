package com.crmSDETPOMPractice;

import java.util.Random;

import org.testng.annotations.Test;

import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.CreateNewOrganizationPage;
import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.OrganizationInformationPage;
import com.crm.comcastORGObjectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
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
		         
		         String actualSucMsg = oip.getSuccusfulmsg().getText();
		         
		        if (actualSucMsg.contains(lastName)) {
					System.out.println(lastName + "org is created==PASS");
				}
		        else{
					System.out.println(lastName + "org is not created==FAIL");

				}

	}

}
