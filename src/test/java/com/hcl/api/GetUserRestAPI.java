package com.hcl.api;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetUserRestAPI {
	
	@Test
	public void testGetUser(ITestContext context)
	{
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
