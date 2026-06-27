package com.demoblaze.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.demoblaze.ui.DemoblazeCar.PRODUCT_NAMES;

public class ValidateProductsCarDemoblazeQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateProductsCarDemoblazeQuestion.class);
    private final List<String> productsExpected;

    public ValidateProductsCarDemoblazeQuestion(List<String> productsExpected) {
        this.productsExpected = productsExpected;
    }

    public static ValidateProductsCarDemoblazeQuestion areDisplayed(List<String> productsExpected) {
        return new ValidateProductsCarDemoblazeQuestion(productsExpected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> productElements = PRODUCT_NAMES.resolveAllFor(actor);
        List<String> productsInCart = productElements.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());

        LOGGER.info("Productos esperados: {}", productsExpected);
        LOGGER.info("Productos encontrados en el carrito: {}", productsInCart);

        boolean result = new HashSet<>(productsInCart).containsAll(productsExpected);
        LOGGER.info("Resultado de la validación: {}", result);

        return result;
    }
}