package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ui.core.DriverManager;
import ui.utils.ConfigReader;


public class BaseTest {
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setUp() {
        ConfigReader configReader = ConfigReader.getInstance();
        driver = new DriverManager().createDriver(configReader.getBrowserName());
        driver.get(configReader.getBaseUrl());
        driverThreadLocal.set(driver);

    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

}
