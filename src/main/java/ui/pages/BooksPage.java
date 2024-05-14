package ui.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class BooksPage extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(BooksPage.class);
    private final String pageTitleXpath = "//div[@class = 'page-title']";

    public BooksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitleText() {
        logger.info("Get Books page title text");
        return driver.findElement(By.xpath(pageTitleXpath)).getText();
    }
}
