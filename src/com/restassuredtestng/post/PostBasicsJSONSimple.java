package com.restassuredtestng.post;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

//creating payload  using any of the libs gson, jackson, json, simplejson

public class PostBasicsJSONSimple {

    @Test
    void PostBasics_Test1() {
        //Create the json object
/*        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name","Druthi");
        payload.put("job", "toddler");

//    JSON Simple
        JSONObject payloadObject = new JSONObject(payload);*/
        JSONObject payloadObject = new JSONObject();
        payloadObject.put("name", "Druthi");
        payloadObject.put("job", "toddler");
        System.out.println(payloadObject);

//        Restassured test
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(payloadObject.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201).log().all();

    }

}
