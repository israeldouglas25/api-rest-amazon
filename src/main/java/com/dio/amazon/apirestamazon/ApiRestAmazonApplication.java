package com.dio.amazon.apirestamazon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestAmazonApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepository repository){
		return args -> {
			repository.save(new Person(null, "Israel", "Douglas"));
			repository.save(new Person(null, "Ferreira", "Paixão"));
		};
	}

}
