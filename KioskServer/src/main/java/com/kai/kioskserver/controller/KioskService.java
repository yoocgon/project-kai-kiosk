package com.kai.kioskserver.controller;

import java.util.ArrayList;
//
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.kai.kioskserver.entity.Login;
import com.kai.kioskserver.entity.Tag;
import com.kai.kioskserver.entity.Test;
import com.kai.kioskserver.repository.LoginRepository;
import com.kai.kioskserver.repository.TagRepository;

//
@Service
public class KioskService {

	//
	Logger logger = LoggerFactory.getLogger(KioskController.class);

	//
	@Autowired
	private LoginRepository loginRepository;

	//
	@Autowired
	private TagRepository tagRepository;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//
	public String tagNfc(String strJson) {
		try {
			logger.debug(strJson);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(strJson);
			String strSerial = (String) jsonObject.get("serial");
			String strIpAddress = (String) jsonObject.get("ipaddr");
			String strType = (String) jsonObject.get("type");
			String strUid = (String) jsonObject.get("uid");
			String strData = (String) jsonObject.get("data");
			int cnt = loginRepository.insertUsingSql(strSerial, strUid, strIpAddress, "NFC");
			logger.debug(Integer.toString(cnt));
			return "{\"result\": \"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\": \"fail\"}";
		}
	}
	

	//
	public String login(String strJson) {
		try 
		{
			logger.debug(strJson);
			// String ipAddr = "172.0.0.1";
			// List<Login> listLogin = loginRepository.selectAllWhereIpUsingSql(ipAddr);
			// logger.debug(listLogin.toString());
			return "{\"result\": \"success\"}";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "{\"result\": \"fail\"}";
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//
	public String tagRFID(String strJson) {
		try 
		{
			logger.debug(strJson);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(strJson);
			String strSerial = (String) jsonObject.get("serial");
			String strIpAddress = (String) jsonObject.get("ipadd");
			String strType = (String) jsonObject.get("type");
			String strUid = (String) jsonObject.get("uid");
			String strData = (String) jsonObject.get("data");
			//
			int cnt = tagRepository.insertUsingSql(strSerial, strIpAddress, strUid, strType, strData);
			logger.debug(Integer.toString(cnt));
			//
			return "{\"result\": \"success\"}";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "{\"result\": \"fail\"}";
		}
	}	
	
	//
	@SuppressWarnings("finally")
	public List<Tag> getRfidHistory() {

		List<Tag> tags = null;
		try 
		{
			tags = tagRepository.selectAllUsingSql();
		} 
		catch (Exception e) 
		{
			logger.debug(e.toString());
			tags = new ArrayList<Tag>();
		} 
		finally {
			return tags;
		}
	}
	
	//
	public void truncateRfidHistory() {
		//
		tagRepository.truncate();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//
	public String getOrders(String strJson) {
		try {
			String strKaiKioskOrderList = "" 
				+ "{" 
				+ "	orders: [" 
				+ "		{ row: 1, order: 'Order aaaa' },"
				+ "		{ row: 2, order: 'Order aaaa' }," 
				+ "		{ row: 3, order: 'Order aaaa' },"
				+ "		{ row: 4, order: 'Order aaaa' }," 
				+ "		{ row: 5, order: 'Order aaaa' },"
				+ "		{ row: 6, order: 'Order aaaa' }," 
				+ "		{ row: 7, order: 'Order aaaa' }," 
				+ "]}";
			strKaiKioskOrderList = strKaiKioskOrderList.replace("\"", "\\\"");
			return strKaiKioskOrderList;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\": \"fail\"}";
		}
	}
}
