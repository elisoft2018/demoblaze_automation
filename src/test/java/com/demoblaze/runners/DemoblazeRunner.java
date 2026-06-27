package com.demoblaze.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Indica a JUnit que ejecute los escenarios usando el runner de Serenity con Cucumber.
@RunWith(CucumberWithSerenity.class)
// Configura la ubicacion de features, tags, formato de snippets y paquete de glue.
@CucumberOptions(
        // Define la carpeta donde se encuentran todos los archivos feature.
        features = "src/test/resources/features/",
        // Ejecuta actualmente solo los escenarios marcados con este tag.
        tags = "@shoppingFlow",
        // Genera nombres de metodos de step definitions en estilo camelCase.
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        // Define el paquete donde Cucumber debe buscar los steps y hooks.
        glue = "com.demoblaze.stepdefinitions",
        monochrome = true
)

public class DemoblazeRunner {
}