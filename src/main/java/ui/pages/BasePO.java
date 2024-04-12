package ui.pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;


public abstract class BasePO {
    @Getter
    private WebDriver driver;


    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

}