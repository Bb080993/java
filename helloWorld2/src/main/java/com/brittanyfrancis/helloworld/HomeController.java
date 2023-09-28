package com.brittanyfrancis.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}
	@RequestMapping("/me")
	public String mine() {
		return "Hello me!";
	}

}
