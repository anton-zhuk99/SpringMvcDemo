package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class HelloController {

    // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//    @Autowired
//    @Qualifier(value = "randomBeanWithSeed")
//    Random random;

    // url: localhost:8080/
    // url: localhost:8080/greeting?user=''
    // url: myhosting.com/greeting?user=''
    @GetMapping(value = "/greeting")
    public String greetingController(
            Model model,
            @RequestParam(name = "user", required = false, defaultValue = "Anonymous") String username
    ) {
        model.addAttribute("requestParam", username);
        return "greeting"; // return "resources/templates/greeting.html"
    }

    // @GetMapping(value = "/") => return "index"

}
