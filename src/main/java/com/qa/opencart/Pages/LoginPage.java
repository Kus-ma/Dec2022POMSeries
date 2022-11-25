package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Util.Constants;
import com.qa.opencart.Util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	//1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. By locators
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.xpath("//input[@class='btn btn-primary']");
	private By forgetPwdLink = By.linkText("Forgotten Password");
	private By registetLink = By.xpath("(//a[@class='list-group-item'])[2]");
	
	//4. page actions
	@Step("getting login page title value ....")
    public boolean getLoginPageTitle() {
    	return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }
    
    public Boolean getLoginPageUrl() {
    	return eleUtil.waitForUrlContains1((String) Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
    }
    
    public boolean isForgetPWDLinkExist() {
    	return eleUtil.doIsDisplayed(forgetPwdLink);
    }
    
    public boolean isRegisterLinkExist() {
    	return eleUtil.doIsDisplayed(registetLink);
    }
    
    @Step("do login with username: {0} and password: {1}")
    public AccountsPage doLogin(String un, String pwd) {
    	System.out.println("login with: " + un + ":" + pwd);
    	eleUtil.doSendKeys(emailid, un);
    	eleUtil.doSendKeys(password, pwd);
    	eleUtil.doClick(loginbtn);
    	return new AccountsPage(driver);
    	
    }
    
    public RegistrationPage goToRegisterPage() {
    	eleUtil.doClick(registetLink);
    	return new RegistrationPage(driver);
    }

}
