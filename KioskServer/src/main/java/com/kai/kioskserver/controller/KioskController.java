package com.kai.kioskserver.controller;

import javax.annotation.Resource;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Test;


@Controller
@RequestMapping("/kiosk")
public class KioskController {
	
	//
	@Resource(name="testService")
	private TestService testService;
	
	// @Autowired 
	public KioskController(TestService testService) {
		this.testService = testService;
	}
	
    @GetMapping("/index")
    public String sayHello(Model model) {
        model.addAttribute("say", "Hello");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/test")
    public Test getTest() {
    	// log.debug("/info start");
    	Test test = testService.getTest();
    	return test;
    }
}

