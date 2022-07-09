package com.txconsole.helloappjava.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Value("${greet.user}")
    private String greetuser;

    @Value("${greet.msg}")
    private String greetmsg;

    @Value("${app.version}")
    private String appversion;

    @GetMapping(path = "api/greet")
    private Map<String, String> getHello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("greet", greetmsg);
        map.put("user", greetuser);
        logger.info("LOG: api/greet :" + map);
        return map;

    }

    @GetMapping(path = "api/version")
    private Map<String, String> getVersion() {
        HashMap<String, String> map = new HashMap<>();
        map.put("appVersion", appversion);
        logger.info("LOG: api/version :" + map);
        return map;

    }

}
