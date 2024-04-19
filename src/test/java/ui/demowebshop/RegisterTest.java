package ui.demowebshop;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.BaseTest;
import ui.pages.HeaderSection;
import ui.pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test(description = "This test verifies navigation to the Register page after clicking the Register button ")
    public void verifyNavigationToRegisterPage() {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.getRegisterPageTitle(), "Register", "Register page title is not correct");
        softAssert.assertEquals(registerPage.getPersonalDetailsFormTitle(), "Your Personal Details",
                "Personal Details form title is not correct.");
        softAssert.assertTrue(registerPage.isGenderLabelDisplays(), "Gender label does not display.");
        softAssert.assertEquals(registerPage.getGenderLabelText(), "Gender:", "Label of the Gender field is not correct");
        softAssert.assertTrue(registerPage.isMaleRadiobuttonLabelDisplays(), "Male label does not display");
        softAssert.assertEquals(registerPage.getMaleRadiobuttonLabelText(), "Male", "Label of the Male radiobutton is not correct");
        softAssert.assertTrue(registerPage.isFemaleRadiobuttonLabelDisplays(), "FemaLle label does not display");
        softAssert.assertEquals(registerPage.getFemaleRadiobuttonLabelText(), "Female", "Label of the Female radiobutton is not correct");
        softAssert.assertFalse(registerPage.isMaleRadiobuttonSelected(), "Male radiobutton is selected");
        softAssert.assertFalse(registerPage.isFemaleRadiobuttonSelected(), "Female radiobutton is selected");
        softAssert.assertTrue(registerPage.isFirstNameLabelDisplays(), "First Name label does not display.");
        softAssert.assertEquals(registerPage.getFirstNameLabelText(), "First name:", "Label of the First Name field is not correct");
        softAssert.assertTrue(registerPage.isFirstNameFieldEmpty(), "First Name field is not empty.");
        softAssert.assertTrue(registerPage.isLastNameLabelDisplays(), "Last Name label does not display.");
        softAssert.assertEquals(registerPage.getLastNameLabelText(), "Last name:", "Label of the Last Name field is not correct");
        softAssert.assertTrue(registerPage.isLastNameFieldEmpty(), "Last Name field is not empty.");
        softAssert.assertTrue(registerPage.isEmailLabelDisplays(), "Email label does not display.");
        softAssert.assertEquals(registerPage.getEmailLabelText(), "Email:", "Label of the Email field is not correct");
        softAssert.assertTrue(registerPage.isEmailFieldEmpty(), "Email field is not empty.");
        softAssert.assertEquals(registerPage.getYourPasswordFormTitle(), "Your Password",
                "Your Password form title is not correct.");
        softAssert.assertTrue(registerPage.isPasswordLabelDisplayed(), "Password label does not display.");
        softAssert.assertEquals(registerPage.getPasswordLabelText(), "Password:", "Label of the Password field is not correct");
        softAssert.assertTrue(registerPage.isPasswordFieldEmpty(), "Password field is not empty.");
        softAssert.assertTrue(registerPage.isConfirmPasswordLabelDisplayed(), "Confirm password label does not display.");
        softAssert.assertEquals(registerPage.getConfirmPasswordLabelText(), "Confirm password:", "Label of the Confirm password field is not correct");
        softAssert.assertTrue(registerPage.isConfirmPasswordFieldEmpty(), "Confirm password field is not empty.");
        softAssert.assertAll();
    }
}
