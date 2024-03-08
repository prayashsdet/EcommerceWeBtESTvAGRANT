package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private static volatile DriverFactory instance;
    private ThreadLocal<WebDriver> drivers = ThreadLocal.withInitial(() -> null);

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        return drivers.get();
    }

    public void setDriver(String browser) {
        if (drivers.get() != null) {
            throw new IllegalStateException("WebDriver instance already initialized. Quit the current driver first.");
        }
        WebDriver driver = createDriver(browser);
        drivers.set(driver);
    }

    public void quitDriver() {
        WebDriver driver = drivers.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error while quitting WebDriver instance: " + e.getMessage());
            } finally {
                drivers.remove(); // Remove the WebDriver instance from the thread local storage
            }
        } else {
            System.out.println("WebDriver instance already quit or not initialized.");
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
