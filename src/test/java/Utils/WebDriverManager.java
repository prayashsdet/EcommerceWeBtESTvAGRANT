package Utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
	 public WebDriver create(String type, boolean headless, boolean incognito) {
	        WebDriverBuilder builder;
	        switch (type.toLowerCase()) {
	            case "chrome":
	                builder = new ChromeDriverBuilder();
	                break;
	            case "firefox":
	                builder = new FirefoxDriverBuilder();
	                break;
	            case "edge":
	                builder = new EdgeDriverBuilder();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid browser type: " + type);
	        }

	        // Set configuration options
	        builder.setHeadless(headless);
	        builder.setIncognito(incognito);

	        return builder.build();
	    }
	
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
    }

