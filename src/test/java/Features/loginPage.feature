Feature: Login to application

@Login1
Scenario Outline: User Login to application with valid and invalid credentials
Given Navigate to URL "https://www.saucedemo.com/"
When Enter username "<Username>" and password "<Password>"
And Click on login
Then Validate user "<title>";

Examples:
|Username     |Password    |title																																		 |
|standard_user|secret_sauce|Swag Labs																																 |
#|problem_user |secret sauce|Epic sadface: Username and password do not match any user in this service|
