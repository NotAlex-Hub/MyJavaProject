package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.DriverSingleton;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get("https://demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
    }

    @AfterSuite
    public void closeDriver() {
        DriverSingleton.quitDriver();
    }
}
