package ui.pages.header;

import ch.qos.logback.classic.Logger;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import ui.pages.BasePage;

import java.lang.reflect.Constructor;

public class TopRightMenu extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TopRightMenu.class);

    private final String templateOfItemButtonByNameXpath = "//a[@href = '/%s']";

    public TopRightMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @SneakyThrows
    public <T> T clickOnTopMenuItemByName(String name, Class<T> clazz) {
        logger.info("Click on {} Header item by {} and return page object", name, name);
        driver.findElement(By.xpath(String.format(templateOfItemButtonByNameXpath, name))).click();
        Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
    }

}
