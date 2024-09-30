package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static Target FIRST_NAME = Target.the("first name")
            .located(By.id("first-name"));
    public static Target LAST_NAME = Target.the("last name")
            .located(By.id("last-name"));
    public static Target POSTAL_CODE = Target.the("postal code")
            .located(By.id("postal-code"));
    public static Target CONTINUE = Target.the("continue")
            .located(By.id("continue"));
}
