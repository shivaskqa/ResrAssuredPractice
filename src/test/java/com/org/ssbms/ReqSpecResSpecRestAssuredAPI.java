package com.org.ssbms;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;


public class ReqSpecResSpecRestAssuredAPI {


	RequestSpecification request;
	ResponseSpecification response;
	
   @BeforeTest	
   public void testSetUp()
   {
	
	request= given()
			    .baseUri("http://localhost:3000")
	            .basePath("/students")
	            .auth()
	            .basic("", "")
	            .header("Accept","application/json");
	
	ResponseSpecBuilder resSpecBuilder=new ResponseSpecBuilder();
	response=resSpecBuilder.expectStatusCode(200)
			      .expectContentType(ContentType.JSON)
			      .expectBody("id", hasItem(1))
	              .expectHeader("Content-Type", equalTo("application/json; charset=utf-8"))
	              .build();
   }

   @Test(priority=0)
   public void testGetStudentDetails()
   {
	   
	  given()
	     .spec(request)
	  .when()
	      .get()
	   .then()
	      .spec(response)
	      .body("size()",greaterThan(2));
	   
   }
	
   @Test(priority=1)
   public void testGetStudentInfoWithID()
   {
	   Response res=given(request)
	     .queryParam("id", 1)
	   .when()
	      .get();
	   
	   JSONArray jsonArray=new JSONArray(res.asPrettyString());

	   Iterator iterator=jsonArray.iterator();
	   
	   while(iterator.hasNext())
	   {
		   JSONObject jsonObject=(JSONObject)iterator.next();
		   int id=(Integer)jsonObject.get("id");
		   String name=(String)jsonObject.get("name");
		   Assert.assertEquals("Agasthya", "Agasthya");
		   String phone=(String)jsonObject.get("phone");
		   Assert.assertEquals("Success", "9052112521", phone);
		   String location=(String)jsonObject.get("location");
		   Assert.assertEquals("Success", "hyderabad", location);
		   System.out.println(id+","+name+","+phone+","+location);
		   
		JSONArray courses=(JSONArray)jsonObject.get("courses");
              System.out.println(courses.get(0));
              System.out.println(courses.get(1));
		  
	   }	   
   }

   
   
   
}
