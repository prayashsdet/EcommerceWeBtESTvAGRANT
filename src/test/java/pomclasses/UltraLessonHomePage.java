package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class representing the UltraLesson Home Page.
 */
public class UltraLessonHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement storeButton;

    /**
     * Constructor for the UltraLessonHomePage class.
     * @param driver WebDriver instance
     */
    public UltraLessonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the store button to navigate to the Store Page.
     * @return StorePage instance
     */
    public StorePage navigateToStore() {
        storeButton.click();
        return new StorePage(driver);
    }
}
