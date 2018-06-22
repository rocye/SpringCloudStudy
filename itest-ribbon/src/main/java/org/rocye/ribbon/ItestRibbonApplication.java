package org.rocye.ribbon;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix				//加入断路器功能
@EnableHystrixDashboard		//加入断路器仪表盘功能
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

	//断路器仪表盘功能(解决hystrix.stream : 404 : HTTP/1.1 404 )
	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
