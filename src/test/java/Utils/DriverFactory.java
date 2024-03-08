package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static volatile DriverFactory instance;
    private final Map<String, WebDriver> driverMap = new HashMap<>();

    private DriverFactory() {}

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String browser) {
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
        driverMap.put(browser, driver);
        return driver;
    }

    public void quitDriver(String browser) {
        WebDriver driver = driverMap.get(browser);
        if (driver != null) {
            driver.quit();
            driverMap.remove(browser);
        }
    }
}
