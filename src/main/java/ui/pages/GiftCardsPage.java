package ui.pages;

import org.openqa.selenium.WebDriver;

public class GiftCardsPage extends BasePage {
    public HeaderSection header;

    public GiftCardsPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(webDriver);
    }


}