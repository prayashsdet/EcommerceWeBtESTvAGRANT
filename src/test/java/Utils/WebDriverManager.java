package Utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    
    /**
     * Initializes and returns a WebDriver instance for the specified browser.
     *
     * @param browserName the name of the browser (e.g., "chrome", "firefox", "edge")
     * @return a WebDriver instance
     * @throws IllegalArgumentException if the browser type is not supported
     */
    public static WebDriver getDriver(String browserType) {
        if (webDriverThreadLocal.get() == null) {
            WebDriverBuilder builder;
            switch (browserType.toLowerCase()) {
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
            webDriverThreadLocal.set(builder.createDriver());
        }
        return webDriverThreadLocal.get();
    }
}
