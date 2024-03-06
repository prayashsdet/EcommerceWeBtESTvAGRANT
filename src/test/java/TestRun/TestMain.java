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

import pomclasses.SkisPage;
import pomclasses.StorePage;
import pomclasses.UltraLessonHomePage;

public class TestMain {
	 public static void main(String[] args) {
// System.setProperty("webdriver.chrome.driver", "C:/Users/ACER/Eclipse_New/EcommerceAutomation/chrome.exe");
//	 
		 WebDriver driver = new ChromeDriver();
    driver.get("https://web-playground.ultralesson.com/collections/all");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    UltraLessonHomePage homePage = new UltraLessonHomePage(driver);
    StorePage storePage = homePage.navigateToStore();
    SkisPage skisPage = storePage.selectTiSkis();
   
 if (skisPage.addToCartButton.isDisplayed()) {
     String buttonText = skisPage.addToCartButton.getText();
     if (buttonText.contains("Sold out")) {
         System.out.println("The product is sold out. Aborting the test.");
     } else {
    	 skisPage.addToCart();
     }
 } else {
     System.out.println("The 'Add to Cart' button is not visible. Aborting the test.");
 }
   
    Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"),"Item added to your cart successfully");
    skisPage.viewCart();
    Assert.assertTrue(driver.getPageSource().contains("Rs. 599.00"),"Price of item");
    

    // Close the browser
//    driver.quit();
}
}
	

