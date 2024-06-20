package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartAction {
	
	WebDriver driver;
	public AddToCartAction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public By sauceLabsBackpack=By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
	public By sauceLabsBackpackAddToCart=By.id("add-to-cart-sauce-labs-backpack");
	public By cartLink=By.xpath("//a[@class='shopping_cart_link']");
	
	public void clicksauceLabsBackpack()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(sauceLabsBackpackAddToCart).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void productAddedToCartValidation(String act_productName)
	{
		driver.findElement(cartLink).click();
		String exp_productName=driver.findElement(sauceLabsBackpack).getText();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(act_productName, exp_productName);
		
	}
	
	

}
