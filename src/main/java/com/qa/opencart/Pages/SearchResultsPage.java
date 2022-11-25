package com.qa.opencart.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Util.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productResults = By.cssSelector("div.caption a");

  
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public int getProductListCount() {
	int resultCount = eleUtil.waitforElementToBevisible(productResults, 10).size();
	System.out.println("the search product count:" + resultCount);
	return resultCount; 
	}
    
	
	public ProductInfoPage selectProduct(String mainProductname) {
	System.out.println("main product name is:"+ mainProductname );
	List<WebElement> searchList	= eleUtil.waitforElementToBevisible(productResults, 10);
	for(WebElement e :searchList) {
		String text = e.getText();
		if(text.equals(mainProductname)) {
			e.click();
			break;
			
		}
	
	}
	 return new ProductInfoPage(driver);
	
	}
	
}
