package com.hcl.api;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

public class TestCookies {
	
	//@Test(priority=1)
	public void testCookies()
	{
	
		given()
		.when()
		   .get("https://www.google.com")
		.then()
		  .cookie("AEC", "Ad49MVHTllHBW6jkh-HoGD14f8yFTXrLjablXRto17vexPpCOse7RXPMWQ")
		  .log()
		  .all();
	}

	@Test(priority=1)
	public void getCoookiesInfo()
	{
	
		Response res= given().when().get("https://www.google.com");
		
		//get single cookie info
		
		String cookie_value=res.getCookie("AEC");
		
		System.out.println("The value of AEC Cookie is: "+cookie_value);
		
		//get multiple cookie info
		 
		 Map<String,String> cookiesData=res.getCookies();
		 
		 System.out.println(cookiesData);
		 
		 for(Map.Entry entry:cookiesData.entrySet())
			 System.out.println(entry.getKey()+" : "+entry.getValue());
		 
		
	}
	
	
}
