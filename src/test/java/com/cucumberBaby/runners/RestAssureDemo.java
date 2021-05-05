package com.cucumberBaby.runners;

import com.cucumberBaby.REST.restBaseClass;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RestAssureDemo extends restBaseClass {

    @Test
    public void test1(){

        int code = RestAssured.given()
                .get()
                .getStatusCode();

        System.out.println("Response Code from server is " + code);


    }
}
