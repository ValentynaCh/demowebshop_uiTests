package ui.pages;

import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage {
    public HeaderSection header;

    public BooksPage(WebDriver webDriver) {
        super(webDriver);
        header = new HeaderSection(webDriver);
    }


}
