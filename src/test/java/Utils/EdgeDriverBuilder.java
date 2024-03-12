package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverBuilder extends WebDriverManager {
	
	   
	    private EdgeOptions edgeOptions;

	    public EdgeDriverBuilder() {
	       
	        edgeOptions = new EdgeOptions();
	    }

	    public EdgeDriverBuilder setHeadless(boolean headless) {
	        if (headless) {
	           
	            edgeOptions.addArguments("--headless");
	        }
	        return this;
	    }

	    public EdgeDriverBuilder setIncognito(boolean incognito) {
	        
	        return this;
	    }

	 

	    public WebDriver create() {
	        return new EdgeDriver(edgeOptions);
	    }
	}
