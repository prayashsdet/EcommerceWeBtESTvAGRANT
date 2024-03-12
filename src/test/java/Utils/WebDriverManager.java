package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class WebDriverManager {
	 private static WebDriver chromeDriver;
	    private static WebDriver firefoxDriver;
	    private static WebDriver edgeDriver;
	 public static void initialize(String browserName) {
	        switch (browserName.toLowerCase()) {
	            case "chrome":
	                chromeDriver = new ChromeDriverManager().getChromeDriver();
	                break;
	            case "firefox":
	                firefoxDriver = new FirefoxDriverManager().getFirefoxdriver();
	                break;
	            case "edge":
	                edgeDriver = new EdgeDriverManage().getEdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Browser type not supported: " + browserName);
	        }
	 }
	        
	        public static WebDriver getChromeDriver() {
	            if (chromeDriver == null) {
	                throw new IllegalStateException("Chrome driver not initialized. Call initialize method first.");
	            }
	            return chromeDriver;
	        }

	        public static WebDriver getFirefoxDriver() {
	            if (firefoxDriver == null) {
	                throw new IllegalStateException("Firefox driver not initialized. Call initialize method first.");
	            }
	            return firefoxDriver;
	        }

	        public static WebDriver getEdgeDriver() {
	            if (edgeDriver == null) {
	                throw new IllegalStateException("Edge driver not initialized. Call initialize method first.");
	            }
	            return edgeDriver;
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
    

