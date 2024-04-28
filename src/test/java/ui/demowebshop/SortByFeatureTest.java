package ui.demowebshop;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.BaseTest;
import ui.pages.ProductSection;
import ui.pages.SideMenu;

public class SortByFeatureTest extends BaseTest {
    @Test(description = "This test verifies the Sort by feature - Name: A to Z, Name: Z to A")
    public void verifySortByTest() {
        SideMenu sideMenu = new SideMenu(driver);
        sideMenu.clickOnRandomMenuItem(sideMenu.getAllElementsFromSideMenu());
        sideMenu.clickOnRandomSubCategoryItemIfExist(sideMenu.getAllSubElementsFromCategory());

        ProductSection productSection = new ProductSection(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productSection.getTextFromSortByLabel(), "Sort by",
                "The Sort by label is not correct");

        productSection.selectNameAToZInSortByDropDown();
        softAssert.assertTrue(productSection.isProductsListSortedByASC(productSection.getAllProductsFromCategory()),
                "Products are not sorted properly in ascending order");

        productSection.selectNameZToAInSortByDropDown();
        softAssert.assertTrue(productSection.isProductsListSortedByDESC(productSection.getAllProductsFromCategory()),
                "Products are not sorted properly in descending order");

        softAssert.assertAll();

    }

}
