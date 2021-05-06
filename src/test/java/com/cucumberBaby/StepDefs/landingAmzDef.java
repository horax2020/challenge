package com.cucumberBaby.StepDefs;

import com.cucumberBaby.ObjectMap.AmazonChallenge.ConditionsOfUsePageAmzMap;
import com.cucumberBaby.ObjectMap.AmazonChallenge.EchoPageAmzMap;
import com.cucumberBaby.POM.Factories.AmazonChallenge.*;
import com.cucumberBaby.POM.Factories.MicrosoftChallenge.LandingPagePOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tools.ant.taskdefs.Echo;
import org.testng.asserts.SoftAssert;


public class landingAmzDef {

        private LandingAmzPOM landingAmzPOM = new LandingAmzPOM();
        private SignInAmzPOM signInAmzPOM = new SignInAmzPOM();
        private EchoPageAmzPOM echoPageAmzPOM = new EchoPageAmzPOM();
        private NewCustomerAmzPOM newCustomerAmzPOM = new NewCustomerAmzPOM();
        private ConditionsOfUseAmzPOM conditionsOfUseAmzPOM = new ConditionsOfUseAmzPOM();
        private SoftAssert softAssert = new SoftAssert();

        @Given("^User lands Amazon front page$")
        public void userLandsAmazonFrontPage() {
            landingAmzPOM.setRegionAmzChallenge();
            softAssert.assertTrue(landingAmzPOM.landingAmazon());
        }


        @When("^navigates to New Customer$")
        public void navigatesToNewCustomer() {
            softAssert.assertTrue(landingAmzPOM.navigateToSignIn());
            softAssert.assertTrue(signInAmzPOM.navigateToNewCustomer());
        }


        @Then("^fills the data from the API source$")
        public void fillsTheDataFromTheAPISource() {


        }

        @And("^navigates to Condition of Use$")
        public void navigatesToConditionOfUse() {
            softAssert.assertTrue(newCustomerAmzPOM.navigateToConditionOfUse());

        }

        @Given("User lands Condition of use")
        public void userLandsConditionOfUse() {
            softAssert.assertTrue(conditionsOfUseAmzPOM.isConditionsOfUse());
        }

        @When("search for Echo")
        public void searchForEcho() {
            softAssert.assertTrue(conditionsOfUseAmzPOM.searchFor("echo"));
        }

        @And("click over Echo Support")
        public void clickOverEchoSupport() {
            softAssert.assertTrue(conditionsOfUseAmzPOM.navigateSearchResult("Echo Support"));

        }


        @Then("Validate existing elements")
        public void validateExistingElements() {
            softAssert.assertTrue(echoPageAmzPOM.validateElements());
            softAssert.assertAll();
        }
}
