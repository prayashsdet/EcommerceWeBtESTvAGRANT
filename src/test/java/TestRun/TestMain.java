package TestRun;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomclasses.CartPage;
import pomclasses.SkisPage;
import pomclasses.StorePage;
import pomclasses.UltraLessonHomePage;

public class TestMain {
	 public WebDriver driver;
	 @BeforeMethod
	    public void setUp() {
	        // Set up WebDriver
//	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	    }

	 
	
	
		    @Test
		    public void testAddProductToCart() {
		        // Navigate to the website
		        driver.get("https://web-playground.ultralesson.com/collections/all");

		        // Initialize page objects
		        UltraLessonHomePage homePage = new UltraLessonHomePage(driver);
		        StorePage storePage = homePage.navigateToStore();
		        SkisPage skisPage = storePage.selectTiSkis();
		        CartPage cpg = new CartPage(driver);

		        // Check if the product is available
		        if (skisPage.isProductAvailable().isEnabled()) {
		            // Add product to cart
		            skisPage.addToCart();

		            // Wait for the "Item added to your cart" message to appear
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));

		            // Verify that the cart's item count is incremented
		            Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"), "Item added to cart message not found");
		            skisPage.viewCart();
//		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Quantity-1")));
//		            Assert.assertEquals("1", driver.findElement(By.xpath("//input[@id='Quantity-1']")).getText());
		            
		       
		            Assert.assertEquals(cpg.getProductName(), "16 Ti Skis");
		            Assert.assertEquals(cpg.getProductSize(), "163cm");
		            System.out.println(cpg.productQuantity.getText());
		            Assert.assertEquals(cpg.getProductQuantity(), "1");

		            // Verify price and total
		            Assert.assertEquals(cpg.getProductPrice(), "Rs. 599.00");
		            Assert.assertEquals(cpg.getTotalPrice(), "Rs. 569.05");
		        } else {
		            System.out.println("The product is sold out. Aborting the test.");
		        }
		    }

		   
		    
		
@AfterMethod
public void tearDown() {
    // Close the browser
//    if (driver != null) {
//        driver.quit();
//    }
}
}

