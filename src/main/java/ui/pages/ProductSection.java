package ui.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import ui.enums.SortByItems;
import ui.utils.SortedListComparator;

import java.util.ArrayList;
import java.util.List;

public class ProductSection extends BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductSection.class);
    private final String sortByLabelXpath = "//div[@class = 'product-sorting']/span";
    private final String sortByDropDownXpath = "//div[@class = 'product-sorting']//select[@id = 'products-orderby']";
    private final String productItemsXpath = "//div[@class = 'product-grid']//h2[@class = 'product-title']";
    private final String templateSortByByTagTextXpath = "//select[@id = 'products-orderby']//*[contains(text(), '%s')]";

    public ProductSection(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextFromSortByLabel() {
        logger.info("Get a text from the Sort by label");
        return driver.findElement(By.xpath(sortByLabelXpath)).getText();
    }

    public List<String> getAllProductsFromCategory() {
        logger.info("Get all products of selected category");
        List<WebElement> productList = driver.findElements(By.xpath(productItemsXpath));
        List<String> itemNamesList = new ArrayList<>();
        productList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        logger.info("The next product list has been created - {}", itemNamesList);
        return itemNamesList;
    }

    public void selectNameAToZInSortByDropDown() {
        logger.info("Click the Sort By dropdown list");
        driver.findElement(By.xpath(sortByDropDownXpath)).click();
        logger.info("Select the Name A to Z Sort By dropdown item");
        driver.findElement(By.xpath(String.format(templateSortByByTagTextXpath,
                SortByItems.NAME_A_TO_Z.getItemTagTextName()))).click();
    }

    public void selectNameZToAInSortByDropDown() {
        logger.info("Click the Sort By dropdown list");
        driver.findElement(By.xpath(sortByDropDownXpath)).click();
        logger.info("Select the Name Z to A Sort By dropdown item");
        driver.findElement(By.xpath(String.format(templateSortByByTagTextXpath,
                SortByItems.NAME_Z_TO_A.getItemTagTextName()))).click();
    }

    public boolean isProductsListSortedByASC(List<String> actualSortedList) {
        logger.info("Check whether the list is sorted properly by {}",
                SortedListComparator.SortOrder.ASCENDING);
        SortedListComparator ascendingComparator = new SortedListComparator(SortedListComparator.SortOrder.ASCENDING);
        logger.info("Here is a sorted list by website - {}", actualSortedList);
        List<String> sortedListCopy = new ArrayList<>(actualSortedList);
        sortedListCopy.sort(ascendingComparator);
        logger.info("Here is a ASC sorted list by comparator - {}", actualSortedList);
        return actualSortedList.equals(sortedListCopy);
    }

    public boolean isProductsListSortedByDESC(List<String> actualSortedList) {
        logger.info("Check whether the list is sorted properly by {}",
                SortedListComparator.SortOrder.DESCENDING);
        SortedListComparator descendingComparator = new SortedListComparator(SortedListComparator.SortOrder.DESCENDING);
        logger.info("Here is a sorted list by website - {}", actualSortedList);
        List<String> sortedListCopy = new ArrayList<>(actualSortedList);
        sortedListCopy.sort(descendingComparator);
        logger.info("Here is a DESC sorted list by comparator - {}", actualSortedList);
        return actualSortedList.equals(sortedListCopy);
    }


}
