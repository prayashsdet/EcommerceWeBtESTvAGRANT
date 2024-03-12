package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager  implements WebDriverBuilder {
    

    private FirefoxOptions firefoxOptions;
    private Object options;

   

    public FirefoxDriverManager() {
        firefoxOptions = (FirefoxOptions)options;
        
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
    
        
       

    public WebDriver createDriver( Object options) {
        return new FirefoxDriver(firefoxOptions);
    }
}