package ui.demowebshop;


import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HeaderSection;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {



    @Test(description = "This test verify ability to Login")
    public void verifyUserLogin() {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("some_email@gmail.com");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
    }
}