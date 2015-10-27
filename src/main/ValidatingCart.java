package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.SynchronousQueue;

import org.junit.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ValidatingCart {
	WebDriver driver;
	private static String item ;
	String itemName;

	public ValidatingCart(WebDriver wdriver){
		this.driver= wdriver;
	}

	public void logIn(String username, String password) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[1]/div[1]/p/span[2]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-username']")));
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@data-automation-id='login-sign-in']")).click();

	}

	public void removeItems(){
		driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[2]/div/a/i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spa-layout']/div/div/div[1]/div/h3/span")));

		while(driver.findElements(By.xpath("//*[@id='CartRemItemBtn']")).size() > 0){
			driver.findElements(By.xpath("//*[@id='CartRemItemBtn']")).get(0).click();
		}
	}


	public void searchItem(String searchText)
	{
		driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(searchText);
		driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[3]/form/div/div[3]/button")).click();

		switch(searchText){
		//tv, socks, dvd, toys, iPhone
		case "tv":
			item= "//*[@id='tile-container']/div[2]/div/div/h4/a";
			break;
		case "socks":
			item ="//*[@id='tile-container']/div[2]/div/div/h4/a";
			break;
		case "dvd":
			item= "//*[@id='tile-container']/div[2]/div/div/h4/a";
			break;
		case "toys":
			Actions builder = new Actions(driver);
			WebElement category = driver.findElement(By.xpath("html/body/div[1]/section/section[4]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/ul/li[8]/a/span"));
			builder.moveToElement(category).perform();
			WebElement subcategory = driver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/ul/li[8]/div/div/ul[2]/li[3]/a"));
			builder.moveToElement(subcategory).click().build().perform();
			item= "//*[@id='tile-container']/ul/li[2]/div/a[2]/h3/div";
			break;
		case "iPhone":
			item= "//*[@id='tile-container']/div[6]/div/div/h4/a";
			break;
		default:
			break;

		}
		itemName= driver.findElement(By.xpath(item)).getText();
		driver.findElement(By.xpath(item)).click();
	}

	public void addToCart()
	{
		driver.findElement(By.xpath("//*[@id='WMItemAddToCartBtn']")).click();

	}

	public void viewCart()
	{

		driver.findElement(By.xpath("//*[@id='PACViewCartBtn']")).click();
	}
	public void validateCart(){
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.walmart.com/cart/" );
		Assert.assertEquals(driver.findElement(By.className("cart-item-name")).getText(),itemName);
		WebElement quantity = driver.findElement(By.xpath("//*[@id='spa-layout']/div/div/div[1]/div/h3/span"));
		Assert.assertEquals("1 item.", quantity.getText());

	}


}
