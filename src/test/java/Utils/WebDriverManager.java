package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverManager {
	
	
	
	
	
	 private WebDriver driver;
	  private DesiredCapabilities options;

	    // Method to set WebDriver options
	    public WebDriverManager withOptions(DesiredCapabilities options) {
	        this.options = options;
	        return this;
	    }


    public WebDriverManager create(String browser) {
       
        if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        }

        	else if ("edge".equals(browser)) {
                driver = new EdgeDriver();
             
        }		return this;
    }

        public WebDriver build() {
            return driver;
        }
    }

