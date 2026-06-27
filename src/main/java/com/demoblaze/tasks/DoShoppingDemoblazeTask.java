package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeCar.CART_MENU;

/**
 * Tarea para que un actor navegue al carrito de compras.
 * Simplemente hace clic en el menú del carrito.
 */
public class DoShoppingDemoblazeTask implements Task {

    /**
     * Realiza la acción de navegar al carrito de compras.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_MENU)); // Hace clic en el menú del carrito
    }

    /**
     * Método estático para instanciar la tarea.
     *
     * @return Una instancia de DoShoppingDemoblazeTask.
     */
    public static DoShoppingDemoblazeTask doShoppingTask() {
        return Tasks.instrumented(DoShoppingDemoblazeTask.class);
    }
}