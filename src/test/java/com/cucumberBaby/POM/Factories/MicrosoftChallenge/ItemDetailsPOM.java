package com.cucumberBaby.POM.Factories.MicrosoftChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

public class ItemDetailsPOM extends mapBasePOM {

    public boolean validatePrice() {

        crossScenarioValues.put(itemPriceDetail, itemDetailsMap.itemPriceDetailElement.getText());

        System.out.println("LOG:Compare:"+crossScenarioValues.get(itemPriceSearch)+ " == "+ crossScenarioValues.get(itemPriceDetail));

        clickElement(landingPageMap.marketSignCancel);
        clickElement(landingPageMap.marketCancel);

        return crossScenarioValues.get(itemPriceSearch).equals(crossScenarioValues.get(itemPriceDetail));
    }

    public void addToCart() {

        clickElement(itemDetailsMap.addToCartItemElement);

    }


}

