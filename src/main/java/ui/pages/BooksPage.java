package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage {
    private final String pageTitleXpath = "//div[@class = 'page-title']";

    public BooksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitleText() {
        System.out.printf("Get Books page title text%n");
        return driver.findElement(By.xpath(pageTitleXpath)).getText();
    }
}
