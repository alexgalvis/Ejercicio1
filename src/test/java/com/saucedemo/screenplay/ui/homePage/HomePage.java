package com.saucedemo.screenplay.ui.homePage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static String urlHome = "https://www.saucedemo.com/inventory.html";
    public static ProductItem product(String productName) {
        return new ProductItem(productName);
    }
    public static Target SHOPPING_CART_BADGE = Target.the("shopping cart badge")
            .located(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
    public static Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .located(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));

}
