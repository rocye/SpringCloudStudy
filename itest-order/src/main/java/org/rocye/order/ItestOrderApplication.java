package org.rocye.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class
ItestOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestOrderApplication.class, args);
	}
}
