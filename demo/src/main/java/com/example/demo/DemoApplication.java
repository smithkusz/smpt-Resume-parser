package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class DemoApplication {
	
	@Autowired
	EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@Scheduled(fixedDelay = 5000)
//	@EventListener(ApplicationReadyEvent.class)
//	public void emailBySceduler() {
//		
//		emailSenderService.sendSimpleEmailWithAttachment("sumit.k@rockinterview.in","body","subject");
//		 System.out.println("Send Mail by Schedeled");
//		
//	}

}
