package org.rocye.feign.service;

import org.springframework.stereotype.Component;

//Feign断路器回调方法
@Component
public class FeignServiceHystrix implements IFeignService {
	@Override
	public String testFeign(String name) {
		return "order " + name + ", happen error!";
	}
}
