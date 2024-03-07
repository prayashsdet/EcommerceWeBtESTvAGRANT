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
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "edge";
    private static final String REMOTE = "remote";

    private static final ThreadLocal<DriverFactory> instanceThreadLocal = ThreadLocal.withInitial(DriverFactory::new);
    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> null);
    private final Map<String, WebDriver> driverMap = new HashMap<>();

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        return instanceThreadLocal.get();
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public WebDriver createDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case REMOTE:
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
        driverThreadLocal.set(driver);
        return driver;
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            driverMap.remove(getBrowserType(driver));
        }
    }

    private String getBrowserType(WebDriver driver) {
        String browserType = "Unknown";
        if (driver instanceof ChromeDriver) {
            browserType = CHROME;
        } else if (driver instanceof FirefoxDriver) {
            browserType = FIREFOX;
        } else if (driver instanceof EdgeDriver) {
            browserType = EDGE;
        } else if (driver instanceof RemoteWebDriver) {
            browserType = REMOTE;
        }
        return browserType;
    }
}
