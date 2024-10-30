package com.api.automation_Day_1_Oct_23_2024_Basics;

import com.api.automation.files.Payload;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class First_API_Automation_Code {

    //1. BaseURI has to be present
    //2. given() - all the input details [queryparmeters, body]
    //3. when() - submits the API - resource and https methods(post, get, put, delete)
    //4. then() - validating the API

@Test
    public static void basics(){

      RestAssured.baseURI = "https://rahulshettyacademy.com";

      given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
              .body(Payload.AddPlace()).when().post("/maps/api/place/add/json")
              .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
              .header("server", "Apache/2.4.52 (Ubuntu)");

    }
}
