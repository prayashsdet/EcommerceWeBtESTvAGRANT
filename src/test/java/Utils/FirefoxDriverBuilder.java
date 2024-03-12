package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverBuilder extends WebDriverManager {
    

    private FirefoxOptions firefoxOptions;
   

    public FirefoxDriverBuilder() {
        firefoxOptions = new FirefoxOptions();
        
    }

    public FirefoxDriverBuilder setHeadless(boolean headless) {
        if (headless) {
            firefoxOptions.addArguments("--headless");
           
        }
        return this;
    }

    public FirefoxDriverBuilder setIncognito(boolean incognito) {
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