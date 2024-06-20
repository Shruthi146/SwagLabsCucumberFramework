package StepDefinitions;

import Actions.AddToCartAction;
import Actions.LoginAction;
import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefinitions {
	
	AddToCartAction cart=new AddToCartAction(Hooks.getDriver());
	LoginAction login=new LoginAction(Hooks.getDriver());
	
	@Given("User is on home page {string}")
	public void user_is_on_home_page(String act_title) {
	    
		login.homePageValidation(act_title);
	}
	
	@When("Add Sauce Labs Backpack product to cart displayed on Swag labs page")
	public void add_product_to_cart_displayed_on_swag_labs_page() {
	    cart.clicksauceLabsBackpack();
	}
	
	@Then("Validate {string} product added to cart")
	public void validate_product_added_to_cart(String act_productName) {
		cart.productAddedToCartValidation(act_productName);
	}

}
