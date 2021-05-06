package com.cucumberBaby.runners;

import com.cucumberBaby.POM.Factories.mapBasePOM;
import com.cucumberBaby.reporter.TestNGListener;
import org.testng.annotations.*;

public class RunCucumberByCompostionBase extends TestNGListener {

    public String region = "";

    public mapBasePOM basePOM;

    @BeforeClass
    public void beforeClass() {
        // do expensive setup
        System.out.println("Before Class Base");

    }

    @BeforeMethod
    public void beforeMethod() {
        // do expensive setup
        System.out.println("Before Method Base");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
        basePOM.driver.quit();
    }

}
