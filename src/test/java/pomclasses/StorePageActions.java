package pomclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StorePageActions {
	public  static  Logger logger ;
//    static {
//         // Load Log4j properties from a file or set them programmatically
//        PropertyConfigurator.configure("log4j2.properties");
//    }
    private final WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='16 Ti Skis']")
    private WebElement tiSkisLink;

    /**
     * Constructs a new StorePageActions object.
     * Initializes the WebDriver instance and initializes page elements using PageFactory.
     */
    public StorePageActions(WebDriver driver) {
        this.driver = driver;
                PageFactory.initElements(driver, this);
                logger = LogManager.getLogger(this.getClass().getName());
    }

    /**
     * Selects the Ti Skis product from the store.
     * Clicks on the Ti Skis link to navigate to the product page.
     */
    public synchronized void selectTiSkis() {
        logger.info("Selecting Ti Skis product");
        tiSkisLink.click();
    }
}
