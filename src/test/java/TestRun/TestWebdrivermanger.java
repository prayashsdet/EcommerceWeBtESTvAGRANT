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
/**This class covers various functionalities of the WebDriverManager:

Getting drivers for multiple browsers.
Getting drivers specifically for Chrome, Firefox, and Edge browsers.
Setting and applying options for Chrome and Firefox browsers.
Performing assertions on the obtained WebDriver instances.
**/
public class TestWebdrivermanger {
	@Test
	public void testMultipleBrowsers() {
	    WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
	    Assert.assertNotNull(chromeDriver);
	    // Perform test actions and assertions for Chrome

	    WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
	    Assert.assertNotNull(firefoxDriver);
	    // Perform test actions and assertions for Firefox
	}
	
	@Test
	public void testBrowserName() {
		WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
		Assert.assertEquals(new ChromeOptions().getBrowserName(),"chrome");
		
		WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
		Assert.assertEquals(new FirefoxOptions ().getBrowserName(),"firefox");
	}
	
	public void testincognito() {
		WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
		new ChromeOptions().addArguments("--incognito");
		   Assert.assertTrue(new ChromeOptions().getCapabilityNames().contains("--incognito"));
		
		WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
		new FirefoxOptions().addArguments("--headles");
		Assert.assertTrue(new FirefoxOptions().getCapabilityNames().contains("--headless"));
	}
	 @Test
	    public void testWindowsOS() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--user-agent=Windows");
	        Assert.assertTrue(options.getCapabilityNames().contains("--user-agent=Windows"));
	    }
	 @Test
	    public void testDisableExtensions() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-extensions");
	        Assert.assertTrue(options.getCapabilityNames().contains("--disable-extensions"));
	    }
	 
	 @Test
	    public void testDisablePopupBlocking() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-popup-blocking");
	        Assert.assertTrue(options.getCapabilityNames().contains("--disable-popup-blocking"));
	    }
	 public static WebDriver launchDriver(String browser) {
	       

	        WebDriverBuilder builder;
	        switch (browser) {
	            case "chrome":
	                builder = new ChromeDriverManager();
	                break;
	            case "firefox":
	                builder = new FirefoxDriverManager();
	                break;
	            case "edge":
	                builder = new EdgeDriverManage();
	                break;
	            default:
	                throw new IllegalArgumentException("Browser type not supported: " + browser);
	        }
			return builder.createDriver();
	 

	
	
}
	 @Test
	    public void testChromeBrowser() {
		  WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
	        Assert.assertNotNull(chromeDriver);
	        chromeDriver.get("https://example.com");
	        Assert.assertEquals(chromeDriver.getTitle(), "Example Domain");
	        // Add more assertions for Chrome browser
	    }

	    @Test
	    public void testFirefoxBrowser() {
	        WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
		    Assert.assertNotNull(firefoxDriver);
	        Assert.assertNotNull(firefoxDriver);
	        firefoxDriver.get("https://example.com");
	        Assert.assertEquals(firefoxDriver.getTitle(), "Example Domain");
	        // Add more assertions for Firefox browser
	    }
	    @Test
	    public void  test() {
	        WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
	        Assert.assertNotNull(chromeDriver, "Chrome driver instance is null");
	        chromeDriver.get("https://example.com");
	        Assert.assertEquals(chromeDriver.getTitle(), "Example Domain", "Page title is incorrect for Chrome browser");
	    }

	    @Test
	    public void testFirefoxBrowser1() {
	        WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
	        Assert.assertNotNull(firefoxDriver, "Firefox driver instance is null");
	        firefoxDriver.get("https://example.com");
	        Assert.assertEquals(firefoxDriver.getTitle(), "Example Domain", "Page title is incorrect for Firefox browser");
	    }

	    @Test
	    public void testChromeOptions() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        options.addArguments("--disable-gpu");
	        WebDriver chromeDriver = WebDriverManager.getDriver("chrome");
	        Assert.assertNotNull(chromeDriver, "Chrome driver instance with options is null");
	        // Perform additional assertions related to Chrome options
	    }

	    @Test
	    public void testFirefoxOptions() {
	        FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("--headless");
	        options.addArguments("--disable-gpu");
	        WebDriver firefoxDriver = WebDriverManager.getDriver("firefox");
	        Assert.assertNotNull(firefoxDriver, "Firefox driver instance with options is null");
	        // Perform additional assertions related to Firefox options
	    }

	    @Test
	    public void testEdgeBrowser() {
	        WebDriver edgeDriver = WebDriverManager.getDriver("edge");
	        Assert.assertNotNull(edgeDriver, "Edge driver instance is null");
	        edgeDriver.get("https://example.com");
	        Assert.assertEquals(edgeDriver.getTitle(), "Example Domain", "Page title is incorrect for Edge browser");
	    }

	    // Add more test methods to cover other functionalities of WebDriverManager

	}

