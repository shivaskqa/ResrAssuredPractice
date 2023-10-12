package com.hcl.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HTTPRequests {
	
	int id;
	
	//@Test
	public void getSingleUser()
	{
		
		//given()
		when().get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200);
		
	}
	
	@Test(priority=1)
    public void getListofUsers()
    {
    	 given()
    	 .when()
    	    .get("https://reqres.in/api/users?page=2")
    	    .then()
    	     .statusCode(200)
    	     .body("page",equalTo(2)).log().all();
    	 
    }
	
	@Test(priority = 2)
	public void createUserviaPost()
	{
		Map<String,String> data=new HashMap<String,String>();
		 
		  data.put("name", "morpheus");
		  data.put("job", "leader");
		
		id=given()
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("https://reqres.in/api/users")
				.jsonPath()
				.getInt("id");
		
		System.out.println(id);

/*.then()
		.statusCode(201)
		.log()
		.all();
		*/
		
	}
	
	@Test(priority=3,dependsOnMethods = {"createUserviaPost"})
	public void updateUser()
	{
		
		Map<String,String> data=new HashMap<String,String>();
		 
		  data.put("name", "pavan");
		  data.put("job", "teacher");
			
		given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200)
		.log()
		.all();
		
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log()
		.all();	
	}
}
