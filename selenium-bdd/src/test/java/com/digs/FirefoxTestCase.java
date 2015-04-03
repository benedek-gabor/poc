package com.digs;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirefoxTestCase {
	
	private WebDriver driver;
	
	@Given("a &browser web driver")
	public void setUp(String browser){
		if(browser == "Firefox"){
			driver = new FirefoxDriver();
		} else{
			throw new IllegalArgumentException("Wrong browser type.");
		}
	}
	
	@When(value = "I open this &url")
	public void testFirefox(String url){
		driver.get(url);
	}
	
	@Then("the page title should contains: &(Caplin Systems)")
	public void verifyPageTitle(String expTitle) {
		String actualPageTitle = driver.getTitle();
		String expPageTitle = expTitle;
		
		Assert.assertTrue(actualPageTitle.contains(expPageTitle));
	}

	@Then("Close the browser")
	public void tearDown(){
		driver.quit();
	}

}
