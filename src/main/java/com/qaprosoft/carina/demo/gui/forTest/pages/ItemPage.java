package com.qaprosoft.carina.demo.gui.forTest.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.forTest.components.ItemMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {
    @FindBy(id = "inventory_item_container")
    private ItemMenu itemMenu;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }
}
