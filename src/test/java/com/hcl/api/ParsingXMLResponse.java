package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponse {
	
		
	@Test
	public void testParsingXMLResponse()
	{
		//approach - 1
		
		given()
		  .when()
		     .get("http://restapi.adequateshop.com/api/Traveler?page=3")
		  .then()
		     .statusCode(200)
		     .header("Content-Type", "application/xml; charset=utf-8")
		     .body("TravelerinformationResponse.page",equalTo("3"))
		     .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("AzatTest"));
		
		//approach -2
		
		Response response=given()
		  .when()
		     .get("http://restapi.adequateshop.com/api/Traveler?page=3"); 
		
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.header("Content-Type"),"application/xml; charset=utf-8");
		
		String pagenumber=(String)response.xmlPath().get("TravelerinformationResponse.page");
		
		Assert.assertEquals(pagenumber, "3");
		
		String name=(String)response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name");
		
		Assert.assertEquals(name, "AzatTest");
		
	}
	
	@Test
	public void testAdditionalValidationsOnXMLResponse()
	{
		
		Response response=given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlObj=new XmlPath(response.asString());
		
		List<String> travelers=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		Assert.assertEquals(travelers.size(), 10);
		
		boolean flag=false;
		//verify traveler name present in response
		for(String node:travelers)
		{
			if(node.equalsIgnoreCase("Developer123"))
				{  flag=true; break;}
		}
		Assert.assertEquals(flag, true,"Developer123 is found in the response");
	}
}
