package com.kai.kioskserver.controller;

import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import entity.Test;


@Service
public class TestService {
	
	//
	//	public Test getTest() {
	//		Test test = new Test(0, "test", );
	//		return test;
	//	}

	//
	public Test getTest() {
		//
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Test test = new Test(0, "test", timestamp, timestamp);
		return test;
	}
}
