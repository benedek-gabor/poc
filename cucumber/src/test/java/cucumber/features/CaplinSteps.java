package cucumber.features;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaplinSteps {

	private WebDriver driver;
	private String actPageTitle;
	
	@Given("^I navigated to the Caplin website$")
	public void navigateToCaplin() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("https://www.caplin.com/");
	}

	@When("^I get the page title$")
	public void getPageTitle() throws Throwable {
		actPageTitle = driver.getTitle();
	}

	@Then("^I check that is equals with Caplin Systems$")
	public void verifyPageTitle() throws Throwable {
		String expPageTitle = "Caplin Systems";
	    Assert.assertTrue(actPageTitle.contains(expPageTitle));
	    System.out.println("The actual page title: " + actPageTitle + " contains the expected page title: " + expPageTitle);
	}

	@And("^I close the web browser$")
	public void i_close_the_web_browser() throws Throwable {
	    driver.quit();
	}
}
