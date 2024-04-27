package ui.pages;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.enums.SortByItems;
import ui.utils.SortedListComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSection extends BasePage {
    private final String sortByLabelXpath = "//div[@class = 'product-sorting']/span";
    private final String sortByDropDownXpath = "//div[@class = 'product-sorting']//select[@id = 'products-orderby']";
    private final String productItemsXpath = "//div[@class = 'product-grid']//h2[@class = 'product-title']";
    private final String templateSortByByTagTextXpath = "//select[@id = 'products-orderby']//*[contains(text(), '%s')]";

    public ProductSection(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextFromSortByLabel() {
        System.out.println("Get a text from the Sort by label");
        return driver.findElement(By.xpath(sortByLabelXpath)).getText();
    }

    public List<String> getAllProductsFromCategory() {
        System.out.println("Get all products of selected category");
        List<WebElement> productList = driver.findElements(By.xpath(productItemsXpath));
        List<String> itemNamesList = new ArrayList<>();
        productList.stream()
                .forEach(item -> {
                    itemNamesList.add(item.getText());
                });
        System.out.println("The next product list has been created - " + itemNamesList);
        return itemNamesList;
    }

    public void selectNameAToZInSortByDropDown() {
        System.out.println("Click the Sort By dropdown list");
        driver.findElement(By.xpath(sortByDropDownXpath)).click();
        System.out.println("Select the Name A to Z Sort By dropdown item");
        driver.findElement(By.xpath(String.format(templateSortByByTagTextXpath,
                SortByItems.NAME_A_TO_Z.getItemTagTextName()))).click();
    }

    public void selectNameZToAInSortByDropDown() {
        System.out.println("Click the Sort By dropdown list");
        driver.findElement(By.xpath(sortByDropDownXpath)).click();
        System.out.println("Select the Name Z to A Sort By dropdown item");
        driver.findElement(By.xpath(String.format(templateSortByByTagTextXpath,
                SortByItems.NAME_Z_TO_A.getItemTagTextName()))).click();
    }

    public boolean isProductsListSorted(List<String> actualSortedList, SortByItems order){
        System.out.printf("Check whether the list is sorted properly by %s%n", order);
        SortedListComparator comparator = new SortedListComparator(order);
        List<String> listToBeSorted = new ArrayList<>(actualSortedList);
        return comparator.compare(actualSortedList, listToBeSorted) == 0;
    }

}
