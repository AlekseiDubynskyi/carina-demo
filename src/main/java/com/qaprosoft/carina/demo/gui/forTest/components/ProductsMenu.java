package com.qaprosoft.carina.demo.gui.forTest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.forTest.pages.CartPage;
import com.qaprosoft.carina.demo.gui.forTest.pages.ItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsMenu extends AbstractUIObject {
    @FindBy(className = "inventory_item_name")
    private List<ExtendedWebElement> productNames;

    @FindBy(className = "inventory_item_price")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//*[./*[./*[text() = '%s']]]/following-sibling::*/*[text() = 'Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = "//*[text()='%s']")
    private ExtendedWebElement itemNameButton;

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

    public void addProductToCart(String text) {
        addToCartButton.format(text).click();
    }

    public CartPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new CartPage(driver);
    }

    public ItemPage openItemPage(String text) {
        itemNameButton.format(text).click();
        return new ItemPage(driver);
    }

    public void clickSortNameAToZ() {
        nameAToZ.click();
    }

    public void clickSortNameZToA() {
        nameZToA.click();
    }

    public void clickSortPriceLowToHigh() {
        priceLowToHigh.click();
    }

    public void clickSortPriceHighToLow() {
        priceHighToLow.click();
    }

    public boolean isNamesSortedAToZ() {
        List<String> nameList = new ArrayList<>();
        for (ExtendedWebElement productName : productNames) {
            nameList.add(productName.getText());
        }

        List<String> nameListSorted = nameList.stream().sorted().collect(Collectors.toList());

        return nameList.equals(nameListSorted);
    }

    public boolean isNamesSortedZToA() {
        List<String> nameList = new ArrayList<>();
        for (ExtendedWebElement productName : productNames) {
            nameList.add(productName.getText());
        }

        List<String> nameListSorted = nameList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return nameList.equals(nameListSorted);
    }

    public boolean isPricesSortedLowToHigh() {
        List<Double> priceList = new ArrayList<>();
        for (ExtendedWebElement productPrice : productPrices) {
            priceList.add(Double.valueOf(productPrice.getText().replace("$", "")));
        }

        System.out.println(priceList);

        List<Double> priceListSorted = priceList.stream().sorted().collect(Collectors.toList());

        System.out.println(priceListSorted);

        return priceList.equals(priceListSorted);
    }

    public boolean isPricesSortedHighToLow() {
        List<Double> priceList = new ArrayList<>();
        for (ExtendedWebElement productPrice : productPrices) {
            priceList.add(Double.valueOf(productPrice.getText().replace("$", "")));
        }

        List<Double> priceListSorted = priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return priceList.equals(priceListSorted);
    }
}

