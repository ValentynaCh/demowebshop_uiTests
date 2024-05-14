package ui.demowebshop;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.BaseTest;
import ui.enums.HeaderMenuItems;
import ui.pages.SideMenu;
import ui.pages.header.MainMenu;
import ui.utils.ConfigReader;

import java.util.Collections;
import java.util.List;

public class HeaderMenuPageIsOpenedTest extends BaseTest {

    @Test
    @Description("This test verifies opening correspond page after clicking header items in reverse order")
    public void verifyPageIsOpenedTest() {

        SoftAssert softAssert = new SoftAssert();
        MainMenu mainMenu = new MainMenu(driverThreadLocal.get());

        List<String> menuItemsList = mainMenu.getAllElementsFromMenuHeader();
        Collections.reverse(menuItemsList);
        for (String menuItem : menuItemsList) {
            mainMenu.clickOnMenuItemByName(menuItem);

            SideMenu sideMenu = new SideMenu(driverThreadLocal.get());
            String activeSidebarItemText = sideMenu.getActiveSidebarItemText();
            softAssert.assertEquals(activeSidebarItemText, HeaderMenuItems.getTagNameByTextItem(menuItem).getItemTagTextName(),
                    String.format("Active sidebar element {%s} is not correct%n", activeSidebarItemText));
            ConfigReader configReader = ConfigReader.getInstance();
            String expectedPageUrl = configReader.getBaseUrl() + HeaderMenuItems.getTagNameByTextItem(menuItem).getPageUrl();
            System.out.printf("Actual url is - %s %n", driverThreadLocal.get().getCurrentUrl());
            softAssert.assertEquals(driverThreadLocal.get().getCurrentUrl(), expectedPageUrl,
                    String.format("Actual url {%s} does not rely on expected url",driverThreadLocal.get().getCurrentUrl()));
        }
        softAssert.assertAll();
    }
}
