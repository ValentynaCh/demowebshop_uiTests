package ui.demowebshop;

import jdk.jfr.Description;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenuItems;
import ui.pages.BooksPage;
import ui.pages.header.MainMenu;

public class BooksPageTest extends BaseTest {

    @SneakyThrows
    @Test(groups = {"regression"})
    @Description("This test verifies Books page title")
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driverThreadLocal.get());
        BooksPage booksPage = mainMenu.clickOnMenuItemByName("books", BooksPage.class);
        String actualTitle = booksPage.getPageTitleText();
        String expectedTitle = HeaderMenuItems.BOOKS.getItemTagTextName();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
