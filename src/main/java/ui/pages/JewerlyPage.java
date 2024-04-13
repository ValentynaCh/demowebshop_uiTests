package ui.pages;

import org.openqa.selenium.WebDriver;

public class JewerlyPage extends BasePage{
    public HeaderSection header;
    public JewerlyPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(driver);
    }
}
