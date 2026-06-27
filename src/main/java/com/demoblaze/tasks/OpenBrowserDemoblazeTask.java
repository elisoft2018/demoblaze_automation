package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Tarea para que un actor abra el navegador y navegue a la página principal de Demoblaze.
 * También maximiza la ventana del navegador.
 */
public class OpenBrowserDemoblazeTask implements Task {

    /**
     * Realiza la acción de abrir el navegador y navegar a la URL base de Demoblaze.
     *
     * @param actor El actor que realizará la tarea.
     * @param <T>   Tipo de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abre la URL de la aplicación Demoblaze.
        // La URL base se configura en serenity.properties o serenity.conf
        actor.attemptsTo(Open.url("https://www.demoblaze.com/"));
        // Maximiza la ventana del navegador para asegurar la visibilidad de los elementos.
        actor.attemptsTo(Browser.maximize());
    }

    /**
     * Método estático para instanciar la tarea.
     *
     * @return Una instancia de OpenBrowserDemoblazeTask.
     */
    public static OpenBrowserDemoblazeTask openBrowserTask() {
        return Tasks.instrumented(OpenBrowserDemoblazeTask.class);
    }
}