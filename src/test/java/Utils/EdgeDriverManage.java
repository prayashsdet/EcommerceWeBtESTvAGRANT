package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManage implements WebDriverBuilder {
	
	   
	    private EdgeOptions edgeOptions;

	    public EdgeDriverManage() {
	       
	        edgeOptions = new EdgeOptions();
	        edgeOptions.addArguments("--headless");
	    }

	   
	 

	    public WebDriver createDriver() {
	        return new EdgeDriver(edgeOptions);
	    }
	}
