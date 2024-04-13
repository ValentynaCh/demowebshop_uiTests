package ui.pages;

import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public HeaderSection header;

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(webDriver);
    }

}




