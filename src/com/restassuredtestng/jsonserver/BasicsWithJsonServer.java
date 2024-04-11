package com.restassuredtestng.jsonserver;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/*

Based on the example db.json, you'll get the following routes:

GET    /posts
GET    /posts/:id
POST   /posts
PUT    /posts/:id
PATCH  /posts/:id
DELETE /posts/:id

# Same for comments
GET   /profile
PUT   /profile
PATCH /profile
*/
public class BasicsWithJsonServer {

    @Test
    void JsonServerBasics_Test1_Get() {
        baseURI = "http://localhost:3000";
        given().
                get("/posts").
                then().
                statusCode(200).log().all();
    }

    @Test
    void JsonServerBasics_Test2_Post(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("title", "Bharath Nadukatla SDET");
        payload.put("views", 350);
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().post("posts").
                then().
                    statusCode(201).log().all();// 201 For Creating and posting new entries

    }

    @Test
    void JsonServerBasics_Test3_Patch(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("title", "BN SDET");
        payload.put("views", 250);
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().patch("posts/a5bf"). //"id": "a5bf"
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }

    @Test
    void JsonServerBasics_Test4_Put(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("name", "Bharath Nadukatla");
        payload.put("title", "SDET/ QUality Assurance Engineer");
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().put("posts/a5bf"). //"id": "a5bf"
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }

    @Test
    void JsonServerBasics_Test5_Delete(){
        baseURI = "http://localhost:3000/";

        given().
                when().delete("posts/a5bf"). //"id": "a5bf"
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }

    //for path /profile
    @Test
    void JsonServerBasics_Test10_Get() {
        baseURI = "http://localhost:3000";
        given().
                get("/profile").
                then().
                statusCode(200).log().all();
    }

   /*

   POST path is not applicable for /profile

   @Test
    void JsonServerBasics_Test6_Post(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("name", "Bharath");
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().post("posts").
                then().
                    statusCode(201).log().all();// 201 For Creating and posting new entries

    }*/

    @Test
    void JsonServerBasics_Test7_Patch(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("name", "Bharath Nadukatla1");
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().patch("profile").
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }

    @Test
    void JsonServerBasics_Test8_Put(){
        baseURI = "http://localhost:3000/";
        JSONObject payload = new JSONObject();
        payload.put("name", "Bharath");
        System.out.println(payload);

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(payload.toJSONString()).
                when().put("profile").
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }

   /*

   Delete is not supported for /profile
   @Test
    void JsonServerBasics_Test9_Delete(){
        baseURI = "http://localhost:3000/";

        given().
                when().delete("posts/a5bf"). //"id": "a5bf"
                then().
                statusCode(200).log().all();// 200 For Put or Patch

    }*/

}
