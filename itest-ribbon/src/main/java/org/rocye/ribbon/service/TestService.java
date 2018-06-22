package org.rocye.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "testError")
	public String testRibbon(String name) {
		return restTemplate.getForObject("http://ITEST-CLIENT/test?name=" + name, String.class);
	}

	public String testError(String name) {
		return "hello " + name + ", happen error!";
	}

}
