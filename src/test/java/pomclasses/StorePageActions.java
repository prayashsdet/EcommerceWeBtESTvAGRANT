package pomclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePageActions {
    private static final Logger logger = LogManager.getLogger(StorePageActions.class);
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
