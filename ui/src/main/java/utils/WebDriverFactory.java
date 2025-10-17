package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Properties;

public class WebDriverFactory {
    private WebDriver driver;

    public WebDriver getDriverFactory(String config) {
        Properties properties = PropertyReader.getProperties(config);
        boolean headlessMode = Boolean.parseBoolean(properties.getProperty("headlessMode"));
        final String HEADLESS = "--headless";
        switch (properties.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headlessMode) {
                    chromeOptions.addArguments(HEADLESS);
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headlessMode) {
                    edgeOptions.addArguments(HEADLESS);
                }
                driver = new EdgeDriver(edgeOptions);
                break;
        }
        return driver;
    }
}
