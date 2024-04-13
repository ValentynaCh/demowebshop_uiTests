package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import static java.sql.DriverManager.getDriver;

public class HeaderSection extends BasePage {
    private String genderRadioButtonXpath = "//input[@id = 'gender-male']";
    private String emailLoginXpath = "//input[@id = 'Email']";
    private String passwordXpath = "//input[@id = 'Password']";

    private String loginButtonXpath = "//a[@class='ico-login' and @href='/login']";


    private WebElement booksButton = driver.findElement(By.xpath("//a[@href = '/books']"));
    private WebElement computersButton = driver.findElement(By.xpath("//a[@href = '/computers']"));
    private WebElement electronicsButton = driver.findElement(By.xpath("//a[@href = '/electronics']"));
    private WebElement apparelAndShoesButton = driver.findElement(By.xpath("//a[@href = '/apparel-shoes']"));
    private WebElement digitalAndDownloadsButton = driver.findElement(By.xpath("//a[@href = '/digital-downloads']"));
    private WebElement jewerlyButton = driver.findElement(By.xpath("//a[@href = '/jewelry']"));

    private WebElement giftCardsButton = driver.findElement(By.xpath("//a[@href = '/gift-cards']"));





    public HeaderSection(WebDriver webdriver) {
        super(webdriver);
    }

    public BooksPage clickBooks(){
        booksButton.click();
        return new BooksPage(driver);
    }

    public ComputersPage clickComputers(){
        computersButton.click();
        return new ComputersPage(driver);
    }

    public ElectronicsPage clickElectronics(){
        apparelAndShoesButton.click();
        return new ElectronicsPage(driver);
    }

    public ApparelAndShoesPage clickApparelAndShoes(){
        apparelAndShoesButton.click();
        return new ApparelAndShoesPage(driver);
    }

    public DigitalAndDownloadsPage clickDigitalAndDownloads(){
        digitalAndDownloadsButton.click();
        return new DigitalAndDownloadsPage(driver);
    }

    public JewerlyPage clickJewerly(){
        jewerlyButton.click();
        return new JewerlyPage(driver);
    }

    public GiftCardsPage clickGiftCards(){
        giftCardsButton.click();
        return new GiftCardsPage(driver);
    }






    public void enterLoginEmail(String email) {
        driver.findElement(By.xpath(emailLoginXpath)).sendKeys(email);
    }

    public void enterLoginPassword() {
        driver.findElement(By.xpath(passwordXpath)).sendKeys("Password123!");
    }

    public void clickLogin() {
        driver.findElement(By.xpath(loginButtonXpath)).click();
    }


}
