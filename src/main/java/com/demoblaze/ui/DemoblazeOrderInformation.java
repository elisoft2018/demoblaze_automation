package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeOrderInformation {
    public static final Target NAME_FIELD = Target.the("Campo Name")
            .locatedBy("//input[@id='name']");

    public static final Target COUNTRY_FIELD = Target.the("Campo Country")
            .locatedBy("//input[@id='country']");

    public static final Target CITY_FIELD = Target.the("Campo City")
            .locatedBy("//input[@id='city']");

    public static final Target CREDIT_CARD_FIELD = Target.the("Campo Credit Card")
            .locatedBy("//input[@id='card']");

    public static final Target MONTH_FIELD = Target.the("Campo Month")
            .locatedBy("//input[@id='month']");

    public static final Target YEAR_FIELD = Target.the("Campo Year")
            .locatedBy("//input[@id='year']");

    public static final Target PURCHASE_BUTTON = Target.the("Botón Purchase")
            .locatedBy("//button[contains(text(),'Purchase')]");

    public static final Target OK_BUTTON = Target.the("Botón OK")
            .locatedBy("//button[contains(text(),'OK')]");

    public static final Target PURCHASE_CONFIRMATION_MESSAGE = Target.the("Mensaje de confirmación de compra")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");
    public static final Target SUMMARY_ORDER_INFORMATION = Target.the("Resumen de información de la orden")
            .locatedBy("//p[contains(@class, 'lead text-muted')]");

    public static final Target PURCHASE_CONFIRMATION_TITLE = Target.the("Título de confirmación de compra")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

    public static final Target TOTAL_PRICE_CART = Target.the("Precio total del carrito")
            .locatedBy("//h3[@id='totalp']");

}
