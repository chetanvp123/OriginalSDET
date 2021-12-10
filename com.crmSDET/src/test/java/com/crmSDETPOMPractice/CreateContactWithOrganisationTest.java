package com.crmSDETPOMPractice;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcastCONTObjectRepository.ContactInfoPage;
import com.crm.comcastCONTObjectRepository.ContactPage;
import com.crm.comcastCONTObjectRepository.CreateContactPage;
import com.crm.comcastGenricUtility.BaseClass;
import com.crm.comcastORGObjectRepository.CreateNewOrganizationPage;
import com.crm.comcastORGObjectRepository.HomePage;
import com.crm.comcastORGObjectRepository.OrganizationInformationPage;
import com.crm.comcastORGObjectRepository.OrganizationPage;

public class CreateContactWithOrganisationTest extends BaseClass {
	
	@Test 
		 
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
		      String actualSucMsg = oip.getSuccusfulmsg().getText();
		      
		      String actualSucConMsg =  cip.getSuccusfulmsg().getText();
		      
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
		         
		         
			}
			


	}

