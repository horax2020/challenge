package com.cucumberBaby.runners;

 import io.cucumber.java.After;
 import io.cucumber.java.it.Data;
 import io.cucumber.testng.AbstractTestNGCucumberTests;
 import io.cucumber.testng.CucumberOptions;

 import io.cucumber.testng.TestNGCucumberRunner;
 import org.testng.annotations.AfterClass;
 import org.testng.annotations.BeforeClass;
 import org.testng.annotations.DataProvider;
 import org.testng.annotations.Test;

 import java.util.Arrays;

//@CucumberOptions(features = "src/test/resources/loginPage.feature", glue = "com.cucumberBaby.StepDefs")

@CucumberOptions(features = "src/test/resources", glue = "com.cucumberBaby.StepDefs")


 public class TestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider (parallel = false)
  public Object[][] scenarios() {

   //System.out.println("Executing Feature: " + Arrays.stream(super.scenarios()).count());

   return super.scenarios();
  }

  public class testNGRunner extends TestRunner {

   @BeforeClass
   public void setupTest(){
    System.out.println("Before anything");
   }

   @AfterClass()
   public void endTest(){
    System.out.println("Ending Test");
   }


  }
 }
