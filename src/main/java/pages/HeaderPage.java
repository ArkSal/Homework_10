package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    @FindBy(css = ".nav-link")
    private WebElement basicMenuIcon;

    @FindBy(css = ".navbar-nav>:nth-of-type(2)")
    private WebElement interactionsMenuIcon;

    @FindBy(css = ".navbar-nav>:nth-of-type(3)")
    private WebElement widgetsMenuIcon;

    @FindBy(css = ".navbar-nav>:nth-of-type(4)")
    private WebElement othersMenuIcon;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderPage clickBasicMenuIcon() {
        actions.moveToElement(basicMenuIcon).build().perform();
        return this;
    }

    public HeaderPage goToFormPage() {
        driver.findElement(By.cssSelector("#form-item")).click();
        return this;
    }


}
