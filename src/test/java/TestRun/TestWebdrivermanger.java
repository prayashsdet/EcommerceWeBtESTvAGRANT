package TestRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
