package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final String pageTitleXpath = "//div[@class = 'page-title']";
    private final String personalDetailsFormTitleXpath = "//div[@class = 'fieldset'][1]//div[@class = 'title']";
    private final String genderLabelXpath = "//div[@class = 'inputs']//label";
    private final String maleGenderLabelXpath = "//label[@for = 'gender-male']";
    private final String maleGenderRadiobuttonXpath = "//input[@id = 'gender-male']";
    private final String femaleGenderLabelXpath = "//label[@for = 'gender-female']";
    private final String femaleGenderRadiobuttonXpath = "//input[@id = 'gender-female']";
    private final String firstNameLabelXpath = "//label[@for = 'FirstName']";
    private final String firstNameFieldXpath = "//input[@id = 'FirstName']";
    private final String lastNameLabelXpath = "//label[@for = 'LastName']";
    private final String lastNameFieldXpath = "//input[@id = 'LastName']";
    private final String emailLabelXpath = "//label[@for = 'Email']";
    private final String emailFieldXpath = "//input[@id = 'Email']";
    private final String passwordFormTitleXpath = "//div[@class = 'fieldset'][2]//div[@class = 'title']";
    private final String passwordLabelXpath = "//label[@for = 'Password']";
    private final String passwordFieldXpath = "//input[@id = 'Password']";
    private final String confirmPasswordLabelXpath = "//label[@for = 'ConfirmPassword']";
    private final String confirmPasswordFieldXpath = "//input[@id = 'ConfirmPassword']";

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getPageTitleText() {
        System.out.println("Get Register page title text");
        return driver.findElement(By.xpath(pageTitleXpath)).getText();
    }

    public String getPersonalDetailsFormTitle() {
        System.out.println("Get Personal Details form title");
        return driver.findElement(By.xpath(personalDetailsFormTitleXpath)).getText();
    }

    public String getGenderLabelText() {
        System.out.println("Get Gender label text");
        return driver.findElement(By.xpath(genderLabelXpath)).getText();
    }

    public String getMaleRadiobuttonLabelText() {
        System.out.println("Get Male label text");
        return driver.findElement(By.xpath(maleGenderLabelXpath)).getText();

    }

    public String getFemaleRadiobuttonLabelText() {
        System.out.println("Get Female label text");
        return driver.findElement(By.xpath(femaleGenderLabelXpath)).getText();

    }

    public boolean isMaleRadiobuttonSelected() {
        System.out.println("Check if Male radiobutton is selected");
        return driver.findElement(By.xpath(maleGenderRadiobuttonXpath)).isSelected();
    }

    public boolean isFemaleRadiobuttonSelected() {
        System.out.println("Check if Female radiobutton is selected");
        return driver.findElement(By.xpath(femaleGenderRadiobuttonXpath)).isSelected();
    }


    public String getFirstNameLabelText() {
        System.out.println("Get First Name label text");
        return driver.findElement(By.xpath(firstNameLabelXpath)).getText();
    }

    public boolean isFirstNameFieldEmpty() {
        System.out.println("Check if First name field is empty");
        return driver.findElement(By.xpath(firstNameFieldXpath)).getText().isEmpty();
    }

    public String getLastNameLabelText() {
        System.out.println("Get Last Name label text");
        return driver.findElement(By.xpath(lastNameLabelXpath)).getText();
    }

    public boolean isLastNameFieldEmpty() {
        System.out.println("Check if Last name field is empty");
        return driver.findElement(By.xpath(lastNameFieldXpath)).getText().isEmpty();
    }

    public String getEmailLabelText() {
        System.out.println("Get Email label text");
        return driver.findElement(By.xpath(emailLabelXpath)).getText();
    }

    public boolean isEmailFieldEmpty() {
        System.out.println("Check if Email field is empty");
        return driver.findElement(By.xpath(emailFieldXpath)).getText().isEmpty();
    }

    public String getYourPasswordFormTitle() {
        System.out.println("Get Your Password form title");
        return driver.findElement(By.xpath(passwordFormTitleXpath)).getText();
    }

    public String getPasswordLabelText() {
        System.out.println("Get Password label text");
        return driver.findElement(By.xpath(passwordLabelXpath)).getText();
    }

    public boolean isPasswordFieldEmpty() {
        System.out.println("Check if Password field is empty");
        return driver.findElement(By.xpath(passwordFieldXpath)).getText().isEmpty();
    }

    public String getConfirmPasswordLabelText() {
        System.out.println("Get Confirm password label text");
        return driver.findElement(By.xpath(confirmPasswordLabelXpath)).getText();
    }

    public boolean isConfirmPasswordFieldEmpty() {
        System.out.println("Check if Password field is empty");
        return driver.findElement(By.xpath(confirmPasswordFieldXpath)).getText().isEmpty();
    }
}
