package pomclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page Object Model representing the Cart Page.
 * This class provides methods to interact with the Cart page, such as adding/removing products and verifying cart status.
 */
public class CartPage {
    public WebDriver driver;

    @FindBy(xpath = "//a[@class='cart-item__name h4 break']")
    public WebElement productName;

    @FindBy(xpath = "//dd[normalize-space()='163cm']")
    private WebElement productSize;

    @FindBy(xpath = "//input[@id='Quantity-1']")
    public WebElement productQuantity;

    @FindBy(xpath = "//td[@class='cart-item__totals right small-hide']//span[@class='price price--end'][normalize-space()='Rs. 599.00']")
    private WebElement productPrice;

    @FindBy(xpath = "//p[@class='totals__subtotal-value']")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[@name='minus']")
    public WebElement removeButton;

    @FindBy(xpath = "//h1[normalize-space()='Your cart is empty']")
    public WebElement emptyCartMessage;

    /**
     * Constructor for the CartPage class.
     * @param driver WebDriver instance
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the name of the product in the cart.
     * @return Name of the product
     */
    public String getProductName() {
        return productName.getText();
    }

    /**
     * Retrieves the size of the product in the cart.
     * @return Size of the product
     */
    public String getProductSize() {
        return productSize.getText();
    }

    /**
     * Retrieves the quantity of the product in the cart.
     * @return Quantity of the product
     */
    public String getProductQuantity() {
        return productQuantity.getDomAttribute("value");
    }

    /**
     * Retrieves the price of the product in the cart.
     * @return Price of the product
     */
    public String getProductPrice() {
        return productPrice.getText();
    }

    /**
     * Retrieves the total price of the products in the cart.
     * @return Total price of the products in the cart
     */
    public String getTotalPrice() {
        return totalPrice.getText();
    }

    /**
     * Removes a product from the cart.
     * Clicks the remove button to remove the product from the cart.
     */
    public void removeProductFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();
    }

    /**
     * Verifies if the cart is empty.
     * Waits for the empty cart message to appear and asserts that it is displayed.
     */
    public void verifyCartIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        boolean isEmpty = emptyCartMessage.isDisplayed();
        Assert.assertTrue(isEmpty, "Cart is not empty after product removal");
    }
}
