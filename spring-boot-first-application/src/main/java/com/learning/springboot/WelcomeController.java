package com.learning.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.service.WelcomeService;

@RestController
public class WelcomeController {
	@Autowired
	private WelcomeService service;

	@RequestMapping("/login")
	public String getValue() {
		return service.welcomeService();
	}

}
