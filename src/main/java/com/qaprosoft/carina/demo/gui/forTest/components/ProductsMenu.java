package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.forTest.pages.ProductsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsMenu extends AbstractUIObject {
    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement productName;

    @FindBy(className = "inventory_item_price")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private ExtendedWebElement item4Button;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private ExtendedWebElement burgerButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement nameAToZ;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement nameZToA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement priceLowToHigh;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement priceHighToLow;

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

    public void SortNameAToZ() {
        nameAToZ.click();
    }

    public void SortNameZToA() {
        nameZToA.click();
    }

    public void SortPriceLowToHigh() {
        priceLowToHigh.click();
    }

    public void SortPriceHighToLow() {
        priceHighToLow.click();
    }

    public ExtendedWebElement getProductName() {
        return productName;
    }

    public ExtendedWebElement getProductPrice() {
        return productPrice;
    }
}
