package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private ExtendedWebElement item4Button;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private ExtendedWebElement burgerButton;

    public ProductsMenu(WebDriver driver) {
        super(driver);
    }

    public ProductsMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void openShoppingCartPage() {
        shoppingCartButton.click();
    }

    public void openItem4Page() {
        item4Button.click();
    }

    public void openOptions() {
        burgerButton.click();
    }

}
