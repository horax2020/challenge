package com.cucumberBaby.ObjectMap.AmazonChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPageAmzMap {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]") public WebElement nameAccountElement;
    @FindBy(xpath = "//*[@id=\"ap_email\"]") public WebElement emailAccountElement;
    @FindBy(xpath = "//*[@id=\"ap_password\"]") public WebElement passwordAccountElement;
    @FindBy(xpath = "//*[@id=\"ap_password_check\"]") public WebElement pwdCheckAccountElement;
    @FindBy(xpath = "//*[@id=\"legalTextRow\"]/a[text()=\"Conditions of Use\"]") public WebElement conditionsOfUseElement;

    public CreateAccountPageAmzMap(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(this.driver, this);


    }
}
