package com.digs;

import org.jbehave.core.annotations.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirefoxTestCase {
	
	private WebDriver driver;
	private String url;
	
	@Given(value = "")
	public void setUp(){
		driver = new FirefoxDriver();
		url = "https://www.caplin.com/";
	}
	
	public void testFirefox(){
		driver.get(url);
	}
	
	public void tearDown(){
		driver.quit();
	}

}
