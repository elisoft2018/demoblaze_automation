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

/**
 * Clase que define los Step Definitions para el flujo de compra en Demoblaze.
 * Conecta los pasos de Gherkin con las Tareas y Preguntas de Serenity Screenplay.
 */
public class ShoppingFlowDemoblazeStepDefinitions {

    /**
     * Almacena la lista de nombres de productos que el cliente desea añadir al carrito.
     * Se utiliza para pasar los datos entre los pasos del escenario.
     */
    private List<String> products;

    /**
     * Almacena la información del cliente proporcionada para la orden de compra.
     * Se utiliza para pasar los datos entre los pasos del escenario.
     */
    private DataTable customerData;

    /**
     * Paso Given: El cliente abre la página principal de Demoblaze.
     *
     * @Given "the customer opens the Demoblaze home page"
     */
    @Given("the customer opens the Demoblaze home page")
    public void theCustomerOpensTheDemoblazeHomePage() {
        theActorInTheSpotlight().wasAbleTo(
                OpenBrowserDemoblazeTask.openBrowserTask()
        );
    }

    /**
     * Paso When: El cliente añade los productos especificados a la tabla al carrito de compras.
     *
     * @When "the customer adds the following products to the shopping cart"
     * @param dataTable DataTable que contiene los nombres de los productos.
     */
    @When("the customer adds the following products to the shopping cart")
    public void theCustomerAddsTheFollowingProductsToTheShoppingCart(DataTable dataTable) {
        // Extrae los nombres de los productos del DataTable y los guarda para futuras validaciones
        this.products = dataTable.column(0).subList(1, dataTable.height());
        theActorInTheSpotlight().attemptsTo(
                AddProductDemoblazeToCarTask.addProductDemoblazeToCarTask(dataTable)
        );
    }

    /**
     * Paso When: El cliente abre el carrito de compras.
     *
     * @When "the customer opens the shopping cart"
     */
    @When("the customer opens the shopping cart")
    public void theCustomerOpensTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                DoShoppingDemoblazeTask.doShoppingTask()
        );
    }

    /**
     * Paso Then: El carrito de compras debería mostrar los productos seleccionados.
     *
     * @Then "the shopping cart should display the selected products"
     */
    @Then("the shopping cart should display the selected products")
    public void theShoppingCartShouldDisplayTheSelectedProducts() {
        theActorInTheSpotlight().should(
                // Valida que los productos esperados estén en el carrito
                seeThat(ValidateProductsCarDemoblazeQuestion.areDisplayed(products), is(true))
        );
    }

    /**
     * Paso When: El cliente ingresa la información de la orden de compra.
     *
     * @When "the customer places the order with the following information"
     * @param dataTable DataTable que contiene la información del cliente (Name, Country, City, Card, Month, Year).
     */
    @When("the customer places the order with the following information")
    public void theCustomerPlacesTheOrderWithTheFollowingInformation(DataTable dataTable) {
        // Guarda la información del cliente para futuras validaciones
        this.customerData = dataTable;
        theActorInTheSpotlight().attemptsTo(
                OrdeInformationDemoblazeTask.ordeInformationDemoblazeTask(dataTable)
        );
    }

    /**
     * Paso When: El cliente confirma la compra.
     *
     * @When "the customer confirms the purchase"
     */
    @When("the customer confirms the purchase")
    public void theCustomerConfirmsThePurchase() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmOrderInformationTask.confirmOrderInformationTask()
        );
    }

    /**
     * Paso Then: La compra debería completarse exitosamente.
     *
     * @Then "the purchase should be completed successfully"
     */
    @Then("the purchase should be completed successfully")
    public void thePurchaseShouldBeCompletedSuccessfully() {
        theActorInTheSpotlight().should(
                // Valida que la información de la orden en el modal sea correcta
                seeThat(ValidateOrderInformationDemoblazeQuestion.with(customerData), is(true)),
                // Valida que el precio total calculado sea correcto
                seeThat(ValidateTotalPriceShoppingDemoblazeQuestion.isCorrect(), is(true))
        );
    }

    /**
     * Paso Then: El mensaje de confirmación debería contener un texto específico.
     *
     * @Then "the confirmation message should contain {string}"
     * @param expectedMessage El mensaje esperado en el modal de confirmación.
     */
    @Then("the confirmation message should contain {string}")
    public void theConfirmationMessageShouldContain(String expectedMessage) {
        theActorInTheSpotlight().should(
                // Valida que el título del modal de confirmación contenga el mensaje esperado
                seeThat(ValidateMessageCreateOrderDemoblazeQuestion.areDisplayed(), containsString(expectedMessage))
        );

        // Cierra el modal de confirmación para finalizar el flujo
        theActorInTheSpotlight().attemptsTo(
                FinalizedShoppingDemoblazeTask.finalizedShoppingDemoblazeTask()
        );
    }
}