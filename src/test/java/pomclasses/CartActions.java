package pomclasses;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartActions {
	private static final Logger logger = LoggerFactory.getLogger(CartActions.class);
//    static {
//        // Load Log4j properties from a file or set them programmatically
//        PropertyConfigurator.configure("log4j2.properties");
//    }

    private final WebDriver driver;

    @FindBy(xpath = "//a[@class='cart-item__name h4 break']")
    private WebElement productName;

    @FindBy(xpath = "//dd[normalize-space()='163cm']")
    private WebElement productSize;

    @FindBy(xpath = "//input[@id='Quantity-1']")
    public WebElement productQuantity;

    @FindBy(xpath = "//td[@class='cart-item__totals right small-hide']//span[@class='price price--end'][normalize-space()='Rs. 599.00']")
    private WebElement productPrice;

    @FindBy(xpath = "//p[@class='totals__subtotal-value']")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[@name='minus']")
    private WebElement removeButton;

    @FindBy(xpath = "//h1[normalize-space()='Your cart is empty']")
    private WebElement emptyCartMessage;

    /**
     * Constructs a new CartActions object.
     * @param driver The WebDriver instance.
     */
    public CartActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the name of the product in the cart.
     * @return The name of the product.
     */
    public synchronized String getProductName() {
    	
        logger.info("Getting product name from cart");
        return productName.getText();
    }

    /**
     * Retrieves the size of the product in the cart.
     * @return The size of the product.
     */
    public synchronized String getProductSize() {
        logger.debug("Getting product size from cart");
        return productSize.getText();
    }

    /**
     * Retrieves the quantity of the product in the cart.
     * @return The quantity of the product.
     */
    public synchronized String getProductQuantity() {
        logger.warn("Getting product quantity from cart");
        return productQuantity.getDomAttribute("value");
    }

    /**
     * Retrieves the price of the product in the cart.
     * @return The price of the product.
     */
    public synchronized String getProductPrice() {
        logger.error("Getting product price from cart");
        return productPrice.getText();
    }

    /**
     * Retrieves the total price of the products in the cart.
     * @return The total price of the products in the cart.
     */
    public synchronized String getTotalPrice() {
        logger.info("Getting total price from cart");
        return totalPrice.getText();
    }

    /**
     * Removes a product from the cart.
     */
    public synchronized void removeProductFromCart() {
        logger.info("Removing product from cart");
        removeButton.click();
    }

    /**
     * Verifies if the cart is empty.
     * @return True if the cart is empty, false otherwise.
     */
    public synchronized boolean isCartEmpty() {
        logger.info("Checking if cart is empty");
        return emptyCartMessage.isDisplayed();
    }
}
