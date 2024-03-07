package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model representing the Skis Page.
 * This class provides methods to interact with the Skis page, such as adding a product to the cart.
 */
public class SkisPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@name='add']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cart-notification-button']")
    public WebElement viewCartButton;
    
    @FindBy(xpath = "//button[@name='add']")
    private WebElement soldOutMessage;

    /**
     * Constructor for the SkisPage class.
     * @param driver WebDriver instance
     */
    public SkisPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Adds the selected product to the shopping cart by clicking the 'Add to Cart' button.
     */
 
    public void addToCart() {
        addToCartButton.click();
    }

    /**
     * Clicks the view cart button to navigate to the cart page.
     */
    public void viewCart() {
        viewCartButton.click();
    }
    
    /**
     * Checks if the product is available.
     * @return WebElement representing the sold out message if the product is unavailable, null otherwise
     */
    public WebElement isProductAvailable() {
        return soldOutMessage;
    }
}
