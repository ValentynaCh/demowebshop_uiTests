package ui.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.utils.LoggerUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogListener implements ITestListener {
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(LogListener.class);
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        LogListener.driver = driver;
    }

    private static final Path screenshotsPath = Paths.get("src", "main", "resources", "testsScreenshots");


    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger logger = LoggerFactory.getLogger(result.getInstance().getClass());
        String testName = getTestName(result);
        logger.info(testName + " : Test Passed");
        takeScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable t = result.getThrowable();
        String cause = "";
        if (t != null)
            cause = t.getMessage();
        LoggerUtil.getLogger().error(getTestName(result) + " : Test Failed : " + cause);
        takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger logger = LoggerFactory.getLogger(result.getInstance().getClass());
        logger.info(getTestName(result) + " : Test Skipped");
        takeScreenshot(result);
    }

    public void takeScreenshot(ITestResult result) {
        Logger logger = LoggerFactory.getLogger(result.getInstance().getClass());
        String testName = getTestName(result);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = testName + "_" + System.currentTimeMillis() + ".png";
        File destFolder = screenshotsPath.resolve(testName).toFile();
        destFolder.mkdirs();
        File destFile = new File(destFolder, fileName);
        try {
            FileUtils.copyFile(screenshotFile, destFile);
            logger.info("Screenshot saved successfully at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getMessage());
        }
    }
}
