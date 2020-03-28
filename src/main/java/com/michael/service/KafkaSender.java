package com.michael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	@Autowired
	private KafkaTemplate<String, String> kafka;
	String topicName = "sam-topic";

	public void send(String msg) {
		kafka.send(topicName,msg);
	}
}
