package com.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Clase Runner para ejecutar los escenarios de Cucumber con Serenity BDD.
 * Configura la ubicación de los archivos feature, tags, formato de snippets y el paquete de glue.
 */
@RunWith(CucumberWithSerenity.class) // Indica a JUnit que ejecute los escenarios usando el runner de Serenity con Cucumber.
@CucumberOptions(
        // Define la carpeta donde se encuentran todos los archivos feature.
        features = "src/test/resources/features/",
        // Ejecuta actualmente solo los escenarios marcados con este tag.
        tags = "@shoppingFlow",
        // Genera nombres de métodos de step definitions en estilo camelCase.
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        // Define el paquete donde Cucumber debe buscar los steps y hooks.
        glue = "com.demoblaze.stepdefinitions",
        // Asegura que la salida de la consola sea legible y sin caracteres extraños.
        monochrome = true
)
public class DemoblazeRunner {
}