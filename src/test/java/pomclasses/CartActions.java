package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Utils.DriverFactory;

/**
 * Represents the Cart Page of the UltraLesson website.
 * Provides methods to interact with the cart page, such as removing products and verifying cart status.
 */
public class CartActions {
    private  final WebDriver driver;

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
     * Constructs a new CartPage object.
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
    public  synchronized String getProductName() {
        return productName.getText();
    }

    /**
     * Retrieves the size of the product in the cart.
     * @return The size of the product.
     */
    public synchronized String getProductSize() {
        return productSize.getText();
    }

    /**
     * Retrieves the quantity of the product in the cart.
     * @return The quantity of the product.
     */
    public synchronized  String getProductQuantity() {
        return productQuantity.getDomAttribute("value");
    }

    /**
     * Retrieves the price of the product in the cart.
     * @return The price of the product.
     */
    public synchronized String getProductPrice() {
        return productPrice.getText();
    }

    /**
     * Retrieves the total price of the products in the cart.
     * @return The total price of the products in the cart.
     */
    public synchronized String getTotalPrice() {
        return totalPrice.getText();
    }

    /**
     * Removes a product from the cart.
     */
    public synchronized  void removeProductFromCart() {
        removeButton.click();
    }

    /**
     * Verifies if the cart is empty.
     * @return True if the cart is empty, false otherwise.
     */
    public synchronized boolean isCartEmpty() {
        return emptyCartMessage.isDisplayed();
    }
}