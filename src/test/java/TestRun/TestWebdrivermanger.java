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
}
