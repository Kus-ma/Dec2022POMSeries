package com.qa.opencart.test;

import java.util.Map;
import java.util.function.BiConsumer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Util.Constants;

public class ProductInfoPageTest extends BaseTest{
	
	
	@BeforeClass
	public void productInfoSetup() {
     accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority =1)
	public void productHeaderTest() {
		
		searchResultsPage = accountsPage.doSearch("MacBook");
		productInfoPage= searchResultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeader(),"MacBook Pro");
	}
	
	@Test(priority = 2)
	public void productImagesCountTest() {
		searchResultsPage = accountsPage.doSearch("iMac");
		productInfoPage= searchResultsPage.selectProduct("iMac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), Constants.IMAC_IMAGE_COUNT);
	}
	
	@Test(priority = 3)
	public void productInfoTest() {
	
	searchResultsPage = accountsPage.doSearch("MacBook");
	productInfoPage= searchResultsPage.selectProduct("MacBook Pro");
	Map<String, String>	actProductInfoMap = productInfoPage.getProductInfo();
	actProductInfoMap.forEach(new BiConsumer<String, String>() {
		public void accept(String k, String v) {
			System.out.println(k + ":" + v);
		}
	});
	softAssert.assertEquals(actProductInfoMap.get("name"),  "MacBook Pro");
	softAssert.assertEquals(actProductInfoMap.get("Brand"),  "Apple");
	softAssert.assertEquals(actProductInfoMap.get("price"),  "$2,000.00");
	softAssert.assertAll();
	}
}
