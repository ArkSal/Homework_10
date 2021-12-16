package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.actions = new Actions(driver);
        this.driver = driver;
    }
}
