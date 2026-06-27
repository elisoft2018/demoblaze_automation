package com.demoblaze.questions;

import com.demoblaze.ui.DemoblazeCar;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ValidateTotalPriceShoppingDemoblazeQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTotalPriceShoppingDemoblazeQuestion.class);

    public static ValidateTotalPriceShoppingDemoblazeQuestion isCorrect() {
        return new ValidateTotalPriceShoppingDemoblazeQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // 1. Obtener la lista de precios individuales de la tabla
        List<WebElementFacade> priceElements = DemoblazeCar.PRODUCT_PRICES.resolveAllFor(actor);
        int calculatedTotal = priceElements.stream()
                .map(WebElementFacade::getText)
                .mapToInt(Integer::parseInt)
                .sum();

        // 2. Obtener el precio total mostrado por la página
        String totalDisplayedText = Text.of(DemoblazeCar.TOTAL_PRICE).answeredBy(actor);
        int totalDisplayed = Integer.parseInt(totalDisplayedText);

        LOGGER.info("Suma de precios individuales: {}", calculatedTotal);
        LOGGER.info("Total mostrado en pantalla: {}", totalDisplayed);

        return calculatedTotal == totalDisplayed;
    }
}