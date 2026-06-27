package com.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.demoblaze.ui.DemoblazeOrderInformation.PURCHASE_CONFIRMATION_TITLE;

public class ValidateMessageCreateOrderDemoblazeQuestion implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateMessageCreateOrderDemoblazeQuestion.class);

    public static ValidateMessageCreateOrderDemoblazeQuestion areDisplayed() {
        return new ValidateMessageCreateOrderDemoblazeQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        String confirmationMessage = Text.of(PURCHASE_CONFIRMATION_TITLE).answeredBy(actor);
        LOGGER.info("Mensaje de confirmación obtenido del modal: {}", confirmationMessage);
        return confirmationMessage;
    }
}