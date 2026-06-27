package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Define los elementos de la interfaz de usuario relacionados con la adición de productos al carrito
 * en la página de Demoblaze.
 */
public class DemoblazeAddProductsToCar {

    /**
     * Target para el nombre de un producto específico en la lista de productos.
     * Utiliza un placeholder '{0}' para el nombre del producto, permitiendo un localizador dinámico.
     */
    public static final Target PRODUCT_NAME = Target.the("Producto {0}")
            .locatedBy("//a[contains(text(),'{0}')]");

    /**
     * Target para el botón "Add to cart" (Añadir al carrito) en la página de detalles del producto.
     */
    public static final Target ADD_TO_CART_BUTTON = Target.the("Botón Añadir al carrito")
            .locatedBy("//a[contains(text(),'Add to cart')]");
}