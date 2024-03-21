package ui.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public WebDriver createDriver(String browser) {
        return BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
    }
}
