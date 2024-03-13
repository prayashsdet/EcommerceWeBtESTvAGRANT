package TestRun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utils.ChromeDriverManager;
import Utils.EdgeDriverManage;
import Utils.FirefoxDriverManager;
import Utils.WebDriverManager;
import pomclasses.CartPage;
import pomclasses.SkisPage;
import pomclasses.StorePage;
import pomclasses.UltraLessonHomePage;

public class TestMain2 {
	private WebDriver driver;
	
	
	@BeforeSuite
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
		  driver.get("https://web-playground.ultralesson.com/collections/all");

	        // Initialize page objects
	        UltraLessonHomePage homePage = new UltraLessonHomePage(driver);
	        StorePage storePage = new StorePage(driver);
	        SkisPage skisPage = new SkisPage(driver);
	        CartPage cpg = new CartPage(driver);
	        homePage.clickOnStorePageLink();
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
}
