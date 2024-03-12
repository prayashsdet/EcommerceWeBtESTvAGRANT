package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManage  implements WebDriverBuilder {
	
	   
	    private EdgeOptions edgeOptions;
	    private Object options;


	    public EdgeDriverManage() {
	       
	        edgeOptions = ( EdgeOptions)options;
	    }

//	    public EdgeDriverManage setHeadless(boolean headless) {
//	        if (headless) {
//	           
//	            edgeOptions.addArguments("--headless");
//	        }
//	        return this;
//	    }
//
//	    public EdgeDriverManage setIncognito(boolean incognito) {
//	        
//	        return this;
//	    }

	 

	    public WebDriver createDriver(Object options) {
	        return new EdgeDriver(edgeOptions);
	    }
	}
