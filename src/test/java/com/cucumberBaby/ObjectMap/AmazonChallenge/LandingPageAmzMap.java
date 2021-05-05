package com.cucumberBaby.ObjectMap.AmazonChallenge;

import io.cucumber.java.jv.Lan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageAmzMap {

    public WebDriver driver;

    //@FindBy(xpath = "//div[@id='nav-belt']/div/div/a[@data-csa-c-slot-id=\"nav-link-accountList\"]/div/span") public WebElement accountListNavElement;
    //@FindBy(xpath = "//div[@id='nav-belt']/div/div/a[@data-csa-c-slot-id=\"nav-link-accountList\"]/span") public WebElement accountListNavElement;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span[1]") public WebElement accountListNavElement;


    public LandingPageAmzMap (WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

}
