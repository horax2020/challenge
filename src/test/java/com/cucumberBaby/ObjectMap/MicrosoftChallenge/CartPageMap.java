package com.cucumberBaby.ObjectMap.MicrosoftChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageMap {

    public WebDriver driver;

    @FindBy (xpath = "//select") public WebElement qtySelectorElement;
    @FindBy (xpath = "//div[@class=\"line-item-row\"]//span[@class=\"x-screen-reader\"]") public WebElement priceItemElement;
    @FindBy (xpath = "//h2[text()=\"Order summary\"]/following-sibling::div//span[@itemprop=\"price\"]/span") public WebElement subtotalSummaryElement;
    @FindBy (xpath = "//h2[text()=\"Order summary\"]/following-sibling::div[2]//span[@itemprop=\"price\"]") public WebElement totalSummaryElement;


    @FindBy(xpath = "//*[@id=\"ProductPrice_productPrice_PriceContainer-0\"]/span") public WebElement itemDetailElement;
    @FindBy(xpath = "//*[@id=\"buttonPanel_AddToCartButton\"]") public WebElement addToCartItemElement;

    public CartPageMap(WebDriver driver) {

        this.driver  = driver;

        PageFactory.initElements(this.driver, this);


    }

}

