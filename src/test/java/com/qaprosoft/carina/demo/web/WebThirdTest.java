package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.CartMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.CartPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebThirdTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String CORRECT_PASSWORD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Bolt T-Shirt";
    private static final String PRODUCT_PRICE = "$15.99";

    @Test(description = "Check the item in the cart")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void CheckingAddingProductToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");

        LoginMenu loginMenu = loginPage.getLoginMenu();
        Assert.assertTrue(loginMenu.isUIObjectPresent(2), "Login menu wasn't found!");

        loginMenu.typeUsername(CORRECT_USER);
        loginMenu.typePassword(CORRECT_PASSWORD);

        ProductsPage productsPage = loginMenu.clickLoginButton();
        ProductsMenu productsMenu = productsPage.getProductsMenu();
        Assert.assertTrue(productsMenu.isUIObjectPresent(2), "Products menu wasn't found!");

        productsMenu.addProductToCart(PRODUCT_NAME);

        CartPage cartPage = productsMenu.clickShoppingCartButton();
        CartMenu cartMenu = cartPage.getCartMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartMenu.getItemName(), PRODUCT_NAME, "Product name doesn't matches");
        softAssert.assertEquals(cartMenu.getItemPrice(), PRODUCT_PRICE, "Product price doesn't matches");
        softAssert.assertAll();
    }
}
