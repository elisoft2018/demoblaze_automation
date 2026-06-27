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

/**
 * Tarea para que un actor añada múltiples productos al carrito de compras en Demoblaze.
 * Itera sobre una lista de productos, los selecciona, los añade al carrito,
 * acepta la alerta de confirmación y regresa a la página principal.
 */
public class AddProductDemoblazeToCarTask implements Task {

    private final DataTable dataProduct;

    /**
     * Constructor de la tarea.
     *
     * @param dataProduct DataTable que contiene la lista de productos a añadir.
     *                    Se espera que la primera columna contenga los nombres de los productos.
     */
    public AddProductDemoblazeToCarTask(DataTable dataProduct) {
        this.dataProduct = dataProduct;
    }

    /**
     * Método estático para instanciar la tarea.
     *
     * @param dataProduct DataTable que contiene la lista de productos a añadir.
     * @return Una instancia de AddProductDemoblazeToCarTask.
     */
    public static AddProductDemoblazeToCarTask addProductDemoblazeToCarTask(DataTable dataProduct) {
        return Tasks.instrumented(AddProductDemoblazeToCarTask.class, dataProduct);
    }

    /**
     * Realiza la tarea de añadir productos al carrito.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Extrae la lista de nombres de productos de la primera columna del DataTable, omitiendo el encabezado.
        List<String> products = dataProduct.column(0).subList(1, dataProduct.height());
        for (String product : products) {
            actor.attemptsTo(
                    // Espera a que el nombre del producto sea clickeable en la página principal
                    WaitUntil.the(DemoblazeAddProductsToCar.PRODUCT_NAME.of(product), isClickable()).forNoMoreThan(10).seconds(),
                    // Hace clic en el nombre del producto para ir a su detalle
                    Click.on(DemoblazeAddProductsToCar.PRODUCT_NAME.of(product)),
                    // Espera a que el botón "Add to cart" sea clickeable en la página de detalle
                    WaitUntil.the(DemoblazeAddProductsToCar.ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                    // Hace clic en el botón "Add to cart"
                    Click.on(DemoblazeAddProductsToCar.ADD_TO_CART_BUTTON),
                    // Espera a que aparezca la alerta de confirmación
                    WaitUntil.the(ExpectedConditions.alertIsPresent()),
                    // Acepta la alerta
                    Switch.toAlert().andAccept(),
                    // Regresa a la página principal para añadir el siguiente producto
                    Click.on(DemoblazeHomePage.HOME_MENU)
            );
        }
    }
}