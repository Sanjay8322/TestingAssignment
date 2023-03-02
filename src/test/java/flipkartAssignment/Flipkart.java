//package flipkartAssignment;
//
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Flipkart {
//	public static void main(String[] args) throws InterruptedException{
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\esa3001\\Downloads\\chromedriver_win32\\chromedriver.exe" );
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.flipkart.com");
//		driver.manage().window().maximize();
//		WebElement closeButton=driver.findElement(By.xpath("//button[@class='_2KpZ61 _2doB4z']"));
//		closeButton.click();
//		WebElement searchBox=driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
//		searchBox.sendKeys("iphone");
//		searchBox.submit();
//		
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2kHMtA]")));
//		result.click();
//		String parentWindow = driver.getWindowHandle();
//		Set<String> windows=driver.getWindowHandles();
//		
//		for(String window:windows) {
//			if(!window.equals(parentWindow)) {
//				driver.switchTo().window(window);
//			}
//		}
//		WebElement ram=driver.findElement(By.xpath("//*[@id=\"swatch-0-storage\"]"));
//		ram.click();
//		WebElement colour=driver.findElement(By.xpath("//*[@id=\"swatch-0-color\"]/a"));
//		colour.click();
//		WebElement addToCart=driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
//		addToCart.click();
//		
//		
//	}
//
//}



package flipkartAssignment;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\esa3001\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		// Close login popup
		WebElement closeButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closeButton.click();
		
		// Search for iPhone
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchBox.sendKeys("iPhone");
		searchBox.submit();

		// Wait for search results and click on the first result
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2kHMtA']")));
		result.click();

		// Switch to the newly opened window
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}

		// Select RAM and color
		WebElement ram = driver.findElement(By.xpath("//*[@id=\"swatch-0-storage\"]/a"));
		ram.click();
		WebElement colour = driver.findElement(By.xpath("//*[@id=\"swatch-0-color\"]/a"));
		colour.click();

		// Add to cart
		WebElement addToCart = driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
		addToCart.click();
	

		// Validate add to cart page
		WebElement cartMessage = driver.findElement(By.xpath("//div[contains(text(),'Item added to cart')]"));
		if (cartMessage.isDisplayed()) {
			System.out.println("Item added to cart successfully.");
		} else {
			System.out.println("Item not added to cart.");
		}

		// Validate 'Place Order' button
		WebElement placeOrder = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		if (placeOrder.isEnabled()) {
			System.out.println("'Place Order' button is enabled.");
		} else {
			System.out.println("'Place Order' button is not enabled.");
		}

		driver.quit();
	}
}



