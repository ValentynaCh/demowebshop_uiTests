package ui.pages.header;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.enums.HeaderMenuPageTitle;
import ui.pages.BasePage;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends BasePage {
    private final String templateOfItemButtonByNameXpath = "//a[@href = '/%s']";
    private final String mainMenuXpath = "//ul[@class = 'top-menu']/li";
    private final String templateItemButtonByTagTextXpath = "//ul[@class= 'top-menu']//*[contains(text(), '%s')]";

    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @SneakyThrows
    public <T> T clickOnMenuItemByName(String name, Class<T> clazz) {
        System.out.printf("Click on Header item by {%s} name and return a page object%n", name);
        driver.findElement(By.xpath(String.format(templateOfItemButtonByNameXpath, name))).click();
        Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
    }

    public void clickOnMenuItemByName(String name) {
        System.out.printf("Click on Header item by {%s} %n", name);
        driver.findElement(By.xpath(String.format(templateItemButtonByTagTextXpath, HeaderMenuPageTitle.getTagNameByTextItem(name).getItemTagTextName()))).click();
    }

    public List<String> getAllElementsFromMenuHeader() {
        System.out.println("Get all elements from Header");
        List<WebElement> elementsList = driver.findElements(By.xpath(mainMenuXpath));
        List<String> itemNamesList = new ArrayList<>();
        elementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        System.out.println("The next list has been created - " + itemNamesList);
        return itemNamesList;
    }
}
