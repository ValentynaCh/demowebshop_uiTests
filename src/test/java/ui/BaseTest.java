package ui;

import ui.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ui.utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;


    @BeforeTest(alwaysRun = true)
    public void setUp() {
        ConfigReader configReader = ConfigReader.getInstance();
        driver = new DriverManager().createDriver(configReader.getBrowserName());
        driver.get(configReader.getBaseUrl());
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
