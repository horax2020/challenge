package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

public class SignInAmzPOM extends mapBasePOM {

    public void navigateToNewCustomer(){
        clickElement(signInPageAmzMap.createAccountElement);
    }

}


