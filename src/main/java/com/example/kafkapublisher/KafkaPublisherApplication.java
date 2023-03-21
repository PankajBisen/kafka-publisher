package com.example.kafkapublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	private String topic = "welcomeTopic";


	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		kafkaTemplate.send(topic,"Hi "+name+" Welcome");
		return "Data Published";
	}
	@GetMapping("/publishJson")
	public String publishMessage(){
		User user=new User(2532,"kafkaUser",new String[]{"sdve","fwef","wf"});
		kafkaTemplate.send(topic,user);
		return "Data Published";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
