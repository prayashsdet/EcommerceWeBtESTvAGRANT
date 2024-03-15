package pomclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkisPageActions {
    private static final Logger logger = LogManager.getLogger(SkisPageActions.class);
    private final WebDriver driver;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cart-notification-button']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement soldOutMessage;

    /**
     * Constructs a new SkisPageActions object.
     * @param driver The WebDriver instance.
     */
    public SkisPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Adds the displayed product to the shopping cart.
     * Clicks on the 'Add to Cart' button for the displayed product.
     */
    public synchronized void addToCart() {
        logger.info("Adding product to cart");
        addToCartButton.click();
    }

    /**
     * Navigates to the cart page by clicking on the View Cart button.
     * @return An instance of CartPage representing the cart page.
     */
    public synchronized void viewCart() {
        logger.info("Viewing cart");
        viewCartButton.click();
    }

    /**
     * Checks if the product is available for purchase.
     * @return WebElement representing the sold out message if the product is unavailable, null otherwise.
     */
    public synchronized WebElement isProductAvailable() {
        logger.info("Checking product availability");
        return soldOutMessage;
    }
}
