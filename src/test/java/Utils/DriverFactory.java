package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;
import java.util.HashMap;

public class DriverFactory {

    private static volatile DriverFactory instance;
    private final Map<Long, WebDriver> driverMap = new HashMap<>();

    private DriverFactory() {}

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public synchronized WebDriver getDriver(String browser) {
        long threadId = Thread.currentThread().getId();
        if (!driverMap.containsKey(threadId)) {
            WebDriver driver = createDriver(browser);
            driverMap.put(threadId, driver);
        }
        return driverMap.get(threadId);
    }

    public synchronized void quitDriver() {
        long threadId = Thread.currentThread().getId();
        if (driverMap.containsKey(threadId)) {
            WebDriver driver = driverMap.get(threadId);
            if (driver != null) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    System.err.println("Error while quitting WebDriver instance: " + e.getMessage());
                } finally {
                    driverMap.remove(threadId);
                }
            }
        }
    }

    private WebDriver createDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "remote":
                // Example of setting up a RemoteWebDriver
                // Replace "remoteUrl" with your actual RemoteWebDriver URL
                String remoteUrl = "http://localhost:4444/wd/hub";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                driver = new RemoteWebDriver(capabilities);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
        return driver;
    }
}
