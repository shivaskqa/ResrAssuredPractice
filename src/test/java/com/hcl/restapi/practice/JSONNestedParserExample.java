package com.hcl.restapi.practice;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONNestedParserExample {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		String filePath="C:\\Users\\Shiva\\Documents\\nestedobjects.json";
		JSONParser parser=new JSONParser();
		
		Object object=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject)object;
		
		
       String name=(String)jsonObject.get("name");
       System.out.println(name);
       
       String website=(String)jsonObject.get("website");
       System.out.println(website);
       
       JSONObject technology=(JSONObject) jsonObject.get("technology");
       long javaversion=(Long)technology.get("java");
       System.out.println(javaversion);
       
       JSONObject compose=(JSONObject)jsonObject.get("compose");
       long total=(Long)compose.get("total");
       System.out.println(total);
       
       JSONArray array=(JSONArray) compose.get("soundex");
       System.out.println(array);
       
       Iterator itr=array.iterator();
       
       while(itr.hasNext())
       {
    	   
    	   JSONObject obj=(JSONObject)itr.next();
    	   JSONObject info=(JSONObject)obj.get("info");
    	   
    	      String dateofbirth=(String)info.get("date_of_birth");
    	      String name_id=(String)info.get("name_id");
    	   System.out.println(dateofbirth);
    	   System.out.println(name_id);
       }
       
       
       
		
		
	}

}
