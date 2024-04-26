package ui.pages.header;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TopRightMenu extends BasePage {

    private final String templateOfItemButtonByNameXpath = "//a[@href = '/%s']";

    public TopRightMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @SneakyThrows
    public <T> T clickOnTopMenuItemByName(String name, Class<T> clazz) {
        System.out.printf("Click on %s Header item by {%s} and return page object %n", name, name);
        driver.findElement(By.xpath(String.format(templateOfItemButtonByNameXpath, name))).click();
        Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
    }

}
