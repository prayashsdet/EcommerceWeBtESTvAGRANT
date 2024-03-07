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

public class CartPage {
    public WebDriver driver;

    @FindBy(xpath = "//a[@class='cart-item__name h4 break']")
    public  WebElement productName;

    @FindBy(xpath = "//dd[normalize-space()='163cm']")
    private  WebElement productSize;

    @FindBy(xpath = "//input[@id='Quantity-1']")
    public  WebElement productQuantity;

    @FindBy(xpath = "//td[@class='cart-item__totals right small-hide']//span[@class='price price--end'][normalize-space()='Rs. 599.00']")
    private  WebElement productPrice;

    @FindBy(xpath = "//p[@class='totals__subtotal-value']")
    private  WebElement totalPrice;
    
    
    
    
    
    
    @FindBy(xpath = "//button[@name='minus']")
    public WebElement removeButton;

    @FindBy(xpath = "//h1[normalize-space()='Your cart is empty']")
    public WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  String getProductName() {
        return productName.getText();
    }

  

	public  String getProductSize() {
        return productSize.getText();
    }

    public  String getProductQuantity() {
    	
  return  productQuantity.getDomAttribute("value");
//         String quantityValue = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].value;", productQuantity);
//         return quantityValue;
    }
    public  String getProductPrice() {
        return productPrice.getText();
    }

    public  String getTotalPrice() {
        return totalPrice.getText();
        
        
    }
    
    
    
    public void removeProductFromCart() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
          wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();
        // Optionally, wait for the cart to update after removal
        // You may need to wait for some time or for specific elements to appear indicating an empty cart
    }

    public void verifyCartIsEmpty() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        boolean isEmpty = emptyCartMessage.isDisplayed();
        Assert.assertTrue(isEmpty, "Cart is not empty after product removal");
    }
}
