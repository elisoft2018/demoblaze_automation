package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Define los elementos de la interfaz de usuario relacionados con el formulario de información de la orden
 * y el modal de confirmación de compra en Demoblaze.
 */
public class DemoblazeOrderInformation {

    /**
     * Target para el campo de entrada "Name" (Nombre) en el formulario de la orden.
     */
    public static final Target NAME_FIELD = Target.the("Campo Name")
            .locatedBy("//input[@id='name']");

    /**
     * Target para el campo de entrada "Country" (País) en el formulario de la orden.
     */
    public static final Target COUNTRY_FIELD = Target.the("Campo Country")
            .locatedBy("//input[@id='country']");

    /**
     * Target para el campo de entrada "City" (Ciudad) en el formulario de la orden.
     */
    public static final Target CITY_FIELD = Target.the("Campo City")
            .locatedBy("//input[@id='city']");

    /**
     * Target para el campo de entrada "Credit Card" (Tarjeta de Crédito) en el formulario de la orden.
     */
    public static final Target CREDIT_CARD_FIELD = Target.the("Campo Credit Card")
            .locatedBy("//input[@id='card']");

    /**
     * Target para el campo de entrada "Month" (Mes) en el formulario de la orden.
     */
    public static final Target MONTH_FIELD = Target.the("Campo Month")
            .locatedBy("//input[@id='month']");

    /**
     * Target para el campo de entrada "Year" (Año) en el formulario de la orden.
     */
    public static final Target YEAR_FIELD = Target.the("Campo Year")
            .locatedBy("//input[@id='year']");

    /**
     * Target para el botón "Purchase" (Comprar) dentro del formulario de la orden.
     */
    public static final Target PURCHASE_BUTTON = Target.the("Botón Purchase")
            .locatedBy("//button[contains(text(),'Purchase')]");

    /**
     * Target para el botón "OK" en el modal de confirmación final de la compra.
     */
    public static final Target OK_BUTTON = Target.the("Botón OK")
            .locatedBy("//button[contains(text(),'OK')]");

    /**
     * Target para el mensaje de confirmación de compra (generalmente el título "Thank you for your purchase!").
     */
    public static final Target PURCHASE_CONFIRMATION_MESSAGE = Target.the("Mensaje de confirmación de compra")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

    /**
     * Target para el resumen de la información de la orden que aparece en el modal de confirmación.
     * Contiene detalles como ID, monto, número de tarjeta, nombre y fecha.
     */
    public static final Target SUMMARY_ORDER_INFORMATION = Target.the("Resumen de información de la orden")
            .locatedBy("//p[contains(@class, 'lead text-muted')]");

    /**
     * Target para el título principal del modal de confirmación de compra, que suele ser "Thank you for your purchase!".
     */
    public static final Target PURCHASE_CONFIRMATION_TITLE = Target.the("Título de confirmación de compra")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

    /**
     * Target para el precio total del carrito, que se muestra en el modal de confirmación.
     */
    public static final Target TOTAL_PRICE_CART = Target.the("Precio total del carrito")
            .locatedBy("//h3[@id='totalp']");
}