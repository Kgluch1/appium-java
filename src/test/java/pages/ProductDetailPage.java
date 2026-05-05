package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitHelper;

public class ProductDetailPage {

    private final AndroidDriver driver;
    private final WaitHelper wait;

    private final By productName  = By.id("com.saucelabs.mydemoapp.android:id/productTV");
    private final By addToCartBtn = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    public ProductDetailPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    public String getProductName() {
        return wait.waitForElement(productName).getText();
    }

    public CartPage addToCart() {
        wait.waitForClickable(addToCartBtn).click();
        return new CartPage(driver);
    }
}