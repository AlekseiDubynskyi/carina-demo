package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebSecondTest implements IAbstractTest {
    private static final String CORRECT_USER = "standard_user";
    private static final String INCORRECT_PASSWORD = "secret_sauce1";
    LoginPage loginPage = null;

    @BeforeSuite
    public void startDriver() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "Test login page with incorrect password")
    @MethodOwner(owner = "Dubynskyi Oleksii")
    public void testLoggingInWithEmptyFields() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");

        LoginMenu loginMenu = loginPage.getLoginMenu();
        Assert.assertTrue(loginMenu.isUIObjectPresent(2), "Login menu wasn't found!");

        loginMenu.sendCredentialToUsernameField(CORRECT_USER);
        loginMenu.sendCredentialToPasswordField(INCORRECT_PASSWORD);

        loginMenu.openProductsPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginMenu.readErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
}
