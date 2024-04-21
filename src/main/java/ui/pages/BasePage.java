package ui.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
}
