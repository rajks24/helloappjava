package com.txconsole.helloappjava.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Value("${greet.user}")
    private String greetuser;

    @Value("${greet.msg}")
    private String greetmsg;

    @Value("${app.version}")
    private String appversion;
    
    @GetMapping("/")
	public String greeting( @RequestParam(name="greet", required=false) String greet, 
    @RequestParam(name="name", required=false) String name, Model model) {
        if (greet != null) {
            model.addAttribute("greet", greet);
        } else {
            model.addAttribute("greet", greetmsg);
        } 

        if (name != null) {
            model.addAttribute("name", name);
        } else {
            model.addAttribute("name", greetuser);
        } 
        model.addAttribute("appversion", appversion);
        logger.info("LOG: index - "+model);
		return "index";
	}

    @GetMapping("about")
	public String about(  Model model) {
        model.addAttribute("appversion", appversion);
        logger.info("LOG: about - "+model);
		return "about";
	}
}
 