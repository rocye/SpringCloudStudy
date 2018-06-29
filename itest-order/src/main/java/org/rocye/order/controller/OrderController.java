package org.rocye.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/order")
	public String getOrder(@RequestParam String name) {
		return "this is total order " + name + ", from port:" + port;
	}
}
