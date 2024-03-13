package TestRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.ChromeDriverManager;
import Utils.EdgeDriverManage;
import Utils.FirefoxDriverManager;
import Utils.WebDriverBuilder;
import Utils.WebDriverManager;

public class TestWebdrivermanger {

    @Test
    public void testBrowserInitialization() {
        WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
        Assert.assertNotNull(chromeDriver, "Chrome driver instance is null");
        
        WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
        Assert.assertNotNull(firefoxDriver, "Firefox driver instance is null");
        
        WebDriver edgeDriver = WebDriverManager.getDriver("edge");
        Assert.assertNotNull(edgeDriver, "Edge driver instance is null");
    }

    @Test
    public void testBrowserOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions= new ChromeDriverManager().setOptions(chromeOptions);
        Assert.assertNotNull(chromeOptions, "Chrome driver instance with options is null");
        
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--disable-gpu");
         firefoxOptions = new FirefoxDriverManager().setOptions(firefoxOptions);
        Assert.assertNotNull(firefoxOptions, "Firefox driver instance with options is null");
    }

    @Test
    public void testBrowserSpecificFunctionality() {
        WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
        chromeDriver.get("https://example.com");
        Assert.assertEquals(chromeDriver.getTitle(), "Example Domain", "Page title is incorrect for Chrome browser");
        
        WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
        firefoxDriver.get("https://example.com");
        Assert.assertEquals(firefoxDriver.getTitle(), "Example Domain", "Page title is incorrect for Firefox browser");
        
        WebDriver edgeDriver = WebDriverManager.getDriver("edge");
        edgeDriver.get("https://example.com");
        Assert.assertEquals(edgeDriver.getTitle(), "Example Domain", "Page title is incorrect for Edge browser");
    }

    // Add more test methods to cover other functionalities of WebDriverManager

}
