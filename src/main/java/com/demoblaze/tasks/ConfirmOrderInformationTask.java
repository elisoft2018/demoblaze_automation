package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeOrderInformation.PURCHASE_BUTTON;

/**
 * Tarea para que un actor confirme la orden de compra haciendo clic en el botón "Purchase".
 * Esta tarea asume que el formulario de la orden ya ha sido llenado y el modal está visible.
 */
public class ConfirmOrderInformationTask implements Task {

    /**
     * Método estático para instanciar la tarea.
     *
     * @return Una instancia de ConfirmOrderInformationTask.
     */
    public static ConfirmOrderInformationTask confirmOrderInformationTask() {
        return Tasks.instrumented(ConfirmOrderInformationTask.class);
    }

    /**
     * Realiza la acción de confirmar la orden.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PURCHASE_BUTTON) // Hace clic en el botón de compra
        );
    }
}