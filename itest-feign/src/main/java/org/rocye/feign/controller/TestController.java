package org.rocye.feign.controller;

import org.rocye.feign.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
	private IFeignService feignService;

    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)
    public String test(@RequestParam String name){
        return feignService.testFeign(name);
    }
}