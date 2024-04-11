package com.restassuredtestng.delete;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

//creating payload  using any of the libs gson, jackson, json, simplejson

public class DeleteBasicsJSONSimple {

    @Test
    void DeleteBasics_Test1() {

//        Restassured test
        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204).log().all();

    }

}
