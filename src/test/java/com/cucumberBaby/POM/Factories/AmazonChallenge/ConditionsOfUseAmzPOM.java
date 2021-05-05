package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.ObjectMap.AmazonChallenge.EchoPageAmzMap;
import com.cucumberBaby.POM.Factories.mapBasePOM;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ConditionsOfUseAmzPOM extends mapBasePOM {

    public void searchFor(String s){
        clickElement(conditionsOfUsePageAmzMap.couSearchElement);
        writeText(conditionsOfUsePageAmzMap.couSearchElement, s);
        conditionsOfUsePageAmzMap.couSearchElement.sendKeys(Keys.RETURN);
    }

    public void navigateSearchResult(String s){

        conditionsOfUsePageAmzMap.resultListElements.forEach((e) ->
                System.out.println(e.getText().toString()));

        for (int idx=0; idx < conditionsOfUsePageAmzMap.resultListElements.toArray().length; idx++){
            if (conditionsOfUsePageAmzMap.resultListElements.get(idx).getText().equals(s)) {
                System.out.println("LOG:Found a Match:" + conditionsOfUsePageAmzMap.resultListElements.get(idx).getText());
                clickElement(conditionsOfUsePageAmzMap.resultListElements.get(idx));
            }
        }

    }

    public boolean isConditionsOfUse() {
        return find(conditionsOfUsePageAmzMap.couSearchElement);
    }

}
