package ui.demowebshop;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.BaseTest;
import ui.enums.SortByItems;
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
        softAssert.assertTrue(productSection.isProductsListSorted(productSection.getAllProductsFromCategory(),
                SortByItems.NAME_A_TO_Z));

        productSection.selectNameZToAInSortByDropDown();
        softAssert.assertTrue(productSection.isProductsListSorted(productSection.getAllProductsFromCategory(),
                SortByItems.NAME_Z_TO_A));

        softAssert.assertAll();

    }
}
