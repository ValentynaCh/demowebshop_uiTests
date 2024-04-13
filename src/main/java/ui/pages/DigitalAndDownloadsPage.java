package ui.pages;

import org.openqa.selenium.WebDriver;

public class DigitalAndDownloadsPage extends BasePage {
    public HeaderSection header;
    public DigitalAndDownloadsPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(driver);
    }
}
