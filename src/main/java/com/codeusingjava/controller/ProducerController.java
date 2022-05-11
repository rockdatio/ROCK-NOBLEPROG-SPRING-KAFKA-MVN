package com.codeusingjava.controller;

import com.codeusingjava.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/")
public class ProducerController {
    // http://localhost:8090/kafka/producer?message=test
    @Autowired
    ProducerService kafkaProducer;

    @GetMapping(value = "/producer")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return "Message sent Successfully to the topic";
    }
}
