package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private String genderRadioButtonXpath = "//input[@id = 'gender-male']";
    private String emailLoginXpath = "//input[@id = 'Email']";
    private String passwordXpath = "//input[@id = 'Password']";
    private String loginButtonXpath = "//div[@class = 'buttons'] //input[@type = 'submit']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterLoginEmail(String email) {
        driver.findElement(By.xpath(emailLoginXpath)).sendKeys(email);
    }

    public void enterLoginPassword() {
        driver.findElement(By.xpath(passwordXpath)).sendKeys("Password123!");
    }

    public void clickTheLogin() {
        driver.findElement(By.xpath(loginButtonXpath)).click();
    }
}
