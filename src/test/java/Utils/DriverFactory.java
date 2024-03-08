package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class provides a centralized way to manage WebDriver instances for Selenium tests.
 * It follows the singleton design pattern and ensures thread safety for parallel test execution.
 */
public class DriverFactory {

    private static volatile DriverFactory instance;
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {}

    /**
     * Returns the singleton instance of DriverFactory.
     * If the instance doesn't exist, it creates a new one.
     *
     * @return The singleton instance of DriverFactory.
     */
    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    /**
     * Returns the WebDriver instance associated with the current thread.
     * If no WebDriver instance exists for the current thread, it creates a new one based on the specified browser.
     *
     * @param browser The type of browser for which to create the WebDriver instance (e.g., "chrome", "firefox").
     * @return The WebDriver instance associated with the current thread.
     */
    public WebDriver getDriver(String browser) {
        if (driverThreadLocal.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driverThreadLocal.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverThreadLocal.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                case "remote":
                    // Example of setting up a RemoteWebDriver
                    // Replace "remoteUrl" with your actual RemoteWebDriver URL
                    String remoteUrl = "http://localhost:4444/wd/hub";
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    driverThreadLocal.set(new RemoteWebDriver(capabilities));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type: " + browser);
            }
        }
        return driverThreadLocal.get();
    }

    /**
     * Quits the WebDriver instance associated with the current thread.
     * If a WebDriver instance exists for the current thread, it quits the instance and removes it from the thread-local storage.
     */
    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Log or handle any exceptions that occur during quitting the WebDriver
                System.out.println("Error occurred while quitting WebDriver: " + e.getMessage());
            } finally {
                driverThreadLocal.remove();
            }
        }
    }
}
