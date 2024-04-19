package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderSection extends BasePage {

    private final String menuHeaderTemplateButton = "//a[@href = '/%s']";
    private final String pageTitle = "//div[@class = 'page-title']";
    private final String registerButtonXpath = "//a[@href='/register']";

    public void clickOnHeaderButtonByName(String itemName) {
        System.out.println(String.format("Click on %s header item", itemName));
        driver.findElement(By.xpath(String.format(menuHeaderTemplateButton, itemName))).click();
    }

    public HeaderSection(WebDriver webdriver) {
        super(webdriver);
    }

    public String clickBooks() {
        clickOnHeaderButtonByName("books");
        return driver.findElement(By.xpath(pageTitle)).getText();
    }

    public String clickComputers() {
        clickOnHeaderButtonByName("computers");
        return driver.findElement(By.xpath(pageTitle)).getText();
    }

    public void clickLoginButton() {
        clickOnHeaderButtonByName("login");
    }

    public void clickRegisterButton(){
        System.out.println("Click Register button");
        driver.findElement(By.xpath(registerButtonXpath)).click();
    }
}
