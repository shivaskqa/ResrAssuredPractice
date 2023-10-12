package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class WaysToCreatePOSTRequestBody {

	// Post request body using HashMap

//	@Test(priority=1)
	public void testPostUsingHashMap() {

		Map data = new HashMap();

		String[] courses = { "C#", "Javascript" };

		data.put("name", "samplestudentinfo");
		data.put("location", "hyderabad");
		data.put("phone", "9885588999");
		data.put("courses", courses);

		given().contentType(ContentType.JSON).body(data).when().post("http://localhost:3000/students").then()
				.statusCode(201).body("name", equalTo("samplestudentinfo")).body("location", equalTo("hyderabad"))
				.body("phone", equalTo("9885588999")).body("courses[0]", equalTo("C#"))
				.body("courses[1]", equalTo("Javascript")).header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}

	// @Test(priority=2)
	public void testDelete() {

		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);
	}

	// Post request body using org.json library

	// @Test(priority=1)
	public void testPostUsingJsonLibrary() {

		JSONObject jsonData = new JSONObject();

		jsonData.put("name", "jsonsamplestudent");
		jsonData.put("location", "france");
		jsonData.put("phone", "955195519");

		String coursesArr[] = { "C", "C++" };

		jsonData.put("courses", coursesArr);

		given().contentType(ContentType.JSON).body(jsonData.toString()).when().post("http://localhost:3000/students")
				.then().statusCode(201).body("name", equalTo("jsonsamplestudent")).body("location", equalTo("france"))
				.body("phone", equalTo("955195519")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();

	}

	// @Test(priority=2)
	public void testDeleteUserCreatedWithJSON() {

		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);
	}

	//Post request using POJO 
	
	//@Test
	public void testPostUsingPojo() {

		POJO_PostRequest data = new POJO_PostRequest();

		data.setName("samplepojostudent");
		data.setLocation("japan");
		data.setPhone("9119911999");

		String courses[] = {"Java","Javascript"};

		data.setCourses(courses);

		given().contentType(ContentType.JSON).
		       body(data)
		.when()
		    .post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("samplepojostudent"))
			.body("location", equalTo("japan"))
			.body("phone", equalTo("9119911999"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("Javascript"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log()
			.all();
	}

	//@Test(priority = 2)
	public void testDeleteUserCreatedWithPojo() {

		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);
	}
	
	//Post request using external json file
	
	//@Test(priority = 1)
	public void testPostUsingJsonExternalFile() throws IOException {
		
		
		File file=new File(".\\samplejson.json");
		
		FileReader reader=new FileReader(file);
		
		JSONTokener tokener=new JSONTokener(reader);
		
		JSONObject object=new JSONObject(tokener);
		
		given().contentType(ContentType.JSON).
		       body(object.toString())
		.when()
		    .post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("SampleStudentExtFile"))
			.body("location", equalTo("Germany"))
			.body("phone", equalTo("9959959199"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("javascript"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log()
			.all();
	}

	//@Test(priority = 2)
	public void testDeleteUserCreatedWithJsonExtnFile() {

		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);
	}
	
   @Test	
   public void testCreateUserViaPostRequest()
   {
	   
		/*
		 * Map data = new HashMap();
		 * 
		 * String[] courses = { "Java", "Javascript" };
		 * 
		 * data.put("name", "Mahender"); data.put("location", "hyderabad");
		 * data.put("phone", "9885555999"); data.put("courses", courses);
		 */	   
  
	   POJO_PostRequest data = new POJO_PostRequest();

		data.setName("anvesh");
		data.setLocation("australia");
		data.setPhone("8115511863");

		String courses[] = {".Net","Javascript"};

		data.setCourses(courses);

	   
	   String requestURL="http://localhost:3000/students";
		
	   given()
	     .contentType(ContentType.JSON)
	     .body(data)
	    .when()
	     .post(requestURL)
	     .then()
	     .statusCode(201)
	     .log()
	     .all();
	   
	   given()
          .contentType(ContentType.JSON)
          .queryParam("id", 1)
       .when()
          .get(requestURL)
        .then()
          .statusCode(200)
          .body("name", equalTo("Agasthya"))
          .body("id", equalTo(1));
          
   }
	
}