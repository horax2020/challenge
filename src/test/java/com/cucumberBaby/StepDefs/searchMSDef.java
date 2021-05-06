package com.cucumberBaby.StepDefs;

import com.cucumberBaby.POM.Factories.MicrosoftChallenge.CartPagePOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.ItemDetailsPOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.LandingPagePOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.SearchResultsPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class searchMSDef {

    private LandingPagePOM landingPagePOM = new LandingPagePOM();
    private SearchResultsPOM searchResultsPOM = new SearchResultsPOM();
    private ItemDetailsPOM itemDetailsPOM = new ItemDetailsPOM();
    private CartPagePOM cartPagePOM = new CartPagePOM();
    private SoftAssert softAssert = new SoftAssert();

    @When("^obtain search results for Visual Studio$")
    public void searchMSDef(){
        softAssert.assertTrue(landingPagePOM.showSearchResults("Visual Studio"));
        softAssert.assertTrue(searchResultsPOM.showItems());
    }

    @Then("^Validates the first item details$")
    public void validateOneItemMSDef() {
        softAssert.assertTrue(itemDetailsPOM.validatePrice());
    }

    @And("^Validate the three prices in the cart$")
    public void validateThreeItemsMSDef() {
        softAssert.assertTrue(cartPagePOM.validatePrices());
    }

    @And("^Validate with Twenty in quantity$")
    public void validateWithTwenty(){
        softAssert.assertTrue(cartPagePOM.validateQuantity());
        softAssert.assertAll();
    }

}
