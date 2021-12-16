package pages;

import models.configuration.EnvironmentConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import providers.ConfigProvider;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected EnvironmentConfig environmentConfig;

    public BasePage(WebDriver driver) {
        this.actions = new Actions(driver);
        this.driver = driver;
        environmentConfig = ConfigProvider.getConfig();
    }
}
