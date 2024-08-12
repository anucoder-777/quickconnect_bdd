package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		System.out.println("Inside Step 01");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("Inside Step 02");
	}

	@And("clicks on the login button")
	public void clicks_on_the_login_button() {
		System.out.println("Inside Step 03");
	}

	@Then("the user should be navigated to the Home page")
	public void the_user_should_be_navigated_to_the_home_page() {
		System.out.println("Inside Step 04");
	}
	
}
