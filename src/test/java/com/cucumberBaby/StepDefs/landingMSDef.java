package com.cucumberBaby.StepDefs;

import com.cucumberBaby.POM.Factories.MicrosoftChallenge.LandingPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class landingMSDef {

    private LandingPagePOM landingPagePOM = new LandingPagePOM();

    @Given("^User lands MS front page$")
    public void userLandsMSFrontPage(){
        landingPagePOM.setRegionMSChallenge();
        landingPagePOM.reachLandingPage();
        landingPagePOM.isLandingPage();
        //assertTrue(landingPagePOM.isLandingPage());
    }


    @Then ("^verifies persistent tab menu exists MS365, Office, Windows, Surface, XBox, Deals and Support$")
    public void userVerifiesMSFrontPage(){
        landingPagePOM.isLandingPageNavBar();
        //assertTrue(landingPagePOM.isLandingPageNavBar());
    }


    @Given("^User reaches Windows page$")
    public void userReachesWindowsPage() {
        landingPagePOM.reachWindowsPage();

        //assertTrue(landingPagePOM.reachWindowsPage());

    }

    @When("^shows Windows context Menu$")
    public void showsWindowsContextMenu() {
        landingPagePOM.showWindowsMenu();
    }


}

