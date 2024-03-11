package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverBuilder implements WebDriverBuilder {
    private FirefoxOptions options = new FirefoxOptions();

    @Override
    public WebDriverBuilder setHeadless(boolean headless) {
     
        return this;
    }

    @Override
    public WebDriverBuilder setIncognito(boolean incognito) {
        // Firefox does not support incognito mode
        return this;
    }

    @Override
    public WebDriver build() {
        return new FirefoxDriver(options);
    }
}
