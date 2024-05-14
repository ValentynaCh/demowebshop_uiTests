package ui.utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import ui.exceptions.ConfigurationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    public static ConfigReader configReader;
    private static final String FILE_NAME = "app.properties";
    private static final Path RESOURCES_PATH = Paths.get("src", "main", "resources");
    private static final ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(ConfigReader.class);

    private ConfigReader() {
        try (BufferedReader reader = Files.newBufferedReader(RESOURCES_PATH.resolve(FILE_NAME))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            logger.error("error while reading a {} file", FILE_NAME);
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base.url");
        if (baseUrl == null) {
            logger.error("base_Url not specified in {} file.", FILE_NAME);
        }
        return baseUrl;
    }

    public String getBrowserName() {
        String browserName = properties.getProperty("browser.name");
        if (browserName != null) {
            return browserName;
        } else {
            throw new ConfigurationException(String.format("browser_Name not specified in %s file.", FILE_NAME));
        }
    }
}
