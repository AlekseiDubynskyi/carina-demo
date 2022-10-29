package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebFirstTest implements IAbstractTest {

    @Test(description = "Test login page with empty fields")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void testLoggingInWithEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");

        LoginMenu loginMenu = loginPage.getLoginMenu();
        Assert.assertTrue(loginMenu.isUIObjectPresent(2), "Login menu wasn't found!");
        loginMenu.clickLoginButton();

        Assert.assertEquals(loginMenu.getErrorMessage(), "Epic sadface: Username is required", "Error message wasn't found!");
    }
}
