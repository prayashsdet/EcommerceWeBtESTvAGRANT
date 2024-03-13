package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager  implements WebDriverBuilder {
    

    private FirefoxOptions options;
  

    public FirefoxOptions setOptions(FirefoxOptions options) {
	return	this.options = options;
	}

	public FirefoxDriverManager() {
       options = new FirefoxOptions();
//        options.addArguments("--headless");
        
    }

//    public FirefoxOptions setHeadless() {
//        
//           return firefoxOptions.addArguments("--headless");
//    }
//        
//          
//        
//
//    public FirefoxOptions setIncognito() {
//      
//          return   firefoxOptions.addArguments("-private");
//            // Edge does not support incognito mode
    
        
       

    public WebDriver createDriver() {
        return new FirefoxDriver(options);
    }
}