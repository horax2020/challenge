package com.cucumberBaby.runners;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

    @Test
    public void testResponseCode(){

        Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");

        int code = response.getStatusCode();

        System.out.println("Status code is "+ code);

        Assert.assertEquals(code, 200);

    }

    @Test
    public void testBody(){

        Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");

        ResponseBody data = response.getBody();

        System.out.println("Status data is "+ data.prettyPrint());

        System.out.println("Response time " + response.getTime());


    }
}
