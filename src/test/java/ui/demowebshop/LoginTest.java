package ui.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HeaderSection;
import ui.pages.SignInPage;

public class LoginTest extends BaseTest {
    @Test(description = "This test verifies message of incorrect login credentials")
    public void verifyMessageOfIncorrectLoginCredentials() {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.clickLoginButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.setEmail("some_email@gmail.com");
        signInPage.setPassword("123456");
        signInPage.clickLoginButton();
        Assert.assertEquals(signInPage.getErrorLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect", "Error message is not correct");
    }
}
