package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

public class NewCustomerAmzPOM extends mapBasePOM {

    public void fillCustomerData() {

    }

    public void navigateToConditionOfUse(){
        clickElement(createAccountPageAmzMap.conditionsOfUseElement);
    }
}
