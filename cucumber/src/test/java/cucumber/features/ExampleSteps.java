package cucumber.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ExampleSteps {

	@Given("^The person: ([^\"]*)$")
	public void printLink(String person){
		System.out.println("The person: " + person);
	}
	
	@When("([^\"]*) ([^\"]*) ([^\"]*)$")
	public void printLink2(String person, String verb, String adjective){
		System.out.println(person + " " + verb + " " + adjective);
	}
	
	@When("^going to be ([^\"]*)$")
	public void printLink2(String something){
		System.out.println("going to be " + something);
	}
	
}
