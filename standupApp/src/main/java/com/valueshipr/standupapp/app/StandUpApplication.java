package com.valueshipr.standupapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StandUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandUpApplication.class, args);
		System.out.println("Hello Webservice");
	}

}
