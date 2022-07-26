package com.kai.kioskserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kai.kioskserver.entity.Test;
import com.kai.kioskserver.repository.TestRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TestService {
	//
	Logger logger = LoggerFactory.getLogger(KioskController.class);
	
	//
	@Autowired
	private TestRepository testRepository;

	//
	public String readPostJsonString(String strJson) {
		try 
		{
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(strJson);
			Boolean result = (Boolean) jsonObject.get("result");
			Long count = (Long) jsonObject.get("count");		
			return "{\"result\": \"ok\"}";
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
			return "{\"result\": \"failed\"}";
		}
	}

	//
	public String getGSonTest() {
		//
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("sample1", "sample1");
		jsonObj.addProperty("sample2", "sample2");
		//
		JsonObject jsonObj1 = new JsonObject();
		jsonObj1.addProperty("data1", "data1");
		jsonObj1.addProperty("data2", "data2");
		//
		JsonArray jsonArray = new JsonArray();
		String[] str = { "apple", "banana", "coconut" };
		for (String val : str)
			jsonArray.add(val);
		//
		jsonObj.add("json1", jsonObj1);
		jsonObj.add("json array", jsonArray);
		//
		return jsonObj.toString();
	}

	//
	@SuppressWarnings("finally")
	public List<Test> getTestAll() {

		List<Test> tests = null;
		try 
		{
			tests = testRepository.selectAllUsingSql();
		} 
		catch (Exception e) 
		{
			logger.debug(e.toString());
			tests = new ArrayList<Test>();
		} 
		finally 
		{
			return tests;
		}
	}
	
	//
	public String insertTest2(String strJson) {
		//
		try 
		{
			logger.debug(strJson);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(strJson);
			JSONArray jsonMessages = (JSONArray) jsonObject.get("messages");
			//
			List<String> messages = new ArrayList<String>();
			for (int i = 0; i < jsonMessages.size(); i++) {
				Object message = jsonMessages.get(i); 
				messages.add(message.toString());
			}
			//
			for (String message : messages) {
				int cnt = testRepository.insertAllUsingSql(message);
			}
			//
			return "{\"result\": \"ok\"}";
			//
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "{\"result\": \"failed\"}";
		}
	}
	
}

