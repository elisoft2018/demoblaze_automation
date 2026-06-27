package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeCar.CART_MENU;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoShoppingDemoblazeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(CART_MENU));

    }
    public static DoShoppingDemoblazeTask doShoppingTask() {

        return instrumented(DoShoppingDemoblazeTask.class);

    }

}
