package com.qa.opencart.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Util.Constants;
import com.qa.opencart.Util.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By accountsSections = By.cssSelector("div#content h2") ;
	private By searchField = By.xpath("//input[@class = 'form-control input-lg']");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink = By.xpath("(//a[@class='list-group-item'])[13]");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public Boolean getAccountsPageTitle() {
		return eleUtil.waitForTitleToBe(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean getAccountsPageHeader() {
		return eleUtil.doGetText(header) != null;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public void logout()
	{
		if (isLogoutLinkExist()){
			eleUtil.doClick(logoutLink);
			
		}
		
	}
	
	public List<String> getAccountSecList() {
	List<WebElement>accSecList	=eleUtil.waitforElementToBevisible(accountsSections, 10);
		List<String> accSecValList = new ArrayList<String>();
		for(WebElement e:accSecList) {
			String text = e.getText();
			accSecValList.add(text);
		}
		
		return accSecValList;
		}
		
		
		public boolean isSearchExist() {
			return ((ElementUtil) driver).doIsDisplayed(searchField);
		}
		
		public SearchResultsPage doSearch(String productName) {
			System.out.println("searching the product:" + productName);
			eleUtil.doSendKeys(searchField, productName);
			eleUtil.doClick(searchButton);
			return new SearchResultsPage(driver);
		}
		
		
}
