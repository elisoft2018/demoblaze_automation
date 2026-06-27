package com.demoblaze.stepdefinitions;

import com.demoblaze.questions.ValidateMessageCreateOrderDemoblazeQuestion;
import com.demoblaze.questions.ValidateOrderInformationDemoblazeQuestion;
import com.demoblaze.questions.ValidateProductsCarDemoblazeQuestion;
import com.demoblaze.questions.ValidateTotalPriceShoppingDemoblazeQuestion;
import com.demoblaze.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ShoppingFlowDemoblazeStepDefinitions {

    private List<String> products;
    private DataTable customerData;

    @Given("the customer opens the Demoblaze home page")
    public void theCustomerOpensTheDemoblazeHomePage() {
        theActorInTheSpotlight().wasAbleTo(
                OpenBrowserDemoblazeTask.openBrowserTask()
        );
    }

    @When("the customer adds the following products to the shopping cart")
    public void theCustomerAddsTheFollowingProductsToTheShoppingCart(DataTable dataTable) {
        this.products = dataTable.column(0).subList(1, dataTable.height());
        theActorInTheSpotlight().attemptsTo(
                AddProductDemoblazeToCarTask.addProductDemoblazeToCarTask(dataTable)
        );
    }

    @When("the customer opens the shopping cart")
    public void theCustomerOpensTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                DoShoppingDemoblazeTask.doShoppingTask()
        );
    }

    @Then("the shopping cart should display the selected products")
    public void theShoppingCartShouldDisplayTheSelectedProducts() {
        theActorInTheSpotlight().should(
                seeThat(ValidateProductsCarDemoblazeQuestion.areDisplayed(products), is(true))
        );
    }

    @When("the customer places the order with the following information")
    public void theCustomerPlacesTheOrderWithTheFollowingInformation(DataTable dataTable) {
        this.customerData = dataTable;
        theActorInTheSpotlight().attemptsTo(
                OrdeInformationDemoblazeTask.ordeInformationDemoblazeTask(dataTable)
        );
    }

    @When("the customer confirms the purchase")
    public void theCustomerConfirmsThePurchase() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmOrderInformationTask.confirmOrderInformationTask()
        );
    }

    @Then("the purchase should be completed successfully")
    public void thePurchaseShouldBeCompletedSuccessfully() {
        theActorInTheSpotlight().should(
                seeThat(ValidateOrderInformationDemoblazeQuestion.with(customerData), is(true))
        );
        theActorInTheSpotlight().should(
                seeThat(ValidateTotalPriceShoppingDemoblazeQuestion.isCorrect(),is(true))
        );
    }

    @Then("the confirmation message should contain {string}")
    public void theConfirmationMessageShouldContain(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat(ValidateMessageCreateOrderDemoblazeQuestion.areDisplayed(), containsString(expectedMessage))
        );

        theActorInTheSpotlight().attemptsTo(

                FinalizedShoppingDemoblazeTask.finalizedShoppingDemoblazeTask()

        );
    }

}