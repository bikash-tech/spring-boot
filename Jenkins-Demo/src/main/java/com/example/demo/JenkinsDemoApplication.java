package com.example.demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsDemoApplication {
	
	public static Logger log = LoggerFactory.getLogger(JenkinsDemoApplication.class);

	@PostConstruct
	public void init() {
		log.info("Application started....");
	}
	
	public static void main(String[] args) {
		log.debug("Application Executed....");
		SpringApplication.run(JenkinsDemoApplication.class, args);
	}

}
