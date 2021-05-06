package com.cucumberBaby.POM.Factories;

import com.cucumberBaby.Config.ReadPropertyFiles;
import com.cucumberBaby.ObjectMap.AmazonChallenge.*;
import com.cucumberBaby.ObjectMap.MicrosoftChallenge.CartPageMap;
import com.cucumberBaby.ObjectMap.MicrosoftChallenge.ItemDetailsMap;
import com.cucumberBaby.ObjectMap.MicrosoftChallenge.LandingPageMap;
import com.cucumberBaby.ObjectMap.MicrosoftChallenge.SearchResultsMap;
import com.cucumberBaby.Utility.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import static com.cucumberBaby.Utility.BrowserFactory.actions;
import static com.cucumberBaby.Utility.BrowserFactory.wait;



public class mapBasePOM {


    //Allows to read the evn from testng xml

    private static String envFromXML;

    // Allows access to accesory functions

    //public static ReadPropertyFiles region = new ReadPropertyFiles(envFromXML);

    //public static ReadPropertyFiles region = new ReadPropertyFiles("prod");

    public static ReadPropertyFiles region = new ReadPropertyFiles("default");

    public static String itemPriceSearch = "ItemPriceSearch";
    public static String itemPriceDetail = "ItemPriceDetail";
    public static String itemPriceCart = "ItemPriceCart";
    public static String itemSubtotalCart = "ItemSubtotalCart";
    public static String itemTotalCart = "ItemTotalCart";

    public static Map<String, String> crossScenarioValues = new HashMap<String, String>();


    //Allows access to Driver instance
    public static WebDriver driver = new BrowserFactory().StartBrowser("Chrome", region.valueProperty);

    // Allows to take screenshots
    TakesScreenshot scrShot =((TakesScreenshot)driver);

    // Create image file
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    //Allows access to Map classes for microsoft challenge

    public static LandingPageMap landingPageMap = new LandingPageMap(driver);
    public static SearchResultsMap searchResultsMap = new SearchResultsMap(driver);
    public static ItemDetailsMap itemDetailsMap = new ItemDetailsMap(driver);
    public static CartPageMap cartPageMap = new CartPageMap(driver);

    public static CreateAccountPageAmzMap createAccountPageAmzMap = new CreateAccountPageAmzMap(driver);
    public static LandingPageAmzMap landingPageAmzMap = new LandingPageAmzMap(driver);
    public static SignInPageAmzMap signInPageAmzMap = new SignInPageAmzMap(driver);
    public static EchoPageAmzMap echoPageAmzMap = new EchoPageAmzMap(driver);
    public static ConditionsOfUsePageAmzMap conditionsOfUsePageAmzMap = new ConditionsOfUsePageAmzMap(driver);

    public static void navigateTo(String url) {
        driver.get(url);
    }

    // fluent wait allows ignoring exceptions and
    // double validates conditions Visibility and if Enabled

    public static boolean find(WebElement element) {
        Wait<WebDriver> wait = null;

        try {

            System.out.println("LOG:finding:" + element.toString());

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(6))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);

            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("LOG:Found:" + element.toString());
            return element.isEnabled();
        }catch(Exception e) {
            System.out.println("LOG:Not found:" + element.toString());
            return false;
        }

    }


    // obtains a web element through the web locator
    public WebElement getElement(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    //allows click
    public void clickElement(WebElement element) {
        if (find(element)) {
            System.out.println("LOG:Clicking:"+ element.toString());
            element.click();
        }
    }

    //allows click and returns true if it exists
    public boolean boolClickElement(WebElement element) {
        if (find(element)) {
            System.out.println("LOG:Clicking:"+ element.toString());
            element.click();
            return true;
            }
        return false;
    }

    //allows entering text
    public void writeText(WebElement element, String textToWrite) {
        if (find(element)) {
            element.clear();
            element.sendKeys(textToWrite);
        }
    }

    public void selectFromDDByValue(WebElement element, String valueToSelect) {
        if (find(element)) {
            Select ddToSelect = new Select(element);
            ddToSelect.selectByValue(valueToSelect);

        }
    }

    public void selectFromDDByIndex(WebElement element, int valueToSelect) {
        if (find(element)) {
            Select ddToSelect = new Select(element);
            ddToSelect.selectByIndex(valueToSelect);

        }
    }

    public void selectFromDDByText(WebElement element, String valueToSelect) {
        if (find(element)) {
            Select ddToSelect = new Select(element);
            ddToSelect.selectByVisibleText(valueToSelect);

        }
    }

    public void deselectFromDD(WebElement element) {
        if (find(element)) {
            Select ddToSelect = new Select(element);
            ddToSelect.deselectAll();
        }
    }

    public List<WebElement> getOptionsFromDD(WebElement element) {
        List<WebElement> options = null;

        if (find(element)) {
            Select ddToSelect = new Select(element);
            options = ddToSelect.getOptions();
        }
        return (options);
    }

    public void hoverOverElement(WebElement element) {
        if (find(element)) {
            actions.moveToElement(element);
        }
    }

    public void hoverOverElementXY(WebElement element, int x, int y) {
        if (find(element)) {
            actions.moveToElement(element, x, y);
        }
    }

    public void doubleClick(WebElement element) {
        if (find(element)) {
            actions.doubleClick(element);
        }
    }

    public  void rightClick(WebElement element) {
        if (find(element)) {
            actions.contextClick(element);
        }
    }

    public String getValueFromTable(String locator, int row, int col) {
        String val =  locator + "/table/tbody/tr/[" + row + "]/td["+col+"]";

        return getElement(val).getText();

    }

    public void setValueOnTAble(String locator, int row, int col, String val) {
        String cell = locator + "/table/tbody/tr/[" + row + "]/td["+col+"]";

        getElement(cell).sendKeys(val);

    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination



    }

    public void switchToiFrame(int iFrameID){
        driver.switchTo().frame(iFrameID);
    }

    public void swithToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void mySleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
