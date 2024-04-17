package ui.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenu;
import ui.pages.*;

public class BooksPageTest extends BaseTest {
    @Test(description = "This test verifies pages title")
    public void verifyTitleTest() {
        HeaderSection headerSection = new HeaderSection(driver);
        Assert.assertEquals(headerSection.clickBooks(), HeaderMenu.BOOKS.getHeaderName(),String.format("Title of the %s page is not correct", HeaderMenu.BOOKS.getHeaderName()));
    }
}