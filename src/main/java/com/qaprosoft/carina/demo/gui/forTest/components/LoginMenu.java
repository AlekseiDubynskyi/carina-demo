package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
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

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void typeUsername(String text) {
        username.type(text);
    }

    public void typePassword(String text) {
        password.type(text);
    }
}
