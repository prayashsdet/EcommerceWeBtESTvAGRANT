package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the UltraLesson Home Page.
 * This class provides methods to interact with the home page, such as navigating to the store.
 */
public class UltraLessonHomePageActions {
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(UltraLessonHomePageActions.class);

    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement storeButton;

    /**
     * Constructs a new UltraLessonHomePage object.
     * Initializes the WebDriver instance and initializes page elements using PageFactory.
     */
    public UltraLessonHomePageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the store page.
     * Clicks on the store button to navigate to the store page.
     */
    public void clickOnStorePageLink() {
        storeButton.click();
        logger.info("Clicked on the store button to navigate to the store page.");
    }
}
