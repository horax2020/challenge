package com.cucumberBaby.POM.Factories.MicrosoftChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

public class SearchResultsPOM extends mapBasePOM {

    public boolean showItems() {


            crossScenarioValues.put(itemPriceSearch, searchResultsMap.searchItemsElements.get(0).getText());
            System.out.println("LOG:Item Price In Search Result:"+ crossScenarioValues.get(itemPriceSearch));



            searchResultsMap.searchItemsElements.get(0).click();

        return false;
    }

}

/*
landingPageMap.windows10ContextNavElement.forEach((e) -> {
                find(e);
                System.out.println(e.getText().toString());

                }

            );
//*/
