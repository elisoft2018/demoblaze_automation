package com.demoblaze.tasks;

import com.demoblaze.ui.DemoblazeAddProductsToCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectProductDemoblazeTask implements Task {

    private final String productName;

    public SelectProductDemoblazeTask(String productName) {
        this.productName = productName;
    }

    public static SelectProductDemoblazeTask withName(String productName) {
        return Tasks.instrumented(SelectProductDemoblazeTask.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DemoblazeAddProductsToCar.PRODUCT_NAME.of(productName))
        );
    }
}