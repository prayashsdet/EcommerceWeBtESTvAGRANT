package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManage  implements WebDriverBuilder {
	
	   
	    private EdgeOptions edgeOptions;

	    public EdgeDriverManage() {
	       
	        edgeOptions = new EdgeOptions();
	    }

	    public EdgeDriverManage setHeadless(boolean headless) {
	        if (headless) {
	           
	            edgeOptions.addArguments("--headless");
	        }
	        return this;
	    }

	    public EdgeDriverManage setIncognito(boolean incognito) {
	        
	        return this;
	    }

	 

	    public WebDriver getWebDriver() {
	        return new EdgeDriver(edgeOptions);
	    }
	}
