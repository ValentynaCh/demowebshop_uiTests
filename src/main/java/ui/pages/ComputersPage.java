package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage extends BasePage {
    private final String pageTitleXpath = "//div[@class = 'page-title']";

    public ComputersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitleText() {
        System.out.println("Get Computers page title text");
        return driver.findElement(By.xpath(pageTitleXpath)).getText();
    }
}
