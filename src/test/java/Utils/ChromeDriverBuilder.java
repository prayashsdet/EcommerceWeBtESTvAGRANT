package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverBuilder implements WebDriverBuilder {
    private ChromeOptions options = new ChromeOptions();

    @Override
    public WebDriverBuilder setHeadless(boolean headless) {
    	 if (headless) {
             options.addArguments("--headless");
         }
         return this;
     }

    

    @Override
    public WebDriverBuilder setIncognito(boolean incognito) {
    	  if (incognito) {
              options.addArguments("--incognito");
          }
          return this;
      }

    @Override
    public WebDriver build() {
        return new ChromeDriver(options);
    }
}
