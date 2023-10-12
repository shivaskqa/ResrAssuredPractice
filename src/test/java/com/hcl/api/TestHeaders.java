package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TestHeaders {
	
	@Test
	public void testHeaders()
	{
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server", "gws")
		.log()
		.all();
	}
	
	@Test
	public void getAndTestHeaders()
	{
		
		Response res= given()
		.when()
		.get("https://www.google.com");
		
		
		//get single header Content-type value
		
		String headerValue=res.getHeader("Content-Type");
		
		System.out.println(" The value of Content-Type in Header : "+headerValue);
		
		System.out.println("******************************************************************");
		
		//get all Headers info
		
		Headers myHeaders= res.getHeaders();
		
		for(Header h:myHeaders)
			System.out.println(h.getName()+" : "+h.getValue());
		
	}
	
	
}
