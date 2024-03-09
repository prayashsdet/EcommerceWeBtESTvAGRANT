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

import Utils.DriverFactory;
import pomclasses.CartPage;
import pomclasses.SkisPage;
import pomclasses.StorePage;
import pomclasses.UltraLessonHomePage;

/**
 * Test class for adding a product to the cart.
 * This class contains methods to test the functionality of adding a product to the cart on the UltraLesson website.
 */
public class TestMain {
	private WebDriver driver;
    private DriverFactory driverFactory;
    /**
     * Set up method to initialize WebDriver.
     * This method sets up the WebDriver before each test method.
     */
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
    	  driverFactory = DriverFactory.getInstance();

          // Get WebDriver instance from DriverFactory
          driverFactory.setDriver("chrome");
          driver=driverFactory.getDriver();
          driver.manage().window().maximize();
    }

    /**
     * Test method to add a product to the cart.
     * This method navigates to the website, selects a product, adds it to the cart, and verifies the cart contents.
     */
    @Test
    public void testAddProductToCart() {
        // Navigate to the website
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

            // Wait for the "Item added to your cart" message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));

            // Verify that the cart's item count is incremented
            Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"), "Item added to cart message not found");
            skisPage.viewCart();
            Assert.assertEquals(cpg.getProductName(), "16 Ti Skis");
            Assert.assertEquals(cpg.getProductSize(), "163cm");
//            System.out.println(cpg.productQuantity.getText());
            Assert.assertEquals(cpg.getProductQuantity(), "1");

            // Verify price and total
            Assert.assertEquals(cpg.getProductPrice(), "Rs. 599.00");
            Assert.assertEquals(cpg.getTotalPrice(), "Rs. 569.05");
        } else {
            System.out.println("The product is sold out. Aborting the test.");
        }
        
        // Remove product from cart and verify it's empty
        cpg.removeProductFromCart();
        cpg.isCartEmpty();
    }

    /**
     * Tear down method to close the WebDriver.
     * This method closes the WebDriver after each test method.
     */
    @AfterMethod
    public void tearDown() {
        // Close the browser
    	 if (driver != null) {
             // Quit WebDriver and remove from DriverFactory
             driver.quit();
             driverFactory.quitDriver();
        }
    }
}
