package com.open;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;

import java.util.Arrays;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@SpringBootApplication
public class JsonToStringApplication {

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
		SpringApplication.run(JsonToStringApplication.class, args);
		
		//Convert Java Object to JSON
		
		List<Information> information = Arrays.asList(new Information("01:02:03","today",1,"i1"),new Information("01:02:03","today",4,"i2"));
		ValueData valueData = new ValueData();
		valueData.setInformation(information);
		//System.out.println(valueData.toString());
				
		System.out.println("There are 2 ways to convert from Java Object to JSON string \n 1) ObjectMapper. \n 2) Gson ");
		
		//1 scenario is based on the ObjectMapper
		//ObjectMapper om = new ObjectMapper();
		//String json = om.writeValueAsString(valueData);
		//System.out.println("ObjectMapper :"+json);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(valueData);
		System.out.println("Using a Gson class :"+jsonStr);
		
		//Gson gson = new Gson();
	   // return Response.ok(gson.toJson(yourClass)).build();
		
		
		System.out.println(" Convert from String to Java Object");
		
		
		String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]"; 
		
		JSONArray json1 = new JSONArray(str);
		
		for(int i=0;i<json1.length();i++) {
			
			JSONObject jsonObj = json1.getJSONObject(i);
			System.out.println("No:"+jsonObj.getString("No"));
			System.out.println("Name:"+jsonObj.getString("Name"));
			
		}
		
		File file = ResourceUtils.getFile("classpath:myjson.json");

				//Read File Content
				String content = new String(Files.readAllBytes(file.toPath()));
				System.out.println(content);
		
		
	    JsonObject myobject = (JsonObject) new JsonParser().parse(content);
	    
	    JSONArray jsonArray2 = new JSONArray(content);
				
		JsonObject response = (JsonObject) jsonArray2.get("response");
		
				
		JsonObject body = (JsonObject) response.get("body");
		JsonObject patients= (JsonObject) body.get("patients");
		
		JsonArray patientbody= (JsonArray) patients.get("patient");
		
		// Iterate patient list and check all the objects
		for(int i=0;i<patientbody.size();i++) {
			
			JsonObject  patient = patientbody.get(i).getAsJsonObject();
			
			System.out.println("PatientID :"+patient.get("patientID").getAsString());
			System.out.println("Submitted Date "+patient.get("submittedStatus").getAsString());
			System.out.println("patientType " +patient.get("patientType").getAsString());
			System.out.println("submissionDate "+patient.get("submissionDate").getAsString());
			
		}
		
		
		
		
		
		
		
		
	}

}
