package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.ui.OrderConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletePurchase implements Task {

    public static Performable andComplete(){
        return instrumented(CompletePurchase.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OrderConfirmationPage.FINISH)
        );
    }
}
