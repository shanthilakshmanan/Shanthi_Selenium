package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddPostToTrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC3_AddPostIntoTrashTest {

	private WebDriver driver;
	private String baseUrl;
	private AddPostToTrashPOM toTrashPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMeth;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		toTrashPOM = new AddPostToTrashPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		genericMeth = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		genericMeth.assertURL(baseUrl); //Assert the url
		Thread.sleep(3000);
		toTrashPOM.loginRegisterClick(); //Click on Login/Register
		Thread.sleep(2000);
		toTrashPOM.sendUserName("admin");
		toTrashPOM.sendPassword("admin@123");
		Thread.sleep(2000);
		toTrashPOM.clickLoginBtn(); //Click on Login button
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
				
		screenShot.captureScreenShot("Mainpage");
		toTrashPOM.postLinkClick();
		genericMeth.assertText("Posts", AddPostToTrashPOM.postXpath, "xpath", "Posts keyword does not match with actual value");
		Thread.sleep(2000);
		toTrashPOM.allPostLinkClick();
		genericMeth.assertText("All Posts", AddPostToTrashPOM.allPostXpath, "xpath", "All Posts text does not match");
//		toTrashPOM.sendMouseHoverText("New Villa 111");
		screenShot.captureScreenShot("AllPostLink");
		Thread.sleep(2000);
		toTrashPOM.setTitleXpath("New House");
		Thread.sleep(2000);
		genericMeth.scrollToElement("//a[contains(text(),'New House')]", "xpath", "New House");
		System.out.println("hi here shanthi");
		Thread.sleep(2000);
		genericMeth.assertText("New House", AddPostToTrashPOM.titleNewHouseXpath, "xpath", "Title text does not match");
		Thread.sleep(2000);
		toTrashPOM.trashClick();
		Thread.sleep(2000);
		toTrashPOM.undoClick();
		Thread.sleep(2000);
	}
}
