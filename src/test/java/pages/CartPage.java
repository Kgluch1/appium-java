package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitHelper;

public class CartPage {

    private final AndroidDriver driver;
    private final WaitHelper wait;

    private final By cartItems    = By.id("com.saucelabs.mydemoapp.android:id/cartTV");
    private final By proceedBtn   = By.id("com.saucelabs.mydemoapp.android:id/proceedToCheckoutBt");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    public int getItemCount() {
        return driver.findElements(cartItems).size();
    }

    public boolean isEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    public void proceedToCheckout() {
        wait.waitForClickable(proceedBtn).click();
    }
}