package com.qaprosoft.carina.demo.gui.forTest.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.forTest.components.CartMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(id = "cart_contents_container")
    private CartMenu cartMenu;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartMenu getCartMenu() {
        return cartMenu;
    }
}
