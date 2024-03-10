package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverBuilder implements WebDriverBuilder {
    private EdgeOptions options = new EdgeOptions();


    public WebDriverBuilder setHeadless(boolean headless) {
        // Edge does not support headless mode
        return this;
    }

    @Override
    public WebDriverBuilder setIncognito(boolean incognito) {
        // Edge does not support incognito mode
        return this;
    }

    @Override
    public WebDriver build() {
        return new EdgeDriver(options);
    }
}