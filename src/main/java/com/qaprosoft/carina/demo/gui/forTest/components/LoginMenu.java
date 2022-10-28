package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.forTest.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private ExtendedWebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private ExtendedWebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private ExtendedWebElement errorMessage;

    public LoginMenu(WebDriver driver) {
        super(driver);
    }

    public LoginMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductsPage openProductsPage() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public String readErrorMessage() {
        assertElementPresent(errorMessage);
        return errorMessage.getText();
    }

    public void sendCredentialToUsernameField(String text) {
        username.click();
        username.type(text);
    }

    public void sendCredentialToPasswordField(String text) {
        password.click();
        password.type(text);
    }
}
