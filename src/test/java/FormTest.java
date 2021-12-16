import handlers.FileHandler;
import models.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;
import pages.HeaderPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(FormTest.class);
    FormPage formPage;
    HeaderPage headerPage;

    @Test
    void fillFormTest() {
        headerPage = new HeaderPage(driver);
        headerPage.clickBasicMenuIcon()
                .goToFormPage();

        formPage = new FormPage(driver);
        formPage.fillTheFormWithConstantData()
                .clickSignInButton();
        assertThat(formPage.getStringFromValidatorMessageField(), equalTo("Form send with success"));
        logger.info("Test completed");
    }

    @Test
    void downloadFileTest() {
        headerPage = new HeaderPage(driver);
        headerPage.clickBasicMenuIcon()
                .goToFormPage();

        formPage = new FormPage(driver);
        int filesQuantityBeforeDownload = FileHandler.getFilesQuantityFromDownloadDirectory();
        formPage.clickDownloadButton();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int filesQuantityAfterDownload = FileHandler.getFilesQuantityFromDownloadDirectory();
        assertEquals(filesQuantityBeforeDownload, filesQuantityAfterDownload - 1);
        logger.info("Test downloadFile completed");
    }

    @Test
    void validateDownloadedFileName() {
        FileHandler.getFilesQuantityFromDownloadDirectory();
        assertTrue(FileHandler.checkIfFileWithSpecificNameExist("test-file-to-download"));
        logger.info("Test validateDownloadedFileName completed");
    }
}
