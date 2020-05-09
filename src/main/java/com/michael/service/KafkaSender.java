package com.michael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.michael.model.User;

@Service
public class KafkaSender {
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String topicName = "sam-topic";

	public void send(String name) {
		kafkaTemplate.send(topicName,new User(name,"Web developer",20000L));
		
	}
}
