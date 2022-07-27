package com.kai.kioskserver.controller;

import java.util.List;

//
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kai.kioskserver.entity.Tag;

//import org.springframework.web.servlet.view.RedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
@Controller
@RequestMapping("/")
public class KioskController {
	//
	Logger logger = LoggerFactory.getLogger(KioskController.class);

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//
	@Resource(name = "kioskService")
	private KioskService service;

	// @Autowired
	public KioskController(KioskService service) {
		this.service = service;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//	//
	//	@Resource(name = "testService")
	//	private TestService service;
	//
	//	// @Autowired
	//	public TestController(TestService service) {
	//		this.service = service;
	//	}
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// pages

	//
	@GetMapping("/")
	public String getIndexPage() {
		logger.debug("Log>>> (func) getIndexPage");
		return "index";
	}
	
	@GetMapping("/page/orders")
	public String getOrdersPage(HttpServletRequest request) {
		logger.debug("Log>>> (func) getOrdersPage");
		return "orders";
	}
	
	//
	@GetMapping("/page/worker")
	public String getWorkerGroupPage() {
		logger.debug("Log>>> (func) getWorkerGroupPage");
		return "add_worker";
	}

	//
	@GetMapping("/page/tc")
	public String getTcPage() {
		logger.debug("Log>>> (func) getTcPage");
		return "tc";
	}

	//
	@GetMapping("/page/progress")
	public String getProgressPage() {
		logger.debug("Log>>> (func) getProgressPage");
		return "progress";
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// api

	//	// nfc tagging
	//	@ResponseBody
	//	@RequestMapping(value = "/api/nfc", method = RequestMethod.POST)
	//	public String tagNfc(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	//		logger.debug("Log>>> (func) tagNfc");
	//		logger.debug(payload.toString());
	//		String result = service.tagNfc(payload.toString());
	//		logger.debug(result);
	//		return result;
	//	}

	// NFC tagging
	@ResponseBody
	@RequestMapping(value = "/api/nfc", method = RequestMethod.POST)
	public String tagNfc(
			@RequestBody com.fasterxml.jackson.databind.JsonNode payload,
			HttpServletRequest request) {
		logger.debug("Log>>> (func) tagNfc");
		logger.debug(payload.toString());
		String ip = request.getRemoteAddr();
		logger.debug(ip);
		String result = service.tagNfc(payload.toString());
		logger.debug(result);
		return result;
	}

	// login, server redirect
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		logger.debug("Log>>> (func) login");
		String ip = request.getRemoteAddr();
		logger.debug(ip);
		// String result = service.login(ip);
		// logger.debug(result);
		return "redirect:/page/orders";
	}

	// login, post js relocate
	@ResponseBody
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(HttpServletRequest request) {
		logger.debug("Log>>> (func) login");
		String ip = request.getRemoteAddr();
		logger.debug(ip);
		String result = service.login(ip);
		logger.debug(result);
		return result;
	}
	
	// RFID tagging
	@ResponseBody
	@RequestMapping(value = "/api/rfid", method = RequestMethod.POST)
	public String tagRFID(
			@RequestBody com.fasterxml.jackson.databind.JsonNode payload,
			HttpServletRequest request) {
		logger.debug("Log>>> (func) tagRFID");
		//
		logger.debug(payload.toString());
		String ip = request.getRemoteAddr();
		logger.debug(ip);
		String result = service.tagRFID(payload.toString());
		logger.debug(result);
		//
		return result;
	}

	//
	@ResponseBody
	@RequestMapping(value = "/api/tagged", method = RequestMethod.POST)
	public List<Tag> getTagHistory(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		logger.debug("Log>>> (func) getTagHistory");
		//
		logger.debug(payload.toString());
		//
		List<Tag> tags = service.getRfidHistory();
		//
		return tags;
	}
	
	//
	@ResponseBody
	@RequestMapping(value = "/api/tag/truncate", method = RequestMethod.POST)
	public String truncateTagHistory(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		logger.debug("Log>>> (func) truncateTagHistory");
		//
		logger.debug(payload.toString());
		//
		try
		{
			service.truncateRfidHistory();
			return "{\"result\": \"success\"}";
		}
		catch(Exception ex) {
			logger.debug(ex.toString());
			return "{\"result\": \"fail\"}";
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//	// tset
	//
	//	//
	//	@GetMapping("/page/hello-world")
	//	public String sayHello(Model model) {
	//		model.addAttribute("say", "Hello");
	//		return "hello_world";
	//	}
	//
	//	//
	//	@GetMapping("/page/api-test")
	//	public String getPageApiTest() {
	//		return "api_test";
	//	}
	//
	//	//
	//	@ResponseBody
	//	@RequestMapping("/test/user")
	//	public User getUser() {
	//		User user = new User(0, "gony");
	//		logger.debug(user.toString());
	//		return user;
	//	}
	//
	//	//
	//	@ResponseBody
	//	@RequestMapping("/test/get-job-list")
	//	public String getJobList() {
	//		//
	//		String result = service.getGSonTest();
	//		logger.debug(result);
	//		return result;
	//	}
	//
	//	@ResponseBody
	//	@RequestMapping("/test/all")
	//	public List<Test> getTestAll() {
	//		List<Test> tests = service.getTestAll();
	//		logger.debug(tests.toString());
	//		return tests;
	//	}
	//
	//	@ResponseBody
	//	@PostMapping(value = "/test/post-json")
	//	public void postJsonNoResponse(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	//		logger.debug(payload.toString());
	//		String result = service.readPostJsonString(payload.toString());
	//		logger.debug(result);
	//	}
	//
	//	@ResponseBody
	//	@RequestMapping(value = "/test/post-json-2", method = RequestMethod.POST)
	//	public String postJsonResponseJsonString(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	//		logger.debug(payload.toString());
	//		String result = service.readPostJsonString(payload.toString());
	//		logger.debug(result);
	//		return result;
	//	}
	//
	//	@ResponseBody
	//	@RequestMapping(value = "/test/insert", method = RequestMethod.POST)
	//	public String postJsonInsertTests(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	//		logger.debug(payload.toString());
	//		// String result = testService.insertTest(payload.toString());
	//		String result = service.insertTest2(payload.toString());
	//		logger.debug(result);
	//		return result;
	//	}
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
