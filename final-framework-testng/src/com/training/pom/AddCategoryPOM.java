package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
	private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='responsive']/li[7]/a")
	private WebElement loginRegister;
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement userName; 
	
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[3]")
	private WebElement postLink;
	
	@FindBy(xpath="//*[@id='menu-posts']/ul/li[2]/a")
			private WebElement allPostLink;
	
	@FindBy(xpath="//*[@id='menu-posts']/ul/li[4]/a")
		private WebElement addCategory;
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement newCatName;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugName;
	
	@FindBy (xpath="//textarea[@id='tag-description']")
	private WebElement descText;
	
	@FindBy (xpath="//input[@id='submit']")
	private WebElement submitbtn;
	
	@FindBy (xpath="//*[@id='menu-posts']/ul/li[4]/a")
	private WebElement addCatMainPage;
	
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
	
	public void postLinkClick() {
		this.postLink.click(); 
	}
	
	public void addCategoryClick() {
		this.addCategory.click(); 
	}
	
	public void sendCatName(String val) {
		this.newCatName.clear();
		this.newCatName.sendKeys(val);
	}
	public void sendSlugName(String val) {
		this.slugName.clear();
		this.slugName.sendKeys(val);
	}
	public void sendDescText(String val) {
		this.descText.clear();
		this.descText.sendKeys(val);
	}
	public void submitBtnClick() {
		this.submitbtn.click(); 
	}
	public void addCatMainPageClick() {
		this.addCatMainPage.click(); 
	}
	
}
