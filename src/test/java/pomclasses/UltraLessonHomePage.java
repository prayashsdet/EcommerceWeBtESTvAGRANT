package pomclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UltraLessonHomePage {
	private WebDriver driver;

    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement storeButton;

    public UltraLessonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StorePage navigateToStore() {
        storeButton.click();
        return new StorePage(driver);
    }
}

