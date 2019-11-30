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
import com.training.pom.PropertiesPOM;
import com.training.pom.PublishPostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_TC3_SelectAddedFeatureRegion {

	private WebDriver driver;
	private String baseUrl;
	private PropertiesPOM propPOM;
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
		propPOM = new PropertiesPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		genericMeth = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(2000);
		genericMeth.assertURL(baseUrl); //Assert the url
		propPOM.loginRegisterClick();  //Click on Login/Register
		Thread.sleep(2000);
		propPOM.sendUserName("admin");
		propPOM.sendPassword("admin@123");
		Thread.sleep(2000);
		propPOM.clickLoginBtn(); //Click on Login button
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		String propTitleVal="SHAN2 Presitge Prop TITLE2";
		String propContentVal="SHAN2 Hometown Content2";
		String regionVal ="SHAN TEST REGION1";
		String featureVal ="SHAN2 BEST Feature2";
		screenShot.captureScreenShot("1_RegionFeature");
		propPOM.propLinkClick();
		genericMeth.assertText("Properties", PropertiesPOM.propXpath, "xpath", "Properties keyword does not match with actual value");
		Thread.sleep(2000);
		propPOM.AddNewClick();
		screenShot.captureScreenShot("2_RegionFeature");
		genericMeth.assertText("Add New", PropertiesPOM.addNewPropXpath, "xpath", "Add New keyword does not match with actual value");
		Thread.sleep(2000);
		propPOM.sendPropTitle(propTitleVal);
		Thread.sleep(2000);
		propPOM.sendPropContent(propContentVal);
		Thread.sleep(2000);
		screenShot.captureScreenShot("3_RegionFeature");
		propPOM.featureSelect(featureVal);
		Thread.sleep(2000);
		screenShot.captureScreenShot("4_RegionFeature");
		Thread.sleep(2000);
		propPOM.regionSelect(regionVal);
		screenShot.captureScreenShot("5_RegionFeature");
		Thread.sleep(2000);
		propPOM.pubBtnClick(propPOM.propPublish);
		screenShot.captureScreenShot("6_Feature");
		Thread.sleep(4000);
	}
}
