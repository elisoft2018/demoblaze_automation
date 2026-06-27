package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Define los elementos de la interfaz de usuario relacionados con la visualización de productos
 * en el carrito de compras de Demoblaze.
 */
public class DemoblazeProductsCar {

    /**
     * Target para la lista de nombres de productos que se muestran en el carrito.
     * Apunta a la segunda columna (td) de las filas de productos con clase 'success'.
     */
    public static final Target PRODUCT_LIST = Target.the("Lista de productos en el carrito")
            .locatedBy("//tr[@class='success']/td[2]");
}