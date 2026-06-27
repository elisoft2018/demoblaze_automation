package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.DemoblazeOrderInformation.OK_BUTTON;

/**
 * Tarea para que un actor finalice el proceso de compra haciendo clic en el botón "OK"
 * del modal de confirmación final.
 */
public class FinalizedShoppingDemoblazeTask implements Task {

    /**
     * Realiza la acción de hacer clic en el botón "OK" para cerrar el modal de confirmación.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OK_BUTTON) // Hace clic en el botón OK del modal de confirmación
        );
    }

    /**
     * Método estático para instanciar la tarea.
     *
     * @return Una instancia de FinalizedShoppingDemoblazeTask.
     */
    public static FinalizedShoppingDemoblazeTask finalizedShoppingDemoblazeTask() {
        return Tasks.instrumented(FinalizedShoppingDemoblazeTask.class);
    }
}