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

    @SneakyThrows
    @Test(description = "This test verifies Books page title", groups = {"regression"})
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driver);
        BooksPage booksPage = mainMenu.clickOnMenuItemByName("books", BooksPage.class);
        String actualTitle = booksPage.getPageTitleText();
        String expectedTitle = HeaderMenuItems.BOOKS.getItemTagTextName();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
