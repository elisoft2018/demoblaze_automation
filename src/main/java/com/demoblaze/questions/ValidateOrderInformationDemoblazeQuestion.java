package com.demoblaze.questions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.demoblaze.ui.DemoblazeOrderInformation.SUMMARY_ORDER_INFORMATION;

public class ValidateOrderInformationDemoblazeQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateOrderInformationDemoblazeQuestion.class);
    private final DataTable expectedData;

    public ValidateOrderInformationDemoblazeQuestion(DataTable expectedData) {
        this.expectedData = expectedData;
    }

    public static ValidateOrderInformationDemoblazeQuestion with(DataTable expectedData) {
        return new ValidateOrderInformationDemoblazeQuestion(expectedData);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String summaryText = Text.of(SUMMARY_ORDER_INFORMATION).answeredBy(actor);
        Map<String, String> expectedMap = expectedData.asMap(String.class, String.class);

        String expectedName = expectedMap.get("Name");
        String expectedCard = expectedMap.get("Card");

        LOGGER.info("Resumen obtenido del modal: {}", summaryText.replace("\n", " | "));
        LOGGER.info("Buscando Nombre: {}", expectedName);
        LOGGER.info("Buscando Tarjeta: {}", expectedCard);

        boolean isNameCorrect = summaryText.contains("Name: " + expectedName);
        boolean isCardCorrect = summaryText.contains("Card Number: " + expectedCard);

        LOGGER.info("¿Nombre correcto?: {}", isNameCorrect);
        LOGGER.info("¿Tarjeta correcta?: {}", isCardCorrect);

        return isNameCorrect && isCardCorrect;
    }
}