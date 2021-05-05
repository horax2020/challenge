package com.cucumberBaby.runners;

import com.cucumberBaby.reporter.TestNGListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class RunCucumberByCompostionBase extends TestNGListener {

    public String region = "";

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
}
