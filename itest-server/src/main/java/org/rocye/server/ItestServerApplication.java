package org.rocye.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ItestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestServerApplication.class, args);
	}
}
