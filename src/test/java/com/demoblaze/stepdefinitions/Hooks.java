package com.demoblaze.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

/**
 * Clase que contiene los Hooks (ganchos) de Cucumber para configurar el entorno
 * antes y después de la ejecución de los escenarios.
 */
public class Hooks {

    /**
     * Inyecta una instancia de WebDriver gestionada por Serenity BDD.
     * Serenity se encarga de inicializar y cerrar el navegador.
     */
    @Managed
    WebDriver driver;

    /**
     * Hook que se ejecuta antes de cada escenario de Cucumber.
     * Configura el escenario de Screenplay:
     * 1. Establece el "Stage" (escenario) para los actores.
     * 2. Crea un actor llamado "QA AUTOMATION".
     * 3. Le da al actor la habilidad de "BrowseTheWeb" (navegar por la web) con la instancia del WebDriver.
     */
    @Before
    public void setUp() {
        // Establece el escenario para los actores de Screenplay
        OnStage.setTheStage(Cast.ofStandardActors());
        // Crea un actor con el nombre "QA AUTOMATION"
        OnStage.theActorCalled("QA AUTOMATION");
        // Le otorga al actor la habilidad de navegar por la web con el WebDriver gestionado
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }
}