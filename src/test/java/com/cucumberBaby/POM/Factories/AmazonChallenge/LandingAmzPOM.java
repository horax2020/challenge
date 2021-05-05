package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.Config.ReadPropertyFiles;
import com.cucumberBaby.POM.Factories.mapBasePOM;

public class LandingAmzPOM extends mapBasePOM {

    public void setRegionAmzChallenge() {
        mapBasePOM.region = new ReadPropertyFiles("prod_chl2");
    }

    public void landingAmazon(){
        driver.get(region.valueProperty);
    }

    public void navigateToSignIn() {
        clickElement(landingPageAmzMap.accountListNavElement);
    }


}
