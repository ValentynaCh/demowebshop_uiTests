package ui.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.listeners.LogListener;

public class LoggerUtil {
    public WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LogListener.class);

    public static void log(String message) {
        logger.info(message);
    }

    public static Logger getLogger() {
        return logger;
    }

}
