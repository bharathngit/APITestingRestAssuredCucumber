package test.java.com.cucumberwithrestassured.responsespecifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class PostsResponseStatusCodesValidations {

    public static ResponseSpecification postsStatus200Ok(){
        return new ResponseSpecBuilder().
                expectContentType("application/json").
                expectStatusCode(200).
                build();
    }

    public static ResponseSpecification postsStatus201Created(){
        return new ResponseSpecBuilder().
                expectContentType("application/json").
                expectStatusCode(201).
                build();
    }

}
