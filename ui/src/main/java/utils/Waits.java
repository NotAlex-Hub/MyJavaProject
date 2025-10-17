package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public interface Waits {

    default WebElement visibilityOfElement(WebElement webElement) {
        return new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    default WebElement clickableOfElement(WebElement webElement) {
        return new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    default void waitForSeconds() {
        Instant time = Instant.now().plusSeconds(1);
        new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(1))
                .until(driver -> Instant.now().isAfter(time));
    }
}
