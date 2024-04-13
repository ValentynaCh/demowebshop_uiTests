package ui.pages;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {

    public WebDriver driver;
    public String pageTitle = "//div[@class = 'page-title']";
    public WebElement headerElement;



    public BasePage(WebDriver webDriver) {
        driver = webDriver;
        headerElement = driver.findElement(By.xpath(pageTitle));


    }


    public String getHeaderText(){
        return headerElement.getText();
    }



}