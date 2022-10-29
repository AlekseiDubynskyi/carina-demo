package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebSecondTest implements IAbstractTest {
    private static final String CORRECT_USERNAME = "standard_user";
    private static final String INCORRECT_PASSWORD = "secret_sauce1";

    @Test(description = "Test login page with incorrect password")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void testLoggingInWithEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");

        LoginMenu loginMenu = loginPage.getLoginMenu();
        Assert.assertTrue(loginMenu.isUIObjectPresent(2), "Login menu wasn't found!");

        loginMenu.typeUsername(CORRECT_USERNAME);
        loginMenu.typePassword(INCORRECT_PASSWORD);

        loginMenu.clickLoginButton();
        Assert.assertEquals(loginMenu.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message wasn't found!");
    }
}
