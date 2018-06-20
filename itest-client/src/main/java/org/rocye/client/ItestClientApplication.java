package org.rocye.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ItestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestClientApplication.class, args);
	}
}
