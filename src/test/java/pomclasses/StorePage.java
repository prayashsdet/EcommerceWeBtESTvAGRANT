package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class representing the Store Page.
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
     * Clicks the link to select Ti Skis and navigates to the Skis Page.
     * @return SkisPage instance
     */
    public SkisPage selectTiSkis() {
        tiSkisLink.click();
        return new SkisPage(driver);
    }
}
