package com.demoblaze.tasks;

import com.demoblaze.ui.DemoblazeAddProductsToCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Tarea para que un actor seleccione un producto específico haciendo clic en su nombre.
 * Esto generalmente lleva al actor a la página de detalles del producto.
 */
public class SelectProductDemoblazeTask implements Task {

    private final String productName;

    /**
     * Constructor de la tarea.
     *
     * @param productName El nombre del producto a seleccionar.
     */
    public SelectProductDemoblazeTask(String productName) {
        this.productName = productName;
    }

    /**
     * Método estático para instanciar la tarea con el nombre del producto.
     *
     * @param productName El nombre del producto a seleccionar.
     * @return Una instancia de SelectProductDemoblazeTask.
     */
    public static SelectProductDemoblazeTask withName(String productName) {
        return Tasks.instrumented(SelectProductDemoblazeTask.class, productName);
    }

    /**
     * Realiza la acción de seleccionar un producto.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DemoblazeAddProductsToCar.PRODUCT_NAME.of(productName)) // Hace clic en el nombre del producto
        );
    }
}