package com.demoblaze.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:webdriver.base.url")
public class DemoblazeHomePage extends PageObject {

    public static final Target HOME_MENU = Target.the("Enlace de Inicio (Home)")
            .locatedBy("//a[contains(text(),'Home')]");

}
