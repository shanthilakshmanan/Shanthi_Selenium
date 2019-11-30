package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddPostToTrashPOM;
import com.training.pom.PublishPostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1_PublishPostTest {

	private WebDriver driver;
	private String baseUrl;
	private PublishPostPOM pubPOM;
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
		pubPOM = new PublishPostPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		genericMeth = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(2000);
		genericMeth.assertURL(baseUrl); //Assert the url
		pubPOM.loginRegisterClick();  //Click on Login/Register
		Thread.sleep(2000);
		pubPOM.sendUserName("admin");
		pubPOM.sendPassword("admin@123");
		Thread.sleep(2000);
		pubPOM.clickLoginBtn(); //Click on Login button
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		screenShot.captureScreenShot("MainPage");
		pubPOM.postLinkClick();
		genericMeth.assertText("Posts", AddPostToTrashPOM.postXpath, "xpath", "Posts keyword does not match with actual value");
		Thread.sleep(2000);
		pubPOM.addNewClick();
		Thread.sleep(2000);
		pubPOM.sendTitle("NEW VILLA 997");
		Thread.sleep(2000);
		pubPOM.sendContent("WELCOME TO THE  VILLA 997");
		screenShot.captureScreenShot("AddTitle");
		Thread.sleep(2000);
		pubPOM.publishPostClick();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Publish");
		Thread.sleep(2000);
	}
}
