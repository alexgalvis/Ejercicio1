package com.saucedemo.stepdefinitions;

import com.saucedemo.screenplay.questions.IsOrderConfirmed;
import com.saucedemo.screenplay.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuyProductsDefinitions {
    @Managed
    WebDriver driver;
    Actor actor = Actor.named("Toby");
    @Before
    public void setupActor(){
        OnStage.setTheStage(new OnlineCast());
        actor.can(BrowseTheWeb.with(driver));
    }

    @Given("the user is on the SauceDemo homepage")
    public void homePageLogin(){
        theActorCalled(actor.getName()).attemptsTo(
                NavigateTo.theSearchHomePage()
        );
    }
    @When("^the user logs in with the username (.*) and the password (.*)$")
    public void the_user_logs_in_with_the_username_and_the_password(String user, String password) {
        theActorCalled(actor.getName()).attemptsTo(
                DoLogin.withCredentials(user,password)
        );
    }
    @When("the user adds the products")
    public void the_user_adds_the_products(List<String> products){
        theActorCalled(actor.getName()).attemptsTo(
                AddProductsToCard.withName(products.get(0)),
                AddProductsToCard.withName(products.get(1))
        );
    }
    @When("the user views the cart and proceeds to checkout with the following data:")
    public void view_cart_and_checkout(DataTable data){
        List<Map<String, String>> form = data.asMaps(String.class, String.class);
        String firstName = form.get(0).get("firstName");
        String lastName = form.get(0).get("lastName");
        String postalCode = form.get(0).get("postalCode");
        theActorCalled(actor.getName()).attemptsTo(
                ProceedToCheckout.withData(firstName,lastName,postalCode)
        );
    }
    @When("the user completes the purchase")
    public void completes_purchase(){
        theActorCalled(actor.getName()).attemptsTo(
                CompletePurchase.andComplete()
        );
    }
    @Then("^the user should see the confirmation message (.*)$")
    public void the_user_should_see_the_confirmation_message(String messageConfirm){
        theActorInTheSpotlight().should(
            seeThat("The order was successfully confirmed", IsOrderConfirmed.title(),equalTo(messageConfirm))
        );
    }

}
