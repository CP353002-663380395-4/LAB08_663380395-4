package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cp.lab7sec4")
@EntityScan("com.cp.lab7sec4.model")
@EnableJpaRepositories("com.cp.lab7sec4.repository")
public class Lab08CustomerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab08CustomerRestApiApplication.class, args);
	}

}