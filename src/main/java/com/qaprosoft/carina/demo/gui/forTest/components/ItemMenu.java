package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]//div[@class=\"inventory_details_name large_size\"]")
    private ExtendedWebElement itemName;

    @FindBy(className = "inventory_details_price")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private ExtendedWebElement backToProductsButton;

    public ItemMenu(WebDriver driver) {
        super(driver);
    }

    public ItemMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void clickBackToProductsButton() {
        backToProductsButton.click();
    }
}
