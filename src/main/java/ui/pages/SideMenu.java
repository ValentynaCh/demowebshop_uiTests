package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.enums.HeaderMenuItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SideMenu extends BasePage {
    private final String activeItemXpath = "//ul[@class='list']/li[@class='active']/a";
    private final String sideMenuXpath = "//div[@class = 'block block-category-navigation']//ul[@class = 'list']/li";

    private final String templateItemButtonByTagTextXpath = "//ul[@class= 'list']//*[contains(text(), '%s')]";
    private final String templateSubCategoryButtonByTagTextXpath = "//ul[@class= 'sublist']//*[contains(text(), '%s')]";
    private final String sublistXpath = "//ul[@class='sublist']/li";


    public SideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getActiveSidebarItemText() {
        System.out.println("Get active item from the side bar - " + driver.findElement(By.xpath(activeItemXpath)).getText());
        return driver.findElement(By.xpath(activeItemXpath)).getText();
    }

    public List<String> getAllElementsFromSideMenu() {
        System.out.println("Get all categories from SideMenu");
        List<WebElement> elementsList = driver.findElements(By.xpath(sideMenuXpath));
        List<String> itemNamesList = new ArrayList<>();
        elementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        System.out.println("The next list has been created - " + itemNamesList);
        return itemNamesList;
    }

    public void clickOnRandomMenuItem(List<String> itemNamesList) {
        System.out.printf("Choose random menu item name %n");
        Random random = new Random();
        int randomIndex = random.nextInt(itemNamesList.size());
        String randomMenuItem = itemNamesList.get(randomIndex);
        System.out.printf("Click random menu item - %s%n", randomMenuItem);
        driver.findElement(By.xpath(String.format(templateItemButtonByTagTextXpath,
                HeaderMenuItems.getTagNameByTextItem(randomMenuItem).getItemTagTextName()))).click();
    }

    public List<String> getAllSubElementsFromCategory() {
        System.out.println("Get all subcategories from Category");
        List<WebElement> subElementsList = driver.findElements(By.xpath(sublistXpath));
        List<String> itemNamesList = new ArrayList<>();
        subElementsList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        System.out.println("The next sublist has been created - " + itemNamesList);
        return itemNamesList;
    }

    public void clickOnRandomSubCategoryItem(List<String> itemNamesList) {
        System.out.printf("Choose random sub category item name %n");
        Random random = new Random();
        int randomIndex = random.nextInt(itemNamesList.size());
        String randomMenuItem = itemNamesList.get(randomIndex);
        System.out.printf("Click random sub category item - %s %n", randomMenuItem);
        driver.findElement(By.xpath(String.format(templateSubCategoryButtonByTagTextXpath, randomMenuItem))).click();
        //HeaderMenuItems.getTagNameByTextItem(randomMenuItem).getSubcategories())))
    }

}
