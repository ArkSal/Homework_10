package handlers;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getDriverOptions(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
        }
        return null;
    }

    public static void getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
        }
    }

    private static WebDriver getChromeDriver() {
        Map<String, Object> prefs = new HashMap<>() {{
            put("download.default_directory", FileHandler.getDownloadFile().getAbsolutePath());
        }};
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.dir", FileHandler.getDownloadFile().getAbsolutePath());
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/x-pdf,application/octet-stream");
        return new FirefoxDriver(option);
    }

}
