package pomclasses;

import org.openqa.selenium.By.ByLinkText;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page Object Model class representing the Cart Page.
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
     * Get the name of the product.
     * @return Name of the product
     */
    public String getProductName() {
        return productName.getText();
    }

    /**
     * Get the size of the product.
     * @return Size of the product
     */
    public String getProductSize() {
        return productSize.getText();
    }

    /**
     * Get the quantity of the product.
     * @return Quantity of the product
     */
    public String getProductQuantity() {
        return productQuantity.getDomAttribute("value");
    }

    /**
     * Get the price of the product.
     * @return Price of the product
     */
    public String getProductPrice() {
        return productPrice.getText();
    }

    /**
     * Get the total price of the products in the cart.
     * @return Total price of the products in the cart
     */
    public String getTotalPrice() {
        return totalPrice.getText();
    }

    /**
     * Remove a product from the cart.
     */
    public void removeProductFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();
    }

    /**
     * Verify if the cart is empty.
     */
    public void verifyCartIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        boolean isEmpty = emptyCartMessage.isDisplayed();
        Assert.assertTrue(isEmpty, "Cart is not empty after product removal");
    }
}
