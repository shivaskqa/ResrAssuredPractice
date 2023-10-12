package com.hcl.restapi.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.api.Cricketers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAPICRUDOperations {
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="http://localhost:3000/Cricketers";
	}

	//@Test
	public void testGetRequest()
	{
		
		Response response=given()
		  .contentType(ContentType.JSON)
         .when()
         .get("/11")
         .then()
         .extract()
         .response();
		
		JsonPath path=new JsonPath(response.asString());
		System.out.println(response.asString());
		String name=path.get("name").toString();
		String s= path.get("type_of_player").toString();
		System.out.println(s);
		Assert.assertEquals(name, "David Warner");
		Assert.assertEquals(s, "[ODIs, Twenty20s]");
		
		/*
		 * given() .contentType(ContentType.JSON) .queryParam("name", "Ishaan Kishan")
		 * .when() .get() .then() .body("name", hasItem("Ishaan Kishan"))
		 * .body("country",hasItem("Bharath"));
		 */
	}
	
	@Test
	public void testPatchRequest()
	{
	
		String body="{\"type_of_player\": [\r\n"
				+ "    \"ODIs\",\r\n"
				+ "    \"Twenty20s\"\r\n"
				+ "  ]}";
		
		given()
		.contentType(ContentType.JSON)
        .body(body)
        .when()
        .patch()
        .then()
        .log()
        .all();
		
		
	}
	
	@Test
	public void testUpdateRequest()
	{
		
		/*
		 * String body="{\r\n" + "    \"country\": \"England\",\r\n" +
		 * "    \"type_of_player\": [\r\n" + "        \"ODIs\",\r\n" +
		 * "        \"Twenty20s\"\r\n" + "    ],\r\n" +
		 * "    \"name\": \"Jos Buttler\",\r\n" + "    \"id\": 12\r\n" + "}";
		 */
		
		Cricketers cricObj=new Cricketers();
		cricObj.setName("Jos Buttler");
		cricObj.setCountry("England");
		String s[]={"Tests","ODIs","Twenty20s"};
		cricObj.setType_of_player(s);
		
		given()
		.contentType(ContentType.JSON)
		.body(cricObj)
		.when()
		.put("/12")
		.then()
		.log()
		.all();
		
	}
	
	
	//@Test(priority=1)
	public void createPostRequestWithCricketersPOJO() {
		
		Cricketers cricObj=new Cricketers();
		cricObj.setName("Ishaan Kishan");
		cricObj.setCountry("Bharath");
		String s[]={"Tests","ODIs","Twenty20s"};
		cricObj.setType_of_player(s);
		
		Response response=given()
		.contentType(ContentType.JSON)
		.body(cricObj)
		.when()
		.post()
		.then()
		.extract()
		.response();
		
		String res=response.asPrettyString();
		System.out.println(res);
		
	}

	
	//@Test(priority=1)
	public void createPostRequestWithHashMap()
	{
		
		Map cricMap=new HashMap();
		
		cricMap.put("name", "Josh Hazlewood");
		cricMap.put("country", "Australia");
		String s[]={"Tests","ODIs"};
		cricMap.put("type_of_player", s);
		
		Response response=given()
		.contentType(ContentType.JSON)
		.body(cricMap)
		.when()
		.post()
		.then().extract().response();
		
		Assert.assertEquals(201, response.getStatusCode());
		
	}

	//@Test(priority=1)
	public void createPostRequestWithJSONobject()
	{
		JSONObject object=new JSONObject();
		
		object.put("name", "David Warner");
		object.put("country", "Ausis");
		String[] s= {"ODIs","Twentey20s",};
		object.put("type_of_player", s);
		
		given()
		.contentType(ContentType.JSON)
		.body(object.toString())
		.when()
		.post()
		.then()
        .log()
        .all();
		
	  	
		
	}
	

}
