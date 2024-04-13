package ui.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.*;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyHeaders() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        BooksPage booksPage = landingPage.header.clickBooks();
        Assert.assertEquals(booksPage.getHeaderText(), "BOOKS","Header of BooksPage is wrong" );

        ComputersPage computersPage = landingPage.header.clickComputers();
        Assert.assertEquals(computersPage.getHeaderText(), "COMPUTERS","Header of ComputerPage is wrong" );

        ElectronicsPage electronicsPage = landingPage.header.clickElectronics();
        Assert.assertEquals(electronicsPage.getHeaderText(), "COMPUTERS","Header of ElectronicsPage is wrong");

        ApparelAndShoesPage apparelAndShoesPage = landingPage.header.clickApparelAndShoes();
        Assert.assertEquals(apparelAndShoesPage.getHeaderText(), "APPAREL & SHOES","Header of APPAREL & SHOES Page is wrong");

        DigitalAndDownloadsPage digitalAndDownloadsPage = landingPage.header.clickDigitalAndDownloads();
        Assert.assertEquals(digitalAndDownloadsPage.getHeaderText(), "DIGITAL DOWNLOADS","Header of DIGITAL&DOWNLOADS is wrong");

        JewerlyPage jewerlyPage = landingPage.header.clickJewerly();
        Assert.assertEquals(jewerlyPage.getHeaderText(), "JEWELRY","Header of JEWELRYPage is wrong");

        GiftCardsPage giftCardsPage = landingPage.header.clickGiftCards();
        Assert.assertEquals(giftCardsPage.getHeaderText(), "GIFT CARDS","Header of GIFT CARDSPage is wrong");


    }
}
