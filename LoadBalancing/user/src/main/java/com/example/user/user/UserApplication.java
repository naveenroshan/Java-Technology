package com.example.user.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "loadbalance", configuration = RibbonConfiguration.class)
public class UserApplication {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/invoke")
	public String invokeChatBook(){
		String url = "http://loadbalance/chatbook-app/chat";
		return template().getForObject(url, String.class);
	}
	@Bean
	@LoadBalanced
	public RestTemplate template(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
