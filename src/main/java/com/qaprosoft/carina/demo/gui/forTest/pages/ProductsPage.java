package com.qaprosoft.carina.demo.gui.forTest.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.forTest.components.BurgerButtonMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.CartMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ItemMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractPage {

    @FindBy(id = "inventory_container")
    private ProductsMenu productsMenu;

    @FindBy(id = "cart_contents_container")
    private CartMenu cartMenu;

    @FindBy(id = "inventory_item_container")
    private ItemMenu itemMenu;

    @FindBy(id = "menu_button_container")
    private BurgerButtonMenu burgerButtonMenu;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsMenu getProductsMenu() {
        return productsMenu;
    }

    public CartMenu getCartMenu() {
        return cartMenu;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public BurgerButtonMenu burgerButtonMenu() {
        return burgerButtonMenu;
    }
}
