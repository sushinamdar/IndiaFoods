package com.store.indiafoods.contoller;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeControllerTests {

    @Test
    public void testGetByCategory(){
        String endPoint = "https://localhost:7050/shop/category/3";
        //String endPoint = "https://thetestingworldapi.com/api/technicalskills/3";
        Response response = RestAssured .get(endPoint);
        System.out.println(response.asPrettyString());
    }
}
