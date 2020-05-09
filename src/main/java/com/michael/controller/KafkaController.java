package com.michael.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.service.KafkaSender;

@RestController
@RequestMapping("/")
public class KafkaController {
	@Autowired
	KafkaSender kafkaSender;

	@GetMapping("/")
	public String display() {
		return "Welcome to springboot kafka services";
	}
	//localhost:8080/producer?msg="abc"
	@GetMapping("/producer")
	public String producer(@RequestParam("msg") String msg) {
		kafkaSender.send(msg);
		return "Message sent to the kafka topic successfully";
	}
	
	
	/**
	 * @Autowired
	 * KafkaTemplate<String,String> kT;
	 * 
	 * private static final String TOPIC="Kafka_Example";
	 * 
	 * @GetMapping("/publish/{msg}")
	 * public String psot(@PathVariable("msg") final String msg){
	 * 	kT.send(TOPIC, msg);
	 * 	return "Published successfully";
	 * }
	 * 
	 * 
	 * */
	
	
	
}
