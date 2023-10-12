package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TestLogsWithRestAssured {
	

	@Test
	public void testLogsWithResponseWithHeaders()
	{
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.headers();
	}
	
	public void testLogsWithResponseWithResponse()
	{
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.body();
	}

	public void testLogsWithResponseWithCookies()
	{
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.cookies();
	}

	public void testLogsWithResponseWithAll()
	{
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.all(); 
	}

	
	

}
