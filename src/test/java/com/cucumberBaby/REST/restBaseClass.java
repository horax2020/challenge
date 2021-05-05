package com.cucumberBaby.REST;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class restBaseClass {

    @BeforeClass
    public void setup(){

        RestAssured.authentication=RestAssured.preemptive().basic("ToolsQA", "TestPassword");
        RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
    }
}
