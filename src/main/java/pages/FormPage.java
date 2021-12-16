package pages;

import handlers.FileHandler;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomDataGenerator;

import java.util.List;

public class FormPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(FormPage.class);

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameTextField;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameTextField;

    @FindBy(css = "#inputEmail3")
    private WebElement emailTextField;

    @FindBy(css = "[name=gridRadiosSex]")
    private List<WebElement> sexRadioButtons;

    @FindBy(css = "#inputAge3")
    private WebElement ageTextField;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> yearOfExperienceRadioButtons;

    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> professionCheckBoxes;

    @FindBy(css = "#selectContinents>*")
    private List<WebElement> continentsSelectField;

    @FindBy(css = "#selectSeleniumCommands>*")
    private List<WebElement> seleniumCommandsSelect;

    @FindBy(css = "#chooseFile")
    private WebElement fileLoadField;

    @FindBy(css = ".btn-secondary")
    private WebElement testFileToDownloadButton;

    @FindBy(css = ".btn-primary")
    private WebElement signInButton;

    @FindBy(css = "#validator-message")
    private WebElement validatorMessageField;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FormPage fillTheFormWithConstantData() {
        firstNameTextField.sendKeys(environmentConfig.getFirstName());
        lastNameTextField.sendKeys(environmentConfig.getLastName());
        emailTextField.sendKeys("mistrz@gmail.com");
        sexRadioButtons.get(RandomDataGenerator.randomFunction(2)).click();
        ageTextField.sendKeys(String.valueOf(RandomDataGenerator.randomFunction(18, 50)));
        yearOfExperienceRadioButtons.get(RandomDataGenerator.randomFunction(0, 6)).click();
        professionCheckBoxes.get(1).click();
        continentsSelectField.get(RandomDataGenerator.randomFunction(1, continentsSelectField.size() - 1)).click();
        seleniumCommandsSelect.get(1).click();
        actions.keyDown(Keys.LEFT_CONTROL).build().perform();
        seleniumCommandsSelect.get(2).click();
        actions.release().build().perform();
        fileLoadField.sendKeys(FileHandler.fileToLoadPath());
        logger.info("Form filled with constants values");
        return this;
    }

    public FormPage clickSignInButton() {
        signInButton.submit();
        logger.info("Sign in button clicked");
        return this;
    }

    public String getStringFromValidatorMessageField() {
        return validatorMessageField.getText();
    }

    public FormPage clickDownloadButton() {
        testFileToDownloadButton.click();
        logger.info("Download button clicked");
        return this;
    }
}
