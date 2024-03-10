package Utils;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver create(String type) {
        WebDriverBuilder builder;
        switch (type.toLowerCase()) {
            case "chrome":
                builder = new ChromeDriverBuilder();
                break;
            case "firefox":
                builder = new FirefoxDriverBuilder();
                break;
            case "edge":
                builder = new EdgeDriverBuilder();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + type);
        }

        return builder.build();
    }
}
