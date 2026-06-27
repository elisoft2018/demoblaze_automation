package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeCar {

    public static final Target CART_MENU = Target.the("Menú del carrito")
            .locatedBy("//*[@id='cartur']");

    public static final Target PRODUCT_LIST = Target.the("Lista de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']/tr");

    public static final Target PRODUCT_NAMES = Target.the("Nombres de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']//td[2]");

    public static final Target PRODUCT_PRICES = Target.the("Precios de productos en el carrito")
            .locatedBy("//tbody[@id='tbodyid']//td[3]");

    public static final Target TOTAL_PRICE = Target.the("Precio total del carrito")
            .locatedBy("//h3[@id='totalp']");

    public static final Target PLACE_ORDER_BUTTON = Target.the("Botón Place Order")
            .locatedBy("//button[contains(text(),'Place Order')]");

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
}