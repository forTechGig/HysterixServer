package com.example.hystricServer.hystricServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystricServerService {

    @Autowired
    HystricServerManager hystricServerManager;
    @RequestMapping(name = "getName", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@RequestParam("userId") String userId){
        String response = null;
        hystricServerManager.getUserDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
