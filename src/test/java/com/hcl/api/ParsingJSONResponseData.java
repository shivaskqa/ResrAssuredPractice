package com.hcl.api;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {

	@Test
	public void testResponse() {

		/*
		 * given() .contentType(ContentType.JSON) .when()
		 * .get("http://localhost:3000/store") .then() .statusCode(200)
		 * .header("Content-Type", "application/json; charset=utf-8")
		 * .body("book[3].title", equalTo("The Lord of the Rings"))
		 * .body("book[1].author", equalTo("Evlyn Waugh")) .body("book[3].author",
		 * equalTo("J.R.R Tolkein")) .body("book[2].category", equalTo("fiction"))
		 * .log() .all();
		 * 
		 */

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		/*
		 * Assert.assertEquals(response.getStatusCode(),200);
		 * Assert.assertEquals(response.header("Content-Type")
		 * ,"application/json; charset=utf-8");
		 * 
		 * String title=(String)response.jsonPath().get("book[3].title");
		 * Assert.assertEquals(title, "The Lord of the Rings");
		 */

		// JSONObject
		// following line tells us about how to convert response to json object
		String res = response.asString();

		//search for a title of a book in json
		boolean flag = false;

		JSONObject object = new JSONObject(res);
		for (int i = 0; i < object.getJSONArray("book").length(); i++) {
			String title = object.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(title);
			if (title.equalsIgnoreCase("The Lord of the Rings")) {
				flag = true;
				break;
			}
		}

		Assert.assertEquals(flag, true);
		
		//validate total price of books
		int sum = 0;
		for (int i = 0; i < object.getJSONArray("book").length(); i++) {
			int priceofEachBook = (Integer)object.getJSONArray("book").getJSONObject(i).get("price");
		    sum=sum+priceofEachBook;
		    
		}
		System.out.println("Total price value: "+sum);
		Assert.assertEquals(sum, 525);
	}

}
