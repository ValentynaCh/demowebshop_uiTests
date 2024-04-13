package ui.pages;

import org.openqa.selenium.WebDriver;

public class ComputersPage extends BasePage {
    public HeaderSection header;
    public ComputersPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(driver);
    }
}
