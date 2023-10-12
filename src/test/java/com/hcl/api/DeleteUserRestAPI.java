package com.hcl.api;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUserRestAPI {
	
	@Test
	public void testGetUser(ITestContext context)
	{
		//String bearerToken="86e4b2405574c82b72282582cd19b2966f2695fa7afa4068ac68e33a04ff2de5";
		
		String bearerToken=(String)context.getAttribute("Bearer_Token");
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		    .pathParam("id", id)
		.when()
		    .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log()
			.all();
	}

}
