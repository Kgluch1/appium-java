package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;

public class CatalogTest extends BaseTest {

    @Test(description = "Catalog loads products on app start")
    public void shouldDisplayProducts() {
        CatalogPage catalogPage = new CatalogPage(driver);
        Assert.assertTrue(catalogPage.isLoaded(), "Product list should be visible");
        Assert.assertTrue(catalogPage.getProductCount() > 0, "At least one product expected");
    }

    @Test(description = "Product detail opens on tap")
    public void shouldOpenProductDetail() {
        CatalogPage catalogPage = new CatalogPage(driver);
        String productName = catalogPage.openProduct(0).getProductName();
        Assert.assertFalse(productName.isEmpty(), "Product name should be visible");
    }
}