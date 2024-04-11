package test.java.com.cucumberwithrestassured.requestspecification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostsRequestSpecValidations {

    public static RequestSpecification getRequestSpecForPosts(){
        return new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .setBaseUri("http://localhost:3000/")
                .setBasePath("/posts")
                .build();
    }

    public static String createJsonString(Object pojoObject) throws JsonProcessingException {
        // Use ObjectMapper to serialize the User object to JSON
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

}
