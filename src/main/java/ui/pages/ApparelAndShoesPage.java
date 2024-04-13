package ui.pages;

import org.openqa.selenium.WebDriver;

public class ApparelAndShoesPage extends BasePage{
    public HeaderSection header;
    public ApparelAndShoesPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(driver);
    }
}
