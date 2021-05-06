package com.cucumberBaby.StepDefs;

import com.cucumberBaby.POM.Factories.MicrosoftChallenge.LandingPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class landingMSDef {

    private LandingPagePOM landingPagePOM = new LandingPagePOM();
    private SoftAssert softAssert = new SoftAssert();

    @Given("^User lands MS front page$")
    public void userLandsMSFrontPage(){
        landingPagePOM.setRegionMSChallenge();
        landingPagePOM.reachLandingPage();
        landingPagePOM.isLandingPage();
        softAssert.assertTrue(landingPagePOM.isLandingPage());
    }


    @Then ("^verifies persistent tab menu exists MS365, Office, Windows, Surface, XBox, Deals and Support$")
    public void userVerifiesMSFrontPage(){
        softAssert.assertTrue(landingPagePOM.isLandingPageNavBar());
    }


    @Given("^User reaches Windows page$")
    public void userReachesWindowsPage() {
        softAssert.assertTrue(landingPagePOM.reachWindowsPage());

    }

    @When("^shows Windows context Menu$")
    public void showsWindowsContextMenu() {
        softAssert.assertTrue(landingPagePOM.showWindowsMenu());
        softAssert.assertAll();
    }


}

