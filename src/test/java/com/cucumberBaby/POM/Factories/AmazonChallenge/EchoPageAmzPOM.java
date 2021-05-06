package com.cucumberBaby.POM.Factories.AmazonChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EchoPageAmzPOM extends mapBasePOM {

    public boolean findElementFromList(List<WebElement> elements, String lookFor){

        elements.forEach((e) ->
                System.out.println("Log:Looking for:"+ e.getText().toString()+ " comparing " + lookFor));

        for (int idx=0; idx < elements.toArray().length; idx++){
            System.out.println("LOG:Comparing:"+idx+" "+elements.get(idx).getText());
            if (elements.get(idx).getText().equals(lookFor)) {
                System.out.println("LOG:FOUND:"+elements.get(idx).getText());
                return true;
            }
        }

        return false;
    }

    public boolean validateElements(){
        //Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting

        System.out.println("LOG:Find Topic:Getting Started"+findElementFromList(echoPageAmzMap.topicListElements, "Getting Started"));
        System.out.println("LOG:Find Topic:Wi-Fi and Bluetooth"+findElementFromList(echoPageAmzMap.topicListElements, "Wi-Fi and Bluetooth"));
        System.out.println("LOG:Find Topic:Device Software..."+findElementFromList(echoPageAmzMap.topicListElements, "Device Software and Hardware"));
        System.out.println("LOG:Find Topic:Troubleshooting"+findElementFromList(echoPageAmzMap.topicListElements, "Troubleshooting"));

        if (findElementFromList(echoPageAmzMap.topicListElements, "Getting Started") &&
        findElementFromList(echoPageAmzMap.topicListElements, "Wi-Fi and Bluetooth") &&
        findElementFromList(echoPageAmzMap.topicListElements, "Device Software and Hardware") &&
        findElementFromList(echoPageAmzMap.topicListElements, "Troubleshooting")) return true;


        return false;
    }
}
