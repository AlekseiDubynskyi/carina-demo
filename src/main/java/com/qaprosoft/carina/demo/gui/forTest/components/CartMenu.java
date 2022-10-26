package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private ExtendedWebElement readItemName4;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]/text()[2]")
    private ExtendedWebElement readItemPrice4;

    public CartMenu(WebDriver driver) {
        super(driver);
    }

    public CartMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readItemName4() {
        assertElementPresent(readItemName4);
        return readItemName4.getText();
    }

    public String readItemPrice4() {
        assertElementPresent(readItemPrice4);
        return readItemPrice4.getText();
    }
}
