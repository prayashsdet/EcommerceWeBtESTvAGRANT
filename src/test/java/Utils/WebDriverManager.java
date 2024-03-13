package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Factory class for creating WebDriver instances based on the specified browser name.
 * This class demonstrates the Factory Method pattern for object creation.
 * 
 * The Factory Method pattern is used to provide an interface for creating objects, 
 * allowing subclasses to alter the type of objects that will be created. In this case, 
 * concrete subclasses (ChromeDriverManager, FirefoxDriverManager, EdgeDriverManager) 
 * implement the factory method to create WebDriver instances specific to each browser.
 * 
 * The Factory Method pattern is chosen over the Builder pattern in this context because
 * it allows for the creation of different types of WebDriver instances based on the browser type
 * without tightly coupling the client code (test classes) to the specific implementation classes.
 * Additionally, the Factory Method pattern provides a more straightforward approach when 
 * dealing with multiple subclasses, each responsible for creating objects of a different type.
 * Although the Builder pattern can provide more flexibility in configuring and constructing objects,
 * it may introduce unnecessary complexity for the simple task of creating WebDriver instances 
 * with different configurations.
 */
public class WebDriverManager {
    
    /**
     * Initializes and returns a WebDriver instance for the specified browser.
     *
     * @param browserName the name of the browser (e.g., "chrome", "firefox", "edge")
     * @return a WebDriver instance
     * @throws IllegalArgumentException if the browser type is not supported
     * 
     */
	@BeforeSuite
//	 @Parameters("browser")
	public static WebDriver getDriver(String browser) {
       

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

        
//        if (options != null) {
//            if (builder instanceof ChromeDriverManager && options instanceof ChromeOptions) {
//                ((ChromeDriverManager) builder).setOptions((ChromeOptions) options);
////            } else if (builder instanceof FirefoxDriverManager && options instanceof FirefoxOptions) {
////                ((FirefoxDriverManager) builder).setOptions((FirefoxOptions) options);
//            }
//        }
        return builder.createDriver();
    
}
	}

