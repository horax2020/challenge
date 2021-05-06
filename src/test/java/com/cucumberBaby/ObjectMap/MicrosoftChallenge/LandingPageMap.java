package com.cucumberBaby.ObjectMap.MicrosoftChallenge;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LandingPageMap {

 public WebDriver driver;

 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Microsoft 365\")]") public WebElement microsoft365NavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Office\")]") public WebElement officeNavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Windows\")]") public WebElement windowsNavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Surface\")]") public WebElement surfaceNavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Xbox\")]") public WebElement xboxNavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Deals\")]") public WebElement dealsNavElement;
 @CacheLookup @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/*[contains(text(), \"Support\")]") public WebElement supportNavElement;

 @FindBy(xpath = "//button[@type='button' and contains(., 'Windows 10')]") public WebElement windows10NavElement;
 @FindBy(xpath = "//button[@type='button' and contains(., 'Computers')]") public WebElement computersNavElement;

 @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul") public WebElement windows10ContextMenuElement;

 //@FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li/div/ul") public WebElement windows10ContextMenuElement;

 @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul//li[contains(@class, \"js-nav-menu\")]") public List<WebElement> windows10ContextNavElement;

 @FindBy(xpath = "//button[@id='search']") public WebElement searchMagnifier;
 @FindBy(xpath = "//input[@id='cli_shellHeaderSearchInput']") public WebElement searchInputBar;

 @FindBy(xpath = "//button[@id=\"R1MarketRedirect-close\"]") public WebElement marketRedirect;
 @FindBy(xpath = "//button[@class=\"c-glyph glyph-cancel\"]") public WebElement marketCancel;
 @FindBy(xpath = "//div[@class=\"c-glyph glyph-cancel\"]") public WebElement marketSignCancel;



 public LandingPageMap(WebDriver driver) {

  this.driver  = driver;

  PageFactory.initElements(this.driver, this);


 }


}
