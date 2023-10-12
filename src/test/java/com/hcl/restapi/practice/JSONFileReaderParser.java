package com.hcl.restapi.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReaderParser {

	public static void main(String[] args) {

		String jsonFilePath = "C:\\Users\\Shiva\\Documents\\nestedobjects.json";
		JSONParser parser = new JSONParser();

		try {
			Object object = parser.parse(new FileReader(jsonFilePath));
			JSONObject jsonObject = (JSONObject) object;

			String name = (String) jsonObject.get("name");
			String website = (String) jsonObject.get("website");

			System.out.println(name);
			System.out.println(website);

			JSONObject technology = (JSONObject) jsonObject.get("technology");
			long version = (Long) technology.get("java");
			System.out.println("Java :" + version);

			JSONObject compose = (JSONObject) jsonObject.get("compose");
			long number = (Long) compose.get("total");
			System.out.println(number);

			JSONArray soundex = (JSONArray) compose.get("soundex");
			System.out.println(soundex);

			Iterator iterator = soundex.iterator();

			while (iterator.hasNext()) {
				
				JSONObject json = (JSONObject) iterator.next();
				JSONObject info = (JSONObject) json.get("info");

				System.out.println(info.get("date_of_birth"));
				System.out.println(info.get("name_id"));
			}

		} catch (FileNotFoundException fe) {
			System.out.println("json file is not found in the provided path..");
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
