package com.example.tuitioncenterApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TuitioncenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuitioncenterApplication.class, args);
	}

}
