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

import Utils.ChromeDriverBuilder;
//import Utils.DriverFactory;
import Utils.WebDriverManager;
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
//    private DriverFactory driverFactory;
    /**
     * Set up method to initialize WebDriver.
     * This method sets up the WebDriver before each test method.
     */
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
//    	  driverFactory = DriverFactory.getInstance();
    	driver= new ChromeDriverBuilder()
                .setHeadless(false)
                .setIncognito(false)	
                .create();
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
       
            // Add product to cart
            skisPage.addToCart();

         
      
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
//             driverFactory.quitDriver("chrome");
        }
    }
}
