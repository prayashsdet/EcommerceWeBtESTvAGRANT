package pomclasses;

//import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorePageActions {
	private static final Logger logger = LoggerFactory.getLogger(StorePageActions.class);
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
