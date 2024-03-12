package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager extends WebDriverFactory {
    

    private FirefoxOptions firefoxOptions;
   

    public FirefoxDriverManager() {
        firefoxOptions = new FirefoxOptions();
        
    }

    public FirefoxDriverManager setHeadless(boolean headless) {
        if (headless) {
            firefoxOptions.addArguments("--headless");
           
        }
        return this;
    }

    public FirefoxDriverManager setIncognito(boolean incognito) {
        if (incognito) {
            firefoxOptions.addArguments("-private");
            // Edge does not support incognito mode
        }
        return this;
    }

    public WebDriver create() {
        return new FirefoxDriver(firefoxOptions);
    }
}