package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.DriverFactory;

/**
 * Represents the UltraLesson Home Page.
 * This class provides methods to interact with the home page, such as navigating to the store.
 */
public class UltraLessonHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement storeButton;

    /**
     * Constructs a new UltraLessonHomePage object.
     * Initializes the WebDriver instance and initializes page elements using PageFactory.
     */
    public UltraLessonHomePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the store page.
     * Clicks on the store button to navigate to the store page.
     */
    public void navigateToStore() {
        storeButton.click();
    }
}
