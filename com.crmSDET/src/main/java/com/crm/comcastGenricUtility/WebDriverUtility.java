package com.crm.comcastGenricUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebDriverUtility {
	/**
	 * wait for page to load before indentifying any sychronized element in DOM [HTML-Docuent]
	 * @param driver
	 */

	 @SuppressWarnings("deprecation")
	public void waitForPageToLoad (WebDriver driver)   {
		 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	 }
	 /**
		 * wait for page to load before indentifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
		 * @param driver
		 **/
	 
	 @SuppressWarnings("deprecation")
	public void waitForPageToLoadForJSElement (WebDriver driver)   {
		 driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);
	 }
	 /**
	     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	     * @param driver
	     * @param element
	     */

	 public void waitForElementToBeClickable(WebDriver driver, WebElement element)  {
		 @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait (driver, 15);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 @SuppressWarnings("unchecked")
	  /**
	     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	     * @param driver
	     * @param element
	     * @param pollingTime in the form second
		 * @throws Throwable **/

	 public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
			@SuppressWarnings("rawtypes")
			FluentWait wait = new FluentWait(driver);
			/*wait.pollingEvery(pollingTime, TimeUnit.SECONDS);*/
			wait.wait(20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
		}
	 	/**
		 *  used to Switch to Any Window based on Window Title
		 * @param driver
		 * @param partialWindowTitle
		 */


	 
	 public void swithToWindow (WebDriver driver, String partialWindowTitle)  {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 while (it.hasNext())  {
			 String wid = it.next();
			 driver.switchTo().window(wid);
			 String currentWindowTitle = driver.getTitle();
			 if (currentWindowTitle.contains(partialWindowTitle))  {
				 break;
			 }
			 }
	 }
	 	/**
		 * used to Switch to Alert Window & click on OK button
		 * @param driver
		 */

	 	public void swithToAlertWindowAndAccept  (WebDriver driver)   {
	 		driver.switchTo().alert().accept();
	 	}
	 	
	 	/**
		 * used to Switch to Alert Window & click on Cancel button
		 * @param driver
		 */

	 	public void swithToAlertWindowAndCancel  (WebDriver driver)   {
	 		driver.switchTo().alert().dismiss();
	 	}
	 	/**
		 * used to Switch to Frame Window based on index
		 * @param driver
		 * @param index
		 */

	 	public void swithToFrame  (WebDriver driver, int index)   {
	 		driver.switchTo().frame(index);
	 	}
	 	/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 */

	 	public void swithToFrame  (WebDriver driver, String id_name_attribute)   {
	 		driver.switchTo().frame(id_name_attribute);
	 	}
	 	/**
		 * used to select the value from the dropDwon  based on index
		 * @param driver
		 * @param index
		 */

	 	public void select (WebElement element, int index)   {
	 		Select s = new Select (element);
	 		s.selectByIndex(index);
	 	}
	 	/**
		 * used to select the value from the dropDwon  based on value / option avlaible in GUI
		 * @param element
		 * @param value
		 */
	 	public void select (WebElement element, String text)   {
	 		Select s = new Select (element);
	 		s.selectByVisibleText(text);
	 	}
	 	/**
		 * used to place mouse cursor on specified element
		 * @param driver
		 * @param elemnet
		 */

	 	public void mouseOverOnElement(WebDriver driver, WebElement element)   {
	 		Actions act = new Actions (driver);
	 		act.moveToElement(element).perform();
	 	}
	 	/**
		 * 	 used to right click  on specified element

		 * @param driver
		 * @param elemnet
		 */


	 	public void rightClickOnElement(WebDriver driver, WebElement element)   {
	 		Actions act = new Actions (driver);
	 		act.contextClick(element).perform();
	 	}
	 	public void executeJavaScript(WebDriver driver, String javascript)   {
	 		JavascriptExecutor jse = (JavascriptExecutor) driver;
	 		jse.executeAsyncScript(javascript, null);
	 		}
	 	public void waitAndClick (WebElement element) throws Throwable   {
	 		int count = 0;
	 		while (count<5)  {
	 			try {
	 				element.click();
	 				break;
	 			}
	 			
	 			catch (Throwable e){
	 				Thread.sleep(1000);
	 				count++;
	 			}
	 		}
	 	}
	 	
	 	public void takeScreenshot(WebDriver driver, String screenshotname) throws Throwable  {
	 	TakesScreenshot ts = (TakesScreenshot) driver;
	 	File src= ts.getScreenshotAs(OutputType.FILE);
	 	File dest = new File ("./screenshot/"+screenshotname+".PNG");
	 	Files.copy(src, dest);            
	 	}
	 	/**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */

	 	public void passEnterKey(WebDriver driver) {
			   Actions act = new Actions(driver);
			   act.sendKeys(Keys.ENTER).perform();
		   } 

	 	
}
