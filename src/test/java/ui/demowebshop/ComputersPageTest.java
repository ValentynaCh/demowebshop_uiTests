package ui.demowebshop;

import jdk.jfr.Description;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.enums.HeaderMenuItems;
import ui.pages.ComputersPage;
import ui.pages.header.MainMenu;


public class ComputersPageTest extends BaseTest {

    @SneakyThrows
    @Test
    @Description("This test verifies Computers page title")
    public void verifyPageTitleTest() {
        MainMenu mainMenu = new MainMenu(driverThreadLocal.get());
        ComputersPage computersPage = mainMenu.clickOnMenuItemByName("computers", ComputersPage.class);
        Assert.assertEquals(computersPage.getPageTitleText(), HeaderMenuItems.COMPUTERS.getItemTagTextName(),
                String.format("Title of the {%s} page is not correct", HeaderMenuItems.COMPUTERS.getItemTagTextName()));

    }
}
