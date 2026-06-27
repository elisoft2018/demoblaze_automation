package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBrowserDemoblazeTask implements Task{
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abre la URL del login de la aplicacion Serenity Demo.
        actor.attemptsTo(Open.url("https://www.demoblaze.com/"));
        // Maximiza la ventana para reducir problemas de visibilidad en los elementos.
        actor.attemptsTo(Browser.maximize());
    }

    // Metodo fabrica para crear el task instrumentado por Serenity.
    public static OpenBrowserDemoblazeTask openBrowserTask() {
        // Retorna una instancia del task lista para ser ejecutada por el actor.
        return instrumented(OpenBrowserDemoblazeTask.class);
    }


}
