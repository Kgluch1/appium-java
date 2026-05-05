package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private final AndroidDriver driver;

    public WaitHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForText(By locator, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}