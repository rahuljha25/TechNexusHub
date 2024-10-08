package com.technexushub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TechNexusHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(TechNexusHubApplication.class, args);
	}
	@GetMapping("/hi")
	public String welcomeMsg(){
		System.out.println("coming inside");
		return "Welcome back";
	}

}
