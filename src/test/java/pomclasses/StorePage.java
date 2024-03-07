package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Store Page of the UltraLesson website.
 * Provides methods to interact with the store page, such as selecting products.
 */
public class StorePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='16 Ti Skis']")
    private WebElement tiSkisLink;

    /**
     * Constructs a new StorePage object.
     * @param driver The WebDriver instance.
     */
    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the Ti Skis product from the store.
     * @return An instance of SkisPage representing the selected product page.
     */
    public SkisPage selectTiSkis() {
        tiSkisLink.click();
        return new SkisPage(driver);
    }
}
