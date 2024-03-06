package TestRun;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
    Assert.assertTrue(driver.getPageSource().contains("16 Ti Skis"), "Item is available");
    skisPage.addToCart();
    Assert.assertTrue(driver.getPageSource().contains("Item added to your cart"),"Item added to your cart successfully");
    skisPage.viewCart();
    Assert.assertTrue(driver.getPageSource().contains("599.00"),"Price of item");
    

    // Close the browser
//    driver.quit();
}
}
	

