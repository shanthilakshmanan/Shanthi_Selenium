package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddPostToTrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1_AddPostIntoTrashTests {

	private WebDriver driver;
	private String baseUrl;
	private AddPostToTrashPOM toTrashPOM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		toTrashPOM.loginRegisterClick();
		Thread.sleep(2000);
		toTrashPOM.sendUserName("admin");
		toTrashPOM.sendPassword("admin@123");
		Thread.sleep(2000);
		toTrashPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Mainpage");
		toTrashPOM.postLinkClick();
		Thread.sleep(2000);
		toTrashPOM.allPostLinkClick();
		toTrashPOM.sendMouseHoverText("New Villa 111");
		screenShot.captureScreenShot("AllPostLink");
		
		toTrashPOM.undoClick();
	}
}
