package com.demoblaze.tasks;

import com.demoblaze.ui.DemoblazeAddProductsToCar;
import com.demoblaze.ui.DemoblazeHomePage;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddProductDemoblazeToCarTask implements Task {

    private final DataTable dataProduct;

    public AddProductDemoblazeToCarTask(DataTable dataProduct) {
        this.dataProduct = dataProduct;
    }

    public static AddProductDemoblazeToCarTask addProductDemoblazeToCarTask(DataTable dataProduct) {
        return Tasks.instrumented(AddProductDemoblazeToCarTask.class, dataProduct);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> products = dataProduct.column(0).subList(1, dataProduct.height());
        for (String product : products) {
            actor.attemptsTo(
                    WaitUntil.the(DemoblazeAddProductsToCar.PRODUCT_NAME.of(product), isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(DemoblazeAddProductsToCar.PRODUCT_NAME.of(product)),
                    WaitUntil.the(DemoblazeAddProductsToCar.ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(DemoblazeAddProductsToCar.ADD_TO_CART_BUTTON),
                    WaitUntil.the(ExpectedConditions.alertIsPresent()),
                    Switch.toAlert().andAccept(),
                    Click.on(DemoblazeHomePage.HOME_MENU)
            );
        }
    }
}