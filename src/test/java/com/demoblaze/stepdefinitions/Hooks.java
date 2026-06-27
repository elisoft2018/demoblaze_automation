package com.demoblaze.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("QA AUTOMATION");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }
}
