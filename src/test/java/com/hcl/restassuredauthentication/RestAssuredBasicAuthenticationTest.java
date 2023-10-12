package com.hcl.restassuredauthentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class RestAssuredBasicAuthenticationTest {

	
	@Test(priority=1)
	public void testBasicAuthentication()
	{
		given()
		.auth().basic("postman", "password")
		    .when()
		       .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		 .body("authenticated", equalTo(true))
		.log()
		.all();
		
	}
	
	@Test(priority=2)
	public void testDigestAuthentication()
	{
		given()
		.auth().digest("postman", "password")
		    .when()
		       .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		 .body("authenticated", equalTo(true))
		.log()
		.all();
		
	}
	
	
	@Test(priority=3)
	public void testPreemptiveAuthentication()
	{
		given()
		.auth().preemptive().basic("postman", "password")
		    .when()
		       .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		 .body("authenticated", equalTo(true))
		.log()
		.all();
		
	}
	
	@Test(priority=4)
	public void testBearerAuthentication()
	{
		
	 String parentToken="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";	
		
		given()
		.headers("Authorization","Bearer "+parentToken)
		.when()
		  .get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		 .log()
		 .all();
	}
	
	@Test(priority=5)
	public void testOAuth1()
	{
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken","secretToken") //this is oauth 1.0 authentication
		.when()
		  .get("")
		.then()
		  .statusCode(200)
		   .log().all();
	}
	
	
	@Test(priority=5)
	public void testOAuth2()
	{
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken","secretToken") //this is oauth 1.0 authentication
		.when()
		  .get("")
		.then()
		  .statusCode(200)
		   .log().all();
	}
	
}
