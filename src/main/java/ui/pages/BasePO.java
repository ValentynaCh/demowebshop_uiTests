package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class BasePO {

    private final WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }
}

//один раз я передаю драйвер в бейз по, і непотрібно в лендінгпо, наприклад, передавати той драйвер,
// бо він наслідується від бейз по. В без по будуть розміщуватись вейти