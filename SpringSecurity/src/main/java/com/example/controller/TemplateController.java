package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

	@RequestMapping("login")
	public String getLogin() {
		System.out.println("login page calling...");
		return "login";
	}

	@RequestMapping("courses")
	public String getCourses() {
		System.out.println("courses page calling....");
		return "courses";
	}
}
