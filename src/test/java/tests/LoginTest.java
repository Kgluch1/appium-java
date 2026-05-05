package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;

import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test(description = "Successful login with valid credentials")
    public void shouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        CatalogPage catalogPage = loginPage.loginWith("bob@example.com", "10203040");
        Assert.assertTrue(catalogPage.isLoaded(), "Catalog should be visible after login");
    }

    @Test(description = "Login fails with wrong password")
    public void shouldShowErrorForInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("bob@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.tapLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertFalse(error.isEmpty(), "Error message should be displayed");
    }

    @Test(description = "Login fails with empty fields")
    public void shouldShowErrorForEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tapLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertFalse(error.isEmpty(), "Error message should be displayed");
    }
}