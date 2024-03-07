package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model representing the Store Page.
 * This class provides methods to interact with the Store page, such as selecting products.
 */
public class StorePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='16 Ti Skis']")
    private WebElement tiSkisLink;

    /**
     * Constructor for the StorePage class.
     * @param driver WebDriver instance
     */
    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the Ti Skis product from the store.
     * Clicks the link to navigate to the Skis Page.
     * @return SkisPage instance
     */
    public SkisPage selectTiSkis() {
        tiSkisLink.click();
        return new SkisPage(driver);
    }
}
