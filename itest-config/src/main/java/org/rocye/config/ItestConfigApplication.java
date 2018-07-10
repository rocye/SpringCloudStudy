package org.rocye.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ItestConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestConfigApplication.class, args);
	}

	@Value("${msg}")
	private String msg;

	@RequestMapping(value = "/msg")
	public String getMsg(){
		return msg;
	}
}
