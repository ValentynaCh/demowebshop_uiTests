package ui;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ui.core.DriverManager;
import ui.listeners.LogListener;
import ui.utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
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
        WebDriver driver = new DriverManager().createDriver(configReader.getBrowserName());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        LogListener.setDriver(driver);
        driver.get(configReader.getBaseUrl());
        driverThreadLocal.set(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
