package ui.demowebshop;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.BaseTest;
import ui.enums.HeaderMenuPageTitle;
import ui.pages.SideMenu;
import ui.pages.header.MainMenu;
import ui.utils.ConfigReader;

import java.util.Collections;
import java.util.List;

public class HeaderMenuPageIsOpenedTest extends BaseTest {

    @Test(description = "This test verifies opening correspond page after clicking header items in reverse order")
    public void verifyPageIsOpenedTest() {

        SoftAssert softAssert = new SoftAssert();
        MainMenu mainMenu = new MainMenu(driver);

        List<String> menuItemsList = mainMenu.getAllElementsFromMenuHeader();
        Collections.reverse(menuItemsList);
        for (String menuItem : menuItemsList) {
            mainMenu.clickOnMenuItemByName(menuItem);

            SideMenu sideMenu = new SideMenu(driver);
            String activeSidebarItemText = sideMenu.getActiveSidebarItemText();
            softAssert.assertEquals(activeSidebarItemText, HeaderMenuPageTitle.getTagNameByTextItem(menuItem).getItemTagTextName(),
                    String.format("Active sidebar element {%s} is not correct%n", activeSidebarItemText));
            ConfigReader configReader = ConfigReader.getInstance();
            String expectedPageUrl = configReader.getBaseUrl() + HeaderMenuPageTitle.getTagNameByTextItem(menuItem).getPageUrl();
            System.out.printf("Actual url is - %s %n", driver.getCurrentUrl());
            softAssert.assertEquals(driver.getCurrentUrl(), expectedPageUrl, String.format("Actual url {%s} does not rely on expected url",driver.getCurrentUrl()));
        }
        softAssert.assertAll();
    }
}
