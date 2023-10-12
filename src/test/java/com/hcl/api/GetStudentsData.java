package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStudentsData {
	
	
	@Test(enabled=false)
	public void getStudentsData()
	{
		
	String url="http://localhost:3000/students";	
	
	RequestSpecification request=given();
	
	   request.contentType(ContentType.JSON)
	          .when()
	          .get(url)
	          .then()
	          .statusCode(200);
	
	
	Response response= request 
			                          .contentType(ContentType.JSON)
			                          	.when()
			                          	.get(url);
	JsonPath jsonPath=response.jsonPath();
	
	List<String> ids=jsonPath.get("id");
	
	System.out.println(ids);	

	String responsepayload=response.asString();
	System.out.println(responsepayload);
	
	
	JSONArray array=new JSONArray(responsepayload);
	
	Iterator iterator=array.iterator();
	
	while(iterator.hasNext())
	{
	   JSONObject jsonObject=(JSONObject)iterator.next();
		
		   System.out.println(jsonObject.get("id")+","+jsonObject.get("name")+","+jsonObject.get("location")+","+jsonObject.get("phone"));
		   JSONArray coursesarray=(JSONArray) jsonObject.get("courses");  
		   System.out.println(coursesarray.get(0)+","+coursesarray.get(1));
		   
	}
	
	}

	@Test(enabled=false)
	public void getCricketerDetailsWithID()
	{
		
		RequestSpecification request=given()
										 .baseUri("http://localhost:3000")
										 .basePath("/Cricketers")
										 .queryParam("id", 1)
										 .contentType(ContentType.JSON);
		
		Response response=request.when().get();
		String res=response.asPrettyString();
		System.out.println(res);
		
		
		  
	}

	@Test(enabled=false)
	public void addCricketer()
	{
		POJO_Cricketer_PostRequest pojo=new POJO_Cricketer_PostRequest();
		
		  pojo.setName("Shubhman Gill");
		  pojo.setCountry("Bharath");
		  String[] s= { "Tests","ODIs","Twenty20s"};
		  pojo.setType_of_player(s);
	
         given()
         .contentType(ContentType.JSON)
		 .body(pojo)
		 .when()
		   .post("http://localhost:3000/Cricketers")
		   .then()
		   .statusCode(201)
		   .body("name", equalTo("Shubhman Gill"))
		   .body("country", equalTo("Bharath"))
		   .log()
		   .all();
		
	}

	@Test(priority=1,enabled=false)
	public void updateCricketer()
	{
		POJO_Cricketer_PostRequest pojo=new POJO_Cricketer_PostRequest();
		
		  pojo.setName("Shreyas Iyer");
		  pojo.setCountry("Bharath");
		  String[] s= { "Tests","ODIs"};
		  pojo.setType_of_player(s);
	
         given()
         .contentType(ContentType.JSON)
		 .body(pojo)
		 .when()
		   .put("http://localhost:3000/Cricketers/15")
		   .then()
		   .statusCode(201)
		   .log()
		   .all();
		
	}

	
	@Test
	public void getCricketersDetails()
	{
		
		Response response=given()
		 .contentType(ContentType.JSON)
		.when()
		  .get("http://localhost:3000/Cricketers");
		
		String jsonPayload=response.getBody().asString();
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			POJO_Cricketer_PostRequest obj=objectMapper.readValue(jsonPayload, POJO_Cricketer_PostRequest.class);
			System.out.println(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
