package com.demoblaze.questions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.demoblaze.ui.DemoblazeOrderInformation.SUMMARY_ORDER_INFORMATION;

/**
 * Pregunta para validar la información de la orden de compra mostrada en el modal de resumen
 * después de una compra exitosa. Compara los datos esperados del feature con los datos reales
 * extraídos del modal.
 */
public class ValidateOrderInformationDemoblazeQuestion implements Question<Boolean> {

    /**
     * Logger para registrar información de depuración y seguimiento.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateOrderInformationDemoblazeQuestion.class);

    private final DataTable expectedData;

    /**
     * Constructor de la pregunta.
     *
     * @param expectedData DataTable que contiene la información del cliente esperada (Name, Card, etc.).
     */
    public ValidateOrderInformationDemoblazeQuestion(DataTable expectedData) {
        this.expectedData = expectedData;
    }

    /**
     * Método estático para instanciar la pregunta.
     *
     * @param expectedData DataTable con la información esperada.
     * @return Una instancia de ValidateOrderInformationDemoblazeQuestion.
     */
    public static ValidateOrderInformationDemoblazeQuestion with(DataTable expectedData) {
        return new ValidateOrderInformationDemoblazeQuestion(expectedData);
    }

    /**
     * Responde la pregunta validando la información de la orden.
     *
     * @param actor El actor que realiza la pregunta.
     * @param <T>   Tipo de Actor.
     * @return true si el nombre y el número de tarjeta esperados se encuentran en el resumen del modal, false en caso contrario.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtiene el texto completo del resumen de la orden del modal
        String summaryText = Text.of(SUMMARY_ORDER_INFORMATION).answeredBy(actor);
        // Convierte el DataTable de datos esperados en un mapa para fácil acceso
        Map<String, String> expectedMap = expectedData.asMap(String.class, String.class);

        String expectedName = expectedMap.get("Name");
        String expectedCard = expectedMap.get("Card");

        // Registra los datos para depuración
        LOGGER.info("Resumen obtenido del modal: {}", summaryText.replace("\n", " | "));
        LOGGER.info("Buscando Nombre: {}", expectedName);
        LOGGER.info("Buscando Tarjeta: {}", expectedCard);

        // Verifica si el nombre y el número de tarjeta esperados están presentes en el texto del resumen
        boolean isNameCorrect = summaryText.contains("Name: " + expectedName);
        boolean isCardCorrect = summaryText.contains("Card Number: " + expectedCard);

        // Registra los resultados de las validaciones individuales
        LOGGER.info("¿Nombre correcto?: {}", isNameCorrect);
        LOGGER.info("¿Tarjeta correcta?: {}", isCardCorrect);

        // Retorna true si ambas validaciones son correctas
        return isNameCorrect && isCardCorrect;
    }
}