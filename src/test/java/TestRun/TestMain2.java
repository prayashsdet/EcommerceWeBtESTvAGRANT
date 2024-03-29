package TestRun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.ChromeDriverManager;
import Utils.EdgeDriverManage;
import Utils.FirefoxDriverManager;
import Utils.WebDriverManager;
import pomclasses.CartActions;
import pomclasses.SkisPageActions;
import pomclasses.StorePageActions;
import pomclasses.UltraLessonHomePageActions;

public class TestMain2 {
	private WebDriver driver;
	
	
	@BeforeTest
    public void setUp() {
        // Set up WebDriver
//    	  driverFactory = DriverFactory.getInstance();
	
         driver = WebDriverManager.getDriver("firefox");
          driver.manage().window().maximize();
          
          Assert.assertNotNull(driver);
              
//          driver.manage().window().maximize();
    }
	@Test
	public void verifyincrementcount() {
		System.out.println("temp2M1: " +Thread.currentThread().getId());
		  driver.get("https://web-playground.ultralesson.com/collections/all");

	        // Initialize page objects
	        UltraLessonHomePageActions homePage = new UltraLessonHomePageActions(driver);
	        StorePageActions storePage = new StorePageActions(driver);
	        SkisPageActions skisPage = new SkisPageActions(driver);
	        CartActions cpg = new CartActions(driver);
//	        homePage.clickOnStorePageLink();
	        storePage.selectTiSkis();
	        // Check if the product is available
	        if (skisPage.isProductAvailable().isEnabled()) {
	            // Add product to cart
	            skisPage.addToCart();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));

	            // Verify that the cart's item count is incremented
	            Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"), "Item added to cart message not found");
	            skisPage.viewCart();
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
	 // Wait for the "Item added to your cart" message to appear
    
   
}
	@AfterTest
    public void tearDown() {
        // Close the browser
    	 if (driver != null) {
             // Quit WebDriver and remove from DriverFactory
             driver.quit();
//             driverFactory.quitDriver("chrome");
        }
}
}
