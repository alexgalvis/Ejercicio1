package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.OrderConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class IsOrderConfirmed implements Question<String> {
    public static Question<String> title(){
        return new IsOrderConfirmed();
    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OrderConfirmationPage.CONFIRMATION_LABEL)
                .answeredBy(actor);
    }
}
