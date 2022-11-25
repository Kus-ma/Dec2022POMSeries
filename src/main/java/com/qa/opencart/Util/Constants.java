package com.qa.opencart.Util;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String Account_PAGE_HEADER = "naveenautomationlabs";
	public static final CharSequence LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final int DEFAULT_TIME_OUT = 5;
	public static final Object IMAC_IMAGE_COUNT = 3;
	public static final Object MACBOOKPRO_IMAGE_COUNT = 4;
    public static final int MACBOOKAIR_IMAGE_COUNT =4;
	
    public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
    public static final String REGISTER_SHEET_NAME= "registration";

	

	public static List<String> getExpectedAccSecList() {
		List<String> expSecList = new ArrayList<String>();
		expSecList.add("My Account");
		expSecList.add("My Orders");
		expSecList.add("My Affiliate Account");
		expSecList.add("Newsletter");
		return expSecList;
	}
	
}
