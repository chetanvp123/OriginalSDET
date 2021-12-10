package com.crmSDETPOMPractice;
import java.util.Random;

import org.testng.annotations.Test;

import com.crm.comcastCONTObjectRepository.ContactInfoPage;
import com.crm.comcastCONTObjectRepository.ContactPage;
import com.crm.comcastCONTObjectRepository.CreateContactPage;
import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.HomePage;

public class CreateContactTest extends BaseClass{

	@Test
	public void createContact () throws Throwable { 
		
		Random ranDomNum = new  Random ();
        ranDomNum.nextInt();
        
        String lastName = eLib.getDataFromExcel("contact", 2, 2)+ ranDomNum;
        
				/* step 1 : navigate to contact */ 
				HomePage hp= new HomePage (driver);
			    hp.getContactsLink().click();
				 
		         /* step 3 : create contact */
		         ContactPage cp = new ContactPage (driver);
				 cp.getCreateContImg().click();
				 
				 /*step 4*/
				 CreateContactPage ccp = new CreateContactPage (driver);
				 ccp.lastname(lastName);
				 ccp.getSaveCont().click();
				 
				 /* step 5 verify the contact  */
				 ContactInfoPage cip = new ContactInfoPage(driver);
				 String actualSucMsg = cip.getSuccusfulmsg().getText();
				 
				 if (actualSucMsg.contains(lastName)) {
						System.out.println(lastName + "org is created==PASS");
					}
			        else{
						System.out.println(lastName + "org is not created==FAIL");

					}
		         
	}

}
