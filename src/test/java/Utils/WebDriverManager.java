package Utils;

import org.openqa.selenium.WebDriver;

/**
 * Factory class for creating WebDriver instances based on the specified browser name.
 * This class demonstrates both the Factory Method and Singleton patterns.
 * The Factory Method pattern is used to provide an interface for creating objects, allowing subclasses
 * to alter the type of objects that will be created. In this case, concrete subclasses (ChromeDriverManager,
 * FirefoxDriverManager, EdgeDriverManager) implement the factory method to create WebDriver instances specific
 * to each browser.
 * Additionally, the Singleton pattern ensures that only one instance of the WebDriverManager class exists
 * throughout the application, providing a global point of access to the factory method.
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
        return builder.createDriver();
    }
}
