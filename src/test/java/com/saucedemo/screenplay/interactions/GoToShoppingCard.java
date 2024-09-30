package com.saucedemo.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.screenplay.ui.homePage.HomePage.SHOPPING_CART_LINK;

public class GoToShoppingCard implements Interaction {
    public static GoToShoppingCard on() {
        return new GoToShoppingCard();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHOPPING_CART_LINK)
        );
    }
}
