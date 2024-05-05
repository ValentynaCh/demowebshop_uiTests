package ui.demowebshop;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.SignInPage;
import ui.pages.header.TopRightMenu;

public class LoginTest extends BaseTest {
    @SneakyThrows
    @Test(description = "This test verifies message of unsuccessful login", groups = {"regression"})
    public void verifyMessageOfIncorrectCredentials() {
        TopRightMenu topRightMenu = new TopRightMenu(driver);
        SignInPage signInPage = topRightMenu.clickOnTopMenuItemByName("login", SignInPage.class);
        signInPage.setEmail("some_email@gmail.com");
        signInPage.setPassword("123456");
        signInPage.clickOnLoginButton();
        Assert.assertEquals(signInPage.getErrorLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect", "Error message of incorrect credentials is not correct");
    }
}
