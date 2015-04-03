package cucumber.features.substeps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TableSteps {

	@Given("^I print out \"(.*?)\"$")
	public void i_print_out(String arg1) throws Throwable {
		System.out.println(arg1);
	}

	@When("^Print out the my table$")
	public void print_out_the_my_table(DataTable dataTable) throws Throwable {
		System.out.println(dataTable.raw());
	}
}
