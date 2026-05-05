package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;

public class CartTest extends BaseTest {

    @Test(description = "Cart is empty on app start")
    public void cartShouldBeEmptyInitially() {
        CartPage cart = new CatalogPage(driver).openCart();
        Assert.assertTrue(cart.isEmpty(), "Cart should be empty initially");
    }

    @Test(description = "Product can be added to cart")
    public void shouldAddProductToCart() {
        CartPage cart = new CatalogPage(driver).openProduct(0).addToCart();
        Assert.assertEquals(cart.getItemCount(), 1, "Cart should contain one item");
    }
}