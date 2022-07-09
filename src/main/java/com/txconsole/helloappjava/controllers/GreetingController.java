package com.txconsole.helloappjava.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Value("${greet.user}")
    private String greetuser; // read property from application.properties or cmd argument

    @Value("${greet.msg}")
    private String greetmsg; // read property from application.properties or cmd argument

    @Value("${app.version}")
    private String appversion; // read property from application.properties or cmd argument

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("greet", greetmsg);
        model.addAttribute("name", greetuser);
        model.addAttribute("appversion", appversion);
        logger.info("LOG: GET : / - " + model);
        return "index";
    }

    @GetMapping("/greet")
    public String defaultGreet(Model model) {
        model.addAttribute("greet", greetmsg);
        model.addAttribute("name", greetuser);
        model.addAttribute("appversion", appversion);
        logger.info("LOG: GET : /greet - " + model);
        return "index";
    }

    @PostMapping("/greet")
    public String greeting(@RequestParam("username") String username, Model model) {

        model.addAttribute("greet", greetmsg);
        if (username != null) {
            model.addAttribute("name", username);
        } else {
            model.addAttribute("name", greetuser);
        }
        model.addAttribute("appversion", appversion);

        logger.info("LOG: POST : /greet - " + model);
        return "index";
    }

    @GetMapping("about")
    public String about(Model model) {
        model.addAttribute("appversion", appversion);
        logger.info("LOG: GET : /about - " + model);
        return "about";
    }
}
