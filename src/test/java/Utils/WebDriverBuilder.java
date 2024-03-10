package Utils;

import org.openqa.selenium.WebDriver;

public interface WebDriverBuilder {
    WebDriverBuilder setHeadless(boolean headless);
    WebDriverBuilder setIncognito(boolean incognito);
    WebDriver build();
}
