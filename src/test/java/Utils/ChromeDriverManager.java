package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements  WebDriverBuilder{
	 private ChromeOptions options;

	    public ChromeDriverManager() {
	        options = new ChromeOptions();
//	        options.addArguments("--headless");
	        options.addArguments("--incognito");
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-notifications");
	    }

	    public ChromeOptions getOptions() {
	        return options;
	    }
	     
	    

	    
	 

	    public WebDriver createDriver() {
	        return new ChromeDriver(options);
	    }
	}
