package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.utils.StoreHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class NavigateTo {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the sauceDemo home page",
                Open.browserOn().the(StoreHomePage.class));
    }
}
