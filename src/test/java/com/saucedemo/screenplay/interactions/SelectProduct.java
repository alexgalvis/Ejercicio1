package com.saucedemo.screenplay.interactions;

import com.saucedemo.screenplay.ui.homePage.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;



public class SelectProduct implements Interaction {
    private final String productName;

    public SelectProduct(String productName) {
        this.productName = productName;
    }

    public static SelectProduct withName(String productName) {
        return new SelectProduct(productName);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.product(productName).addToCartButton())
        );
    }
}
