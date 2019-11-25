package com.training.generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


/**
 * 
 * @author Naveen
 * @see in this class the path for screenshot is hard coded, please refer to others.properties file 
 *   the entry is kept, and this path shall be able to change from properties file 
 */
public class ScreenShot {

	private WebDriver driver; 
	
	// the driver information will be given by selenium test case 
	public ScreenShot(WebDriver driver){
		this.driver = driver; 
	}
	
	/*public void captureScreenShot(){
		
		// to be changed 
		String path = "C:\\Users\\ShanthiLakshmanan\\git\\Shanthi_Selenium\\final-framework-testng\\Screenshots";
		String fileName ="";

		GregorianCalendar calendar = new GregorianCalendar(); 
		
		int date =  calendar.get(Calendar.DATE); 
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		
		
		fileName = new Integer(date).toString() + "-" + new Integer(minute).toString() +"-" +
					new Integer(second).toString() +".png"; 
		
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}*/
	

	public void captureScreenShot(String stepName){
		
		String path =  "C:\\Users\\ShanthiLakshmanan\\git\\Shanthi_Selenium\\final-framework-testng\\Screenshots\\";
	
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +stepName+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("inside screen shot method");
		/*
		try {

			Date d = new Date();
			String timeStamp = d.toString().replace(":", "_").replace(" ", "_");

			// Cast the driver which is pin-pointing towards the object of CHROMEDROVER<
			// FIREFOXDRIVER, INTERNETEXPLORERDRIVER, etc
			TakesScreenshot scr = (TakesScreenshot) driver;
			// Get the screenshot and the output has to be kept in cache memory (temp
			// memory)
			// Output type can be an image file i.e. jPEG and PNG
			// Output can be in BYTE code.
			// Outout type can be in encrypted format using the BASE 64 class of Java
			// OutputType - is an interface
			// f1 --> Temp memory location where screenshot will be kept
			File f1 = scr.getScreenshotAs(OutputType.FILE);

			// Create the permanent location and path of screenshot
			// f2 - Permanent location
			File f2 = new File(
					System.getProperty(path + timeStamp + "_" + stepName + ".png"));

			// Copy the screenshot from f1 to f2 location
			// api --> Common IO Ver 2.6 for copying
			// Common IO ver 2.6 doc -->
			// https://commons.apache.org/proper/commons-io/javadocs/api-release/index.html
			// Parent Website Common IO and for downloading the binary file ->
			// https://commons.apache.org/proper/commons-io/download_io.cgi
			FileUtils.copyFile(f1, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
	}
	
}
