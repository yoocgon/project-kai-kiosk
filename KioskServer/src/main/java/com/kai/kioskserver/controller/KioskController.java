package com.kai.kioskserver.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kai.kioskserver.entity.Test;
import com.kai.kioskserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/kiosk")
public class KioskController {
	//
	Logger logger = LoggerFactory.getLogger(KioskController.class);
	//
	@Resource(name = "testService")
	private TestService testService;

	//
	// @Autowired
	public KioskController(TestService testService) {
		this.testService = testService;
	}

	//
	// tset
	//
	
	//
	@GetMapping("/page/api_test")
	public String getPageApiTest() {
		return "api_test";
	}

	//
	@GetMapping("/page/test")
	public String sayHello(Model model) {
		model.addAttribute("say", "Hello");
		return "test";
	}

	//
	@ResponseBody
	@RequestMapping("/user")
	public User getUser() {
		User user = new User(0, "gony");
		logger.debug(user.toString());
		return user;
	}

	//
	@ResponseBody
	@RequestMapping("/mock/get-job-list")
	public String getJobList() {
		//
		JsonObject jsonObj1 = new JsonObject();
		jsonObj1.addProperty("sample1", "sample1");
		jsonObj1.addProperty("sample2", "sample2");
		//
		JsonObject jsonObj2 = new JsonObject();
		jsonObj2.addProperty("data1", "data1");
		jsonObj2.addProperty("data2", "data2");
		//
		JsonArray jsonArray = new JsonArray();
		String[] str = { "apple", "banana", "coconut" };
		for (String val : str)
			jsonArray.add(val);
		//
		jsonObj1.add("json2", jsonObj2);
		jsonObj1.add("json array", jsonArray);
		//
		logger.debug(jsonObj1.toString());
		return jsonObj1.toString();
	}

	//
	@ResponseBody
	@RequestMapping("/test/all")
	public List<Test> getTestAll() {
		List<Test> tests = testService.getTestAll();
		logger.debug(tests.toString());
		return tests;
	}

	//
	@PostMapping(value = "/test/post")
	public void postJson(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		testService.insertPostJson(payload.toString());
	}

	//
	// pages
	//
	@GetMapping("/page/index")
	public String getPageIndex() {
		return "index";
	}

	//
	@GetMapping("/page/job-list")
	public String getPageJobList() {
		return "job_list";
	}

	//
	@GetMapping("/page/add-workers")
	public String getPageAddWorkers() {
		return "add_workers";
	}

	//
	@GetMapping("/page/select-tc")
	public String getPageSelectTc() {
		return "select-tc";
	}

	//
	@GetMapping("/popup/enter-progress")
	public String getPopupEnterProgress() {
		return "popup_enter_progress";
	}

	//
	// api get
	//

}
