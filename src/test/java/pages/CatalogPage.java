package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitHelper;

import java.util.List;

public class CatalogPage {
private final AndroidDriver driver;
private final WaitHelper wait;

private final By productList = By.id("com.saucelabs.mydemoapp.android:id/productIV");
private final By cartIcon     = By.id("com.saucelabs.mydemoapp.android:id/cartIV");

public CatalogPage(AndroidDriver driver) {
    this.driver = driver;
    this.wait = new WaitHelper(driver);
}

public boolean isLoaded() {
    return !driver.findElements(productList).isEmpty();
}

public int getProductCount() {
    return driver.findElements(productList).size();
}

public ProductDetailPage openProduct(int index) {
    List<org.openqa.selenium.WebElement> products = driver.findElements(productList);
    products.get(index).click();
    return new ProductDetailPage(driver);
}

public CartPage openCart() {
    wait.waitForClickable(cartIcon).click();
    return new CartPage(driver);
}
  }