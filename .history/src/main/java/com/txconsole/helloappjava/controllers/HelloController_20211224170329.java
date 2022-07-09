package com.txconsole.helloappjava.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${greet.user}")
    private String greetuser;

    @Value("${greet.msg}")
    private String greetmsg;

    @GetMapping(path = "api")
    private String getHello(){
        return greetmsg + " "+ greetuser + " !!";
    }
    
}
