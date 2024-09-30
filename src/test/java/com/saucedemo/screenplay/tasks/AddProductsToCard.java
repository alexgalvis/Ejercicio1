package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.interactions.SelectProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCard implements Task {
    private final String productName;

    public AddProductsToCard(String productName) {
        this.productName = productName;
    }
    public static Performable withName(String productName){
        return  instrumented(AddProductsToCard.class,productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProduct.withName(productName)
        );
    }
}
