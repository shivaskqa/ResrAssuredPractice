package com.hcl.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;


public class TestUploadDownloadFileToWebApp {
	
	//@Test
	public void testUploadSingleFile()
	{
		
		String path="C:/Users/Shiva/Documents/Hello.txt";
		File file=new File(path);
		
		given()
		.multiPart("file",file)
		.contentType("multipart/form-data")
		.when()
		 .post("http://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.body("fileName",equalTo("Hello.txt"))
		.log()
		.all();
	}

	
	@Test
	public void testUploadMultipleFile()
	{
		
		String path1="C:/Users/Shiva/Documents/Hello.txt";
		String path2="C:/Users/Shiva/Documents/Hello_Skandha.txt";
		String path3="C:/Users/Shiva/Documents/Hello_Ishaan.txt";
		
		File file1=new File(path1);
		File file2=new File(path2);
		File file3=new File(path3);
		
		given()
		.multiPart("files",file1)
		.multiPart("files",file2)
		.multiPart("files",file3)
		.contentType("multipart/form-data")
		.when()
		 .post("http://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Hello.txt"))
		.body("[1].fileName", equalTo("Hello_Skandha.txt"))
		.body("[2].fileName",equalTo("Hello_Ishaan.txt"))
		.log()
		.all();
	}

	

}
