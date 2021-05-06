package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.Config.ReadPropertyFiles;
import com.cucumberBaby.POM.Factories.mapBasePOM;

public class LandingAmzPOM extends mapBasePOM {

    public void setRegionAmzChallenge() {
        mapBasePOM.region = new ReadPropertyFiles("prod_chl2");
    }

    public boolean landingAmazon(){
        driver.get(region.valueProperty);
        System.out.println(driver.getTitle());
        return landingPageAmzMap.driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    public boolean navigateToSignIn() {
        return boolClickElement(landingPageAmzMap.accountListNavElement);
    }


}
