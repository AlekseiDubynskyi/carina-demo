package com.qaprosoft.carina.demo.gui.forTest.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.forTest.components.BurgerButtonMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.CartMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ItemMenu;
import com.qaprosoft.carina.demo.gui.forTest.components.ProductsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends AbstractPage {

    @FindBy(id = "inventory_container")
    private ProductsMenu productsMenu;

    @FindBy(id = "menu_button_container")
    private BurgerButtonMenu burgerButtonMenu;

    @FindBy(id = "inventory_container")
    private List<ProductsMenu> productsList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsMenu getProductsMenu() {
        return productsMenu;
    }

    public BurgerButtonMenu burgerButtonMenu() {
        return burgerButtonMenu;
    }

    public List<ProductsMenu> getProductsList() {
        return productsList;
    }
}
