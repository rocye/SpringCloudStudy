package org.rocye.ribbon.controller;

import org.rocye.ribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/testRibbon")
	public String hi(@RequestParam String name){
		return testService.testRibbon(name);
	}
}
