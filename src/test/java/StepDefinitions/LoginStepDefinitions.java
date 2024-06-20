package StepDefinitions;

import Actions.LoginAction;
import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	LoginAction login=new LoginAction(Hooks.getDriver());
	
	@Given("Navigate to URL {string}")
	public void navigate_to_url(String string) {
		
		login.navigateToURL(string);
	   
	}
	@When("Enter username {string} and password {string}")
	public void enter_username_and_password(String user, String pwd) {
		
		login.enterUsernamePassword(user, pwd);
	    
	}
	@When("Click on login")
	public void click_on_login() {
	    
		login.clickOnLogin();
	}
	
//	@Then("Validate user navigated to home page {string};")
//	public void validate_user_navigated_to_home_page(String title) {
//		
//	   login.homePageValidation(title);
//	}
//	
//	@Then("Validate error message displayed {string}")
//	public void validate_error_message_displayed(String errorMsg) {
//	    login.errorMessageValidation(errorMsg);
//	}
	
	@Then("Validate user {string};")
	public void validate_user(String title) {
		
		if(title.equals("Swag Labs"))
		{
			login.homePageValidation(title);
		}
		else
		{
			login.errorMessageValidation(title);
		}
	   
		
	}

	
}
