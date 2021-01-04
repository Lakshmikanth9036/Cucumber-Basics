package training.bdd.stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleStepDef {
	@Given("^enter the web page$")
	public void enter_the_web_page() throws Throwable {
	    System.out.println("entering the web page");
	}

	@When("^i enter provide user credential$")
	public void i_enter_provide_user_credential() throws Throwable {
		System.out.println("i enter provide user credential");
	}

	@Then("^click on the register button$")
	public void click_on_the_register_button() throws Throwable {
		System.out.println("click on the register button");
	}

}
