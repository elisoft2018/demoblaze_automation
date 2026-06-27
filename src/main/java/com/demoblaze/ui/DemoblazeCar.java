package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Define los elementos de la interfaz de usuario relacionados con el carrito de compras
 * y el modal de "Place Order" en Demoblaze.
 */
public class DemoblazeCar {

    /**
     * Target para el enlace del menú "Cart" (Carrito).
     */
    public static final Target CART_MENU = Target.the("Menú del carrito")
            .locatedBy("//*[@id='cartur']");

    /**
     * Target para la lista de productos dentro de la tabla del carrito.
     * Representa cada fila (tr) dentro del tbody con id 'tbodyid'.
     */
    public static final Target PRODUCT_LIST = Target.the("Lista de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']/tr");

    /**
     * Target para los nombres de los productos mostrados en el carrito.
     * Apunta a la segunda columna (td) de cada fila de producto.
     */
    public static final Target PRODUCT_NAMES = Target.the("Nombres de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']//td[2]");

    /**
     * Target para los precios de los productos mostrados en el carrito.
     * Apunta a la tercera columna (td) de cada fila de producto.
     */
    public static final Target PRODUCT_PRICES = Target.the("Precios de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']//td[3]");

    /**
     * Target para el precio total mostrado en el carrito.
     */
    public static final Target TOTAL_PRICE = Target.the("Precio total del carrito")
            .locatedBy("//h3[@id='totalp']");

    /**
     * Target para el botón "Place Order" (Realizar Pedido) dentro del carrito.
     */
    public static final Target PLACE_ORDER_BUTTON = Target.the("Botón Place Order")
            .locatedBy("//button[contains(text(),'Place Order')]");

    // --- Campos del formulario "Place Order" ---

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
}