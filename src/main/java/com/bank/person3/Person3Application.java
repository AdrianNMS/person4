package com.bank.person3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Person3Application {

	public static void main(String[] args) {
		SpringApplication.run(Person3Application.class, args);
	}

}
