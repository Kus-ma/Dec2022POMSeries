package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.ProductInfoPage;
import com.qa.opencart.Pages.RegistrationPage;
import com.qa.opencart.Pages.SearchResultsPage;

public class BaseTest {
	
	
	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	AccountsPage accountsPage;
	SearchResultsPage searchResultsPage;
	ProductInfoPage productInfoPage;
	SoftAssert softAssert;
	RegistrationPage registerationPage;

	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage= new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
