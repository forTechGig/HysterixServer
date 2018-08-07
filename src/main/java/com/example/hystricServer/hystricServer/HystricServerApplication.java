package com.example.hystricServer.hystricServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan("com.example.hystricServer.hystricServer")
public class HystricServerApplication {

   /* @Autowired
	RestTemplate restTemplate;*/
	public static void main(String[] args) {
		SpringApplication.run(HystricServerApplication.class, args);
	}

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }
	/*@Bean
	public RestTemplate restTemplate(){
		return this.restTemplate;
	}*/
}
