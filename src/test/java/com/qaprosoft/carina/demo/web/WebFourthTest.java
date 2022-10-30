package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.BurgerButtonMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ItemMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.ItemPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebFourthTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String CORRECT_PASSWORD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Onesie";
    private static final String PRODUCT_PRICE = "$7.99";

    @Test(description = "Login, check the product and logout")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void CheckAddingProductToCart() {
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

        ItemPage itemPage = productsMenu.openItemPage(PRODUCT_NAME);
        ItemMenu itemMenu = itemPage.getItemMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemMenu.getItemName(), PRODUCT_NAME, "Product name doesn't matches");
        softAssert.assertEquals(itemMenu.getItemPrice(), PRODUCT_PRICE, "Product price doesn't matches");
        softAssert.assertAll();

        itemMenu.clickBackToProductsButton();
        productsPage.openOptions();

        BurgerButtonMenu burgerButtonMenu = productsPage.burgerButtonMenu();
        burgerButtonMenu.clickLogoutButton();
    }
}
