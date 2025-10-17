package utils;

import org.openqa.selenium.WebDriver;

import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = webDriverFactory.getDriverFactory(new File("src\\main\\resources\\browser.properties")
                    .getAbsolutePath());
        }
        return driver;
    }

    public static WebDriver quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        return driver;
    }
}
