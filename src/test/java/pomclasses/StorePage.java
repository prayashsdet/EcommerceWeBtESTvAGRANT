package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='5 Pocket Jean']")
    private WebElement tiSkisLink;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SkisPage selectTiSkis() {
        tiSkisLink.click();
        return new SkisPage(driver);
    }
}

