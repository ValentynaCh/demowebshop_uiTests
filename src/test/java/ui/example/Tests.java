package ui.example;


import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.LandingPO;

public class Tests extends BaseTest {

    @Test(groups = "Regression")
    public void titleTest() {
        String testTitle = "Tools QA";
        LandingPO landingPage = new LandingPO(driver);
        Assert.assertEquals(landingPage.getTitle(), testTitle);
        System.out.println("Test execution "+ Thread.currentThread().getId());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void logoTest() {
        LandingPO landingPage = new LandingPO(driver);
        Assert.assertTrue(landingPage.isTitleLogoDisplayed());
        System.out.println("Test execution "+ Thread.currentThread().getId());
    }
    @Test
    public void someTest(){
        System.out.println("some test is running");
    }

}
