package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;



public class ValidateJSONSchemaViaJSONFile {
	

	@Test
	public void testJSONSchema()
	{
		 String json_schema_filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\store-jsonschema.json"; 
		 
		 System.out.println(json_schema_filePath);
		 
		  given()
		    .when()
		      .get("http://localhost:3000/store")
		      .then()
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("store-jsonschema.json"));
	}

	
}
