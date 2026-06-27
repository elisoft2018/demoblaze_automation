package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeAddProductsToCar {
    public static final Target PRODUCT_NAME = Target.the("Producto {0}")
            .locatedBy("//a[contains(text(),'{0}')]");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Botón Añadir al carrito")
            .locatedBy("//a[contains(text(),'Add to cart')]");

}
