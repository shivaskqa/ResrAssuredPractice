package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class HTTPRequestsNew {
	
	int id;
	
	@Test
	public void getSingleUser()
	{
		
		given()
		  .baseUri("https://reqres.in/")
		  .basePath("api/users/2")
		 .when()
		   .get()
		  .then()
		  .assertThat()
		  .statusCode(200)
		  .body("data.first_name", equalTo("Janet"))
		  .contentType(ContentType.JSON)
		  .log()
		  .all();
		
	}
	
	@Test
	public void testPostRequest()
	{
		Map<String,String> data=new HashMap<String,String>();
		 
		  data.put("name", "Ramu");
		  data.put("job", "professor");
		
		  int id=given()
		    .contentType(ContentType.JSON)
		    .body(data)
		    .baseUri("https://reqres.in/")
			.basePath("api/users")
		  .when()
		    .post()
		    .jsonPath()
		    .getInt("id");
		   
		 System.out.println(id);  
		  
	}
	
	@Test(priority=0)
	public void testGetRequest()
	{
		/*
		 * RequestSpecification request=new RequestSpecBuilder()
		 * .setBaseUri("https://reqres.in/") .setBasePath("api/users/2")
		 * .setAccept(ContentType.JSON) .build();
		 */
	   
	  RequestSpecification request=given().baseUri("https://reqres.in/").basePath("api/users").contentType(ContentType.JSON);
	   
	    given().spec(request).when().get().then().statusCode(200).log().all();
			               
		given()
		 .multiPart("attachment",new File(""))
		 .contentType("multipart/form-data");
 	}
}
