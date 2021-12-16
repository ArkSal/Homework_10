package models;

import handlers.DriverFactory;
import handlers.FileHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.ConfigProvider;

import java.time.Duration;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeAll
    static void setDriver() {
        DriverFactory.getDriver(Browsers.valueOf(ConfigProvider.getConfig().getBrowser()));
        logger.info("WebDriver initialized");
        FileHandler.createDirectory();
        logger.info("Download files directories created");
    }

    @BeforeEach
    void setUp() {
        driver = DriverFactory.getDriverOptions(Browsers.valueOf(ConfigProvider.getConfig().getBrowser()));
        logger.info("Driver initialized with additional options");
        actions = new Actions(driver);
        logger.info("Action initialized");
        int waitValue = Integer.parseInt(ConfigProvider.getConfig().getWait());
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitValue));
        driver.get(ConfigProvider.getConfig().getUlr());
        logger.info("WaitDriver with " + waitValue + "secs value initialized");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Driver quit done properly");
    }
}