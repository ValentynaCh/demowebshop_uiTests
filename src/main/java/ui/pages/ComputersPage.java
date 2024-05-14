package ui.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class ComputersPage extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ComputersPage.class);
    private final String pageTitleXpath = "//div[@class = 'page-title']";

    public ComputersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitleText() {
        logger.info("Test are running from " + Thread.currentThread().getName());
        logger.info("Get Computers page title text");
        return driver.findElement(By.xpath(pageTitleXpath)).getText();
    }
}
