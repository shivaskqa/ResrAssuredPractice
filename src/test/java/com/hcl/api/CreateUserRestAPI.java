package com.hcl.api;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class CreateUserRestAPI {
	
	
	@Test
	public void createUserViaFakerJavaLibrary(ITestContext context)
	{
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="86e4b2405574c82b72282582cd19b2966f2695fa7afa4068ac68e33a04ff2de5";
		
		context.setAttribute("Bearer_Token", bearerToken);
		
		int id=given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.when()

		.post("https://gorest.co.in/public/v2/users")
		 .jsonPath().getInt("id");
		 
		System.out.println("Generated ID via Post request: "+id);
		

		//context.setAttribute("user_id", id); // set user_id scope to test level
		context.getSuite().setAttribute("user_id", id); //set user_id scope to suite level
	}
}
