package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkisPage {
	private WebDriver driver;

    @FindBy(xpath = "//button[@name='add']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cart-notification-button']")
    private WebElement viewCartButton;
    
    @FindBy(xpath = "//button[@name='add']")
    private WebElement soldOutMessage;

    public SkisPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void viewCart() {
        viewCartButton.click();
    }
    public WebElement isProductAvailable() {
    	
        return soldOutMessage;
    }
}

