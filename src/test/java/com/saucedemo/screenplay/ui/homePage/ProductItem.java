package com.saucedemo.screenplay.ui.homePage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductItem {
    private final String productName;
    public ProductItem(String productName) {
        this.productName = productName;
    }
    public Target addToCartButton() {
        return Target.the("add to cart button")
                .located(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName +"']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]"));
    }


}
