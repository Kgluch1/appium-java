package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitHelper;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriverException;

public class LoginPage {

    private final AndroidDriver driver;
    private final WaitHelper wait;

    private final By menuButton    = By.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private final By loginMenuItem = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
    private final By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By loginButton   = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By errorMessage  = By.id("com.saucelabs.mydemoapp.android:id/errorTV");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        navigateToLogin();
    }

    private void navigateToLogin() {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                wait.waitForClickable(menuButton).click();
                Thread.sleep(1000);
            } catch (Exception ignored) {}

            try {
                wait.waitForClickable(loginMenuItem).click();
            } catch (Exception ignored) {}

            waitForUiAutomator2();

            try {
                Thread.sleep(2000);
                if (!driver.findElements(usernameField).isEmpty()) {
                    return;
                }
            } catch (Exception ignored) {}
        }
    }

    public void enterUsername(String username) {
        wait.waitForElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.waitForElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLogin() {
        try {
            wait.waitForClickable(loginButton).click();
        } catch (WebDriverException ignored) {}
        waitForUiAutomator2();
    }

    public CatalogPage loginWith(String username, String password) {
        enterUsername(username);
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        enterPassword(password);
        tapLogin();
        return new CatalogPage(driver);
    }

    public String getErrorMessage() {
        return wait.waitForElement(errorMessage).getText();
    }
    private void waitForUiAutomator2() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
                driver.currentActivity();
                return;
            } catch (Exception ignored) {}
        }
    }
}