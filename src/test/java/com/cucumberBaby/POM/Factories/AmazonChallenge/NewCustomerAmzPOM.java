package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

public class NewCustomerAmzPOM extends mapBasePOM {

    public void fillCustomerData() {

    }

    public boolean navigateToConditionOfUse(){
        boolClickElement(createAccountPageAmzMap.conditionsOfUseElement);
        System.out.println("LOG:Condition of Use:"+ driver.getTitle());
        return driver.getTitle().equals("Amazon.com Help: Conditions of Use");

    }
}
