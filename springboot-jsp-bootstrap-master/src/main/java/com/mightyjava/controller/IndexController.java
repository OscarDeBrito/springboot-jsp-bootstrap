package com.mightyjava.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(PATH)
	public String error() {
		return "No Mapping available.";
	}
}
