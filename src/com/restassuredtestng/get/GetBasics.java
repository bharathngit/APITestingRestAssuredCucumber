package com.restassuredtestng.get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBasics {

	@Test
	void getTest1() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[0]",equalTo(7)).
			body("data.first_name",hasItems("Lindsay", "Tobias")).
			log().all();
		}
	@Test
	void getTest2() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.first_name",hasItems("Lindsay", "Tobias")).
		log().all();
		}
}
