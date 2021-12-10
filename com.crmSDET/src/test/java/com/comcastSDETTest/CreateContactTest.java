package com.comcastSDETTest;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcastCONTObjectRepository.ContactInfoPage;
import com.crm.comcastCONTObjectRepository.ContactPage;
import com.crm.comcastCONTObjectRepository.CreateContactPage;
import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.CreateNewOrganizationPage;
import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.OrganizationInformationPage;
import com.crm.comcastORGObjectRepository.OrganizationPage;

public class CreateContactTest extends BaseClass{
	
	@Test (groups= {"smokeTest"})
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
				 
				 SoftAssert soft = new SoftAssert ();
				 
				 soft.assertEquals(actualSucMsg, lastName);
				 soft.assertAll();
				 /* if (actualsseSucMsg.contains(lastName)) {
					System.out.println(lastName + "org is created==PASS");
				}
		        else{
					System.out.println(lastName + "org is not created==FAIL");

		        }*/
  	}	
	
		@Test (groups= {"RegressionTest"})
			 
		public void multipleTest() throws Throwable  {
			Random ranDom= new Random  ();
			
			String orgName = eLib.getDataFromExcel("ORG", 1, 0)+ranDom.nextInt(1000);
			String   contactName = eLib.getDataFromExcel("contact", 1, 2)+ranDom.nextInt(1000);
			HomePage hp = new HomePage (driver);
			ContactPage cp = new ContactPage(driver);
			
			         /* step 1 : navigate to Org Page */ 
			         hp.getOrgLink().click();

			         /* step 2 :  navigate to CREATE  Org Page*/ 
			         OrganizationPage op= new OrganizationPage (driver);
			         op.getCreateOrgImg().click();
			         
			         /* step 3 : create a new Org */
			         CreateNewOrganizationPage cnop= new CreateNewOrganizationPage (driver);
			         cnop.createOrganization(orgName);      
			         
			         /* step 4 : navigate to Contact Page */
			         wLib.waitAndClick(driver.findElement(By.linkText("Contacts")));
			         hp.getContactsLink().click();
			        
			         /* step 5 :  navigate to CREATE  Contact Page */
			         
			         cp.getCreateContImg().click();
			        
			         /*step 6 : create a new contact With org Name*/ 
			         ContactInfoPage cip = new ContactInfoPage  (driver);
			         cip.orgLookup(contactName);
			        
			         /* step 7  switch to organisation page */
			         
			         wLib.swithToWindow(driver, orgName);
			         op.getSearchOrgName();
			         op.getSearchBtn();
			       driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			       wLib.swithToWindow(driver,  "Creating New Contact");
			       CreateContactPage ccp= new CreateContactPage(driver);
			       ccp.getSaveCont().click();
			       
			         
			         /* verify the orgname */
			      OrganizationInformationPage oip= new OrganizationInformationPage(driver);
			      String statusOrg = oip.getSuccusfulmsg().getText();
			      
			      String statusContact =  cip.getSuccusfulmsg().getText();
			      
			      SoftAssert soft = new SoftAssert ();
			      soft.assertEquals(statusOrg, orgName);
			      soft.assertAll();
			      
			      
			      soft.assertEquals(statusContact, contactName);
			      soft.assertAll();
			      
			      /*
			         if (actualSucMsg.contains(orgName))  {
			        	 
			        	 System.out.println("verified Orgname"); 
			         }
			         else {
			        	 System.out.println("not verified Orgname");
			         }
			         if (actualSucConMsg.contains(contactName))  {
			        	 System.out.println("verified contact "); 
			         }
			         else {
			        	 System.out.println("not verified contact");
			         }
			         
			         */
				}
				


		}
