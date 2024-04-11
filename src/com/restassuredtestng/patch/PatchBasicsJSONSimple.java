package com.restassuredtestng.patch;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

//creating payload  using any of the libs gson, jackson, json, simplejson

public class PatchBasicsJSONSimple {

    @Test
    void PatchBasics_Test1() {
        //Create the json object
/*        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name","Druthi");
        payload.put("job", "toddler");

//    JSON Simple
        JSONObject payloadObject = new JSONObject(payload);*/
        JSONObject payloadObject = new JSONObject();
        payloadObject.put("name", "Druthi");
        payloadObject.put("job", "Baby");
        System.out.println(payloadObject);

//        Restassured test
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(payloadObject.toJSONString()).
        when().
                patch("https://reqres.in/api/users/2").
        then().
                statusCode(200).log().all();

    }

}
