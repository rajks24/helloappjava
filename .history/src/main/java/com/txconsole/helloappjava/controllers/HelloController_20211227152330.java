package com.txconsole.helloappjava.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${greet.user}")
    private String greetuser;

    @Value("${greet.msg}")
    private String greetmsg;

    @Value("${app.version}")
    private String appversion;

    @GetMapping(path = "api/greet")
    private Map<String, String> getHello(){
        HashMap<String, String> map = new HashMap<>();
        map.put("greet", greetmsg);
        map.put("user", "greetuser");
        map.put("appVersion", appversion);
        return map;

    }
    
}
