package ui.demowebshop;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenuItems;
import ui.pages.ComputersPage;
import ui.pages.header.MainMenu;

public class ComputersPageTest extends BaseTest {

    @SneakyThrows
    @Test(description = "This test verifies page title")
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driver);
        ComputersPage computersPage = mainMenu.clickOnMenuItemByName("computers", ComputersPage.class);
        Assert.assertEquals(computersPage.getPageTitleText(), HeaderMenuItems.COMPUTERS.getItemTagTextName(),
                String.format("Title of the {%s} page is not correct", HeaderMenuItems.COMPUTERS.getItemTagTextName()));

    }
}
