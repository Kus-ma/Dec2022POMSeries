package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Util.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstname = By.xpath("(//input[@class='form-control'])[1]");
	private By lastname = By.xpath("(//input[@class='form-control'])[2]");
	private By email = By.xpath("(//input[@class='form-control'])[3]");
	private By telephone = By.xpath("(//input[@class='form-control'])[4]");
	private By password = By.xpath("(//input[@class='form-control'])[5]");
	private By confirmpassword = By.xpath("(//input[@class='form-control'])[6]");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[1]");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[2]");
	private By agreecheckbox = By.xpath("//input[@type ='checkbox']");
	private By continueButton = By.xpath("//input[@type='submit']");
	
	private By sucessmessg = By.cssSelector("div#content h1");
	private By logout = By.xpath("(//a[@class='list-group-item'])[13]");
	private By registerLink = By.xpath("(//a[@class='list-group-item'])[2]");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public boolean accountRegistration(String firstName, String lastName, String email,
			String telephone, String password, String subscribe) throws InterruptedException
	{
		eleUtil.doSendKeys(this.firstname, firstName);
		eleUtil.doSendKeys(this.lastname, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);

		
		
		if(subscribe.equals("yes")) {
			eleUtil.doClick(subscribeYes);
		}else {
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.doClick(agreecheckbox);
		eleUtil.doClick(continueButton);
		
		 Thread.sleep(5000);
		 WebElement sucessMessg	= driver.findElement(By.cssSelector("div#content h1"));
		 System.out.println(sucessMessg);
		 eleUtil.doClick(logout);
		 eleUtil.doClick(registerLink);
		        
		 return true;
		   		
			}
	}
	

	


