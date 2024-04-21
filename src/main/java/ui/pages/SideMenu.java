package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SideMenu extends BasePage {
    private final String activeItemXpath = "//ul[@class='list']/li[@class='active']/a";

    public SideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getActiveSidebarItemText() {
        System.out.println("Get active item from the side bar - " + driver.findElement(By.xpath(activeItemXpath)).getText());
        return driver.findElement(By.xpath(activeItemXpath)).getText();
    }
}
