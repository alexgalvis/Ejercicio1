package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderConfirmationPage {
    public static Target FINISH = Target.the("finish")
            .located(By.id("finish"));
    public static Target CONFIRMATION_LABEL = Target.the("summary total label")
            .located(By.cssSelector("h2.complete-header"));
}
