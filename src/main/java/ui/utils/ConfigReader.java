package ui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static ConfigReader configReader;
    private static final String FILE_NAME = "app.properties";
    private static final Path RESOURCES_PATH = Paths.get("src", "main", "resources");

    private ConfigReader() {
        try (BufferedReader reader = Files.newBufferedReader(RESOURCES_PATH.resolve(FILE_NAME))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("error while reading a %s file.", FILE_NAME));
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
        if (baseUrl != null) {
            return baseUrl;
        } else {
            throw new RuntimeException(String.format("base_Url not specified in %s file.", FILE_NAME));
        }
    }

    public String getBrowserName() {
        String browserName = properties.getProperty("browser.name");
        if (browserName != null) {
            return browserName;
        } else {
            throw new RuntimeException(String.format("browser_Name not specified in %s file.", FILE_NAME));
        }
    }
}
