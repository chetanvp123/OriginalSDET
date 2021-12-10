package com.crm.comcastGenricUtility;


import java.util.Date;
import java.util.Random;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class JavaUtility {
	/**
	 * its used to generate random number with in the boundary of 0 to 10000
	 * @return
	 */
	
	public String getRandomNumber ()   {
		Random ran = new Random () ;
		int ranDom = ran.nextInt(10000);
		return " "+ ranDom;
	}
	/**
	 * it is used to get current system date & Time
	 * @return
	 */
	
	public String getSystemDate ()  {
		Date date = new Date ();
		String DateAndTime = date.toString();
		String systemDateTime = DateAndTime.replace(":", "_").replace(" ", "_");
		return systemDateTime;
		}
	
	
	/* public String getSystemDateYYYY_MM_DD ()  {
		Date date = new Date ();
		int day = date.getDay();
		int month = date.getMonth();
		String year = date.toString().split(" ")[5];
		String format = year+"-"+month+"-"+day;   */
	/**
	 * it is used to get the date & time in Format MMMM_MM_DD
	 * @return
	 */
	
	public String getSystemDateYYYY_MM_DD  ()   {
		Date date = new Date ();
		String systemDateAndTime = date.toString();
		String[] arr = systemDateAndTime.split(" ");
		String DD = arr[2];
		 String YYYY = arr[5];
		 @SuppressWarnings("deprecation")
		int MM = date.getMonth()+1;
		 String format = YYYY+"-"+MM+"-"+DD;
		 return format;
		}
	/**
	 * used to pass Virtual Key to OS
	 * @throws Throwable 
	 */
	
	public void pressVirtualKey () throws Throwable  {
		Robot rc = new Robot ();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease (KeyEvent.VK_ENTER);
	}  
	
	
}
