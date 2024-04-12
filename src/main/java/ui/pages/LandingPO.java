package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LandingPO extends BasePO {

    private final By siteLogo = By.xpath("//*[@class='tools-qa-header__logo']");

    public LandingPO(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        System.out.println("Getting 'Landing Page' title.");
        return getDriver().getTitle();
    }

    public boolean isTitleLogoDisplayed() {
        System.out.println("Is logo displayed on 'Landing Page'.");
        return getDriver().findElement(siteLogo).isDisplayed();

    }


}