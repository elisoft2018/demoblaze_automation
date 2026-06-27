package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeOrderInformation.OK_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinalizedShoppingDemoblazeTask implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OK_BUTTON)
        );
    }

    public static FinalizedShoppingDemoblazeTask finalizedShoppingDemoblazeTask(){
        return instrumented(FinalizedShoppingDemoblazeTask.class);
    }
}
