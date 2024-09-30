package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.interactions.GoToShoppingCard;
import com.saucedemo.screenplay.ui.CartPage;
import com.saucedemo.screenplay.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProceedToCheckout implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public ProceedToCheckout(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    public static Performable withData(String firstName, String lastName,String postalCode){
        return instrumented(ProceedToCheckout.class,firstName,lastName,postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoToShoppingCard.on(),
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE)
        );
    }
}
