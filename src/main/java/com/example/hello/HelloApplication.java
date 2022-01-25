package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HelloApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void xyz() {
		User user = new User();
		user.setName("somkiat");
		userRepository.save(user);
	}


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
