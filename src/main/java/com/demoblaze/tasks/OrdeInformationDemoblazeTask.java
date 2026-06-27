package com.demoblaze.tasks;

import com.demoblaze.ui.DemoblazeCar;
import com.demoblaze.ui.DemoblazeOrderInformation;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

/**
 * Tarea para que un actor ingrese la información de la orden de compra
 * en el formulario del modal de "Place Order" en Demoblaze.
 * Los datos del cliente se obtienen de un DataTable proporcionado por el feature.
 */
public class OrdeInformationDemoblazeTask implements Task {

    private final DataTable customerData;

    /**
     * Constructor de la tarea.
     *
     * @param customerData DataTable que contiene la información del cliente para la orden.
     *                     Se espera que sea un mapa con claves como "Name", "Country", "City", "Card", "Month", "Year".
     */
    public OrdeInformationDemoblazeTask(DataTable customerData) {
        this.customerData = customerData;
    }

    /**
     * Método estático para instanciar la tarea.
     *
     * @param customerData DataTable con la información del cliente.
     * @return Una instancia de OrdeInformationDemoblazeTask.
     */
    public static OrdeInformationDemoblazeTask ordeInformationDemoblazeTask(DataTable customerData) {
        return Tasks.instrumented(OrdeInformationDemoblazeTask.class, customerData);
    }

    /**
     * Realiza la tarea de llenar el formulario de la orden de compra.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Convierte el DataTable en un mapa para acceder a los datos por nombre de campo
        Map<String, String> data = customerData.asMap(String.class, String.class);

        actor.attemptsTo(
                // Espera a que el botón "Place Order" sea clickeable y hace clic en él
                WaitUntil.the(DemoblazeCar.PLACE_ORDER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DemoblazeCar.PLACE_ORDER_BUTTON),

                // Ingresa los valores en los campos del formulario usando los datos del mapa
                Enter.theValue(data.get("Name")).into(DemoblazeOrderInformation.NAME_FIELD),
                Enter.theValue(data.get("Country")).into(DemoblazeOrderInformation.COUNTRY_FIELD),
                Enter.theValue(data.get("City")).into(DemoblazeOrderInformation.CITY_FIELD),
                Enter.theValue(data.get("Card")).into(DemoblazeOrderInformation.CREDIT_CARD_FIELD),
                Enter.theValue(data.get("Month")).into(DemoblazeOrderInformation.MONTH_FIELD),
                Enter.theValue(data.get("Year")).into(DemoblazeOrderInformation.YEAR_FIELD)
                // Nota: El botón "Purchase" se hace clic en la tarea ConfirmOrderInformationTask
        );
    }
}