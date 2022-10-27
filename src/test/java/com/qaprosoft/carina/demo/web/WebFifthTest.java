package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebFifthTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String CORRECT_PASSWORD = "secret_sauce";

    LoginPage loginPage = null;

    @BeforeSuite
    public void startDriver() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "Check sorting function")
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

        productsMenu.SortNameAToZ();
        List<ProductsMenu> sortNameAToZList = productsPage.getProductsList();
        Assert.assertEquals(sortNameAToZList.get(0).getProductName().getText(), "Sauce Labs Backpack");

        productsMenu.SortNameZToA();
        List<ProductsMenu> sortNameZToAList = productsPage.getProductsList();
        Assert.assertEquals(sortNameZToAList.get(0).getProductName().getText(), "Test.allTheThings() T-Shirt (Red)");

        productsMenu.SortPriceLowToHigh();
        List<ProductsMenu> sortPriceLowToHigh = productsPage.getProductsList();
        Assert.assertEquals(sortPriceLowToHigh.get(0).getProductPrice().getText(), "$7.99");

        productsMenu.SortPriceHighToLow();
        List<ProductsMenu> sortPriceHighToLow = productsPage.getProductsList();
        Assert.assertEquals(sortPriceHighToLow.get(0).getProductPrice().getText(), "$49.99");
    }
}
