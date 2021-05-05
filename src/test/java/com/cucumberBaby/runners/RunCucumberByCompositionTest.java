package com.cucumberBaby.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
* This class will run everything on the <testNGSuite>.xml under XML folder
*
* */

@CucumberOptions(features = "src/test/resources", glue = "com.cucumberBaby.StepDefs")

public class RunCucumberByCompositionTest  extends RunCucumberByCompostionBase {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {

        System.out.println(cucumberFeature.toString());
        System.out.println(pickle.toString());

        testNGCucumberRunner.runScenario(pickle.getPickle());

//        if (pickle.toString().contains("User enters creds")||
//                pickle.toString().contains("User logs out")
//        ) testNGCucumberRunner.runScenario(pickle.getPickle());

//        if (pickle.toString().contains("User logs out")
//        ) testNGCucumberRunner.runScenario(pickle.getPickle());

    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}
