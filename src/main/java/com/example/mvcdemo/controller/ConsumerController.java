package com.example.mvcdemo.controller;

import com.example.mvcdemo.model.Consumer;
import com.example.mvcdemo.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsumerController {

    @Autowired
    private ConsumerRepository consumerRepository;

    // localhost:8080/consumers/get?id=num
    @GetMapping(value = "/consumers/v1/get")
    public String getConsumer1(
            Model model,
            @RequestParam(name = "id", required = false, defaultValue = "5") Integer id
    ) {
        Consumer consumer = consumerRepository.get(id);
        model.addAttribute("consumer", consumer.toString());
        return "consumer"; // consumer.html
    }

    @GetMapping(value = "/consumers/v2/get/{reqId}")
    public String getConsumer2(
            Model model,
            @PathVariable(name = "reqId") Integer id
    ) {
        Consumer consumer = consumerRepository.get(id);
        model.addAttribute("consumer", consumer.toString());
        return "consumer"; // consumer.html
    }

}
