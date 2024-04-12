package ui.example;


import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.LandingPO;

public class AdditionalTests extends BaseTest {

    @Test(groups = "Sanity")
    public void someTest(){
        System.out.println("some test is running");
    }
}
