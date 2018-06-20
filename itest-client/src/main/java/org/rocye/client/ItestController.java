package org.rocye.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItestController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/test")
	public String test(@RequestParam String name) {
		return "hello " + name + ", from port:" + port;
	}
}
