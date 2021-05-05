package com.cucumberBaby.ObjectMap.MicrosoftChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsMap {

    public WebDriver driver;

    @FindBy(xpath = "//li[contains(@id, \"coreui\")]/div/a/div[2]/div/div/span/span[1]")
    public List<WebElement> searchItemsElements;

    public SearchResultsMap(WebDriver driver) {

        this.driver  = driver;

        PageFactory.initElements(this.driver, this);

    }

}
