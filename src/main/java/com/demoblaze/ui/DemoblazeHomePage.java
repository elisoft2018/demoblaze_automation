package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Representa la página principal de Demoblaze.
 * Define la URL por defecto y los elementos clave de la interfaz de usuario en esta página.
 */

public class DemoblazeHomePage {

    /**
     * Target para el enlace del menú "Home" (Inicio).
     * Utilizado para navegar de vuelta a la página principal.
     */
    public static final Target HOME_MENU = Target.the("Enlace de Inicio (Home)")
            .locatedBy("//a[contains(text(),'Home')]");
}