package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import main.ValidatingCart;



public class TestCase {

	WebDriver driver ;	
	ValidatingCart validCart;
	String userName = "testassghomework@gmail.com";
	String password = "guess@123";
	String itemToSearch= "socks";


	@Before
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		//open the browser
		driver.get("https://www.walmart.com");
		sleep(1000);
		// close the pop up appears before login
		driver.findElement(By.className("Modal-closeButton")).click();
		driver.manage().window().maximize();
		validCart = new ValidatingCart(driver);

	}

	@Test
	public void testEndToEnd() throws InterruptedException
	{
		sleep(5000);
		//  login to walmart.com
		validCart.logIn(userName, password);
		sleep(5000);
		// remove any item from cart if already exist
		validCart.removeItems();
		// search the item 
		validCart.searchItem(itemToSearch);
		sleep(5000);
		validCart.addToCart();
		sleep(5000);
		validCart.viewCart();
		sleep(5000);
		// validate cart that it is the same item added and the only item in cart.
		validCart.validateCart();
	}


	@After
	public void closeBrowser()
	{
		// closing the browser
		driver.close();
	}


	private void sleep(int x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
