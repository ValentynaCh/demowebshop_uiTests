package ui;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import ui.core.DriverManager;
import ui.listeners.LogListener;
import ui.pages.SideMenu;
import ui.utils.ConfigReader;
import ui.utils.LoggerUtil;

@Listeners (LogListener.class)
public class BaseTest {
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static WebDriver driver;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(BaseTest.class);

    @AfterSuite(alwaysRun = true)
    public void printReport(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        logger.info("Total number of testcases : " + total);
        logger.info("Number of testcases Passed : " + passed);
        logger.info("Number of testcases Failed : " + failed);
        logger.info("Number of testcases Skipped  : " + skipped);
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        ConfigReader configReader = ConfigReader.getInstance();
        driver = new DriverManager().createDriver(configReader.getBrowserName());
        LogListener.setDriver(driver);
        driver.get(configReader.getBaseUrl());
        driverThreadLocal.set(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(ITestContext context) {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
