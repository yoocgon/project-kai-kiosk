package com.kai.kioskserver.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// tset

	//
	@GetMapping("/page/hello-world")
	public String sayHello(Model model) {
		model.addAttribute("say", "Hello");
		return "hello_world";
	}
	
	//
	@GetMapping("/page/api-test")
	public String getPageApiTest() {
		return "api_test";
	}

	//
	@ResponseBody
	@RequestMapping("/test/user")
	public User getUser() {
		User user = new User(0, "gony");
		logger.debug(user.toString());
		return user;
	}

	//
	@ResponseBody
	@RequestMapping("/test/get-job-list")
	public String getJobList() {
		//
		String result = testService.getGSonTest();
		logger.debug(result);
		return result;
	}

	// ok
	@ResponseBody
	@RequestMapping("/test/all")
	public List<Test> getTestAll() {
		List<Test> tests = testService.getTestAll();
		logger.debug(tests.toString());
		return tests;
	}
	
	// ok
	@ResponseBody
	@PostMapping(value = "/test/post-json")
	public void postJsonNoResponse(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		logger.debug(payload.toString());
		String result = testService.readPostJsonString(payload.toString());
		logger.debug(result);
	}

	// ok
	@ResponseBody
	@RequestMapping(value = "/test/post-json-2", method = RequestMethod.POST)
	public String postJsonResponseJsonString(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		logger.debug(payload.toString());
		String result = testService.readPostJsonString(payload.toString());
		logger.debug(result);
		return result;
	}

	// ok
	@ResponseBody
	@RequestMapping(value = "/test/insert", method = RequestMethod.POST)
	public String postJsonInsertTests(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		logger.debug(payload.toString());
		// String result = testService.insertTest(payload.toString());
		String result = testService.insertTest2(payload.toString());
		logger.debug(result);
		return result;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// api

	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
