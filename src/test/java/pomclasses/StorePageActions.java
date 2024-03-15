package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Utils.DriverFactory;

/**
 * Represents the Store Page of the UltraLesson website.
 * This class provides methods to interact with the store page, such as selecting products.
 */
public class StorePageActions {
    private final  WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='16 Ti Skis']")
    private WebElement tiSkisLink;

    /**
     * Constructs a new StorePage object.
     * Initializes the WebDriver instance and initializes page elements using PageFactory.
     */
    public  StorePageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the Ti Skis product from the store.
     * Clicks on the Ti Skis link to navigate to the product page.
     */
    public synchronized void selectTiSkis() {
        tiSkisLink.click();
    }
}