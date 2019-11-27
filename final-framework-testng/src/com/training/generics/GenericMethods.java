package com.training.generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * 
 * @author Naveen
 * @see this class will help when you want to do custom business logic, since  in POM we dont do 
 * 			dynamic elements available, when you want to iterate the table/accordion etc 
 * @since 17-Dec-2018 
 */
public class GenericMethods {
	WebDriver driver ; 
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * 
	 * @param locator 
	 * @param type
	 * @see type is id, name, xpath, text, partialtext
	 * @see locator will be the element to be found on DOM 
	 * @return  WebElement
	 * this method shall give provided it has single enty in the DOM
	 */
	public WebElement getElement(String locator, String type){
		WebElement element  = null;
		type = type.toLowerCase();
		
		if(type.equals("id")){
			element  =  driver.findElement(By.id(locator));
		} else if(type.equals("css")){
			element = driver.findElement(By.cssSelector(locator));
		}else if (type.equals("name")){
			element  = driver.findElement(By.name(locator));
		}else if(type.equals("xpath")){
			element = driver.findElement(By.xpath(locator));
		}
		else if(type.equals("linkText")){
			element = driver.findElement(By.linkText(locator));
		}
		
		if(checkSingleEntry(locator, type)){
			System.out.println("Element Found and Returned");
			return element;
		}	
		System.out.println("Sorry Element not found, so not returned...");
		return null;


	}
	
	
	// shall give if it has multiple entries as a list in DOM 
	
	public List<WebElement> getElementsAsList(String locator, String type){
		type = type.toLowerCase();
		if(type.equals("id")){
			return driver.findElements(By.id(locator));
		}else if(type.equals("name")){
			return driver.findElements(By.name(locator));
		}else if(type.equals("xpath")){
			return driver.findElements(By.xpath(locator));
		}else if(type.equals("class")){
			return driver.findElements(By.className(locator));
		}// other TODO 
		return null;
	}
	
	// return true if element exists 
	// this method works for us when we have more than 1 element 
	// to be found for 
	public boolean isElementFound(String locator, String type){
		return getElementsAsList(locator, type).size()>0;
	}
	
	// this method gives true only where there is an single entry 
	// in the DOM 
	public boolean checkSingleEntry(String locator, String type){
		return getElementsAsList(locator, type).size() ==1;
	}
	
	public void scrollToElement(String locator, String type, String linkTxt) throws InterruptedException {
		Point p;
		JavascriptExecutor js;
		int xcords;
		String xcordinates;
		int ycords;
		String ycordinates;
		
		type = type.toLowerCase();
		/*
		if (type.equals("xpath")) {
			p = driver.findElement(By.xpath(locator)).getLocation();
			xcords = p.x;
			xcordinates = String.valueOf(xcords); 
			ycords = p.y;
			ycordinates = String.valueOf(ycords);
			js = (JavascriptExecutor)driver;
			js.executeScript("windows.scrollTo(xcordinates, ycordinates)", "");
			
		}*/
		/*
		js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.linkText(linkTxt));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        */
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Thread.sleep(2000);
		actions.perform();
	}

public void assertTextOld(String expectedText, String locator, String type, String msg) {
		type = type.toLowerCase();
		
		if(type.equals("id")){
			String actualText = driver.findElement(By.id(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("class")){
			String actualText = driver.findElement(By.className(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("name")){
			String actualText = driver.findElement(By.name(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("xpath")){
			String actualText = driver.findElement(By.xpath(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("css")){
			String actualText = driver.findElement(By.cssSelector(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("tagname")){
			String actualText = driver.findElement(By.tagName(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("linktext")){
			String actualText = driver.findElement(By.linkText(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("partiallinktext")){
			String actualText = driver.findElement(By.partialLinkText(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}
		
	} 

	//AssertURl - getUrl()
	public void assertURL(String expectedURL) {
		String actualURL = driver.getCurrentUrl();
		System.out.println("The URL at runtime is " + actualURL);
		SoftAssert s = new SoftAssert();
		s.assertTrue(actualURL.equals(expectedURL),
				"The assertion failed as the expected URL did not match with actual URL");
		s.assertAll();
	}

	// AssertTEXT - getText
	public void assertText(String expectedText, String locator, String type, String msg) {
		type = type.toLowerCase();
		SoftAssert s = new SoftAssert();
		if (type.equals("id")) {
			String actualText = driver.findElement(By.id(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("class")) {
			String actualText = driver.findElement(By.className(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("name")) {
			String actualText = driver.findElement(By.name(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("xpath")) {
			String actualText = driver.findElement(By.xpath(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("css")) {
			String actualText = driver.findElement(By.cssSelector(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("tagname")) {
			String actualText = driver.findElement(By.tagName(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("linktext")) {
			String actualText = driver.findElement(By.linkText(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("partiallinktext")) {
			String actualText = driver.findElement(By.partialLinkText(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		}

	}
	
	// AssertAttributeValue = getAttribute()
	//Attribute type - value, id, class, name, title, 
	//type - xpath, name, class, xpath, css, tagname, partiallinktext,linktext
	public void assertAttributeValue(String expectedAttributeVal, String attributeType,String locator, String type, String msg) {
		type = type.toLowerCase();
		SoftAssert s = new SoftAssert();
		if (type.equals("id")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("class")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("name")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("xpath")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("css")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("tagname")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("linktext")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("partiallinktext")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		}

	}
	
	// AssertTitle = getTitle();
	public void assertTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("The URL at runtime is " + actualTitle);
		SoftAssert s = new SoftAssert();
		s.assertTrue(actualTitle.equals(expectedTitle),
				"The assertion failed as the expected Title did not match with actual Title");
		s.assertAll();
	}

}