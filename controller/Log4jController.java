package com.Springlog4j.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
public class Log4jController {
	final Logger log = LogManager.getLogger(Log4jController.class.getName());
	
	@Value("${spring.message}")
	private String message;

	@GetMapping("/")
	public String msg() {
		log.info("!!!!!!!!......Application Started.....!!!!");
		return message;
	}
}
