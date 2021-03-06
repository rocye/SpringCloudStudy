package org.rocye.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service("feignService")
@FeignClient(value = "itest-order",fallback = FeignServiceHystrix.class)
public interface IFeignService {

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	String testFeign(@RequestParam(value = "name") String name);
}