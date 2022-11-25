package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.SearchResultsPage;
import com.qa.opencart.Util.Constants;

public class AccountsPageTest extends BaseTest {
	
	AccountsPage accountsPage;
	SearchResultsPage searchResultsPage;

	
	@BeforeClass
	public void accPageSetUp() {
	 accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void accPageTitleTest() {
	Boolean actTitle	= accountsPage.getAccountsPageTitle();
	System.out.println("acc page title:" + actTitle);
	Assert.assertTrue(actTitle, Constants.ACCOUNT_PAGE_TITLE);
		
	}
	
	@Test(priority =2)
	public void accPageHeaderTest() {
		boolean header = accountsPage.getAccountsPageHeader();
		System.out.println("acc page header is:" + header);
		Assert.assertTrue(header, Constants.Account_PAGE_HEADER);
	}
	
	@Test(priority =3)
	public void isLogoutExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}
	
	@Test(priority =4)
	public void accPageSectionTest() {
	List<String> actAccSecList	= accountsPage.getAccountSecList();
	Assert.assertEquals(actAccSecList, Constants.getExpectedAccSecList());
	}
	
	// keep test data using 2 dimensional Object array
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"MacBook Pro"},
			{"Apple"},
			{"Samsung"},
				
			
		};
	}
	
	
	@Test(priority= 5, dataProvider ="productData" )
    public void searchTest(String productname) {
		searchResultsPage	= accountsPage.doSearch(productname);
		Assert.assertTrue(searchResultsPage.getProductListCount()>0);
		
	}
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { 
			{"MacBook" ,  "MacBook Pro"}, 
			{"iMac" , "iMac"},
			{"Samsung", "Samsung Galaxy Tab 10.1"},
			{"Apple", "Apple Cinema 30\""}
			
			};
	}
	
	
	@Test(priority = 6, dataProvider="productSelectData")
	public void selectProductTest(String productName, String mainProductname) {
		searchResultsPage	= accountsPage.doSearch(productName);
		productInfoPage = searchResultsPage.selectProduct(mainProductname);
		Assert.assertEquals(productInfoPage.getProductHeader(), mainProductname);
		
	}
	
	
}
