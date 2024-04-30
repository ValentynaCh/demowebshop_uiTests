package ui.demowebshop;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenuItems;
import ui.pages.BooksPage;
import ui.pages.header.MainMenu;

public class BooksPageTest extends BaseTest {
    private static final Logger logger
            = LoggerFactory.getLogger(BooksPageTest.class);



    @SneakyThrows
    @Test(description = "This test verifies Books page title")
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driver);
        BooksPage booksPage = mainMenu.clickOnMenuItemByName("books", BooksPage.class);
        String actualTitle = booksPage.getPageTitleText();
        String expectedTitle = HeaderMenuItems.BOOKS.getItemTagTextName();
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    //String.format("Title of the {%s} page is not correct. Actual: {%s}, Expected: {%s}",
    //                        HeaderMenuItems.BOOKS.getItemTagTextName(), actualTitle, expectedTitle)
}
