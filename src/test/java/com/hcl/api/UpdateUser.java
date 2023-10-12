package com.hcl.api;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	public void createUserViaFakerJavaLibrary(ITestContext context) {

		int id=(Integer) context.getSuite().getAttribute("user_id");

		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");

		//String bearerToken = "86e4b2405574c82b72282582cd19b2966f2695fa7afa4068ac68e33a04ff2de5";
		String bearerToken=(String)context.getAttribute("Bearer_Token");
		
		given().headers("Authorization", "Bearer " + bearerToken).contentType("application/json").body(data.toString())
				.pathParam("id", id).when().put("https://gorest.co.in/public/v2/users/{id}").then().statusCode(200)
				.log().all();

		System.out.println("Generated ID via Post request: " + id);

	}

}
