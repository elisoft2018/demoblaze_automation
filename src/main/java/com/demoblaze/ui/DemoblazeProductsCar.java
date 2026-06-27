package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeProductsCar {

    public static final Target PRODUCT_LIST = Target.the("Lista de productos en el carrito")
            .locatedBy("//tr[@class='success']/td[2]");
}
