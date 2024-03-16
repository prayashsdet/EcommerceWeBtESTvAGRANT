package TestRun;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.ChromeDriverManager;
//import Utils.DriverFactory;
import Utils.WebDriverManager;
import pomclasses.CartActions;
import pomclasses.SkisPageActions;
import pomclasses.StorePageActions;
import pomclasses.UltraLessonHomePageActions;

/**
 * Test class for adding a product to the cart.
 * This class contains methods to test the functionality of adding a product to the cart on the UltraLesson website.
 */
public class TestMain {
	private WebDriver driver;
	
//	        // Load Log4j properties from a file or set them programmatically
//	        PropertyConfigurator.configure("log4j2.properties");
//	    }

//    private DriverFactory driverFactory;
    /**
     * Set up method to initialize WebDriver.
     * This method sets up the WebDriver before each test method.
     */
    @BeforeTest
    public void setUp() {
        // Set up WebDriver
//    	  driverFactory = DriverFactory.getInstance();
//    	 ChromeOptions chromeOptions = new ChromeOptions();
//         chromeOptions.addArguments("--incognito");

         driver = WebDriverManager.getDriver("chrome");
          driver.manage().window().maximize();
          Assert.assertNotNull(driver);
          ChromeDriverManager chromeDriverManager = new ChromeDriverManager();
          ChromeOptions chromeOptions = chromeDriverManager.getOptions();
          Assert.assertEquals(chromeOptions.getBrowserName(),"chrome");
          chromeOptions.getCapabilityNames().contains("--incognito");
          
      }
    

    /**
     * Test method to add a product to the cart.
     * This method navigates to the website, selects a product, adds it to the cart, and verifies the cart contents.
     */
    @Test
    public void testAddProductToCart() {
        // Navigate to the website
    	System.out.println(Thread.currentThread().getId());
        driver.get("https://web-playground.ultralesson.com/collections/all");

        // Initialize page objects
        UltraLessonHomePageActions homePage = new UltraLessonHomePageActions(driver);
        StorePageActions storePage = new StorePageActions(driver);
        SkisPageActions skisPage = new SkisPageActions(driver);
        CartActions cpg = new CartActions(driver);
        homePage.clickOnStorePageLink();
        storePage.selectTiSkis();
        // Check if the product is available
       
            // Add product to cart
            skisPage.addToCart();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));
            Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"), "Item added to cart message not found");
            skisPage.viewCart();
            Assert.assertEquals(cpg.getProductName(), "16 Ti Skis");

         
      
        // Remove product from cart and verify it's empty
    }

    /**
     * Tear down method to close the WebDriver.
     * This method closes the WebDriver after each test method.
     */
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
