package ui.example;


import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HeaderSection;
import ui.pages.LandingPage;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {



    @Test
    public void testUserLogin() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.header.clickLogin();



//        HeaderSection headerSection = new HeaderSection(driver);
//        headerSection.clickLogin();

        //landingPage.header.clickLogin();

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterLoginEmail("some_email@gmail.com");
//        loginPage.enterLoginPassword();



//        pageLogin.clickLogin();
    }
}
