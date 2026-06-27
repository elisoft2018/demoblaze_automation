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

/**
 * Pregunta para validar que los productos esperados se visualizan correctamente en el carrito de compras.
 * Compara la lista de productos esperados con los nombres de los productos realmente presentes en el carrito.
 */
public class ValidateProductsCarDemoblazeQuestion implements Question<Boolean> {

    /**
     * Logger para registrar información de depuración y seguimiento.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateProductsCarDemoblazeQuestion.class);

    private final List<String> productsExpected;

    /**
     * Constructor de la pregunta.
     *
     * @param productsExpected Lista de nombres de productos que se esperan encontrar en el carrito.
     */
    public ValidateProductsCarDemoblazeQuestion(List<String> productsExpected) {
        this.productsExpected = productsExpected;
    }

    /**
     * Método estático para instanciar la pregunta.
     *
     * @param productsExpected Lista de nombres de productos esperados.
     * @return Una instancia de ValidateProductsCarDemoblazeQuestion.
     */
    public static ValidateProductsCarDemoblazeQuestion areDisplayed(List<String> productsExpected) {
        return new ValidateProductsCarDemoblazeQuestion(productsExpected);
    }

    /**
     * Responde la pregunta obteniendo los nombres de los productos en el carrito
     * y comparándolos con la lista de productos esperados.
     *
     * @param actor El actor que realiza la pregunta.
     * @param <T>   Tipo de Actor.
     * @return true si todos los productos esperados están presentes en el carrito, false en caso contrario.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        // Resuelve todos los elementos que representan los nombres de los productos en el carrito
        List<WebElementFacade> productElements = PRODUCT_NAMES.resolveAllFor(actor);
        // Extrae el texto de cada elemento para obtener los nombres de los productos en el carrito
        List<String> productsInCart = productElements.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());

        // Registra los productos esperados y los encontrados para depuración
        LOGGER.info("Productos esperados: {}", productsExpected);
        LOGGER.info("Productos encontrados en el carrito: {}", productsInCart);

        // Compara si la lista de productos en el carrito contiene todos los productos esperados
        // Se usa HashSet para una comparación eficiente y para manejar duplicados si los hubiera, aunque en este caso no es crítico.
        boolean result = new HashSet<>(productsInCart).containsAll(productsExpected);
        LOGGER.info("Resultado de la validación: {}", result);

        return result;
    }
}