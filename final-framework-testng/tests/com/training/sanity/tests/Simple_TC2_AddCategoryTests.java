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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC2_AddCategoryTests {

	private WebDriver driver;
	private String baseUrl;
	private AddCategoryPOM catPOM;
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
		catPOM = new AddCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		genericMeth = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(4000);
		genericMeth.assertURL(baseUrl); //Assert the url
		Thread.sleep(2000);
		catPOM.loginRegisterClick(); //Click on Login/Register
		Thread.sleep(2000);
		catPOM.sendUserName("admin");
		catPOM.sendPassword("admin@123");
		Thread.sleep(2000);
		catPOM.clickLoginBtn(); //Click on Login button
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		screenShot.captureScreenShot("MainPage");
		catPOM.postLinkClick();
		genericMeth.assertText("Posts", AddPostToTrashPOM.postXpath, "xpath", "Posts keyword does not match with actual value");
		Thread.sleep(2000);
		catPOM.addCategoryClick();
		genericMeth.assertText("Categories", AddCategoryPOM.catXpath, "xpath", "Categories keyword does not match with actual value");
		screenShot.captureScreenShot("CategoryPage");
		catPOM.sendCatName("SHAN CATEGORY 222");
		Thread.sleep(2000);
		catPOM.sendSlugName("SLUG NAME 222");
		Thread.sleep(2000);
		catPOM.sendDescText("DESC TEXT 222");
		Thread.sleep(2000);
		screenShot.captureScreenShot("NewCategory");
		Thread.sleep(2000);
		catPOM.submitBtnClick();
		Thread.sleep(2000);
		catPOM.addCatMainPageClick();
		
	}
}
