package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends WebDriverBuilder {
	 private ChromeOptions options;

	    public ChromeDriverManager() {
	        options = new ChromeOptions();
	    }

	    public ChromeDriverManager setHeadless(boolean headless) {
	    	 if (headless) {
	             options.addArguments("--headless");
	         }
	         return this;
	     }

	    public ChromeDriverManager setIncognito(boolean incognito) {
	    	 if (incognito) {
	             options.addArguments("--incognito");
	         }
	        return this;
	    }

	    public ChromeDriverManager addArgument(String argument) {
	        options.addArguments(argument);
	        return this;
	    }

	 

	    public WebDriver create() {
	        return new ChromeDriver(options);
	    }
	}
