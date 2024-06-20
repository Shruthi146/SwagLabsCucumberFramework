Feature: Add products to cart
  
Background: 
Given Navigate to URL "https://www.saucedemo.com/"
When Enter username "standard_user" and password "secret_sauce"
And Click on login

@Cart1
Scenario: Adding products to cart displayed Swag Labs page
Given User is on home page "Swag Labs"
When Add Sauce Labs Backpack product to cart displayed on Swag labs page
Then Validate "Sauce Labs Backpack" product added to cart

@Cart2
Scenario: Adding products to cart by navigating to product page
Given User is on home page
When Click on first product displayed on Swag labs page
Then User navigated to product page
When Add product to cart displayed on product page
And Click on Back to products
And User is on home page