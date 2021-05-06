package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EchoPageAmzPOM extends mapBasePOM {

    public boolean findElementFromList(List<WebElement> elements, String lookFor){

        elements.forEach((e) ->
                System.out.println(e.getText().toString()));

        for (int idx=0; idx < elements.toArray().length; idx++){
            if (elements.get(idx).toString().equals(lookFor)) {
                System.out.println(elements.get(idx).getText().toString());
                return true;
            }
        }

        return false;
    }

    public boolean validateElements(){
        //Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting
        if (findElementFromList(echoPageAmzMap.topicListElements, "Getting Started") &&
        findElementFromList(echoPageAmzMap.topicListElements, "Wi-Fi and Bluetooth") &&
        findElementFromList(echoPageAmzMap.topicListElements, "Device Software and Hardware") &&
        findElementFromList(echoPageAmzMap.topicListElements, "TroubleShooting")) return true;


        return false;
    }
}
