package handlers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    private static Logger logger = LoggerFactory.getLogger(FileHandler.class);
    private final static String downloadFileDirectory = "/resources/downloadedTestFiles";
    private final static String projectPath = System.getProperty("user.dir");
    private final static String screenShotDirectory = "/resources/screenshotDirectory";

    public static String fileToLoadPath() {
        return projectPath + "/resources/filesToLoad/File.txt";
    }

    public static void createDirectory() {
        try {
            Files.createDirectories(Paths.get(projectPath + downloadFileDirectory));
            Files.createDirectories(Paths.get(projectPath + screenShotDirectory));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Created download & screenshot directory");
    }

    public static File getDownloadFile() {
        return new File(projectPath + downloadFileDirectory);
    }

    public static int getFilesQuantityFromDownloadDirectory() {
        int filesQuantityInDownloadDirectory = getDownloadFile().list().length;
        logger.info("Files in download directory: {}", filesQuantityInDownloadDirectory);
        return filesQuantityInDownloadDirectory;

    }

    public static boolean checkIfFileWithSpecificNameExist(String fileName) {
        File file = new File(getDownloadFile() + "/" + fileName + ".xlsx");
        logger.info("Validating if specific file exist in directory {}", file);
        if (file.exists()) {
            logger.info("File found in directory");
            return true;
        }
        logger.error("File not found in directory");
        return false;
    }

    public static void takeScreenshot(WebDriver driver) {
        //tak śrendio pdoobaq mi się ta metoda w tej klasie
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr, new File(projectPath + screenShotDirectory + "/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
