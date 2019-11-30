package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPOM {
	private WebDriver driver; 
	
	public PropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public static String propXpath="//*[@id='menu-posts-property']/a/div[3]"; //1
	public static String addNewPropXpath="//*[@id='menu-posts-property']/ul/li[3]/a";
	public static String addNewFeatureLink="//*[@id='property_feature-add-toggle']";
	public static String newFeatureTxt="//input[@id='newproperty_feature']";
	public static String featureParent="//select[@id='newproperty_feature_parent']";
	public static String featureAddSubmit="//input[@id='property_feature-add-submit']";
	public static String propTitle="//input[@id='title']";
	public static String propContent="//textarea[@id='content']";
	public String propPublish="//input[@id='publish']";
	
	//Region xPath
	public String addNewRegionLink="//a[@id='region-add-toggle']";
	public String regionParent="//*[@id='newregion_parent']";
			//"//select[@id='newregion_parent']";
	
	@FindBy(xpath="//*[@id='responsive']/li[7]/a")
	private WebElement loginRegister;
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement userName; 
	
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='menu-posts-property']/a/div[3]")
	private WebElement propWE;
	
	@FindBy(xpath="//*[@id='menu-posts-property']/ul/li[3]/a")
	private WebElement addNewPropWE;
	
	@FindBy(xpath="//*[@id='property_feature-add-toggle']")
	private WebElement featureHyperLink;
	
	@FindBy(xpath="//input[@id='newproperty_feature']")
	private WebElement newFeatureTxtWB;
	
	@FindBy(xpath="//input[@id='property_feature-add-submit']")
	private WebElement newFeatureSubmitWB;

	@FindBy(xpath="//input[@id='title']")
	private WebElement propTitleWB;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement propContentWB;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtnWB;
	
	//Region ACtivity Starts
	@FindBy(xpath="//a[@id='region-add-toggle']")
	private WebElement regionHyperLink;
	
	@FindBy(xpath="//input[@id='newregion']")
	private WebElement newRegionTxtWB;
	
	@FindBy(xpath="//input[@id='region-add-submit']")
	private WebElement newRegionSubmitWB;
	
	
	//Regtion Activity Ends
	
	public void loginRegisterClick() {
		this.loginRegister.click(); 
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void propLinkClick() {
		this.propWE.click(); 
	}
	public void AddNewClick() {
		this.addNewPropWE.click(); 
	}
	//Feature ACtivity - Starts
	public void addNewFeatureLinkClick() {
		this.featureHyperLink.click(); 
	}
	public void sendFeature(String val) {
		this.newFeatureTxtWB.clear(); 
		this.newFeatureTxtWB.sendKeys(val); 
	}
	public void featureSubmit() {
		this.newFeatureSubmitWB.click(); 
	}
	public void sendPropTitle(String val) {
		this.propTitleWB.clear(); 
		this.propTitleWB.sendKeys(val); 
	}
	public void sendPropContent(String val) {
		this.propContentWB.clear(); 
		this.propContentWB.sendKeys(val); 
	}
	public void featureSelect(String featureText) {
		Actions actions = new Actions(driver);
		WebElement  element = driver.findElement(By.xpath("//li[starts-with(@id,'property_feature')]/label[text()=' "+featureText+"']/input"));
		actions.moveToElement(element).click().build().perform();
	}
	//Feature ACtivity - ENDS
	
	//Region Activity - Starts
	public void addNewRegionLinkClick() {
		this.regionHyperLink.click(); 
	}
	public void sendRegion(String val) {
		this.newRegionTxtWB.clear(); 
		this.newRegionTxtWB.sendKeys(val); 
	}
	public void regionSubmit() {
		this.newRegionSubmitWB.click(); 
	}
	//li[starts-with(@id,'region-')]/label[text()=' Test Regino']/input
	public void regionSelect(String regionText) {
		Actions actions = new Actions(driver);
		WebElement  element = driver.findElement(By.xpath("//li[starts-with(@id,'region-')]/label[text()=' "+regionText+"']/input"));
		actions.moveToElement(element).click().build().perform();
	}
	//Region Activity - Ends
	public void pubBtnClick(String locator) {
		Actions actions = new Actions(driver);
		WebElement  element = driver.findElement(By.xpath(locator));
		actions.moveToElement(element).click().build().perform();
	}
}
