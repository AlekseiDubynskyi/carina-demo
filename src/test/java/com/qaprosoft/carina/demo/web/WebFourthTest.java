package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.BurgerButtonMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ItemMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebFourthTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String CORRECT_PASSWORD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";
    private static final String PRODUCT_PRICE = "29.99";
    LoginPage loginPage = null;

    @BeforeSuite
    public void startDriver() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "Login, check the product and logout")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void testLoggingInWithEmptyFields() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");

        LoginMenu loginMenu = loginPage.getLoginMenu();
        Assert.assertTrue(loginMenu.isUIObjectPresent(2), "Login menu wasn't found!");

        loginMenu.sendCredentialToUsernameField(CORRECT_USER);
        loginMenu.sendCredentialToPasswordField(CORRECT_PASSWORD);

        loginMenu.openProductsPage();
        ProductsPage productsPage = new ProductsPage(getDriver());
        ProductsMenu productsMenu = productsPage.getProductsMenu();
        Assert.assertTrue(productsMenu.isUIObjectPresent(2), "Products menu wasn't found!");

        productsMenu.openItem4Page();
        ItemMenu itemMenu = productsPage.getItemMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemMenu.ItemName4(), PRODUCT_NAME);
        softAssert.assertEquals(itemMenu.ItemPrice4(), PRODUCT_PRICE);

        itemMenu.backToProductsButton();
        productsMenu.openOptions();

        BurgerButtonMenu burgerButtonMenu = productsPage.burgerButtonMenu();
        try {
            Thread.sleep(2000);
            burgerButtonMenu.logout();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
