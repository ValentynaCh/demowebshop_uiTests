package ui;


import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.LandingPO;

public class Tests extends BaseTest {
    @Test
    public void titleTest() {
        String testTitle = "Tools QA";
        LandingPO landingPage = new LandingPO(driver);
        Assert.assertEquals(landingPage.getTitle(), testTitle);
    }

    @Test
    public void logoTest() {
        LandingPO landingPage = new LandingPO(driver);
        Assert.assertTrue(landingPage.isTitleLogoDisplayed());
    }
}
