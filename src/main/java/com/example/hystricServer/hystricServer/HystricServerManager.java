package com.example.hystricServer.hystricServer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class HystricServerManager {

    private final RestTemplate restTemplate;

    public HystricServerManager(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getUserDetails(){
        URI uri = URI.create("http://localhost:8080/getUser?userId=senthil");
        String s = this.restTemplate.getForObject(uri, String.class);
        System.out.println("response::"+s);
        return s;
    }

    public String fallbackMethod( ){
        return "Fallback method";
    }
}
