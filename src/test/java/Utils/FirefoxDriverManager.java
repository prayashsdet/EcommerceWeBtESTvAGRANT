package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager  {
    

    private FirefoxOptions firefoxOptions;
   

    public FirefoxDriverManager() {
        firefoxOptions = new FirefoxOptions();
        
    }

    public FirefoxOptions setHeadless() {
        
           return firefoxOptions.addArguments("--headless");
    }
        
          
        

    public FirefoxOptions setIncognito() {
      
          return   firefoxOptions.addArguments("-private");
            // Edge does not support incognito mode
    }
        
       

    public WebDriver getFirefoxdriver() {
        return new FirefoxDriver(firefoxOptions);
    }
}