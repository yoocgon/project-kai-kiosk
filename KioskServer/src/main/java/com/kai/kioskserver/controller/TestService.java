package com.kai.kioskserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kai.kioskserver.entity.Test;
import com.kai.kioskserver.repository.TestRepository;

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
	@SuppressWarnings("finally")
	public List<Test> getTestAll(){

		List<Test> tests = null;
		try 
		{
			tests = testRepository.selectAllUsingSql();
		}
		catch(Exception e) {
			logger.debug(e.toString());
			tests = new ArrayList<Test>();
		}
		finally {
			return tests;
		}
	}
}
				
//		Test test = null;
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		try 
//		{
//			Optional<Test> optional = testRepository.findById(1);
//			if(optional.isPresent())
//				test = optional.get();
//			else
//				test = new Test(0, "test message", timestamp, timestamp);
//		}
//		catch(Exception e) {
//			test = new Test(0, "test message", timestamp, timestamp);
//		}
//		finally {
//			return test;
//		}

		//
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//
		// Test test = testRepository.findById(1);
		// List<Test> test = testRepository.findById(1);
		//
		// return test;
		
//		List<Test> listTest = testRepository.findByIdUsingSql(1);
//		Test test = listTest.get(0);
//		return test;
