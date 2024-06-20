package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAction {
	
public WebDriver driver;

public static By username=By.xpath("//input[@id='user-name']");
public static By password=By.xpath("//input[@id='password']");
public static By loginButton=By.xpath("//input[@id='login-button']");
public static By errorMessage=By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

	public LoginAction(WebDriver driver)
	{
		this.driver=driver;
	}

	public void navigateToURL(String url)
	{
		driver.get(url);
	}
	
	public void enterUsernamePassword(String user, String pwd)
	{
		WebElement userName=driver.findElement(username);
		userName.sendKeys(user);
		
		WebElement passWord=driver.findElement(password);
		passWord.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginButton).click();
	}

	public void homePageValidation(String act_title)
	{
		String exp_title=driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
	}
	
	public void errorMessageValidation(String act_errorMsg)
	{
		String exp_errorMsg=driver.findElement(errorMessage).getText();
		Assert.assertEquals(act_errorMsg, exp_errorMsg);
	
	}
}
