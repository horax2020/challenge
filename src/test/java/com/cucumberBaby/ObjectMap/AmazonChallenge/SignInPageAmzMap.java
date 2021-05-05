package com.cucumberBaby.ObjectMap.AmazonChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageAmzMap {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]") public WebElement createAccountElement;

    public SignInPageAmzMap(WebDriver driver){

        this.driver  = driver;

        PageFactory.initElements(this.driver, this);


    }
}
