package com.cucumberBaby.ObjectMap.MicrosoftChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsMap {

    public WebDriver driver;

    @FindBy(xpath = "//div[@id=\"productPrice\"]/div/div/div/span") public WebElement itemPriceDetailElement;
    @FindBy(xpath = "//*[@id=\"buttonPanel_AddToCartButton\"]") public WebElement addToCartItemElement;

    public ItemDetailsMap(WebDriver driver) {

        this.driver  = driver;

        PageFactory.initElements(this.driver, this);


    }
}
