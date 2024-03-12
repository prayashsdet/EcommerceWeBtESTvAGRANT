package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class WebDriverManager {
	 
	 public static WebDriver initialize(String browserName) {
		 WebDriver driver;
	        switch (browserName.toLowerCase()) {
	            case "chrome":
	              driver= new ChromeDriverManager().getChromeDriver();
	               break;
			case "firefox":
	              driver=new FirefoxDriverManager().getFirefoxdriver();
	      
	            case "edge":
	               driver=  new EdgeDriverManage().getEdgeDriver();
	             
	            default:
	                throw new IllegalArgumentException("Browser type not supported: " + browserName);
	        }
	        return driver;
	        
	 }
	        
	   	 }
	        // Set configuration options
//	        builder.setHeadless(headless);
//	        builder.setIncognito(incognito);
//
//	        return builder.build();
	    
	
//    /**
//     * Build and return the WebDriver instance.
//     *
//     * @return the WebDriver instance
//     * @throws IllegalStateException if WebDriver has not been created
//     */
//    public WebDriver build() {
//        if (driver == null) {
//            throw new IllegalStateException("WebDriver has not been created. Please call create() method first.");
//        }
//        return driver;
    

