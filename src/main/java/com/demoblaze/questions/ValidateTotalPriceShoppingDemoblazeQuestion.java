package com.demoblaze.questions;

import com.demoblaze.ui.DemoblazeCar;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.demoblaze.ui.DemoblazeCar.PRODUCT_PRICES;

/**
 * Pregunta para validar que el precio total mostrado en el carrito de compras
 * coincide con la suma de los precios individuales de los productos listados.
 */
public class ValidateTotalPriceShoppingDemoblazeQuestion implements Question<Boolean> {

    /**
     * Logger para registrar información de depuración y seguimiento.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTotalPriceShoppingDemoblazeQuestion.class);

    /**
     * Método estático para instanciar la pregunta.
     *
     * @return Una instancia de ValidateTotalPriceShoppingDemoblazeQuestion.
     */
    public static ValidateTotalPriceShoppingDemoblazeQuestion isCorrect() {
        return new ValidateTotalPriceShoppingDemoblazeQuestion();
    }

    /**
     * Responde la pregunta calculando la suma de los precios individuales de los productos
     * y comparándola con el precio total mostrado en la interfaz de usuario.
     *
     * @param actor El actor que realiza la pregunta.
     * @param <T>   Tipo de Actor.
     * @return true si la suma calculada coincide con el total mostrado, false en caso contrario.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        // 1. Obtener la lista de precios individuales de la tabla del carrito
        List<WebElementFacade> priceElements = PRODUCT_PRICES.resolveAllFor(actor);
        // Suma los precios de los productos. Se asume que los precios son enteros.
        int calculatedTotal = priceElements.stream()
                .map(WebElementFacade::getText) // Obtiene el texto del precio (ej. "360")
                .mapToInt(Integer::parseInt)   // Convierte el texto a entero
                .sum();                        // Suma todos los enteros

        // 2. Obtener el precio total mostrado por la página (elemento h3 con id='totalp')
        String totalDisplayedText = Text.of(DemoblazeCar.TOTAL_PRICE).answeredBy(actor);
        int totalDisplayed = Integer.parseInt(totalDisplayedText);

        // Registra los valores para depuración
        LOGGER.info("Suma de precios individuales calculada: {}", calculatedTotal);
        LOGGER.info("Total mostrado en pantalla: {}", totalDisplayed);

        // Compara la suma calculada con el total mostrado y retorna el resultado
        return calculatedTotal == totalDisplayed;
    }
}