package com.org.ssbms;

import static org.hamcrest.CoreMatchers.hasItem;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.api.POJO_Cricketer_PostRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BasicCRUDRestAPITests {
	
	
	RequestSpecification request;
	
	@BeforeMethod
	public void setUp()
	{
		request=RestAssured.given()
				           .baseUri("http://localhost:3000")
				           .basePath("/Cricketers")
				           .auth()
				           .basic("", "")
				           .accept(ContentType.JSON);
		
		/*
		 * ResponseSpecBuilder builder=new ResponseSpecBuilder();
		 * response=builder.expectStatusCode(200) .expectContentType(ContentType.JSON)
		 * .build();
		 */
	}
	
	
	@Test
	public void testGetCricketersDetails()
	{
		
		String resPayload=request.when().get().getBody().asString();
		System.out.println(resPayload);
		
	}

	
	@Test
	public void testGetCricketersDetailsBasedonID()
	{
		
		Response response=request.queryParam("id", 1).when().get();
        Assert.assertEquals("Success",200, response.getStatusCode());
        JSONArray jsonArray=new JSONArray(response.asString());
       
        Iterator iterator=jsonArray.iterator();
        
        while(iterator.hasNext())
        {
        	
        	JSONObject jsonObject=(JSONObject)iterator.next();
        	int id=(Integer)jsonObject.get("id");
        	String name=(String)jsonObject.get("name");
        	String country=(String)jsonObject.get("country");
        	JSONArray type_of_player=(JSONArray)jsonObject.get("type_of_player");
        	        	
        	System.out.println(id+","+name+","+country);
        	
        	for(int i=0;i<type_of_player.length();i++)
        		System.out.println(type_of_player.get(i));
        	
        }
		
	}
	
	//@Test
	public void addNewCricketerviaPostRequestWithPOJO()
	{
		
		POJO_Cricketer_PostRequest pojo=new POJO_Cricketer_PostRequest();
		pojo.setName("Sample Cric Name");
		pojo.setCountry("India");
		String[] s= {"ODIs","Twenty20s"};
		pojo.setType_of_player(s);
		
		RestAssured.given()
		           .contentType(ContentType.JSON)
		           .baseUri("http://localhost:3000/Cricketers")
		           .body(pojo)
		 .when()
		      .post()
		  .then()
		       .statusCode(201);
		         
	}

	//@Test
	public void updateCricketerviaPutRequestWithPOJO()
	{
		
		POJO_Cricketer_PostRequest pojo=new POJO_Cricketer_PostRequest();
		pojo.setName("Axar Patel");
		pojo.setCountry("Bharath");
		String[] s= {"ODIs","Twenty20s"};
		pojo.setType_of_player(s);
		
		RestAssured.given()
		           .contentType(ContentType.JSON)
		           .baseUri("http://localhost:3000/Cricketers/19")
		           .body(pojo)
		 .when()
		      .put()
		  .then()
		       .statusCode(200);
		         
	}
	
	@Test
	public void deleteCricketerDetailsviaID()
	{

      request.basePath("/20").when().delete().then().statusCode(404);
		
		
	}
	
	
	public void doAuthenticationsViaRestAPI()
	{
		//This code is for basic authentication
		RestAssured.given().auth().basic("", "");
		//following code is for digest authentication
		RestAssured.given().auth().digest("","");
		//following code is for preemptive authentication
		RestAssured.given().auth().preemptive().basic("", "");
		
		//following code for Bearer token authorization
		String accessToken="";
		RestAssured.given().header("Authorize", "Bearer "+accessToken);
		
		//following code is for oauth2
		//String accessToken="";
		RestAssured.given().auth().oauth2(accessToken);
  		
	}
	
}


