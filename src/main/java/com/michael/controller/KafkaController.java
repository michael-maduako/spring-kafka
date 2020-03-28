package com.michael.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.service.KafkaSender;

@RestController
@RequestMapping("/")
public class KafkaController {
	@Autowired
	KafkaSender kafkaSender;
	@RequestMapping("/")
	public String display() {
		return "Welcome to springboot kafka services";
	}
	//localhost:8080/producer?msg="abc"
	@RequestMapping("/producer")
	public String producer(@RequestParam("msg")String msg) {
		kafkaSender.send(msg);
		return "Message sent to the kafka topic successfully";
	}
	
}
