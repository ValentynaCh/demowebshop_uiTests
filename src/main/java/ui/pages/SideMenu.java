package ui.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import ui.enums.HeaderMenuItems;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SideMenu extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(SideMenu.class);
    private final String activeItemXpath = "//ul[@class='list']/li[@class='active']/a";
    private final String sideMenuXpath = "//div[@class = 'block block-category-navigation']//ul[@class = 'list']/li";

    private final String templateItemButtonByTagTextXpath = "//ul[@class= 'list']//*[contains(text(), '%s')]";
    private final String templateSubCategoryButtonByTagTextXpath = "//ul[@class= 'sublist']//*[contains(text(), '%s')]";
    private final String sublistXpath = "//ul[@class='sublist']/li";


    public SideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getActiveSidebarItemText() {
        logger.info("Get active item from the side bar - {}", driver.findElement(By.xpath(activeItemXpath)).getText());
        return driver.findElement(By.xpath(activeItemXpath)).getText();
    }

    public List<String> getAllElementsFromSideMenu() {
        logger.info("Get all categories from SideMenu");
        List<WebElement> elementsList = driver.findElements(By.xpath(sideMenuXpath));
        List<String> itemNamesList = new ArrayList<>();
        elementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        logger.info("The next list has been created - {}", itemNamesList);
        System.out.println();
        return itemNamesList;
    }

    public void clickOnRandomMenuItem(List<String> itemNamesList) {
        logger.info("Choose random menu item name");
        Random random = new Random();
        int randomIndex = random.nextInt(itemNamesList.size());
        String randomMenuItem = itemNamesList.get(randomIndex);
        logger.info("Click random menu item - {}", randomMenuItem);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement menuItem = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(String.format(templateItemButtonByTagTextXpath,
                        HeaderMenuItems.getTagNameByTextItem(randomMenuItem).getItemTagTextName()))));
        menuItem.click();
    }

    public List<String> getAllSubElementsFromCategory() {
        logger.info("Get all subcategories from Category");
        List<WebElement> subElementsList = driver.findElements(By.xpath(sublistXpath));
        List<String> itemNamesList = new ArrayList<>();
        subElementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        logger.info("The next sublist has been created - {}", itemNamesList);
        return itemNamesList;
    }

    public void clickOnRandomSubCategoryItem(List<String> itemNamesList) {
        logger.info("Choose random sub category item name");
        Random random = new Random();
        int randomIndex = random.nextInt(itemNamesList.size());
        String randomMenuItem = itemNamesList.get(randomIndex);
        logger.info("Click random sub category item - {}", randomMenuItem);
        driver.findElement(By.xpath(String.format(templateSubCategoryButtonByTagTextXpath, randomMenuItem))).click();
    }

    public void clickOnRandomSubCategoryItemIfExist(List<String> itemNamesList){

        if (getAllSubElementsFromCategory().isEmpty()) {
            logger.info("There is no sub categories in category");
        } else {
            clickOnRandomSubCategoryItem(getAllSubElementsFromCategory());
        }
    }
}
