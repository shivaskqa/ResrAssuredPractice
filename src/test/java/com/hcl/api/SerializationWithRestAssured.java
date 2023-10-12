package com.hcl.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;


public class SerializationWithRestAssured {

	//Process of Serialization in Rest Assured API
	//@Test
	public void testSerialization() throws JsonProcessingException
	{
		//Creating an object for POJO class and set the values via Setters method
		
		Cricketers cricketers=new Cricketers();
		cricketers.setName("Ishaan Kishan");
		cricketers.setCountry("Bharath");
		String[] typeOfCricketPlayer= {"Tests","ODIs","Twenty20s"};
		cricketers.setType_of_player(typeOfCricketPlayer);
		
		//Converting POJO to JSON
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cricketers);
		
		System.out.println(jsonData);
		
	}
	
	//Convert JSON to POJO
	
	//@Test
	public void testDeSerialization() throws JsonProcessingException
	{
				
		Response response=given()
				  .when().get("http://localhost:3000/Cricketers");
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"Ishaan Kishan\",\r\n"
				+ "  \"country\" : \"Bharath\",\r\n"
				+ "  \"type_of_player\" : [ \"Tests\", \"ODIs\", \"Twenty20s\" ]\r\n"
				+ "}";
		
		//Converting JSONData into POJO
		ObjectMapper objMapper=new ObjectMapper();
		Cricketers cricketersObj=objMapper.readValue(jsonData,Cricketers.class);
		
		System.out.println(cricketersObj);
		
	}
	
	@Test
	public void testSerializationWithStudentsJSON() throws JsonProcessingException
	{
		
		POJO_PostRequest student=new POJO_PostRequest();
		
		student.setName("Mahodhar");
		student.setLocation("India");
		student.setPhone("63366336636");
		String[] courses=new String[] {"Java",".net"};
		student.setCourses(courses);
		
		//Serialization - converting POJO to JSON
		ObjectMapper objectMapper=new ObjectMapper();
		String jsonData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		System.out.println(jsonData);
		
		//De-serialization - converting JSON to POJO
		POJO_PostRequest object=objectMapper.readValue(jsonData, POJO_PostRequest.class);
		System.out.println(object);
		
	}
	
}
