package org.rocye.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ItestRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestRibbonApplication.class, args);
	}

	@Bean				//注入restTemplate
	@LoadBalanced		//开启负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}