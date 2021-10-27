package com.esprit.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
public class GestionSuiviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionSuiviApplication.class, args);
	}
	@Bean
    public RestTemplate restTemplate()
{
	return new RestTemplate();
}
}
