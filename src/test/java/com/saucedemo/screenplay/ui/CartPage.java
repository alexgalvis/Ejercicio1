package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static Target CHECKOUT_BUTTON = Target.the("button checkout")
            .located(By.id("checkout"));
}
