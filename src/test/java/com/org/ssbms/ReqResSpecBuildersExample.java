package com.org.ssbms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqResSpecBuildersExample {
	
	@Test
	public void testGetDetails() throws IOException
	{
		String baseURI="http://localhost:3000";
		String basePath="/rohit_sharma";
		String countryAgainst="Sri Lanka";
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
		
		RequestSpecification requestSpecification=requestSpecBuilder.setBaseUri(baseURI)
				                                  .setBasePath(basePath)
				                                  .setAccept(ContentType.JSON)
				                                  .build();
		
		RestAssured.given().spec(requestSpecification).when().get().then().log().all();
		
		Response response=RestAssured.given().spec(requestSpecification)
		                   .queryParam("opposition", countryAgainst)
		                   .when()
		                   .get();
		
		String resString=response.asPrettyString();
		
		String outputFilePath="C:\\Users\\Public\\AutomationProjects\\ResrAssuredPractice\\target\\outputjsonfile.txt";
		FileOutputStream fos=new FileOutputStream(outputFilePath);
		fos.write(resString.getBytes());
		
		JSONArray jsonArray=new JSONArray(response.asString());
		
		System.out.println(jsonArray.length());
		
		java.util.Iterator<Object> iterator=jsonArray.iterator();
		
		while(iterator.hasNext())
		{
			JSONObject object=(JSONObject)iterator.next();
			String cnt=(String)object.get("opposition");
			System.out.println(cnt);
		}
		
		
		
	}

}
