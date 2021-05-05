package com.cucumberBaby.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static WebDriver StartBrowser(String browsername , String url)
    {
        // If the browser is Firefox
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            // Set the path for geckodriver.exe
            System.setProperty("webdriver.firefox.marionette","./Drivers/geckodriver.exe ");
            System.setProperty("webdriver.firefox.logfile", "./Logs/FFLog.txt");
            System.setProperty("webdriver.firefox.verboseLogging", "true");
            driver = new FirefoxDriver();

        }

        // If the browser is Chrome
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            // Set the path for chromedriver.exe
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "./Logs/ChromeLog.txt");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            driver = new ChromeDriver();
        }
        // If the browser is IE
        else if(browsername.equalsIgnoreCase("IE"))
        {
            // Set the path for IEdriver.exe
            System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.logfile", "./Logs/IELog.txt");
            System.setProperty("webdriver.ie.verboseLogging", "true");
            driver = new InternetExplorerDriver();
        }

        wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}