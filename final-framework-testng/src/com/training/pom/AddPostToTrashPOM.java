package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPostToTrashPOM {
	private WebDriver driver; 
	
	public AddPostToTrashPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public static String postXpath="//*[@id='menu-posts']/a/div[3]";
	public static String allPostXpath="//*[@id='menu-posts']/ul/li[2]/a";
	public static String titleNewHouseXpath;
	public static String trashNewHouseXpath="//*[@id='post-7096']/td[1]/div[3]/span[3]/a";
	
	public void setTitleXpath(String title) {
		titleNewHouseXpath="//a[contains(text(),'"+ title +"')]";
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
	public WebElement postLink;
	
	@FindBy(xpath="//*[@id='menu-posts']/ul/li[2]/a")
			private WebElement allPostLink;
	
	@FindBy(xpath="//*[@id='post-7096']/td[1]/div[3]/span[3]/a")
	private WebElement trashNewHouse;
	
	@FindBy(xpath="//*[@id='message']/p/a")
	private WebElement undoclk;
	
	
	////*[@id='post-7096']/td[1]/div[3]/span[3]/a
	
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
	
	public void allPostLinkClick() {
		this.allPostLink.click(); 
	}
	
//	public void sendMouseHoverText(String mouseHoverVal) {
//		this.mouseHoverText.click(); 
//	}
	public void undoClick() {
		this.undoclk.click(); 
	}
	public void trashClick() {
		this.trashNewHouse.click(); 
	}
	
}
