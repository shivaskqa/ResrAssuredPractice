package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class RequestWithPathQueryParameters {

//https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void testQueryAndPathParameters()
	{
		
		given()
		  .pathParam("path", "users")
		  .queryParam("page", 1)
		  .queryParam("id", 3)
		 .when()
		   .get("https://reqres.in/api/{path}")
		 .then()
		   .statusCode(200)
		   .log()
		   .all();
		
		given()
		.pathParam("path","users")
		.queryParam("page",2)
		.queryParam("id",5)
	.when()
	  .get("https://reqres.in/api/{path}")
	.then()
	  .statusCode(200)
	  .log()
	  .all();
		
	}
	
}
