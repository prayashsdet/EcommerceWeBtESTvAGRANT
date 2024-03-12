package Utils;

import org.openqa.selenium.WebDriver;

/**
 * Factory class for creating WebDriver instances based on the specified browser name.
 */
public class WebDriverManager {
    
    /**
     * Initializes and returns a WebDriver instance for the specified browser.
     *
     * @param browserName the name of the browser (e.g., "chrome", "firefox", "edge")
     * @return a WebDriver instance
     * @throws IllegalArgumentException if the browser type is not supported
     */
	public static WebDriver getDriver(String browserType) {
       
        WebDriverBuilder builder;
        switch (browserType) {
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
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }
        return builder.getWebDriver();
    }
}
