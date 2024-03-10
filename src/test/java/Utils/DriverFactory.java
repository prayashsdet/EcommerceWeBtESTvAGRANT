package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	 private static ThreadLocal<DriverFactory> instance = new ThreadLocal<>();
    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private DriverFactory() {}

    public static DriverFactory getInstance() {
    	 if (instance.get() == null) {
             instance.set(new DriverFactory());
         }
         return instance.get();
     }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            throw new IllegalStateException("WebDriver instance not initialized. Call setDriver method first.");
        }
        return drivers.get();
    }

    public void setDriver(String browser) {
    	if (drivers.get() == null) {
        WebDriver driver = createDriver(browser);
        drivers.set(driver);
    }
    }

    public void quitDriver() {
        
        if (drivers.get() != null) {
            try {
                drivers.get().quit();
                drivers.remove();
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
        WebDriverFactory factory = new WebDriverFactory(); // Instantiate the factory
        driver = factory.create(browser); // Delegate browser creation to the factory
        return driver;
    }

}
