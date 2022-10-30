package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebFifthTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String CORRECT_PASSWORD = "secret_sauce";

    @Test(description = "Check sorting function")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void testLoggingInWithEmptyFields() {
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

        SoftAssert softAssert = new SoftAssert();

        productsMenu.clickSortNameAToZ();
        softAssert.assertTrue(productsMenu.isNamesSortedAToZ(), "Sorting by name from A to Z is incorrect");

        productsMenu.clickSortNameZToA();
        softAssert.assertTrue(productsMenu.isNamesSortedZToA(), "Sorting by name from Z to A is incorrect");

        productsMenu.clickSortPriceLowToHigh();
        softAssert.assertTrue(productsMenu.isPricesSortedLowToHigh(), "Sorting by price from Low to High is incorrect");

        productsMenu.clickSortPriceHighToLow();
        softAssert.assertTrue(productsMenu.isPricesSortedHighToLow(), "Sorting by price from High to Low is incorrect");

        softAssert.assertAll();
    }
}
