package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Design Open Cart App - Login Page")
@Story("US 101: Open Cart Login Design with multiple features")
public class LoginPageTest extends BaseTest{
	
	@Description("Login page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		boolean actTitle= loginPage.getLoginPageTitle();
		System.out.println("page title:" + actTitle);
		Assert.assertTrue(actTitle, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
	Assert.assertTrue(loginPage.getLoginPageUrl());
		
	}
	
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgetPWDLinkExist());
	}
	
	@Test(priority =4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	
	@Description("login test with correct credentails")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void loginTest() {
	accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	Assert.assertTrue(accountsPage.getAccountsPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
	
}
