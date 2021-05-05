package com.cucumberBaby.StepDefs;

import com.cucumberBaby.POM.Factories.MicrosoftChallenge.CartPagePOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.ItemDetailsPOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.LandingPagePOM;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.SearchResultsPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchMSDef {

    private LandingPagePOM landingPagePOM = new LandingPagePOM();
    private SearchResultsPOM searchResultsPOM = new SearchResultsPOM();
    private ItemDetailsPOM itemDetailsPOM = new ItemDetailsPOM();
    private CartPagePOM cartPagePOM = new CartPagePOM();

    @When("^obtain search results for Visual Studio$")
    public void searchMSDef(){
        landingPagePOM.showSearchResults("Visual Studio");
        searchResultsPOM.showItems();
    }

    @Then("^Validates the first item details$")
    public void validateOneItemMSDef() {
        itemDetailsPOM.validatePrice();
    }

    @And("^Validate the three prices in the cart$")
    public void validateThreeItemsMSDef() {
        cartPagePOM.validatePrices();
    }

    @And("^Validate with Twenty in quantity$")
    public void validateWithTwenty(){
        cartPagePOM.validateQuantity();

    }

}
