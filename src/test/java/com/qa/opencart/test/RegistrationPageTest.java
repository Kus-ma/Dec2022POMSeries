package com.qa.opencart.test;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest 
{
	RegistrationPage registerationPage;

	
	@BeforeClass
	public void setupRegistration() {
	registerationPage =loginPage.goToRegisterPage();
	}
	
	
	
	
	@Test()
	public void userRegistrationTest() throws InterruptedException   {
		registerationPage.accountRegistration("Radha",	 "gopi", "Rg@gmail.com",	
"8792596370", "Test@123", "yes");	
	}

}
