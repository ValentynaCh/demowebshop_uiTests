package ui.demowebshop;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenuPageTitle;
import ui.pages.BooksPage;
import ui.pages.header.MainMenu;

public class BooksPageTest extends BaseTest {
    @SneakyThrows
    @Test(description = "This test verifies Books page title")
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driver);
        BooksPage booksPage = mainMenu.clickOnMenuItemByName("books", BooksPage.class);
        Assert.assertEquals(booksPage.getPageTitleText(), HeaderMenuPageTitle.BOOKS.getItemTagTextName(),
                String.format("Title of the {%s} page is not correct", HeaderMenuPageTitle.BOOKS.getItemTagTextName()));
    }
}
