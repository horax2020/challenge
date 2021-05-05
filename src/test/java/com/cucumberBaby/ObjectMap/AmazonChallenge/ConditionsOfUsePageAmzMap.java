package com.cucumberBaby.ObjectMap.AmazonChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConditionsOfUsePageAmzMap {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"helpsearch\"]") public WebElement couSearchElement;
    @FindBy(xpath = "//div[@class=\"cs-help-search-result-row\"]/h2/a") public List<WebElement> resultListElements;

    public ConditionsOfUsePageAmzMap(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }
}
