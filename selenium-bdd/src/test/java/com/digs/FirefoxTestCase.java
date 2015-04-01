package com.digs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirefoxTestCase {
	
	private WebDriver driver;
	private String url;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		url = "https://www.caplin.com/";
	}
	
	@Test
	public void testFirefox(){
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
