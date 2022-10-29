package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartMenu extends AbstractUIObject {
    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement readItemName;

    @FindBy(className = "inventory_item_price")
    private ExtendedWebElement readItemPrice;

    public CartMenu(WebDriver driver) {
        super(driver);
    }

    public CartMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return readItemName.getText();
    }

    public String getItemPrice() {
        return readItemPrice.getText();
    }
}
