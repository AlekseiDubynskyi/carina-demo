package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerButtonMenu extends AbstractUIObject {
    @FindBy(xpath = " //*[@id=\"logout_sidebar_link\"]")
    private ExtendedWebElement logoutButton;

    public BurgerButtonMenu(WebDriver driver) {
        super(driver);
    }

    public BurgerButtonMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void logout() {
        logoutButton.click();
    }
}
