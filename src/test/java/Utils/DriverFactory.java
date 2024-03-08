package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private static volatile DriverFactory instance = null;
    private ThreadLocal<WebDriver> driverThread = ThreadLocal.withInitial(() -> null);

    private DriverFactory() {}

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String browser) {
        if (driverThread.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driverThread.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverThread.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverThread.set(new EdgeDriver());
                    break;
                case "remote":
                    // Example of setting up a RemoteWebDriver
                    // Replace "remoteUrl" with your actual RemoteWebDriver URL
                    String remoteUrl = "http://localhost:4444/wd/hub";
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    driverThread.set(new RemoteWebDriver(capabilities));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type: " + browser);
            }
        }
        return driverThread.get();
    }

    public void quitDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
