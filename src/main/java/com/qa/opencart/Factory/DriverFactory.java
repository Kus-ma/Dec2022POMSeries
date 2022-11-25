package com.qa.opencart.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	//public static String highlight;
		public WebDriver driver;
		public Properties prop;
		public OptionsManager optionsmanager;
		
		
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
		
		/*
		 * This method is used to initialize the driver
		 * method will return driver
		 * 
		 * 
		 */
		public WebDriver init_driver(Properties prop) {
			String browsername =  prop.getProperty("browser").trim();
			System.out.println("browsername is :" + browsername);
			//highlight = prop.getProperty(highlight);
			optionsmanager = new OptionsManager(prop);
			
			if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsmanager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
			}
			else if(browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));

			}
			else {
				System.out.println("please pass right browser:" + browsername);
			}
			
			getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			return getDriver();
		}
		
		/*
		 * getdriver(): it will return thread local copy of the webdriver
		 * 
		 */
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}
		
		
		
		
		/*
		 * 
		 * this method is used to initialize the properties
		 * this will return properties prop references
		 */
		
		public Properties init_prop() {
		prop= new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  return prop;
		}
		
		/*
		 * take screenshot
		 *
		 * 
		 * 
		 */
		
		public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/screenshots"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		}


}
