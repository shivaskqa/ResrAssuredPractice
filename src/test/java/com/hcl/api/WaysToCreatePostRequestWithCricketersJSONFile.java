package com.hcl.api;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


//Create Post request using HashMap  -- Done
//Create Post request with JSONObject org.json -- Done
//Create Post request with POJO -- Done
//Create Post request with External JSON file

public class WaysToCreatePostRequestWithCricketersJSONFile {
	

	//@Test(priority=1)
	public void testPostRequestWithHashMap()
	{
      Map data=new HashMap();
      
      data.put("name", "ishaan kishan");
      data.put("country", "Bharath");
      String[] type_of_player= {"Tests","ODIs","Twenty20s"};
      data.put("type_of_player",type_of_player);
      
      given()
      .contentType(ContentType.JSON)
      .body(data)
      .when()
      .post("http://localhost:3000/Cricketers")
      .then()
      .statusCode(201)
      .body("name",equalTo("ishaan kishan"))
      .body("country", equalTo("Bharath"))
      .body("type_of_player[0]", equalTo("Tests"))
      .body("type_of_player[1]", equalTo("ODIs"))
      .body("type_of_player[2]", equalTo("Twenty20s"))
      .log()
      .all();
		
	}
	
   //@Test(priority=2)
   public void deleteRequest()
   {
	   given()
	   .when()
	   .delete("http://localhost:3000/Cricketers/4")
	   .then()
	   .statusCode(200)
	   .log()
	   .all();
	   
   }

   
   //@Test(priority=1)
	public void postRequestWithJSON()
	{
		
		JSONObject data=new JSONObject();
		
		data.put("name", "Pragya Jaiswal");
		data.put("country", "Bharath");
		
		String[] typeofplayer= {"Tests","ODIs"};
		
		data.put("type_of_player", typeofplayer);
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/Cricketers")
		.then()
		.statusCode(201)
		.body("name", equalTo("Pragya Jaiswal"))
		.body("country", equalTo("Bharath"))
		.body("type_of_player[0]",equalTo("Tests"))
		.body("type_of_player[1]", equalTo("ODIs"))
		.log()
		.all();
		
	}
	
   //@Test(priority=2)
   public void deleteRequestcreatedwithJSON()
   {
	   
	   given()
	   .when()
	   .delete("http://localhost:3000/Cricketers/4")
	   .then()
	   .statusCode(200)
	   .log()
	   .all();
   }

   
   //@Test(priority=1)
   public void testPostRequestWithPOJO()
   {
	   
	   POJO_Cricketer_PostRequest data=new POJO_Cricketer_PostRequest();
	   
	    data.setName("Ian Williams");
	    data.setCountry("NewZealand");
	    
	    String[] typeOfCricketer= {"Tests","ODIs"};
	    
	    data.setType_of_player(typeOfCricketer);
	   
	    given()
	    .when()
	    .contentType(ContentType.JSON)
	    .body(data)
	    .when()
	    .post("http://localhost:3000/Cricketers")
	    .then()
	    .statusCode(201)
	    .body("name",equalTo("Ian Williams"))
	    .body("country", equalTo("NewZealand"))
	    .body("type_of_player[0]",equalTo("Tests"))
	    .body("type_of_player[1]",equalTo("ODIs"))
	    .log()
	    .all();
	   
   }
   
   //@Test(priority = 2)
	public void deleteRequestCreatedWithPOJO()
	{
	   given()
	   .when()
	   .delete("http://localhost:3000/Cricketers/4")
	   .then()
	   .statusCode(200)
	   .log()
	   .all();
	}
	
	@Test(priority=1)
	public void testPostRequestWithExternalJSONFile()throws FileNotFoundException
	{
		
		String pathofJSONFile=".//SampleCricketers.json";
		FileReader reader=new FileReader(new File(pathofJSONFile));
		
		JSONTokener jt=new JSONTokener(reader);
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Cricketers")
		.then()
		.statusCode(201)
		.body("name", equalTo("Ravichandran Ashwin"))
		.body("country", equalTo("Bharath"))
		.body("type_of_player[0]",equalTo("Tests"))
		.body("type_of_player[1]", equalTo("ODIs"))
		.log().all();
		
	}

	@Test(priority=2)
	public void deleteRequestCreatedWithExtJSONFile()
	{
		given()
		.when()
		.delete("http://localhost:3000/Cricketers/4")
		.then()
		.statusCode(200)
		.log()
		.all();
		
		
	}
	
}
