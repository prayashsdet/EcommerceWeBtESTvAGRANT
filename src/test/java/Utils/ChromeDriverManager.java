package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class ChromeDriverManager implements  WebDriverBuilder{
	 private ChromeOptions chromeOptions;
	 private Object options;

	    public ChromeDriverManager() {
	    	chromeOptions = (ChromeOptions) options;
	    }

//	    public ChromeOptions setHeadless() {
//	   
//	          return   ((ChromiumOptions<ChromeOptions>) options).addArguments("--headless");
//	         }
//	         
//
//	    public ChromeOptions setIncognito() {
//	    	
//	          return   ((ChromiumOptions<ChromeOptions>) options).addArguments("--incognito");
//	         
//	    }
//	     
//	    
//
//	    public ChromeOptions addArgument(String argument) {
//	       return options.addArguments(argument);
//	     
//	    }

	 

	    public WebDriver createDriver(Object options){
	        return new ChromeDriver(chromeOptions);
	    }
	}
