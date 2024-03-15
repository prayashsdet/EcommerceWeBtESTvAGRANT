package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Utils.DriverFactory;

/**
 * Represents the Skis Page of the UltraLesson website.
 * Provides methods to interact with the skis page, such as adding products to the cart.
 */
public class SkisPageActions {
    private final WebDriver driver;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cart-notification-button']")
    private WebElement viewCartButton;
    
    @FindBy(xpath = "//button[@name='add']")
    private WebElement soldOutMessage;

    /**
     * Constructs a new SkisPage object.
     * @param driver The WebDriver instance.
     */
    public SkisPageActions(WebDriver driver) {
        this.driver = driver;;
        PageFactory.initElements(driver, this);
    }

    /**
     * Adds the displayed product to the shopping cart.
     * Clicks on the 'Add to Cart' button for the displayed product.
     */
    public synchronized void addToCart() {
        addToCartButton.click();
    }

    /**
     * Navigates to the cart page by clicking on the View Cart button.
     * @return An instance of CartPage representing the cart page.
     */
    public synchronized void viewCart() {
        viewCartButton.click();
    }
    
    /**
     * Checks if the product is available for purchase.
     * @return WebElement representing the sold out message if the product is unavailable, null otherwise.
     */
    public synchronized WebElement isProductAvailable() {
        return soldOutMessage;
    }
}