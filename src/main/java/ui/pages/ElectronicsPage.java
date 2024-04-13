package ui.pages;

import org.openqa.selenium.WebDriver;

public class ElectronicsPage extends BasePage {
    public HeaderSection header;
    public ElectronicsPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(driver);
    }
}
