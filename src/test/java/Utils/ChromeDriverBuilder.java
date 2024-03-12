package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverBuilder extends WebDriverManager {
	 private ChromeOptions options;

	    public ChromeDriverBuilder() {
	        options = new ChromeOptions();
	    }

	    public ChromeDriverBuilder setHeadless(boolean headless) {
	    	 if (headless) {
	             options.addArguments("--headless");
	         }
	         return this;
	     }

	    public ChromeDriverBuilder setIncognito(boolean incognito) {
	    	 if (incognito) {
	             options.addArguments("--incognito");
	         }
	        return this;
	    }

	    public ChromeDriverBuilder addArgument(String argument) {
	        options.addArguments(argument);
	        return this;
	    }

	 

	    public WebDriver create() {
	        return new ChromeDriver(options);
	    }
	}
