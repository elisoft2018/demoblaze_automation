package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeOrderInformation.PURCHASE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmOrderInformationTask implements Task {

    public static ConfirmOrderInformationTask confirmOrderInformationTask() {
        return instrumented(ConfirmOrderInformationTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PURCHASE_BUTTON)
                
        );
    }

}
