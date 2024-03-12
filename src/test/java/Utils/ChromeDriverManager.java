package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements  WebDriverBuilder{
	 private ChromeOptions options;

	    public ChromeDriverManager() {
	        options = new ChromeOptions();
	    }

	    public ChromeOptions setHeadless() {
	   
	          return   options.addArguments("--headless");
	         }
	         

	    public ChromeOptions setIncognito() {
	    	
	          return   options.addArguments("--incognito");
	         
	    }
	     
	    

	    public ChromeOptions addArgument(String argument) {
	       return options.addArguments(argument);
	     
	    }

	 

	    public WebDriver createDriver() {
	        return new ChromeDriver(options);
	    }
	}
