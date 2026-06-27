package com.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.demoblaze.ui.DemoblazeOrderInformation.PURCHASE_CONFIRMATION_TITLE;

/**
 * Pregunta para verificar el mensaje de confirmación de la orden de compra en el modal final.
 * Retorna el texto del título de confirmación para su posterior aserción.
 */
public class ValidateMessageCreateOrderDemoblazeQuestion implements Question<String> {

    /**
     * Logger para registrar información de depuración y seguimiento.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateMessageCreateOrderDemoblazeQuestion.class);

    /**
     * Método estático para instanciar la pregunta.
     *
     * @return Una instancia de ValidateMessageCreateOrderDemoblazeQuestion.
     */
    public static ValidateMessageCreateOrderDemoblazeQuestion areDisplayed() {
        return new ValidateMessageCreateOrderDemoblazeQuestion();
    }

    /**
     * Responde la pregunta obteniendo el texto del título de confirmación de compra.
     *
     * @param actor El actor que realiza la pregunta.
     * @param <T>   Tipo de Actor.
     * @return El texto del mensaje de confirmación de compra.
     */
    @Override
    public String answeredBy(Actor actor) {
        String confirmationMessage = Text.of(PURCHASE_CONFIRMATION_TITLE).answeredBy(actor);
        LOGGER.info("Mensaje de confirmación obtenido del modal: {}", confirmationMessage);
        return confirmationMessage;
    }
}