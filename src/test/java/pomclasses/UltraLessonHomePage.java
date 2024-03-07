package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the UltraLesson Home Page.
 * Provides methods to interact with the home page, such as navigating to the store.
 */
public class UltraLessonHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement storeButton;

    /**
     * Constructs a new UltraLessonHomePage object.
     * @param driver The WebDriver instance.
     */
    public UltraLessonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the store page by clicking on the Store button.
     * @return An instance of StorePage representing the store page.
     */
    public StorePage navigateToStore() {
        storeButton.click();
        return new StorePage(driver);
    }
}
