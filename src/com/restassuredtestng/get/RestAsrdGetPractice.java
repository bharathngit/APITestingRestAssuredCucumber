package com.restassuredtestng.get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAsrdGetPractice {

    @Test
    void RestAsrdGetPractice_Test1_equalTo() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.first_name[0]", equalTo("Michael")).log().all();
    }

    @Test
    void RestAsrdGetPractice_Test2_hasItems() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id", hasItems(7, 10, 9)).log().all();
    }

}
