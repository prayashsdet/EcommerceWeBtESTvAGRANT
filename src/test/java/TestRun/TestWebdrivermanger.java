package TestRun;

import org.openqa.selenium.WebDriver;
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
}
