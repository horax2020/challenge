package com.cucumberBaby.runners;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Delete_PutExample {

    @Test
    public void Test1(){

        RequestSpecification request= RestAssured.given();

        request.header("Content-Type", "application/json");


        JSONObject json = new JSONObject();

        json.put("id","27");
        json.put("title","Selenium Webdriver2");
        json.put("author","Learn");

        request.body(json.toJSONString());

        Response response = request.post("http://localhost:3000/posts");

        int code=response.getStatusCode();

        Assert.assertEquals(code, 201);

        json.clear();
        json.put("id","27");
        json.put("title","Selenium Webdriver EDITED");
        json.put("author","Learn");
        response = request.put("http://localhost:3000/posts/27");
        code=response.getStatusCode();
        System.out.println("response code " + code);
        Assert.assertEquals(code, 200);

        response = request.delete("http://localhost:3000/posts/27");
        code=response.getStatusCode();
        Assert.assertEquals(code, 200);

    }
}
