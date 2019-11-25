package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublishPostPOM {
	private WebDriver driver; 
	
	public PublishPostPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id='menu-posts']/ul/li[3]/a")
	private WebElement addnew;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement addTitle;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement addContent;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishPost;
	
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
	
	public void addNewClick() {
		this.addnew.click();
	}
	
	public void sendTitle(String val) {
		this.addTitle.clear(); 
		this.addTitle.sendKeys(val); 
	}
	public void sendContent(String val) {
		this.addContent.clear(); 
		this.addContent.sendKeys(val); 
	}
	public void publishPostClick() {
		this.publishPost.click(); 
	}	
}
