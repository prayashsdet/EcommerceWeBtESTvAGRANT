package Utils;

import org.openqa.selenium.WebDriver;

/**
 * Factory class for creating WebDriver instances based on the specified browser name.
 */
public abstract class WebDriverManager {
    
    /**
     * Initializes and returns a WebDriver instance for the specified browser.
     *
     * @param browserName the name of the browser (e.g., "chrome", "firefox", "edge")
     * @return a WebDriver instance
     * @throws IllegalArgumentException if the browser type is not supported
     */
    public static WebDriver initialize(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriverManager().getChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriverManager().getFirefoxdriver();
                break;
            case "edge":
                driver = new EdgeDriverManage().getEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserName);
        }
        return driver;
    }
}
