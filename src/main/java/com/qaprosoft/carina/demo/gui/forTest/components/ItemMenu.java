package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private ExtendedWebElement ItemName4;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]/text()[2]")
    private ExtendedWebElement ItemPrice4;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private ExtendedWebElement backToProductsButton;

    public ItemMenu(WebDriver driver) {
        super(driver);
    }

    public ItemMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String ItemName4() {
        assertElementPresent(ItemName4);
        return ItemName4.getText();
    }

    public String ItemPrice4() {
        assertElementPresent(ItemPrice4);
        return ItemPrice4.getText();
    }

    public void backToProductsButton() {
        backToProductsButton.click();
    }
}
