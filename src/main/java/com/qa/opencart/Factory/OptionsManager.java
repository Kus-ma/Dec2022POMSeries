package com.qa.opencart.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	

	private static Properties prop;
	private static ChromeOptions co;
	private FirefoxOptions fO;
	
    public OptionsManager (Properties prop) 
    {
    	OptionsManager.prop = prop;
    }
    
    public static ChromeOptions getChromeOptions() {
    	co = new ChromeOptions();
    	try {
			if(Boolean.parseBoolean(prop.getProperty("headless")))co.addArguments("---headless");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(Boolean.parseBoolean(prop.getProperty("incognito")))co.addArguments("---incognito");
    	
    	
    	return co;
    }
    
    public FirefoxOptions getFirefoxOptions() {
    	fO = new FirefoxOptions();
    	if(Boolean.parseBoolean(prop.getProperty("headless")))fO.addArguments("---headless");
    	if(Boolean.parseBoolean(prop.getProperty("incognito")))fO.addArguments("---incognito");
    	
    	
    	return fO;
    	
    }
	


}
