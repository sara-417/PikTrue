package com.itc475.PikTrue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class PikTrueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PikTrueApplication.class, args);
	}

	@GetMapping("/error")
	private String oopsie(Model model) {
		return "An error has occurred. Please contact your administrator.";
	}
	
	@PostMapping("/error")
	private String doodle(Model model) {
		return "An error has occurred. Please contact your administrator.";
	}
	
}
