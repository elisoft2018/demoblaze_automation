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

public class OrdeInformationDemoblazeTask implements Task {

    private final DataTable customerData;

    public OrdeInformationDemoblazeTask(DataTable customerData) {
        this.customerData = customerData;
    }

    public static OrdeInformationDemoblazeTask ordeInformationDemoblazeTask(DataTable customerData) {
        return Tasks.instrumented(OrdeInformationDemoblazeTask.class, customerData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = customerData.asMap(String.class, String.class);

        actor.attemptsTo(
                WaitUntil.the(DemoblazeCar.PLACE_ORDER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DemoblazeCar.PLACE_ORDER_BUTTON),
                Enter.theValue(data.get("Name")).into(DemoblazeOrderInformation.NAME_FIELD),
                Enter.theValue(data.get("Country")).into(DemoblazeOrderInformation.COUNTRY_FIELD),
                Enter.theValue(data.get("City")).into(DemoblazeOrderInformation.CITY_FIELD),
                Enter.theValue(data.get("Card")).into(DemoblazeOrderInformation.CREDIT_CARD_FIELD),
                Enter.theValue(data.get("Month")).into(DemoblazeOrderInformation.MONTH_FIELD),
                Enter.theValue(data.get("Year")).into(DemoblazeOrderInformation.YEAR_FIELD)
        );
    }
}