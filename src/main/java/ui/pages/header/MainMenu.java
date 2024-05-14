package ui.pages.header;

import ch.qos.logback.classic.Logger;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import ui.enums.HeaderMenuItems;
import ui.pages.BasePage;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(MainMenu.class);
    private final String templateOfItemButtonByNameXpath = "//a[@href = '/%s']";
    private final String mainMenuXpath = "//ul[@class = 'top-menu']/li";
    private final String templateItemButtonByTagTextXpath = "//ul[@class= 'top-menu']//*[contains(text(), '%s')]";

    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @SneakyThrows
    public <T> T clickOnMenuItemByName(String name, Class<T> clazz) {
        logger.info("Click on Header item by {} name and return a page object", name);
        driver.findElement(By.xpath(String.format(templateOfItemButtonByNameXpath, name))).click();
        Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
    }

    public void clickOnMenuItemByName(String name) {
        logger.info("Click on Header item by {}", name);
        driver.findElement(By.xpath(String.format(templateItemButtonByTagTextXpath, HeaderMenuItems.getTagNameByTextItem(name).getItemTagTextName()))).click();
    }

    public List<String> getAllElementsFromMenuHeader() {
        logger.info("Get all elements from Header");
        List<WebElement> elementsList = driver.findElements(By.xpath(mainMenuXpath));
        List<String> itemNamesList = new ArrayList<>();
        elementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        logger.info("The next list has been created - {}", itemNamesList);
        return itemNamesList;
    }
}
